package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
		// Full path where login.html is located.
		// You can click on html file and copy the path shown in your browser.
		//
		driver.navigate().to(
				"C://Users//Zaina//OneDrive//Documents//deakin//software testing//week 8//pages/login.html");
		sleep(5);
		
		// Find username element
		//
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		// Find password element
		//
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		ele = driver.findElement(By.id("dob"));
	    ele.clear();
	    ele.sendKeys("01-01-1990");
		
		// Find Submit button, and click on button.
		//
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		Assert.assertTrue(title.contains("success"));
		
		driver.close();
	}
	@Test
	public void testInvalidUsername() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
	    driver.navigate().to("C://Users//Zaina//OneDrive//Documents//deakin//software testing//week 8//pages/login.html");
	    sleep(5);

	    WebElement usernameElement = driver.findElement(By.id("username"));
	    usernameElement.clear();
	    usernameElement.sendKeys("invalidUser");

	    WebElement passwordElement = driver.findElement(By.id("passwd"));
	    passwordElement.clear();
	    passwordElement.sendKeys("validPass");

	    WebElement dobElement = driver.findElement(By.id("dob"));
	    dobElement.clear();
	    dobElement.sendKeys("1990-01-01");

	    WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
	    submitButton.submit();

	    sleep(5);

	    String title = driver.getTitle();
	    System.out.println("Title: " + title);

	    Assert.assertEquals("fail", title);

	    driver.close();
	}

	@Test
	public void testInvalidPassword() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
	    driver.navigate().to("C://Users//Zaina//OneDrive//Documents//deakin//software testing//week 8//pages/login.html");
	    sleep(5);

	    WebElement usernameElement = driver.findElement(By.id("username"));
	    usernameElement.clear();
	    usernameElement.sendKeys("validUser");

	    WebElement passwordElement = driver.findElement(By.id("passwd"));
	    passwordElement.clear();
	    passwordElement.sendKeys("invalidPass");

	    WebElement dobElement = driver.findElement(By.id("dob"));
	    dobElement.clear();
	    dobElement.sendKeys("1990-01-01");

	    WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
	    submitButton.submit();

	    sleep(5);

	    String title = driver.getTitle();
	    System.out.println("Title: " + title);

	    Assert.assertEquals("fail", title);

	    driver.close();
	}

	@Test
	public void testInvalidDateOfBirth() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
	    driver.navigate().to("C://Users//Zaina//OneDrive//Documents//deakin//software testing//week 8//pages/login.html");
	    sleep(5);

	    WebElement usernameElement = driver.findElement(By.id("username"));
	    usernameElement.clear();
	    usernameElement.sendKeys("ahsan");

	    WebElement passwordElement = driver.findElement(By.id("passwd"));
	    passwordElement.clear();
	    passwordElement.sendKeys("ahsan_pass");

	    WebElement dobElement = driver.findElement(By.id("dob"));
	    dobElement.clear();
	    dobElement.sendKeys("1990-01-01"); // Invalid date

	    WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
	    submitButton.submit();

	    sleep(5);

	    String title = driver.getTitle();
	    System.out.println("Title: " + title);

	    Assert.assertEquals("fail", title);

	    driver.close();
	}

	@Test
	public void testEmptyFields() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
	    driver.navigate().to("C://Users//Zaina//OneDrive//Documents//deakin//software testing//week 8//pages/login.html");
	    sleep(5);

	    WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
	    submitButton.submit();

	    sleep(5);
	    String title = driver.getTitle();

	    System.out.println("Title: " + title);

	    Assert.assertEquals("fail", title);

	    driver.close();
	}

	
	
}
