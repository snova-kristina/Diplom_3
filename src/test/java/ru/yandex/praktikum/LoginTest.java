package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pom.ForgotPasswordPage;
import ru.yandex.praktikum.pom.LoginPage;
import ru.yandex.praktikum.pom.MainPage;
import ru.yandex.praktikum.pom.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

	@Before
	public void registerUser() {
		response = userSteps.registerUser(email, password, name);
		token = response.extract().path("accessToken");
	}

	@Test
	@DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
	public void checkLoginFromMainPage() {
		objMainPage = new MainPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objMainPage.clickLoginButton();
		objLoginPage.fillLoginForm(email, password);
		objLoginPage.clickLoginButton();
		assertTrue(objMainPage.createOrderButtonIsDisplayed());
	}

	@Test
	@DisplayName("Вход через кнопку 'Личный кабинет'")
	public void checkLoginFromProfile() {
		objMainPage = new MainPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objMainPage.clickProfileButton();
		objLoginPage.fillLoginForm(email, password);
		objLoginPage.clickLoginButton();
		assertTrue(objMainPage.createOrderButtonIsDisplayed());
	}

	@Test
	@DisplayName("Вход через кнопку в форме регистрации")
	public void checkLoginFromRegistrationPage() {
		objMainPage = new MainPage(webDriver);
		objRegisterPage = new RegisterPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objRegisterPage.openPage();
		objRegisterPage.clickLoginButton();
		objLoginPage.fillLoginForm(email, password);
		objLoginPage.clickLoginButton();
		assertTrue(objMainPage.createOrderButtonIsDisplayed());
	}

	@Test
	@DisplayName("Вход через кнопку в форме восстановления пароля")
	public void checkLoginFromForgotPasswordPage() {
		objMainPage = new MainPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objForgPassPage = new ForgotPasswordPage(webDriver);
		objForgPassPage.openPage();
		objForgPassPage.clickLoginButton();
		objLoginPage.fillLoginForm(email, password);
		objLoginPage.clickLoginButton();
		assertTrue(objMainPage.createOrderButtonIsDisplayed());
	}
}
