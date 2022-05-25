package com.codingdojo.lino.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="videos")
public class Video {

	
		//Id of user
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		//Alternative 
		@Column(columnDefinition="TEXT")
		@NotEmpty(message="cant be empty")
		private String link;
			
		
		//Relationship with the algorithms table
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="algorithm_id")
		private Algorithm algorithm;
		
		//Created at
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date created_at;
			
		//Updated at
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updated_at;

		public Video() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public Algorithm getAlgorithm() {
			return algorithm;
		}

		public void setAlgorithm(Algorithm algorithm) {
			this.algorithm = algorithm;
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

