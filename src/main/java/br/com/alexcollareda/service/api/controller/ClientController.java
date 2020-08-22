package br.com.alexcollareda.service.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/v1", method = RequestMethod.POST, produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createClient(@RequestBody Client client) {
		clientService.save(client);
	}
}