/**
 * 
 */
package br.com.camel.webhook.service;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.camel.webhook.entity.People;
import br.com.camel.webhook.entity.System;
import br.com.camel.webhook.route.Route;

/**
 * @author ivan.oliveira
 *
 */
@Service
public class WebhookService {
	
	private static Logger log = LoggerFactory.getLogger(WebhookService.class);
	 
	@Autowired
	private CamelContext camelContext;
	
   @Value("activemq:topic:topico_people")
   private String jmsTopic;
	
	public WebhookService() { }

	public void add(System system) {
	      try {
	         camelContext.addRoutes(new Route(jmsTopic, system));
	      } catch (Exception e) {
	         e.printStackTrace();
	         log.error(e.getMessage());
	      }
	   }
	 
	   public void remove(System sistem) {
	      try {
	         camelContext.stop();
	         camelContext.removeRoute(sistem.getName());       
	      } catch (Exception e) {
	         e.printStackTrace();
	         log.error("Não foi possivel remover [" + sistem.getName() +"]");
	      }
	   }
	 
	   public void notify(People pessoa) {
	      ProducerTemplate template = camelContext.createProducerTemplate();
	      template.sendBody(jmsTopic, pessoa);
	   }
	
}
