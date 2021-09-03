package com.tcs.finalassessment.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "User")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "first name compulsory")
	@Size(min = 2, message = "name must be greater than 2 characters")
	private String name;

	@Email(message = "proper email format required")
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private Set<QuestionEntity> question;

}
