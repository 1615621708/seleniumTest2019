package test;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NewTest {
	WebDriver driver;
  
	@BeforeMethod
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	/*
	 * ��Ҫ����ٶ���ҳ����������
	 * 
	 * */
	@Test
	public void clickTest() {
		driver.get("https://www.baidu.com");
		//driver.findElement(By.name("tj_trnews")).click();
		WebElement newslink=driver.findElement(By.name("tj_trnews"));
		newslink.click();
		//��ȡ��ǰҳ���Url
		String url=driver.getCurrentUrl();
		//У�鵱ǰҳ���ǲ�������ҳ��
		AssertJUnit.assertEquals(url,"http://news.baidu.com/");
		
  }
	/*
	 * �򿪰ٶ���ҳ
	 * ����ؼ���selenium
	 * ����ٶ�һ�½�������
	 * У��title�Ƿ���ڡ�selenium_�ٶ�������
	 * */
	@Test
	public void sendKeysTest(){
		driver.get("https://www.baidu.com");
		//��λ�ٶ�������
		WebElement keys=driver.findElement(By.id("kw"));
		//����������selenium
		keys.sendKeys("selenium");
		//��λ�ٶ�һ�°�ť
		WebElement baiduButton=driver.findElement(By.id("su"));
		//���
		baiduButton.click();
		//��ӵȴ�3s
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡҳ��title
		String title =driver.getTitle();
		AssertJUnit.assertEquals(title,"selenium_�ٶ�����");
	}
	@Test
	public void clearTest() throws InterruptedException{
		driver.get("https://www.baidu.com");
		//��λ�ٶ�������
		WebElement keys=driver.findElement(By.id("kw"));
		//����������selenium
		keys.sendKeys("selenium");
		Thread.sleep(3000);
		//��������selenium
		keys.clear();
		Thread.sleep(3000);
	}
	/*
	 * �򿪰ٶ�ҳ��
	 * ��ȡ�����ı�
	 * ��ȥ��������ı�
	 * �����Ƿ�Ϊ��selenium��
	 * ����ı���
	 * �ٴλ�ȡ������ı�
	 * У���ı�Ϊ��
	 * */
	@Test
	public void getTextTest(){
		driver.get("https://www.baidu.com");
		WebElement text1=driver.findElement(By.name("tj_trnews"));
		//��ȡ�����ı�
		String i=text1.getText();
		AssertJUnit.assertEquals(i,"����");
		System.out.println(i);
	}
	@Test
	public void getName(){
		driver.get("https://www.baidu.com");
		WebElement w1=driver.findElement(By.id("kw"));
		String tagName=w1.getTagName();
		/*if(tagName.equals("input")){
			System.out.println("ok");
		}else{
			System.out.println("error");
		}*/
		AssertJUnit.assertEquals(tagName,"input");
		
	}
	
	/*
	 * �򿪰ٶ�ҳ��
	 * �жϰ�ť��ʾ���ı�ֵΪ �ٶ�һ��
	 * */
	@Test
	public void getAttriButeTest(){
		driver.get("https://www.baidu.com");
		WebElement w2=driver.findElement(By.id("su"));
		String attriBute=w2.getAttribute("type");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(attriBute);
		AssertJUnit.assertEquals(attriBute,"submit");
		
	}
	
	/*
	 * �򿪰ٶ���ҳ
	 * �ж��Ƿ���ʾ�ٶ�һ�°�ť
	 * */
	@Test
	public void isDisplayedTest(){
		driver.get("https://www.baidu.com");
		WebElement w1=driver.findElement(By.id("su"));
		Boolean b=w1.isDisplayed();
		System.out.println(b);
		Assert.assertTrue(b);	
		

	}
	/*
	 * �򿪲���ҳ��
	 * �ж�Volvo��ѡ��ѡ��
	 * */
	@Test
	public void isSelectedTest(){
		driver.get("https://www.baiud.com");
		WebElement w1=driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
		w1.click();
		Boolean b=w1.isSelected();
		Assert.assertTrue(b);
		
	}
	/*
	 *�򿪲���ҳ��
	 *��sumbit button��ť����δ����״̬ 
	 * */
	@Test
	public void isEnabledTest(){
		driver.get("https://����ҳ��");
		Boolean b=driver.findElement(By.name("buttonhtml")).isEnabled();//����ص���true��������ص���false
		Assert.assertFalse(b);
	}
	
	/*��ͼ
	 * �򿪰ٶ�ҳ�棬��ͼ�ٶ���ҳ
	 * */
	@Test
	public void shotTest(){
		driver.get("https://www.baidu.com");
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File file=(File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//�ڶ���д��
		try{
			FileUtils.copyFile(file,new File("D:\\test1.png"));
		}catch(IOException e){
			e.printStackTrace();
		}

	}
	
	@AfterMethod
	public void closed(){
		driver.quit();
	}
	
	
}
