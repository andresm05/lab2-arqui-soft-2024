package com.udea.lab2arquisoft;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@RestController
public class DataController {

    private static final String LANGUAGE = "en-US";

    @GetMapping("")
    public String healthCheck() {
        return "app works perfectly!";
    }

    @GetMapping("/version")
    public String version() {
        return "The version of the app is 1.0.0";
    }

    @GetMapping("/nations")
    public JsonNode getRandomNations() {
        var objectMapper = new ObjectMapper();

        var faker = new Faker(new Locale(LANGUAGE));

        var nations = objectMapper.createArrayNode();

        for (int i = 0; i < 10; i++) {
            var nation = faker.nation();
            nations.add(objectMapper.createObjectNode()
                    .put("nationality", nation.nationality())
                    .put("capitalCity", nation.capitalCity())
                    .put("flag", nation.flag())
                    .put("language", nation.language()));

        }

        return nations;
    }

    @GetMapping("/currencies")
    public JsonNode getRandomCurrencies() {
        var objectMapper = new ObjectMapper();

        var faker = new Faker(new Locale(LANGUAGE));

        var currencies = objectMapper.createArrayNode();

        for (int i = 0; i < 20; i++) {
            var currency = faker.currency();
            currencies.add(objectMapper.createObjectNode()
                    .put("name", currency.name())
                    .put("code", currency.code()));

        }

        return currencies;
    }

    @GetMapping("/airlines")
    public JsonNode getRandomAirlines() {
        var objectMapper = new ObjectMapper();

        var faker = new Faker(new Locale(LANGUAGE));

        var airlines = objectMapper.createArrayNode();

        for (int i = 0; i < 20; i++) {
            var aviation = faker.aviation();
            airlines.add(objectMapper.createObjectNode()
                    .put("aircraft", aviation.aircraft())
                    .put("airport", aviation.airport())
                    .put("metar", aviation.METAR()));

        }

        return airlines;
    }
}
