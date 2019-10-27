package test;



//import java.awt.SystemTray;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.annotations.*;   // * Ϊ�������еķ���

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
	//�ȴ�5S
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// �������������
	driver.navigate().back();
	//�ȴ�3S
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
	//�رյ�ǰ����
	//driver.close();
	//�ر����������ȫ���˳������
	driver.quit();
	}
	
	
	@Test
	public void winTest() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.baidu.com");
		//ʵ����Dimension ���ô��ڴ�С��
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
		System.out.println("��ȡ����Url�ǣ�"+ url);
		Thread.sleep(3000);
		Assert.assertEquals(url,"https://www.baidu.com/1");
		
	}
	@AfterMethod
	public void closedBrowser(){
		driver.quit();
		
	}

		
}

	
	


