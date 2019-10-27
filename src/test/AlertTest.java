package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
	WebDriver driver;
	@BeforeMethod
	public void f(){
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	/*
	 *打开“ui自动化页测试”页面
	 *点击Alert按钮
	 *在alert警告框点击确定按钮
	 * */
	@Test
	public void alterTest() throws InterruptedException{
		driver.get("file://C:/xxxx");
		driver.findElement(By.className("alter")).click();
		Thread.sleep(3000);
		//TimeUnit.SECONDS.sleep(5);
		//把控制权转交给Alert
		Alert alert=driver.switchTo().alert();
		//获取警告框的文本值
		String text=alert.getText();
		//校验获取到的文本信息是否正确
		Assert.assertEquals(text,"请点击确定");
		alert.accept();
		
	}
	
	/*
	 * 打开“ui自动化测试”页面
	 * 点击confirm按钮
	 * 在Confirm警告框点击确定\取消按钮
	 * 再次点击确定按钮
	 * */
	@Test
	public void ConfirmTest(){
		driver.get("ui测试页面");
		driver.findElement(By.className("confirm")).click();
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//第一种写法
		//driver.switchTo().alert().dismiss();
		//第二种写法
		Alert alert=driver.switchTo().alert();//driver控制权转交alert，注意：json的警告弹窗才会用到switch
		//点击取消
		alert.dismiss();
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//点击确定
		alert.accept();
	}
	
	/*
	 * 打开“ui自动化测试”页面
	 * 点击Prompt按钮
	 * 在Prompt弹窗中，输入“这个是Prompt”
	 * 点击确定
	 * 再次点击确定按钮
	 * */
	@Test
	public void PromptTest(){
		driver.get("打开ui自动化测试页面");
		driver.findElement(By.className("prompt")).click();
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//把控制权转交给alert
		Alert alert=driver.switchTo().alert();
		//输入文本“这个是prompt”
		alert.sendKeys("这个是prompt");
		//点击确定按钮
		alert.accept();				
	}
	
	/*
	 *打开测试页面
	 *点击百度链接 
	 * */
	@Test
	public void ifFromTest() throws InterruptedException{
		driver.get("打开ui自动化测试页面");
		//第一种方法，通过传入id or name的方式转交控制权
		//driver.switchTo().frame("a");//frame("name值")
		//第二种方法，通过WebElement方式
		WebElement iframe=driver.findElement(By.tagName("iframe"));//多层转交跟第一层一样，一层一层的写
		driver.switchTo().frame(iframe);
		driver.findElement(By.linkText("baidu")).click();
		Thread.sleep(5000);
		//driver 控制权转交给原来界面
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("登录界面")).click();
	}
	

	@AfterMethod
	public void closed() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}
	

}
