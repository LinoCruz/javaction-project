package com.codingdojo.lino.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	//Id of user
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//First Name of User
	@NotEmpty(message="Name must not be blank.")
	@Size(min=2, max=30, message="Name should have between 2 characters as minimun")
	private String first_name;
	
	//Last Name of User
	@NotEmpty(message="The Last Name must not be blank.")
	@Size(min=2, max=30, message="Last name should have 2 characters at least.")
	private String last_name;
	
	//Email of user
	@NotEmpty(message="Email is needed.")
	@Email(message="Please use a valid email.")
	private String email;
	
	//Password
	@NotEmpty(message="Password must not be blank.")
	@Size(min=6, max=128, message="The password must have 6 characters at least.")
	private String password;
	
	//Confirm Password
	@Transient
	@NotEmpty(message="Please confirm your password.")
	@Size(min=6, max=128, message="Password should be the same as you typed before.")
	private String confirm;
	
	//Confirm Password
	@NotNull(message="can't be empty.")
	private Integer level;
	
	//One user can resolve several algorithms
	@OneToMany(mappedBy="developer", fetch = FetchType.LAZY)
	private List<Algorithm> madeAlgorithms; 
		
	
	//One admin create several algorithms
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Algorithm> createdAlgorithms; 
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
		
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}


	public List<Algorithm> getMadeAlgorithms() {
		return madeAlgorithms;
	}

	public void setMadeAlgorithms(List<Algorithm> madeAlgorithms) {
		this.madeAlgorithms = madeAlgorithms;
	}

	public List<Algorithm> getCreatedAlgorithms() {
		return createdAlgorithms;
	}

	public void setCreatedAlgorithms(List<Algorithm> createdAlgorithms) {
		this.createdAlgorithms = createdAlgorithms;
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
