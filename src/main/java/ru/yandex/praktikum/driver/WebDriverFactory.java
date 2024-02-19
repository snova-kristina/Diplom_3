package ru.yandex.praktikum.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
	public WebDriver getWebDriver() {
		ChromeOptions options = new ChromeOptions();
		switch (System.getProperty("browser")) {
			case "yandex":
				System.setProperty("webdriver.chrome.driver","src/main/resources/yandexdriver");
				options.addArguments("--remote-allow-origins=*");
				return new ChromeDriver(options);
			case "chrome":
				System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
				options.addArguments("--remote-allow-origins=*");
				return new ChromeDriver(options);
			default:
				throw new RuntimeException("Необходимо указать браузер для запуска.");
		}
	}
}

