package com.hello.web.admin;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class ExpireJobTask {
	HttpServletRequest httpServletRequest;
	HttpServletResponse httpServletResponse;
	ModelMap map;
	
private static final Logger logger = LoggerFactory.getLogger(ExpireJobTask.class);
	public void doBiz(String name) {
		System.out.println("===================come on ========================"+new Date());
  // 执行业务逻辑

  // ........
    }
}
