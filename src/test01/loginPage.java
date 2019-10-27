package test01;

import org.openqa.selenium.By;
//page层（页面对象）
public class loginPage {
	//定义email文本框的定位方式
	public static By emailInput=By.name("email");
	//定义密码输入框的定位方式
	public static By pwdInput=By.name("password");
	//定义登录按钮的定位方式
	public static By loginButton=By.id("dologin");
	//定位注册按钮的定位方式
	public static By zhuceButton=By.id("changepage");
	
	//注册账号定位方式
	public static By mobileNumInput=By.id("nameIpt");

}

