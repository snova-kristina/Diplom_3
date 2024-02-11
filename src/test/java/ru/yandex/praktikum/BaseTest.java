package ru.yandex.praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.api.client.UserClient;
import ru.yandex.praktikum.api.steps.UserSteps;
import ru.yandex.praktikum.driver.WebDriverFactory;
import ru.yandex.praktikum.pom.*;

import static ru.yandex.praktikum.api.config.UserDataConstants.*;

public class BaseTest {

	protected WebDriver webDriver;
	protected UserSteps userSteps;
	protected MainPage objMainPage;
	protected LoginPage objLoginPage;
	protected ProfilePage objProfilePage;
	protected RegisterPage objRegisterPage;
	protected ForgotPasswordPage objForgPassPage;
	protected ValidatableResponse response;
	protected WebDriverFactory webDriverFactory;

	static String email = RANDOM_EMAIL;
	static String password = RANDOM_PASSWORD;
	static String invalidPassword = INVALID_PASSWORD;
	static String name = RANDOM_NAME;
	protected static String token = null;


	@Before
	public void setUp() {
		webDriverFactory = new WebDriverFactory();
		webDriver = webDriverFactory.getWebDriver();
		UserClient userClient = new UserClient();
		userSteps = new UserSteps(userClient);
		objMainPage = new MainPage(webDriver);
		objMainPage.openPage();
		objMainPage.waitForLoadMainPage();
	}

	@After
	public void tearDown() {
		webDriver.quit();
		if (token != null) {
			userSteps.deleteUser(token);
		}
	}

}
