package br.com.camel.webhook.config;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@Configuration
public class JMSConfig {
	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Value("${spring.activemq.user}")
	private String brokerUsername;

	@Value("${spring.activemq.password}")
	private String brokerPassword;

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerUrl);
		connectionFactory.setPassword(brokerUsername);
		connectionFactory.setUserName(brokerPassword);
		connectionFactory.setTrustAllPackages(true);
		return connectionFactory;
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		return new CachingConnectionFactory(connectionFactory());
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(cachingConnectionFactory());
		template.setPubSubDomain(true);
		return template;
	}

	@Bean
	public JmsComponent jmsComponent() throws JMSException {
		return JmsComponent.jmsComponentAutoAcknowledge(cachingConnectionFactory());
	}

	@Bean
	public CamelContext camelContext() throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.setTracing(false);
		camelContext.addComponent("activemq", jmsComponent());
		camelContext.start();
		return camelContext;
	}
}
