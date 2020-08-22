package br.com.alexcollareda.service.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class to Address from clients
 * 
 * @author alexc
 *
 */
@Entity
@Table(name = "client_address")
public class ClientAddress implements Serializable {
	private static final long serialVersionUID = 4745989130060199997L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	private String streetName;

	private String numberAddress;

	private String stateInitials;

	private String cityName;

	private String zipCode;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id", nullable = false)
	@JsonIgnore
	private Client client;

	public ClientAddress() {
		super();
	}

	public ClientAddress(Long id, String streetName, String numberAddress, String stateInitials, String cityName,
			String zipCode, Client client) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.numberAddress = numberAddress;
		this.stateInitials = stateInitials;
		this.cityName = cityName;
		this.zipCode = zipCode;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumberAddress() {
		return numberAddress;
	}

	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}

	public String getStateInitials() {
		return stateInitials;
	}

	public void setStateInitials(String stateInitials) {
		this.stateInitials = stateInitials;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}