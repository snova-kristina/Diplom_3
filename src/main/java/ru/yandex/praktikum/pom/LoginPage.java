package ru.yandex.praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.api.config.URL.LOGIN_PAGE;
import static ru.yandex.praktikum.api.config.URL.REGISTER_PAGE;

public class LoginPage extends BasePage{

	private final By logOutButton = By.xpath(".//button[text()='Выход']");
	private final By logInBlock = By.className("Auth_login__3hAey");
	private final By logInButton = By.xpath(".//button[text()='Войти']");
	private final By emailField = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @type = 'text' and @name = 'name']");
	private final By passwordField = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @type = 'password' and @name = 'Пароль']");

	public LoginPage(WebDriver webDriver) {
		BasePage.webDriver = webDriver;
		webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
	}

	@Step("Открыть страницу входа")
	public void openPage() {
		webDriver.get(LOGIN_PAGE);
	}

	@Step("Дождаться прогрузки страницы - появления блока входа")
	public void waitForLoadLoginBlock() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(logInBlock));
	}

	@Step("Отображается кнопка 'Войти'")
	public boolean loginButtonIsDisplayed() {
		return webDriver.findElement(logInButton).isDisplayed();
	}

	@Step("Заполнить поле 'Email'")
	public void setEmail(String email) {
		webDriver.findElement(emailField).sendKeys(email);
	}

	@Step("Заполнить поле 'Пароль'")
	public void setPassword(String password) {
		webDriver.findElement(passwordField).sendKeys(password);
	}

	@Step("Нажать на кнопку 'Войти'")
	public void clickLoginButton() {
		webDriver.findElement(logInButton).click();
	}

	@Step("Нажать на кнопку 'Выйти'")
	public void clickLogOutButton() {
		webDriver.findElement(logOutButton).click();
	}

	@Step("Заполнить форму входа")
	public void fillLoginForm(String email, String password) {
		waitForLoadLoginBlock();
		setEmail(email);
		setPassword(password);
	}

	@Step("Войти в профиль")
	public void login(String email, String password) {
		openPage();
		waitForLoadLoginBlock();
		setEmail(email);
		setPassword(password);
		clickLoginButton();
	}
}
