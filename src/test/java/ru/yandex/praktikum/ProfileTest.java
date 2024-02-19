package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pom.LoginPage;
import ru.yandex.praktikum.pom.MainPage;
import ru.yandex.praktikum.pom.ProfilePage;

import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {
	@Before
	public void registerUser() {
		response = userSteps.registerUser(email, password, name);
		token = response.extract().path("accessToken");
	}
	@Test
	@DisplayName("Переход по клику на 'Личный кабинет'")
	public void checkTransitionToProfile() {
		objMainPage = new MainPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objMainPage.clickProfileButton();
		assertTrue(objLoginPage.loginButtonIsDisplayed());
	}

	@Test
	@DisplayName("Переход из личного кабинета в конструктор")
	public void checkTransitionToConstructor() {
		objMainPage = new MainPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objProfilePage = new ProfilePage(webDriver);
		objLoginPage.login(email,password);
		objProfilePage.clickConstructorButton();
		assertTrue(objMainPage.constructorBlockIsDisplayed());
	}

	@Test
	@DisplayName("Переход по клику на логотип Stellar Burgers")
	public void checkTransitionToMainPageByClickLogo() {
		objMainPage = new MainPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objProfilePage = new ProfilePage(webDriver);
		objLoginPage.login(email,password);
		objProfilePage.clickHeaderLogo();
		assertTrue(objMainPage.constructorBlockIsDisplayed());
	}
}
