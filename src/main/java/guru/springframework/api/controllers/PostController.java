package guru.springframework.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import guru.springframework.api.services.ApiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PostController {

	private ApiService apiService;

	public PostController(ApiService apiService) {
		super();
		this.apiService = apiService;
	}
	
	@GetMapping({"", "/", "/index"})
	public String index() {
		return "index";
	}
	
	@PostMapping("/post")
	public String formPost(Model model, ServerWebExchange serverWebExchange) {
		
		MultiValueMap<String, String> map = (MultiValueMap<String, String>) serverWebExchange.getFormData().block();
		
		Integer post_number = new Integer(map.get("post_number").get(0));
		
		log.debug("received post number: " + post_number);
		
		if(post_number == null || post_number > 100) {
			post_number = 42;
		}
		
		model.addAttribute("post", apiService.getPost(post_number));
		
		return "post";
	}
	

}
