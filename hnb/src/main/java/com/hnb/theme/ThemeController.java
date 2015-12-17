package com.hnb.theme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theme")
public class ThemeController {
	private static final Logger logger = LoggerFactory.getLogger(ThemeController.class);
	@Autowired ThemeVO theme;
	@Autowired ThemeServiceImpl themeService;
}
