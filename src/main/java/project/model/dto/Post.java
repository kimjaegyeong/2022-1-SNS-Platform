package project.model.dto;

import org.apache.tomcat.jni.File;

public class Post {
	private String post_number;
	private String id;
	private String contents;
	private String img;
	public Post(){
		
	}
	
public	Post(String post_number, String id, String contents, String img){
		this.id= id;
		this.contents= contents;
		this.img= img;
		this.post_number= post_number;
	}
	
	public String getPost_number() {
		return post_number;
	}

	public void setPost_number(String post_number) {
		this.post_number = post_number;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String file) {
		this.img = file;
	}
}


