package com.knt.frontpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.knt.core.MappForMybatis;
import com.knt.frontpage.core.JsonUtil;
import com.knt.mapping.UserForTestMapper;
import com.knt.model.UserForTest;

@Controller
public class UserController {
	@Autowired
	private MappForMybatis businessManager;
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	@ResponseBody
	public String getUserList(HttpServletResponse response) {
		UserForTestMapper mapper = businessManager.getMapper(UserForTestMapper.class); 
		List<UserForTest> list = mapper.getUserList();
		return JsonUtil.beanListToJson(response, list);
	}
	
	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	@ResponseBody
	public String getUserDetail(HttpServletRequest request, HttpServletResponse response) {
		UserForTestMapper mapper = businessManager.getMapper(UserForTestMapper.class); 
		
		UserForTest user = mapper.selectByUserName(SecurityUtils.getSubject().getPrincipal().toString());
		return JsonUtil.beanToJson(response, user);
	}
	@RequestMapping(value = "/admin/adminDetail", method = RequestMethod.GET)
	public ModelAndView adminDetail() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/adminDetail");
		return modelAndView;
	}
}
