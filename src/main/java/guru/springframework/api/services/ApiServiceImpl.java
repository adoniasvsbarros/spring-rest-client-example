package guru.springframework.api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import guru.springframework.api.domain.Post;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;

	public ApiServiceImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public Post getPost(Integer post_number) {
		
		Post post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + post_number, Post.class); 
				
		return post;
	}

}
