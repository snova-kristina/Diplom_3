package ru.yandex.praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.api.config.URL.FORGOT_PASSWORD_PAGE;

public class ForgotPasswordPage extends BasePage{

	private final By loginButton = By.className("Auth_link__1fOlj");
	public ForgotPasswordPage(WebDriver webDriver) {
		BasePage.webDriver = webDriver;
		webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
	}
	@Step("Открыть страницу восстановления пароля")
	public void openPage(){
		webDriver.get(FORGOT_PASSWORD_PAGE);
	}
	@Step("Нажать на кнопку 'Войти'")
	public void clickLoginButton() {
		webDriver.findElement(loginButton).click();
	}
}
