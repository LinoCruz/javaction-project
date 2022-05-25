package com.codingdojo.lino.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="algorithms")
public class Algorithm {

	//Id of user
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Name of the Algorithm
	@NotEmpty(message="The Name must not be blank.")
	@Size(min=2, max=150, message="The name should have 2 characters at least.")
	private String name;
	
	//Description of the Algorithm
	@NotEmpty(message="The Description must not be blank.")
	@Column(columnDefinition="TEXT")
	private String challenge;
	
	//More Info of the Algorithm
	@NotEmpty(message="The Description must not be blank.")
	@Column(columnDefinition="TEXT")
	private String moreinfo;
	
	//Code made by the user
	@Column(columnDefinition="TEXT")
	private String code;
	
	//Status of the Algorithm
	@NotEmpty(message="The Name must not be blank.")
	@Size(min=2, max=100, message="The name should have 2 characters at least.")
	private String status; //done, doing or undone
	
	//Type of the Algorithm
	@NotEmpty(message="The Name must not be blank.")
	private String type; //string, math, ciphers, sorts, etc
	
	
	//One user can resolve several algorithms
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dev_id")
	private User developer;
	
	//One admin create several algorithms
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	//Connection to Answers Table
	@OneToMany(mappedBy="algorithm", fetch= FetchType.LAZY)
	private List<Answer> theAnswers;
	
	//Connection to Answers Table
	@OneToMany(mappedBy="algorithm", fetch= FetchType.LAZY)
	private List<Video> theVideos;
	
	//Created at
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	
	//Updated at
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;

	public Algorithm() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

	public String getMoreinfo() {
		return moreinfo;
	}

	public void setMoreinfo(String moreinfo) {
		this.moreinfo = moreinfo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public List<Answer> getTheAnswers() {
		return theAnswers;
	}

	public void setTheAnswers(List<Answer> theAnswers) {
		this.theAnswers = theAnswers;
	}

	public User getDeveloper() {
		return developer;
	}

	public void setDeveloper(User developer) {
		this.developer = developer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Video> getTheVideos() {
		return theVideos;
	}

	public void setTheVideos(List<Video> theVideos) {
		this.theVideos = theVideos;
	}

	@PrePersist
    protected void onCreate(){
        this.created_at = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updated_at = new Date();
    }
	

}