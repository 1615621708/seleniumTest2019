package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {
	@DataProvider(name="loginUser")
	public Object[][]data1(){
		return new Object[][]{
			{"user1","pwd1","pwds1"},
			{"user2","pwd2","pwds1"}
		};
	}
	@Test(dataProvider="loginUser")
	public void loginTest(String user,String pwd,String pwds){
		//String Time =String.valueOf(System.currentTimeMillis()/100);
		//String time=String.valueOf(System.currentTimeMillis()/100);
		System.out.println("user "+user);
		System.out.println("pwd "+pwd);
		System.out.println("pwds1 "+pwds);
	}

}
