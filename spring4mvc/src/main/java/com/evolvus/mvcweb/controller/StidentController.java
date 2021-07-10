package com.evolvus.mvcweb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evolvus.mvcweb.bean.Loginbean;
import com.evolvus.mvcweb.service.StudentService;

@Controller
@RequestMapping("/student")
public class StidentController {

    private static final Logger logger = Logger.getLogger(StidentController.class);

	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model,HttpServletRequest request) {
		
		logger.info("isnide the index method  the requesting IP:::::" +request.getRemoteAddr());

		model.put("title", "");
		
		logger.error("inside the index the session id ::{}");

		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Map<String, Object> model, @RequestBody String str, HttpServletRequest request) {

		logger.info("isnide the login method  the requesting IP:::::" +request.getRemoteAddr());
		try {
			String username = request.getParameter("fname");

			String lastname = request.getParameter("lname");

			Loginbean bean = new Loginbean();

			bean.setFirstName(username);

			bean.setLastName(lastname);
			
			logger.info("isnide the login method  username :::::" +username);
			logger.info("isnide the login method  lastname :::::" +lastname);



			bean = studentService.saveLogin(bean);

			model.put("successmsg", bean.getMsq());
		} catch (Exception e) {

			logger.error("the Exception :::{}",e);
		}

		return "success";
	}

}
