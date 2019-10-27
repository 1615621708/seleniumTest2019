package test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementsTest {
	/*
	 * �򿪰ٶ�ҳ��
	 * ��λ�������ؼ��֣��ı���
	 * */
	WebDriver driver;
	@BeforeMethod
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	//ͨ��id��λ�����ı���
	@Test
	public void byIDTest(){
		driver.get("https://www.baidu.com/");
		WebElement keyFile=driver.findElement(By.id("kw"));
		
	}
	//ͨ��name��λ�����ı���
	@Test
	public void byName(){
		driver.get("https://www.baidu.com/");
		driver.findElement(By.name("wd"));
	}
	
	//ͨ��clss��λ�������ı���
	//driver.findElement(By.className("class����"));
	
	
	//linkText��Link�ı�����ֻ����a��ǩ������
	
	//ͨ�������ı���ǩ��By.partialLinkText(Link�ı�)��
	@Test
	public void byTagName() throws InterruptedException{
		driver.get("htttps://www.baidu.com");
		WebElement list = (WebElement) driver.findElements(By.tagName("input"));
		System.out.println(list.getSize());
		//list.get(10).sendKeys("asdasd");
		Thread.sleep(5000);
	}
	
	//ͨ��XPath��λ����ҳ��Ԫ��
	@Test
	public void byXpath(){
		driver.get("https://www.baidu.com");
		WebElement e1=driver.findElement(By.xpath(".//*[@id='u1']/a[1]"));
		System.out.println(e1.getText());
	}
	
	//ͨ��Css��λ����ҳ��Ԫ��
	@Test
	public void byCss(){
		driver.get("https://www.baidu.com");
		driver.findElement(By.cssSelector("#lg>map>area"));
	}
	
	
	//
	@Test
	public void byXpath02(){
		driver.get("htpps://www.baidu.com");
		List<WebElement> list=(List<WebElement>) driver.findElements(By.xpath(".//*[@id='u1']"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			String text=list.get(i).getText();
			System.out.println(text);
		}

		}
		

	@AfterMethod
	public void closedBrowser(){
		driver.quit();
	}
	
	


}
