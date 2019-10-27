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
	 * �򿪰ٶ�ҳ��
	 * �ڰٶ�һ�°�ť �Ҽ�
	 * */
	@Test
	public void rightClickTest(){
		driver.get("https://www.baidu.com");
		WebElement buttonBaidu=driver.findElement(By.id("su"));
		//ʵ����actions
		Actions actions= new Actions(driver);
		//�ڵ���ٶ�һ�°�ť �Ҽ�
		actions.contextClick(buttonBaidu).perform();
	}
	
	/*
	 * �򿪰ٶ�ҳ��
	 * ˫���ٶ�һ�°�ť
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
	 * �򿪰ٶ�ҳ��
	 * ����ƶ��������Ʒ��ť
	 * ��ô��ʾ�����Ʒ
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
	 * ��Ԫ���ϵ���һ���ط�ȥ
	 * */
	public void testDrop(){
		driver.get("�򿪲���ҳ��");
		WebElement w1=driver.findElement(By.id("drag"));
		Actions actions =new Actions(driver);
		actions.dragAndDropBy(w1, 500, 500).perform(); 
		
	}
	
	@Test
	public void dropTest(){
		driver.get("�򿪲���ҳ��");
		WebElement d1=driver.findElement(By.id("drag"));
		WebElement d2=driver.findElement(By.xpath("��ק��·��"));
		Actions actions=new Actions(driver);
		actions.clickAndHold(d1).moveToElement(d2).release(d1).perform();
	}
	
	@Test
	public void moreSelectTest(){
		driver.get("�򿪲���ҳ��");
		WebElement w1=driver.findElement(By.id("��λid��Ϣ"));
		List<WebElement> list=(List<WebElement>) driver.findElement(By.xpath("����ѡ��ֵ·��"));
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
		driver.get("���ϴ��ļ�ҳ��");
		driver.findElement(By.id("load")).sendKeys("�ϴ�ͼƬ�ĵ�ַ");
	}
	
	

	@AfterMethod
	public void closeChrome() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}

}
