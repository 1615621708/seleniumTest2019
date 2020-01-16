package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test01 {
	WebDriver driver;
	@Test
	public void test02() throws InterruptedException{
		System.setProperty("webdriver.firefox.driver","D:\\Firefox\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://mail.163.com");
		Thread.sleep(10000);
	}

}
