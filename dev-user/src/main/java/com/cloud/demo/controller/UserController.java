package com.cloud.demo.controller;

import com.cloud.demo.exception.CustomException;
import com.cloud.demo.exception.ResCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjing
 * @date 2022/12/29
 **/
@RestController
public class UserController {
	
	@GetMapping("/test")
	public boolean test1(){
		return true;
	}

	@GetMapping("/test2")
	public boolean test2(){
		int i  = 9/0;
		return true;
	}


	@GetMapping("/test3")
	public boolean test3(){
		throw new CustomException(ResCodeEnum.COMMON_FAIL);
	}
}
	
