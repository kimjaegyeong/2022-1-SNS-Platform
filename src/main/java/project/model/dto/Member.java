package project.model.dto;

public class Member {
	
private String memberId;

private String memberPw;

private String name; 

private String phone;

private String email;

private String grade;

public Member() {

}

public Member(String memberId, String memberPw, String name, String phone, String email, String grade) {
	this.memberId = memberId;
	this.memberPw = memberPw;
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.grade= grade;
}


/**
 * @return the memberId
 */
public String getMemberId() {
	return memberId;
}
/**
 * @param memberId the memberId to set
 */
public void setMemberId(String memberId) {
	this.memberId = memberId;
}
/**
 * @return the memberPw
 */
public String getMemberPw() {
	return memberPw;
}
/**
 * @param memberPw the memberPw to set
 */
public void setMemberPw(String memberPw) {
	this.memberPw = memberPw;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the phone
 */
public String getPhone() {
	return phone;
}
/**
 * @param phone the phone to set
 */
public void setPhone(String phone) {
	this.phone = phone;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the grade
 */
public String getGrade() {
	return grade;
}
/**
 * @param grade the grade to set
 */
public void setGrade(String grade) {
	this.grade = grade;
}


	
}
