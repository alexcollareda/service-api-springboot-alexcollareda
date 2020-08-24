package br.com.alexcollareda.service.api.services;

import java.util.List;

import br.com.alexcollareda.service.api.model.Client;

public interface IClientService {
	void save(Client client);

	Client findBySocialDocumentNumber(String socialDocumentNumber);

	void delete(String socialDocumentNumber);

	List<Client> findAllClients();

	Client update(Client client);
}