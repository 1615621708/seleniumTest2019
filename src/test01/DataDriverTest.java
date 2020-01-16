package test01;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {
	@DataProvider(name="loginUser")
	public Object[][] data1(){
		//¶ÁÈ¡excel csv xmlÊý¾Ý
		return new Object[][]{
			{"user1","pwd1"},
			{"user2","pwd2"}
		};
	}
	@Test(dataProvider="loginUser")
	public void loginTest(String User,String pwd){
		String time=String.valueOf(System.currentTimeMillis());
		System.out.println("user "+User+time);
		System.out.println("pwd"+pwd+time);
	}

}
