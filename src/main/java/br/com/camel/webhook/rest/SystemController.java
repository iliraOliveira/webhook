/**
 * 
 */
package br.com.camel.webhook.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.camel.webhook.entity.People;
import br.com.camel.webhook.entity.System;
import br.com.camel.webhook.service.WebhookService;

/**
 * @author ivan.oliveira
 *
 */
@RestController
@RequestMapping(path = "/system")
public class SystemController {

	private static Logger log = LoggerFactory.getLogger(WebhookService.class);

	@Autowired
	private WebhookService service;

	@PostMapping(value = "/client/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody System system) {
		service.add(system);
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/client/remove")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> remove(@RequestBody System system) {
		service.remove(system);
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/client1")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> client1(@RequestBody People people) {
		log.info("people [" + people.getName() + "] recebida pelo Client 1");
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/client2")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> client2(@RequestBody People people) {
		log.info("people [" + people.getName() + "] recebida pelo Client 2");
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/client3")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> client3(@RequestBody People people) {
		log.info("people [" + people.getName() + "] recebida pelo Client 3");
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/client4")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> client4(@RequestBody People people) {
		log.info("people [" + people.getName() + "] recebida pelo Client 4");
		return ResponseEntity.ok().build();
	}
}
