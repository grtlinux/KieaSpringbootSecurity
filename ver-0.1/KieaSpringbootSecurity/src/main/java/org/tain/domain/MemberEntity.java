package org.tain.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", length = 20, nullable = false)
	private String email;
	
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
	@Builder
	public MemberEntity(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
}
