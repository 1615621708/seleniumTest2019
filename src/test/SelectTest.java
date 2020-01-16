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
		//���ȫ�ֵȴ�
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/*
	 * �����ǵĲ��Խ���
	 * ������ѡ��vivo
	 * �ڶ���ѡ��huawei
	 * ������ѡ��iphone
	 * */
	@Test
	public void selectTest(){
		driver.get("�򿪲��Խ���");
		//����Ԫ��
		WebElement element=driver.findElement(By.id("moreSelect"));
		//ʵ���� select ��
		Select select=new Select(element);
		
		//��һ�ַ�����ͨ��������ѡȡ�����򣬴�0��ʼ
		select.selectByIndex(2);
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//�ڶ��ַ�����ͨ������value������ֵ��ѡȡ
		select.selectByValue("huawei");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		//�����֣�ͨ�����ı�ֵ��ѡȡ������
		select.selectByVisibleText("iphone");
		
	}
	
	
	/*
	 * �򿪲��Խ���
	 * ��open new window
	 * �µĴ��ڵ��baidu
	 * */
	@Test
	public void testWindow() throws InterruptedException{
		driver.get("����ҳ��");
		driver.findElement(By.linkText("Open new window")).click();
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		//��ȡ��ǰdriver���ڵ�ҳ���  ���ֵ
		String handle1=driver.getWindowHandle();
		
		//forѭ���жϻ�ȡ����handles�Ƿ����handle1
		for(String handles:driver.getWindowHandles()){
			if(handles.equals(handle1)){
				continue;//��ʾ������ִ��
				//break;��ʾѭ������
			}else{
				driver.switchTo().window(handles);
			}
		}

		//driver.getWindowHandles();
		//driver.switchTo().window();
		driver.findElement(By.linkText("baidu")).click();
		Thread.sleep(5000);
		
		//�ص���һ��ҳ�棬ֱ����window����д���һ��ҳ��ľ������
		driver.switchTo().window(handle1);
			
	}
	
	/*
	 *�򿪲��Խ���
	 *���wait��ť
	 *��ȡ�ı����ж��Ƿ�Ϊ��wait for display�� 
	 * */
	@Test
	public void waitTest(){
		driver.get("���Խ���");
		driver.findElement(By.xpath("xpath·��"));//ȫ�ֵȴ��ֽ�������ʾ�ȴ�
		//��ʾ�ȴ�  ����������ʵ����WebDriverWait��
		WebDriverWait wait=new WebDriverWait(driver,10);
		//
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("·��2")));
		String text=driver.findElement(By.xpath("·��2")).getText();
		Assert.assertEquals(text,"wait for display");
	}
	
	@Test
	public void openMail()  throws InterruptedException{
		driver.get("https://www.mail.163.com");
		driver.findElement(By.linkText("�����¼")).click();
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
