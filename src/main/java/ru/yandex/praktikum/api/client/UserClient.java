package ru.yandex.praktikum.api.client;

import io.restassured.response.Response;
import ru.yandex.praktikum.api.dto.RegisterUserRequest;

import static ru.yandex.praktikum.api.config.URL.DELETE_USER_PATH;
import static ru.yandex.praktikum.api.config.URL.REGISTER_USER_PATH;

public class UserClient extends RestClient {

	public static Response registerUser(RegisterUserRequest registerUserRequest) {
		return getRequestSpecification()
				.log().all()
				.body(registerUserRequest)
				.when()
				.post(REGISTER_USER_PATH);
	}

	public static Response deleteUser(String token) {
		return getRequestSpecification(token)
				.when()
				.delete(DELETE_USER_PATH);
	}
}
