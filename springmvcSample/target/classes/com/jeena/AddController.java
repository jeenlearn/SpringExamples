package com.jeena;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AddController {
	
	System.out.println("Adding controller 1");
	
	@RequestMapping("/add")
	
	public ModelAndView Add(HttpServletRequest request,HttpServletResponse response ) {
		System.out.println("Adding controller 2");
		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t2"));
		AddService as = new AddService();
		
		int k =as.add(i,j);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		return mv;
	}
}

