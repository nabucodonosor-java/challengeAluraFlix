package com.alura.flix.dto;

import java.io.Serializable;

import com.alura.flix.entities.Role;

public class RoleDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String authority;

	public RoleDto() {
	}

	public RoleDto(Role role) {
		id = role.getId();
		authority = role.getAuthority();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}