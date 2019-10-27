package test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest2 {
	WebDriver driver;
	
	@BeforeMethod
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	/*
	 * 打开百度页面
	 * 在百度一下按钮 右键
	 * */
	@Test
	public void rightClickTest(){
		driver.get("https://www.baidu.com");
		WebElement buttonBaidu=driver.findElement(By.id("su"));
		//实例化actions
		Actions actions= new Actions(driver);
		//在点击百度一下按钮 右键
		actions.contextClick(buttonBaidu).perform();
	}
	
	/*
	 * 打开百度页面
	 * 双击百度一下按钮
	 * */
	@Test
	public void doubleClickTest(){
		driver.get("https://ww.baidu.com");
		WebElement element=driver.findElement(By.id("su"));
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	/*
	 * 打开百度页面
	 * 鼠标移动到更多产品按钮
	 * 那么显示更多产品
	 * */
	@Test
	public void moveToTest(){
		driver.get("https://www.baidu.com");
		WebElement element=driver.findElement(By.name("tj_briicon"));
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
		String nuomi=driver.findElement(By.className("bdbriimgitem_1")).getText();
		Assert.assertEquals(nuomi,"bdbriimgitem_1");
	}
	
	/*
	 * 将元素拖到另一个地方去
	 * */
	public void testDrop(){
		driver.get("打开测试页面");
		WebElement w1=driver.findElement(By.id("drag"));
		Actions actions =new Actions(driver);
		actions.dragAndDropBy(w1, 500, 500).perform(); 
		
	}
	
	@Test
	public void dropTest(){
		driver.get("打开测试页面");
		WebElement d1=driver.findElement(By.id("drag"));
		WebElement d2=driver.findElement(By.xpath("拖拽的路径"));
		Actions actions=new Actions(driver);
		actions.clickAndHold(d1).moveToElement(d2).release(d1).perform();
	}
	
	@Test
	public void moreSelectTest(){
		driver.get("打开测试页面");
		WebElement w1=driver.findElement(By.id("定位id信息"));
		List<WebElement> list=(List<WebElement>) driver.findElement(By.xpath("下拉选项值路径"));
		Actions actions=new Actions(driver);//CONTROL
		actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
	} 
	
	@Test
	public void savaHtml() throws AWTException,InterruptedException{
		driver.get("https://www.baidu.com");
		Robot robot =new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		//int keys=(int)new Character('s');
		//System.println(keys);
		//robot.keyPress(87);
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
	}
	
	@Test
	public void uploadTest(){
		driver.get("打开上传文件页面");
		driver.findElement(By.id("load")).sendKeys("上传图片的地址");
	}
	
	

	@AfterMethod
	public void closeChrome() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}

}
