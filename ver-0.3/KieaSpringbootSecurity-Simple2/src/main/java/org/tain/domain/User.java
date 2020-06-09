package org.tain.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@SequenceGenerator(name = "user_seq"
	, sequenceName = "user_seq"
	, initialValue = 1
	, allocationSize = 1
)
@NoArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@Column
	private Long id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@Builder
	public User(
			String username,
			String password,
			String role
			) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
