package com.discussionforum.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tag")
public class Tag {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="username")
    private String username;

    @Temporal(TemporalType.DATE)
    @Column(name="date_created")
    private Date date_created;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="question_tag", joinColumns= {@JoinColumn(name="tag_id")},  inverseJoinColumns= {@JoinColumn(name="question_id")})
    private Set<Question> questions;

    public Tag() {

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", username=" + username + ", date_created=" + date_created
				+ ", questions=" + questions + "]";
	}
    
	
}