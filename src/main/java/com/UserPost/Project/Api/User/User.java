package com.UserPost.Project.Api.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String firts_name;
	@Column
	private String middle_name;
	@Column(nullable = false)
	private String last_name;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private int address_id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private int rol_id;
	@Column(nullable = false)
	private String email_validation_token;
	@Column(nullable = false)
	private boolean is_verified;
	@Column
	private String phone_number;

}
