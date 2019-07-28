package guru.springframework.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import guru.springframework.api.domain.Post;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;
	private final String api_url;

	public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
		this.restTemplate = restTemplate;
		this.api_url = api_url;
	}

	@Override
	public Post getPost(Integer post_number) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromUriString(api_url + post_number);
				
		System.out.println(uriBuilder.toUriString());
		Post post = restTemplate.getForObject(uriBuilder.toUriString(), Post.class); 
				
		return post;
	}

}
