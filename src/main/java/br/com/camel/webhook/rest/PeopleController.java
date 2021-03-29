/**
 * 
 */
package br.com.camel.webhook.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.camel.webhook.entity.People;
import br.com.camel.webhook.service.WebhookService;

/**
 * @author ivan.oliveira
 *
 */
@RestController
@RequestMapping(path = "/people")
public class PeopleController {

	@Autowired
	private WebhookService service;

	@PostMapping(value = "/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@RequestBody People people) {
		service.notify(people);
		return ResponseEntity.ok().build();
	}

}
