package br.com.alexcollareda.service.api.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.alexcollareda.service.api.AbstractTest;
import br.com.alexcollareda.service.api.model.Client;
import br.com.alexcollareda.service.api.model.ClientAddress;

public class ClientControllerTest extends AbstractTest {

	@Test
	public void createClientWithAddress() throws Exception {
		String uri = "/client/v1/";
		Client client = new Client();
		client.setName("Alex Michelim Collareda");
		client.setSocialDocumentNumber("05476807160");

		ClientAddress ca = new ClientAddress();
		ca.setCityName("São Paulo");
		ca.setNumberAddress("426");
		ca.setStateInitials("SP");
		ca.setStreetName("Rua Copacabana");

		client.setClientAddress(ca);

		String inputJson = super.mapToJson(client);
		System.out.println(mvc);
		System.out.println(uri);
		System.out.println(inputJson);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
	}

	@Test
	public void updateClient() throws Exception {
		String uri = "/client/v1/";
		Client client = new Client();
		client.setName("Alex Michelim Collareda 2");
		client.setSocialDocumentNumber("05476807160");

		ClientAddress ca = new ClientAddress();
		ca.setCityName("Cuiabá");
		ca.setNumberAddress("457");
		ca.setStateInitials("MT");
		ca.setStreetName("Rua Doutor Luis de Castro Pereira");

		client.setClientAddress(ca);

		String inputJson = super.mapToJson(client);
		System.out.println(mvc);
		System.out.println(uri);
		System.out.println(inputJson);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
}