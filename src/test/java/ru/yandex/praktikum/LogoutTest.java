package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pom.LoginPage;
import ru.yandex.praktikum.pom.MainPage;
import ru.yandex.praktikum.pom.ProfilePage;

import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {

	@Test
	@DisplayName("Выход по кнопке 'Выйти' в личном кабинете")
	public void checkSuccessfulLogOut() {
		objMainPage = new MainPage(webDriver);
		objLoginPage = new LoginPage(webDriver);
		objProfilePage = new ProfilePage(webDriver);
		response = userSteps.registerUser(email, password, name);
		token = response.extract().path("accessToken");
		objLoginPage.login(email, password);
		objMainPage.clickProfileButton();
		objProfilePage.clickLogOutButton();
		objLoginPage.waitForLoadLoginBlock();
		assertTrue(objLoginPage.loginButtonIsDisplayed());
	}
}
