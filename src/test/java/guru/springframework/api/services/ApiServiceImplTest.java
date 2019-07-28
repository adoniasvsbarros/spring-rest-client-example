package guru.springframework.api.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.api.domain.Post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

	@Autowired
	ApiService apiService;

	@Before
	public void setUp() throws Exception{
	}
	
	@Test
	public void testGetPost() throws Exception{
		//given
		final Integer userId = 5;
		final Integer id = 42;
		//when
		Post post = apiService.getPost(42);
		//then
		assertEquals(userId, post.getUserId());
		assertEquals(id, post.getId());
	}
}
