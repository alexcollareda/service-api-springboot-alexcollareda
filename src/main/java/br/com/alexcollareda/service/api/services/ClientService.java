package br.com.alexcollareda.service.api.services;

import java.util.List;

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

	/**
	 * Method to save a client into database.
	 */
	@Override
	public void save(Client client) {
		// Here, I Can write validations before call save method.

		Client clientRecov = findBySocialDocumentNumber(client.getSocialDocumentNumber());

		if (clientRecov == null)
			repository.save(client);
	}

	/**
	 * Here we can find client by your personal document social, this is similar to
	 * CPF.
	 */
	@Override
	public Client findBySocialDocumentNumber(String socialDocumentNumber) {
		return repository.findClientBySocialDocumentNumber(socialDocumentNumber);
	}

	/**
	 * Method for delete client by SocialDocumentNumber (CPF)
	 */
	@Override
	public void delete(String socialDocumentNumber) {
		Client c = findBySocialDocumentNumber(socialDocumentNumber);

		if (c != null)
			repository.delete(c);
	}

	/**
	 * Method created to recovery all clients from database
	 */
	@Override
	public List<Client> findAllClients() {
		return (List<Client>) repository.findAll();
	}

	/**
	 * Here we can update a client, when have a register with same
	 * SocialDocumentNumber (CPF)
	 */
	@Override
	public Client update(Client client) {
		Client clientRecov = findBySocialDocumentNumber(client.getSocialDocumentNumber());

		if (clientRecov != null) {
			clientRecov.setName(client.getName());
			clientRecov.setSocialDocumentNumber(client.getSocialDocumentNumber());
			clientRecov.getClientAddress().setCityName(client.getClientAddress().getCityName());
			clientRecov.getClientAddress().setNumberAddress(client.getClientAddress().getNumberAddress());
			clientRecov.getClientAddress().setStateInitials(client.getClientAddress().getStateInitials());
			clientRecov.getClientAddress().setStreetName(client.getClientAddress().getStreetName());
			clientRecov.getClientAddress().setZipCode(client.getClientAddress().getZipCode());
		} else {
			return null;
		}

		return repository.save(client);
	}
}