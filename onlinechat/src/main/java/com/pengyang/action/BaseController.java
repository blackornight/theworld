package com.pengyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	protected HttpServletResponse res;
	protected HttpServletRequest req;
	protected HttpSession session;
	
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest req,HttpServletResponse res){
		this.req = req;
		this.res = res;
		this.session = req.getSession();
	}
}
