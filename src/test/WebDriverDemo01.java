package test;



//import java.awt.SystemTray;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.annotations.*;   // * 为引进所有的方法

public class WebDriverDemo01 {
	WebDriver driver;
	@BeforeMethod
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
	}
	
	
	@Test
	public static void openChrome01(){
		
	System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.baidu.com");
	//等待5S
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// 浏览器导航后退
	driver.navigate().back();
	//等待3S
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.navigate().forward();
	driver.navigate().refresh();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//关闭当前窗口
	//driver.close();
	//关闭浏览器，完全的退出浏览器
	driver.quit();
	}
	
	
	@Test
	public void winTest() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.baidu.com");
		//实例化Dimension 设置窗口大小；
		Dimension dimension = new Dimension(300,300);
		driver.manage().window().setSize(dimension);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	@Test
	public void getURLTest() throws InterruptedException{
		driver=new ChromeDriver();
		driver.get("https://www.baidu.com/");
		String url=driver.getCurrentUrl();
		System.out.println("获取到的Url是："+ url);
		Thread.sleep(3000);
		Assert.assertEquals(url,"https://www.baidu.com/1");
		
	}
	@AfterMethod
	public void closedBrowser(){
		driver.quit();
		
	}

		
}

	
	


