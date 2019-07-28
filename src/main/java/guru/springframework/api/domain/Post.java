package guru.springframework.api.domain;

import java.io.Serializable;

public class Post implements Serializable {

	private Integer id;
	private Integer userId;
	private String title;
	private String body;
	private static final long serialVersionUID = 1228650361351758415L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}


}
