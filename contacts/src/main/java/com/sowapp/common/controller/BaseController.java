package com.sowapp.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseController {
 
	@RequestMapping
    public String getIndexPage() {
        return "index";
    }
	
	
	@RequestMapping("app/views/contact")
    public String getContactPartialPage() {
        return "layout";
    }
	
	@RequestMapping("login")
    public String getLoginPage() {
        return "app/login";
    }
	
	
}