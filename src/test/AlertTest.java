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
	 *�򿪡�ui�Զ���ҳ���ԡ�ҳ��
	 *���Alert��ť
	 *��alert�������ȷ����ť
	 * */
	@Test
	public void alterTest() throws InterruptedException{
		driver.get("file://C:/xxxx");
		driver.findElement(By.className("alter")).click();
		Thread.sleep(3000);
		//TimeUnit.SECONDS.sleep(5);
		//�ѿ���Ȩת����Alert
		Alert alert=driver.switchTo().alert();
		//��ȡ�������ı�ֵ
		String text=alert.getText();
		//У���ȡ�����ı���Ϣ�Ƿ���ȷ
		Assert.assertEquals(text,"����ȷ��");
		alert.accept();
		
	}
	
	/*
	 * �򿪡�ui�Զ������ԡ�ҳ��
	 * ���confirm��ť
	 * ��Confirm�������ȷ��\ȡ����ť
	 * �ٴε��ȷ����ť
	 * */
	@Test
	public void ConfirmTest(){
		driver.get("ui����ҳ��");
		driver.findElement(By.className("confirm")).click();
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//��һ��д��
		//driver.switchTo().alert().dismiss();
		//�ڶ���д��
		Alert alert=driver.switchTo().alert();//driver����Ȩת��alert��ע�⣺json�ľ��浯���Ż��õ�switch
		//���ȡ��
		alert.dismiss();
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//���ȷ��
		alert.accept();
	}
	
	/*
	 * �򿪡�ui�Զ������ԡ�ҳ��
	 * ���Prompt��ť
	 * ��Prompt�����У����롰�����Prompt��
	 * ���ȷ��
	 * �ٴε��ȷ����ť
	 * */
	@Test
	public void PromptTest(){
		driver.get("��ui�Զ�������ҳ��");
		driver.findElement(By.className("prompt")).click();
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//�ѿ���Ȩת����alert
		Alert alert=driver.switchTo().alert();
		//�����ı��������prompt��
		alert.sendKeys("�����prompt");
		//���ȷ����ť
		alert.accept();				
	}
	
	/*
	 *�򿪲���ҳ��
	 *����ٶ����� 
	 * */
	@Test
	public void ifFromTest() throws InterruptedException{
		driver.get("��ui�Զ�������ҳ��");
		//��һ�ַ�����ͨ������id or name�ķ�ʽת������Ȩ
		//driver.switchTo().frame("a");//frame("nameֵ")
		//�ڶ��ַ�����ͨ��WebElement��ʽ
		WebElement iframe=driver.findElement(By.tagName("iframe"));//���ת������һ��һ����һ��һ���д
		driver.switchTo().frame(iframe);
		driver.findElement(By.linkText("baidu")).click();
		Thread.sleep(5000);
		//driver ����Ȩת����ԭ������
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("��¼����")).click();
	}
	

	@AfterMethod
	public void closed() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}
	

}
