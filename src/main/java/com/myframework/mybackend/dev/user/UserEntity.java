package com.myframework.mybackend.dev.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String userName;
	
	private String password;
	
	@Column(unique = true)
	private String email;
}

// @Column(unique = true) : 유일한 값만 저장할 수 있음.