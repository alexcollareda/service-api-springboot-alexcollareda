package br.com.alexcollareda.service.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity Class for Clients
 */
@Entity
@Table(name = "clients")
public class Client implements Serializable {
	private static final long serialVersionUID = -2607131446013700219L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String name;
	private String socialDocumentNumber;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client")
	private ClientAddress clientAddress;

	public Client() {
		super();
	}

	public Client(Long id, String name, String socialDocumentNumber, ClientAddress clientAddress) {
		super();
		this.id = id;
		this.name = name;
		this.socialDocumentNumber = socialDocumentNumber;
		this.clientAddress = clientAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialDocumentNumber() {
		return socialDocumentNumber;
	}

	public void setSocialDocumentNumber(String socialDocumentNumber) {
		this.socialDocumentNumber = socialDocumentNumber;
	}

	public ClientAddress getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(ClientAddress clientAddress) {
		this.clientAddress = clientAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}