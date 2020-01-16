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

	
	//�л���Page�洢��Ԫ��
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
	//�����Լ�д�ķ�����login
	public void loginError(){
		AutoTest.login(driver,"qq18574917812","qq0000");
		//��ʾ�ȴ�
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_mail_tabitem_0_3text")));
		String w1=driver.findElement(By.id("_mail_tabitem_0_3text")).getText();
		Assert.assertEquals(w1,"��ҳ");
	}
	
	/*
	 * ��¼163����
	 * 
	 * */
	@Test
	public void sendEmail(){
		AutoTest.login(driver,"qq18574917812","qq0000");
		//���д�Ű�ť
		driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("qq18574917812@163.com");
		//��λ�����ı��򣬲������ı�
		driver.findElement(By.xpath("//*[@aria-label=\"�ʼ�����������������ʼ�����\"]/input")).sendKeys("���������");
		//�ϴ��ļ�
		driver.findElement(By.xpath("//*[@title=\"һ�οɷ���2000����Ƭ��600��MP3��һ�������Ӱ\"]/input")).sendKeys("C:\\Users\\Administrator\\Desktop\\WEB�Զ�������Ӣ�ĵ���.txt");
		WebElement frame=driver.findElement(By.className("APP-editor-iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body")).sendKeys("������������");
		//driver �Ŀ���Ȩת������
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[text()=\"����\"]")).click();
		Boolean text=driver.findElement(By.xpath("//*[text()=\"���ͳɹ�\"]")).isDisplayed();
		Assert.assertTrue(text);
	}
	
	@AfterMethod
	public void closed(){
		driver.quit();
	}

}
