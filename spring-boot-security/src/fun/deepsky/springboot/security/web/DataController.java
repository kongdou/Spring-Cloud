package fun.deepsky.springboot.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fun.deepsky.springboot.security.domain.Msg;

@Controller
public class DataController {

	@RequestMapping("/")
	public String index(Model model) {
		Msg msg = new Msg("测试标题", "测试内容", "管理员显示");
		model.addAttribute("msg", msg);
		return "home";
	}
}
