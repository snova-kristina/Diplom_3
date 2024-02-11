package ru.yandex.praktikum.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
	public WebDriver getWebDriver() {
		ChromeOptions options = new ChromeOptions();
		switch (System.getProperty("browser")) {
			case "yandex":
				options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
				System.setProperty("webdriver.chrome.driver","/Users/kristinarudik/IdeaProjects/Diplom_3/src/main/resources/yandexdriver");
				options.addArguments("--remote-allow-origins=*");
				return new ChromeDriver(options);
			case "chrome":
				System.setProperty("webdriver.chrome.driver","/Users/kristinarudik/IdeaProjects/Diplom_3/src/main/resources/chromedriver");
				options.addArguments("--remote-allow-origins=*");
				return new ChromeDriver(options);
			default:
				throw new RuntimeException("Необходимо указать браузер для запуска.");
		}
	}
}

