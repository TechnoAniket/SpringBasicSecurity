package in.sellenium.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class humanController {
	
	@GetMapping("/home")
	public String home()
	{
		return "welcome to HOme ";
	}
	@GetMapping("/hii")
	public String hii()
	{
		return "hii ";
	}
	@GetMapping("/bye")
	public String bye()
	{
		return "bye ";
	}
	
}
