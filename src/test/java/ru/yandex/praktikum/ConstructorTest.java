package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {
	@Test
	@DisplayName("Переход к разделу 'Булки'")
	public void checkTransitionToBunsTest() {
		objMainPage.clickIngredientsButton();
		objMainPage.clickBunsButton();
		assertEquals("Булки", objMainPage.getSelectedSection());
	}

	@Test
	@DisplayName("Переход к разделу 'Соусы'")
	public void checkTransitionToSaucesTest() {
		objMainPage.clickSaucesButton();
		assertEquals("Соусы", objMainPage.getSelectedSection());
	}

	@Test
	@DisplayName("Переход к разделу 'Начинки'")
	public void checkTransitionToIngredientsTest() {
		objMainPage.clickIngredientsButton();
		assertEquals("Начинки", objMainPage.getSelectedSection());
	}
}
