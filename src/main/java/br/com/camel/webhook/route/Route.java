/**
 * 
 */
package br.com.camel.webhook.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import br.com.camel.webhook.entity.People;
import br.com.camel.webhook.entity.System;

/**
 * @author ivan.oliveira
 *
 */
public class Route extends RouteBuilder {

	private String jmsTopic;
	private System system;	
	
   public Route(String topico, System sistema) {
	      this.system = sistema;
	      this.jmsTopic = topico;
	   }

	@SuppressWarnings("deprecation")
	@Override
	public void configure() throws Exception {
		errorHandler(defaultErrorHandler()
			      .maximumRedeliveries(5)
			      .redeliveryDelay(2000)
			      .retryAttemptedLogLevel(LoggingLevel.WARN));
			       
	    onException(org.apache.camel.http.common.HttpOperationFailedException.class)
			      .maximumRedeliveries(5)
			      .redeliveryDelay(2000)
			      .handled(true)
			      .log(LoggingLevel.WARN, "Falha ao entregar mensagem para [" + system.getName() + "]");
			 
	    from(jmsTopic)
			      .routeId(system.getName())
			      .log(LoggingLevel.INFO, "PESSOA Topic: ${body.name}")
			      .marshal()
			      .json(JsonLibrary.Gson, People.class)
			      .log(LoggingLevel.INFO, "PESSOA GSon: ${body}")
			      .setHeader(Exchange.HTTP_METHOD, constant("POST"))
			      .to(system.getUrl())
			      .log(LoggingLevel.INFO, "Status: [${header.CamelHttpResponseCode}]")
			      .end();		
	}

}
