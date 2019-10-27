package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoTEST1 {
	WebDriver driver;
	@BeforeMethod
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://mail.163.com");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

	}
	public static void Login(WebDriver driver,String email,String password){
		driver.manage().window().maximize();
//		driver.findElement(By.id("lbNormal")).click();
		driver.findElement(By.cssSelector("#commonOperation > a.u-reg-entry.u-163-reg-entry")).click();
		String handle1=driver.getWindowHandle();
		for(String handles:driver.getWindowHandles()){
			if(handles.equals(handle1)){
				continue;
			}else{
				driver.switchTo().window(handles);
			}

		}
		String time=String.valueOf(System.currentTimeMillis()/100);
		driver.findElement(By.id("nameIpt")).sendKeys("email"+time);
		driver.findElement(By.id("mainPwdIpt")).sendKeys("password");
		driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("password");
		driver.findElement(By.id("vcodeIpt")).sendKeys("asda");
		driver.findElement(By.cssSelector("//*[@id=\"mainMobileIpt\"]")).sendKeys(time);
		driver.findElement(By.id("//*[@id=\"mainRegA\"]")).click();
		
	}
	@Test
	public void AtuoEamil(){
		AutoTEST1.Login(driver,"emali","password");
	}
	
	@Test
	public void AtuoEmail(){
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#lbNormal")).click();
		WebElement frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.name("email")).sendKeys("qq18574917812");
		driver.findElement(By.name("password")).sendKeys("qq0000");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("qq18574917812@163.com");
		driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("这个是主题");
		WebElement iframe=driver.findElement(By.className("APP-editor-iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("/html/body")).sendKeys("坚持学习！@刘宏淼");
		driver.findElement(By.id("//*[@text()=\"发送\"]")).click();
		Boolean b1=driver.findElement(By.id("//*[text()=\"发送成功\"]")).isDisplayed();
		Assert.assertTrue(b1);
		
		
		
	}
	@AfterMethod
	public void closed() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
		
	}

}
