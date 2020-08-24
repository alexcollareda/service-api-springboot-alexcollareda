package br.com.alexcollareda.service.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexcollareda.service.api.model.Client;
import br.com.alexcollareda.service.api.services.IClientService;
import io.swagger.annotations.ApiOperation;

/**
 * Controller Class Responsable to expose the REST integration for CLIENTs.
 * 
 * @author alexc
 *
 */
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@ApiOperation(value = "Method to create a new client into database.")
	@PostMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createClient(@RequestBody Client client) {
		clientService.save(client);
	}

	@ApiOperation(value = "Method to recover a client by socialDocumentNumber(CPF) from database.")
	@GetMapping(value = "/v1/{socialDocumentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> getClient(@PathVariable String socialDocumentNumber) {
		return Optional.ofNullable(clientService.findBySocialDocumentNumber(socialDocumentNumber))
				.map(client -> ResponseEntity.ok().body(client)).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Method to recover all clients from database.")
	@GetMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Client>> getClients() {
		return Optional.ofNullable(clientService.findAllClients()).map(clients -> ResponseEntity.ok().body(clients))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Method to delete a client by socialDocumentNumber(CPF) from database.")
	@DeleteMapping(value = "/v1/{socialDocumentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteClient(@PathVariable String socialDocumentNumber) {
		clientService.delete(socialDocumentNumber);
	}

	@ApiOperation(value = "Method to update a client, using SocialDocumentNumber(CPF) for see the client exists")
	@PutMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		return Optional.ofNullable(clientService.update(client))
				.map(clientReturn -> ResponseEntity.ok().body(clientReturn))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}