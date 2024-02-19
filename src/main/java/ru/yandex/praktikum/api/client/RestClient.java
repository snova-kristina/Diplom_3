package ru.yandex.praktikum.api.client;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.api.config.URL.BASE_URI;

public class RestClient {
	protected static RequestSpecification getRequestSpecification() {
		return given()
				.baseUri(BASE_URI)
				.contentType(ContentType.JSON);
	}

	protected static RequestSpecification getRequestSpecification(String token) {
		return given()
				.contentType(ContentType.JSON)
				.header("Authorization", token)
				.baseUri(BASE_URI);
	}
}
