package test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GridTest {
	@Test
	public void testChrome() throws MalformedURLException,InterruptedException{
		DesiredCapabilities dc =DesiredCapabilities.firefox();
		WebDriver driver =new RemoteWebDriver(new URL("http://172.20.10.8:6666/wd/hub"),dc);
		driver.get("https://www.baidu.com");
		Thread.sleep(20000);
		driver.quit();
	}
	@DataProvider(name="data4")
	public Object[][]test(){
		return new Object[][]{
//      第一种方法：跑全部的浏览器
	     {"firefox"},
	     {"chrome"},
	     {"ie"}
	   };
	}
	@Test(dataProvider="data4")
	public void testGrid2(String browser) throws MalformedURLException,InterruptedException{
		DesiredCapabilities dc=null;
		if(browser.contentEquals("firefox")){
			dc=DesiredCapabilities.firefox();
		}else if(browser.contentEquals("chrome")){
			dc=DesiredCapabilities.chrome();
		}else{
			System.out.println("error");
		}
		WebDriver driver=new RemoteWebDriver(new URL("http://172.20.10.8:4444/wd/hub"),dc);
		driver.get("https://www.baidu.com");
		Thread.sleep(20000);
		driver.quit();
	}

}





//第二种：在指定电脑上运行所对应的浏览器
//@DataProvider(name="data4")
//public Object[][]test(){
//	return new Object[][]{
//	第一种方法：跑全部的浏览器
//     {"firefox","http://xxx.xx.xx.x:端口"},
//     {"chrome","http://xxx.xx.xx.x:端口"},
//     {"ie","http://xxx.xx.xx.x:端口"}
//   };
//}
//@Test(dataProvider="data4")
////第二种方法需要testGrid2中添加一个参数
//public void testGrid2(String browser,String url) throws MalformedURLException,InterruptedException{
//	DesiredCapabilities dc=null;
//	if(browser.contentEquals("firefox")){
//		dc=DesiredCapabilities.firefox();
//	}else if(browser.equals("chrome")){
//		dc=DesiredCapabilities.chrome();
//	}else{
//		System.out.println("error");
//	}
//	WebDriver driver=new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
//	driver.get("https://www.baidu.com");
//	Thread.sleep(20000);
//	driver.quit();
// }
//}

