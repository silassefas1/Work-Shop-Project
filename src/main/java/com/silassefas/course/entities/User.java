package com.silassefas.course.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // diz para o jpa que o user é uma entidade do modelo de dominio
@Table(name = "tb_user")/*Renomeando para nao da conflito com a paravra reservada do banco*/
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //define id como chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //informa ao jpa que a chave é auto incrementada no banco
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User() {
		
	}

	public User(Long id, String name, String emailString, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = emailString;
		this.phone = phone;
		this.password = password;
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

	public String getEmailString() {
		return email;
	}

	public void setEmailString(String emailString) {
		this.email = emailString;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}


	
	
	

}
