package test;

import java.util.concurrent.TimeUnit;

//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import javax.imageio.ImageIO;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class JsTest {
	WebDriver driver;
	@BeforeMethod
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		//全局等待
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void exJS(){
		driver.get("https://www.baidu.com");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('kw').setAttribute('value','webdriver')");
		//另一种写法
		//js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")")
		
	}
	
	
	/*
	 * 163注册
	 * */
	@Test
	public void registest(){
		driver.get("https://mail.163.com");
		driver.findElement(By.cssSelector("#commonOperation > a.u-reg-entry.u-163-reg-entry")).click();
		String handle1=driver.getWindowHandle();
		for(String handles:driver.getWindowHandles()){
			if(handles.equals(handle1)){
				continue;
			}else{
				driver.switchTo().window(handles);
			}

		}
		String Time =String.valueOf(System.currentTimeMillis()/100);
		driver.findElement(By.id("nameIpt")).sendKeys("email"+Time);
		driver.findElement(By.id("mainPwdIpt")).sendKeys("qq0000");
		driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("qq0000");
		driver.findElement(By.id("vcodeIpt")).sendKeys("asdas");		
//		WebElement ele = driver.findElement(By.id("vcodeImg"));
//		java.io.File screenshot = (java.io.File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		BufferedImage fullImg=ImageIO.read(screenshot);
//		org.openqa.selenium.Point point= ele.getLocation();
//		int eleWidth= ele.getSize().getWidth();
//		int eleHeight= ele.getSize().getHeight();
//		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
//		ImageIO.write(eleScreenshot, "png", screenshot);
//		java.io.File screenshotLocation= new java.io.File("D://test.png//");
//		FileUtils.copyFile(screenshot, screenshotLocation);
//		driver.findElement(By.id("vcodeIpt"));		
		driver.findElement(By.id("mainMobileIpt")).sendKeys(Time);			
		driver.findElement(By.id("mainRegA")).click();
		String w1=driver.findElement(By.cssSelector("#m_mainAccept > span")).getText();
		Assert.assertEquals(w1, "  请接受《网易邮箱帐号服务条款》和《网易隐私政策》");

		//显示等待
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" ")));
		//String w1=String.valueOf(System.currentTimeMillis());
	} 
	
	@Test
	public void loginTest() throws InterruptedException{
		driver.get("https://mail.163.com");
		//driver.manage().window().maximize();
		driver.manage().window().maximize();   
		driver.findElement(By.id("lbNormal")).click();
		Thread.sleep(2000);
		WebElement iframe=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe); 
		driver.findElement(By.name("email")).sendKeys("qq18574917812");
		driver.findElement(By.name("password")).sendKeys("qq0000");

	
		driver.findElement(By.id("dologin")).click();
		//driver.findElement(By.id("_mail_tabitem_0_3text"));
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_mail_tabitem_0_3text")));
		String w1=driver.findElement(By.id("_mail_tabitem_0_3text")).getText();
		Assert.assertEquals(w1,"首页");

	}
	
	
    @Test
	public void testcase01(){
		long time =System.currentTimeMillis();
		System.out.println(time);

	}
	
	
	@AfterMethod
	public void closeChrome() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}

}
