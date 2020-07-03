package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping("/gb") // 공통으로 주소 묶기 <타입 & 메소드 묶기> RequestMapping("/ ")
public class GuestbookController {
	GuestDao guestDao = new GuestDao();
	
	@RequestMapping (value = "/addList", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		
		List<GuestVo> gList = guestDao.getGuestList();
		System.out.println(gList.toString());
		
		model.addAttribute("gList", gList);
		
		return "addList";
	}
	
	@RequestMapping(value = "/deleteForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@RequestParam("no")int no) {
		System.out.println("/gb/deleteForm");
		System.out.println(no);

		
		
		return "deleteFrom";
		
	}
	
	
	
	
}
