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
	 * 我要点击百度首页的新闻链接
	 * 
	 * */
	@Test
	public void clickTest() {
		driver.get("https://www.baidu.com");
		//driver.findElement(By.name("tj_trnews")).click();
		WebElement newslink=driver.findElement(By.name("tj_trnews"));
		newslink.click();
		//获取当前页面的Url
		String url=driver.getCurrentUrl();
		//校验当前页面是不是新闻页面
		AssertJUnit.assertEquals(url,"http://news.baidu.com/");
		
  }
	/*
	 * 打开百度首页
	 * 输入关键字selenium
	 * 点击百度一下进行搜索
	 * 校验title是否等于“selenium_百度搜索”
	 * */
	@Test
	public void sendKeysTest(){
		driver.get("https://www.baidu.com");
		//定位百度搜索框
		WebElement keys=driver.findElement(By.id("kw"));
		//搜索框输入selenium
		keys.sendKeys("selenium");
		//定位百度一下按钮
		WebElement baiduButton=driver.findElement(By.id("su"));
		//点击
		baiduButton.click();
		//添加等待3s
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取页面title
		String title =driver.getTitle();
		AssertJUnit.assertEquals(title,"selenium_百度搜索");
	}
	@Test
	public void clearTest() throws InterruptedException{
		driver.get("https://www.baidu.com");
		//定位百度搜索框
		WebElement keys=driver.findElement(By.id("kw"));
		//搜索框输入selenium
		keys.sendKeys("selenium");
		Thread.sleep(3000);
		//清空输入的selenium
		keys.clear();
		Thread.sleep(3000);
	}
	/*
	 * 打开百度页面
	 * 获取新闻文本
	 * 后去搜索框的文本
	 * 检验是否为“selenium”
	 * 清除文本框
	 * 再次获取输入框文本
	 * 校验文本为空
	 * */
	@Test
	public void getTextTest(){
		driver.get("https://www.baidu.com");
		WebElement text1=driver.findElement(By.name("tj_trnews"));
		//获取新闻文本
		String i=text1.getText();
		AssertJUnit.assertEquals(i,"新闻");
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
	 * 打开百度页面
	 * 判断按钮显示的文本值为 百度一下
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
	 * 打开百度首页
	 * 判断是否显示百度一下按钮
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
	 * 打开测试页面
	 * 判断Volvo单选框被选中
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
	 *打开测试页面
	 *打开sumbit button按钮处于未激活状态 
	 * */
	@Test
	public void isEnabledTest(){
		driver.get("https://测试页面");
		Boolean b=driver.findElement(By.name("buttonhtml")).isEnabled();//激活返回的是true，不激活返回的是false
		Assert.assertFalse(b);
	}
	
	/*截图
	 * 打开百度页面，截图百度首页
	 * */
	@Test
	public void shotTest(){
		driver.get("https://www.baidu.com");
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File file=(File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//第二种写法
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
