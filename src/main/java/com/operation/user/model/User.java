package com.operation.user.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "user_table")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Customer Id cannot be null or blank")
	@Column(name = "customer_id", unique = true)
	private String customerId;

	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	@Column(name = "email_id")
	private String emailId;
	
	@Pattern(regexp = "^.{10}$", message = "The string must be exactly 10 characters long.")
	@Column(name = "phone_number")
	private String phoneNumber;
}
