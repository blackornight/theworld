package com.pengyang.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pengyang.entity.Result;
import com.pengyang.entity.User;
import com.pengyang.service.LoginService;
import com.pengyang.util.Util;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	@Resource
	private LoginService loginService;
	@Resource
	private Util util;
	
	
	
	
	@RequestMapping("/tologin.do")
	public String toLogin(){
		return "index";
	}
	
	@RequestMapping("/checkLogin.do")
	public String checkLogin(String name,String password){
		Result result = new Result();
		//执行登录验证
		if(util.checkLogin(name, password)){//验证通过
			return "login";
		}
		return null;
	}
	
	@RequestMapping("/index.do")
	public String toIndex(){
		return "login";
	}
}
