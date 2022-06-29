package org.cibertec.ProyectoIntegrador;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTest {

	private WebDriver driver;
	
	@Test
	public void loginTest() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/");
		
		driver.findElement(By.id("email")).sendKeys("a@gmail.com");
		driver.findElement(By.id("clave")).sendKeys("123");
		
		driver.findElement(By.id("pruebab")).click();
		
		assertTrue(driver.findElement(By.id("pruebahe")).isDisplayed());
	}
}
