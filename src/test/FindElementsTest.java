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
	 * 打开百度页面
	 * 定位搜索（关键字）文本框
	 * */
	WebDriver driver;
	@BeforeMethod
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	//通过id定位搜索文本框
	@Test
	public void byIDTest(){
		driver.get("https://www.baidu.com/");
		WebElement keyFile=driver.findElement(By.id("kw"));
		
	}
	//通过name定位搜索文本框
	@Test
	public void byName(){
		driver.get("https://www.baidu.com/");
		driver.findElement(By.name("wd"));
	}
	
	//通过clss定位给搜索文本框
	//driver.findElement(By.className("class属性"));
	
	
	//linkText（Link文本）：只有在a标签才能用
	
	//通过部分文本标签：By.partialLinkText(Link文本)：
	@Test
	public void byTagName() throws InterruptedException{
		driver.get("htttps://www.baidu.com");
		WebElement list = (WebElement) driver.findElements(By.tagName("input"));
		System.out.println(list.getSize());
		//list.get(10).sendKeys("asdasd");
		Thread.sleep(5000);
	}
	
	//通过XPath定位搜索页面元素
	@Test
	public void byXpath(){
		driver.get("https://www.baidu.com");
		WebElement e1=driver.findElement(By.xpath(".//*[@id='u1']/a[1]"));
		System.out.println(e1.getText());
	}
	
	//通过Css定位搜索页面元素
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
