package lab4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lab4.Services.CookieService;
import lab4.Services.ParamService;
import lab4.Services.SessionService;


@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/logout")
	public String getLogout() {
		sessionService.remove("username");
		return "redirect:/account/login";
	}

	@PostMapping("/login")
	public String postLogin() {

		// Lấy tham số bằng các sử dụng ParamService
		String username = paramService.getString("username", "");
		String password = paramService.getString("password", "");
		boolean remember = paramService.getBoolean("remember", false);

		if (username.equals("poly") && password.equals("123")) {

			// Lưu username vào Session
			sessionService.set("username", username);

		} else {
			return "redirect:/account/login";
		}

		// Lưu username và password vào Cookie
		if (remember) {
			cookieService.add("username", username, 1);
			cookieService.add("password", password, 1);
		} else {
			cookieService.remove("username");
			cookieService.remove("password");
		}
		return "welcome";
	}
}
