package br.com.alexcollareda.service.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alexcollareda.service.api.model.Client;
import br.com.alexcollareda.service.api.repository.ClientRepository;

/**
 * Class Service when I can do bussiness rule to Client object before call
 * repository class.
 * 
 * @author alexc
 *
 */
@Service
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository repository;

	@Override
	public void save(Client client) {
		// Here, I Can write validations before call save method.
		repository.save(client);
	}
}