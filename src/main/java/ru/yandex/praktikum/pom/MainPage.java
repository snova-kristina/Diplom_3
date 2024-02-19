package ru.yandex.praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.api.config.URL.MAIN_PAGE;

public class MainPage extends BasePage {

	private final By profileButton = By.xpath(".//*[text()='Личный Кабинет']");
	private final By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
	private final By constructorBlock = By.className("BurgerIngredients_ingredients__1N8v2");
	private final By ingredientsButton = By.xpath(".//span[text()='Начинки']");
	private final By bunsButton = By.xpath(".//span[text()='Булки']");
	private final By saucesButton = By.xpath(".//span[text()='Соусы']");
	private final By createOrderButton = By.xpath(".//*[text()='Оформить заказ']");
	private final By selectedSection = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");

	public MainPage(WebDriver webDriver) {
		BasePage.webDriver = webDriver;
		webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
	}

	@Step("Открыть главную страницу")
	public void openPage() {
		webDriver.get(MAIN_PAGE);
	}

	@Step("Дождаться прогрузки страницы -появления блока с ингредиентами")
	public void waitForLoadMainPage() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(constructorBlock));
	}
	@Step("Отображается кнопка 'Создать заказ'")
	public boolean createOrderButtonIsDisplayed() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(constructorBlock));
		return webDriver.findElement(createOrderButton).isDisplayed();
	}

	@Step("Отображается блок 'Конструктор'")
	public boolean constructorBlockIsDisplayed() {
		return webDriver.findElement(constructorBlock).isDisplayed();
	}

	@Step("Нажать на кнопку 'Личный Кабинет'")
	public void clickProfileButton() {
		webDriver.findElement(profileButton).click();
	}

	@Step("Нажать на кнопку 'Войти в аккаунт'")
	public void clickLoginButton() {
		webDriver.findElement(loginButton).click();
	}

	@Step("Перейти в раздел 'Соусы'")
	public void clickSaucesButton() {
		webDriver.findElement(saucesButton).click();
	}

	@Step("Перейти в раздел 'Булки'")
	public void clickBunsButton() {
		webDriver.findElement(bunsButton).click();
	}

	@Step("Перейти в раздел 'Начинки'")
	public void clickIngredientsButton() {
		webDriver.findElement(ingredientsButton).click();
	}

	@Step("Получение названия текущего раздела")
	public String getSelectedSection() {
		return webDriver.findElement(selectedSection).getText();
	}
}
