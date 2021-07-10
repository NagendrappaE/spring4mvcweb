package com.evolvus.mvcweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ta_student")

public class TaStudent implements Serializable {

	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_increment_sid_seq_name")
    @SequenceGenerator(name = "auto_increment_sid_seq_name", sequenceName = "auto_increment_sid_seq")
	private Long sid;

	@Column(name = "user_name")
	private String username;

	@Column(name = "last_name")

	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
