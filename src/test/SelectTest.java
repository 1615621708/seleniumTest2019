package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
	WebDriver driver;
	
	@BeforeMethod
	public  void openChrome(){
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		//添加全局等待
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/*
	 * 打开我们的测试界面
	 * 下拉框选择vivo
	 * 第二次选择huawei
	 * 第三次选择iphone
	 * */
	@Test
	public void selectTest(){
		driver.get("打开测试界面");
		//查找元素
		WebElement element=driver.findElement(By.id("moreSelect"));
		//实例化 select 类
		Select select=new Select(element);
		
		//第一种方法：通过索引来选取下拉框，从0开始
		select.selectByIndex(2);
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//第二种方法：通过属性value的属性值来选取
		select.selectByValue("huawei");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		//第三种：通过标文本值来选取下拉框
		select.selectByVisibleText("iphone");
		
	}
	
	
	/*
	 * 打开测试界面
	 * 打开open new window
	 * 新的窗口点击baidu
	 * */
	@Test
	public void testWindow() throws InterruptedException{
		driver.get("测试页面");
		driver.findElement(By.linkText("Open new window")).click();
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		//获取当前driver所在的页面的  句柄值
		String handle1=driver.getWindowHandle();
		
		//for循环判断获取到的handles是否等于handle1
		for(String handles:driver.getWindowHandles()){
			if(handles.equals(handle1)){
				continue;//表示不往下执行
				//break;表示循环结束
			}else{
				driver.switchTo().window(handles);
			}
		}

		//driver.getWindowHandles();
		//driver.switchTo().window();
		driver.findElement(By.linkText("baidu")).click();
		Thread.sleep(5000);
		
		//回到第一个页面，直接在window（“写入第一个页面的句柄”）
		driver.switchTo().window(handle1);
			
	}
	
	/*
	 *打开测试界面
	 *点击wait按钮
	 *获取文本病判断是否为“wait for display” 
	 * */
	@Test
	public void waitTest(){
		driver.get("测试界面");
		driver.findElement(By.xpath("xpath路径"));//全局等待又叫做：隐示等待
		//显示等待  ，，，，，实例化WebDriverWait类
		WebDriverWait wait=new WebDriverWait(driver,10);
		//
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("路径2")));
		String text=driver.findElement(By.xpath("路径2")).getText();
		Assert.assertEquals(text,"wait for display");
	}
	
	@Test
	public void openMail()  throws InterruptedException{
		driver.get("https://www.mail.163.com");
		driver.findElement(By.linkText("密码登录")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("x-URS-iframe1567182121025.8394");
		driver.findElement(By.name("email")).sendKeys("qq18574917812");
		driver.findElement(By.name("password")).sendKeys("qq0000");
		
	}
	
	
	@AfterMethod
	public void closed() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}

}
