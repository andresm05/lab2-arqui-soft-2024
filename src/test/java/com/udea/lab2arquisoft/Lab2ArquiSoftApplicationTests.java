package com.udea.lab2arquisoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;

@SpringBootTest
class Lab2ArquiSoftApplicationTests {

	@Autowired
	private DataController dataController;

	@Test
	 void health() {
		String response = dataController.healthCheck();
		assertEquals("app works perfectly!", response);
	}

	@Test
	 void version() {
		String response = dataController.version();
		assertEquals("The version of the app is 1.0.0", response);
	}

	@Test
	 void nationLength() {
		JsonNode response = dataController.getRandomNations();
		assertEquals(10, response.size());
	}

	@Test
	 void currencyLength() {
		JsonNode response = dataController.getRandomCurrencies();
		assertEquals(20, response.size());
	}

	@Test
	 void airlinesLength() {
		JsonNode response = dataController.getRandomAirlines();
		assertEquals(20, response.size());
	}

	@Test
	void contextLoads() {
	}

}
