package com.atguigu.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理员工 CRUD
 * @author Administrator
 *
 */
@Controller
public class EmployeeController {
	
	@RequestMapping("/emps")
	public String getEmps() {
		System.out.println("AAA");
		return "list";
	}
}
