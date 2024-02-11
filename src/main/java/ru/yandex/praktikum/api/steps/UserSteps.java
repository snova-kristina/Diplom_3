package ru.yandex.praktikum.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.api.client.UserClient;
import ru.yandex.praktikum.api.dto.RegisterUserRequest;

public class UserSteps {

	public UserSteps(UserClient userClient) {
	}

	@Step("Регистрация пользователя")
	public ValidatableResponse registerUser(String email, String password, String name) {
		RegisterUserRequest registerUserRequest = new RegisterUserRequest();
		registerUserRequest.setEmail(email);
		registerUserRequest.setPassword(password);
		registerUserRequest.setName(name);
		return UserClient
				.registerUser(registerUserRequest)
				.then()
				.log().all();
	}

	@Step("Удаление пользователя")
	public void deleteUser(String token) {
		UserClient.deleteUser(token);
	}
}
