package ru.yandex.praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {

	private final By logOutButton = By.xpath(".//button[text()='Выход']");
	private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
	private final By headerLogoButton = By.className("AppHeader_header__logo__2D0X2");


	public ProfilePage(WebDriver webDriver) {
		BasePage.webDriver = webDriver;
		webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
	}
	@Step("Дождаться прогрузки страницы - появления кнопки выхода")
	public void waitForLogOutButton() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(logOutButton));
	}
	@Step("Нажать на кнопку 'Конструктор'")
	public void clickConstructorButton() {
		webDriver.findElement(constructorButton).click();
	}

	@Step("Нажать на логотип")
	public void clickHeaderLogo() {
		webDriver.findElement(headerLogoButton).click();
	}

	@Step("Нажать на кнопку 'Выйти'")
	public void clickLogOutButton() {
		waitForLogOutButton();
		webDriver.findElement(logOutButton).click();
	}
}
