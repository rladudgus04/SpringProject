package net.gondr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.gondr.domain.Regist2VO;
import net.gondr.domain.UserVO;
import net.gondr.domain.YYSampleVO;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@RequestMapping(value="regist", method=RequestMethod.GET)
	public String viewRegisterPage() {
		
		// /user/regist
		return "user/regist";
	}
	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String registProcess(YYSampleVO user) {
		return "redirect:/world/" + user.getUserId();
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String viewLoginPage() {
		return "user/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginProcess(UserVO user, HttpSession session) {
		if(user.getUserid().equals("gondr") && user.getPassword().equals("1234")) {
			session.setAttribute("user", user);
			return "redirect:/";
		}else {
			return "redirect:/user/login";
		}
		
	}
	
	
	@RequestMapping(value = "regist2", method=RequestMethod.GET)
	public String viewRegisterPage2() {
		return "user/regist2";
	}
	
	@RequestMapping(value = "regist2", method=RequestMethod.POST)
	public String registProcess2(Regist2VO user2) {
		return "redirect:/register/" + user2.getUserid() + user2.getPass() + user2.getName() + user2.getEmail();
		
		
	}
}

// 주소는 user/regist2 이고
// 접근시 아이디, 비번 , 비번확인, 이름 ,이메일을 입력하는 폼이 나오고
// 전송을 누르면
// 처리해서 공백이 있는지 확인하여 공백이 있을경우 다시 user/regist2로 보내고
// 모두 옳게 했다면 어떤페이지든 특정페이지로 넘어가서 입력한 값을 모두 출력해서 보여준다.
// 입력하신 아이디: gondr
// 입력한 비밀번호 : 1234
// 입력한 이름 : 김영현
// 입력한 이메일 : totoyou1234@naver.com
