package br.com.alexcollareda.service.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alexcollareda.service.api.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}