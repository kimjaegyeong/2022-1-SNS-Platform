package project.model.dto;

public class Comment {
	String memberId;
	String comment;
	String post_number;
	String comment_number;
	
	public String getComment_number() {
		return comment_number;
	}

	public void setComment_number(String comment_number) {
		this.comment_number = comment_number;
	}

	public Comment() {
		
	}
	
	public Comment(String memberId, String comment,String comment_number, String post_number) {
		this.memberId= memberId;
		this.comment= comment;
		this.comment_number= comment_number;
		this.post_number= post_number;
	}
	
	public Comment(String post_number, String memberId, String comment) {
		this.memberId= memberId;
		this.comment= comment;
		this.post_number= post_number;
	}
	
	
	public String getPost_number() {
		return post_number;
	}

	public void setPost_number(String post_number) {
		this.post_number = post_number;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
