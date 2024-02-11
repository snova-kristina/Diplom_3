package ru.yandex.praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.api.config.URL.REGISTER_PAGE;

public class RegisterPage extends BasePage {

	private final By loginButton = By.className("Auth_link__1fOlj");
	private final By registerBlock = By.xpath(".//*[text()='Регистрация']");
	private final By nameField = By.xpath("//div/form/fieldset[1]//input[@name='name']");
	private final By emailField = By.xpath("//div/form/fieldset[2]//input[@name='name']");
	private final By passwordField = By.xpath(".//input[@name='Пароль']");
	private final By invalidPasswordError = By.xpath(".//p[text() = 'Некорректный пароль']");
	private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

	public RegisterPage(WebDriver webDriver) {
		BasePage.webDriver = webDriver;
		webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
	}

	@Step("Открыть страницу регистрации")
	public void openPage() {
		webDriver.get(REGISTER_PAGE);
	}

	@Step("Дождаться прогрузки страницы - появления формы регистрации")
	public void waitForLoadRegistrationForm() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(registerBlock));
	}

	@Step("Отображается ошибка 'Некорректный пароль'")
	public boolean invalidPasswordIsDisplayed() {
		return webDriver.findElement(invalidPasswordError).isDisplayed();
	}

	@Step("Нажать на кнопку 'Регистрация'")
	public void clickRegisterButton() {
		webDriver.findElement(registerButton).click();
	}

	@Step("Нажать на кнопку 'Войти'")
	public void clickLoginButton() {
		webDriver.findElement(loginButton).click();
	}

	@Step("Заполнить поле 'Имя'")
	public void setName(String name) {
		webDriver.findElement(nameField).sendKeys(name);
	}

	@Step("Заполнить поле 'Email'")
	public void setEmail(String email) {
		webDriver.findElement(emailField).sendKeys(email);
	}

	@Step("Заполнить поле 'Пароль'")
	public void setPassword(String password) {
		webDriver.findElement(passwordField).sendKeys(password);
	}

	@Step("Заполнить поля регистрационной формы и подтвердить отправку")
	public void fillRegistrationForm(String name, String email, String password) {
		waitForLoadRegistrationForm();
		setName(name);
		setEmail(email);
		setPassword(password);
	}
}
