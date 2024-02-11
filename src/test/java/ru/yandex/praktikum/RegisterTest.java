package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pom.LoginPage;
import ru.yandex.praktikum.pom.MainPage;
import ru.yandex.praktikum.pom.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {
	@Test
	@DisplayName("Получение ошибки при вводе некорректного пароля")
	public void checkRegistrationWithInvalidPasswordReturnsError() {
		objMainPage = new MainPage(webDriver);
		objRegisterPage = new RegisterPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objRegisterPage.openPage();
		objRegisterPage.fillRegistrationForm(name, email, invalidPassword);
		objRegisterPage.clickRegisterButton();
		assertTrue(objRegisterPage.invalidPasswordIsDisplayed());
	}
	@Test
	@DisplayName("Успешная регистрация нового пользователя")
	public void checkSuccessfulUserRegistration() {
		objMainPage = new MainPage(webDriver);
		objRegisterPage = new RegisterPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objRegisterPage.openPage();
		objRegisterPage.fillRegistrationForm(name, email, password);
		objRegisterPage.clickRegisterButton();
		objLoginPage.fillLoginForm(email, password);
		objLoginPage.clickLoginButton();
		assertTrue(objMainPage.createOrderButtonIsDisplayed());
	}


}
