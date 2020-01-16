package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test01.loginPage;

public class AutoTest {
	WebDriver driver;
	@BeforeMethod
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://mail.163.com");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}

	
	//切换成Page存储的元素
	public static void login(WebDriver driver,String email,String password){
		driver.manage().window().maximize();   
		driver.findElement(By.id("lbNormal")).click();
		WebElement iframe=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe); 
		driver.findElement(loginPage.emailInput).sendKeys(email);
		driver.findElement(loginPage.pwdInput).sendKeys(password);		
		driver.findElement(loginPage.loginButton).click();						
	}
	
	@Test
	//调用自己写的方法：login
	public void loginError(){
		AutoTest.login(driver,"qq18574917812","qq0000");
		//显示等待
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_mail_tabitem_0_3text")));
		String w1=driver.findElement(By.id("_mail_tabitem_0_3text")).getText();
		Assert.assertEquals(w1,"首页");
	}
	
	/*
	 * 登录163邮箱
	 * 
	 * */
	@Test
	public void sendEmail(){
		AutoTest.login(driver,"qq18574917812","qq0000");
		//点击写信按钮
		driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("qq18574917812@163.com");
		//定位主题文本框，并输入文本
		driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("这个是主题");
		//上传文件
		driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\Administrator\\Desktop\\WEB自动化测试英文单词.txt");
		WebElement frame=driver.findElement(By.className("APP-editor-iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body")).sendKeys("今天是星期日");
		//driver 的控制权转交回来
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[text()=\"发送\"]")).click();
		Boolean text=driver.findElement(By.xpath("//*[text()=\"发送成功\"]")).isDisplayed();
		Assert.assertTrue(text);
	}
	
	@AfterMethod
	public void closed(){
		driver.quit();
	}

}
