package com.bezkoder.spring.login.payload.response;

import java.util.List;

public class DaigramInfoResponse {
	private Long id;
	private String username;
	private String post;
	private String phone;
	private  String email;
	private String photo;
	private List<String> parent;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<String> getParent() {
        return parent;
    }

    public void setParent(List<String> parent) {
        this.parent = parent;
    }

    public DaigramInfoResponse(Long id, String username, String post, String phone, String email, String photo, List<String> parent) {
		this.id = id;
		this.username = username;
		this.post = post;
		this.phone = phone;
		this.email = email;
		this.photo = photo;
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
