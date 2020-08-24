package br.com.alexcollareda.service.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alexcollareda.service.api.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	@Query("SELECT c FROM Client c JOIN FETCH c.clientAddress ca WHERE c.socialDocumentNumber = :socialDocumentNumber")
	Client findClientBySocialDocumentNumber(@Param("socialDocumentNumber") String socialDocumentNumber);
}