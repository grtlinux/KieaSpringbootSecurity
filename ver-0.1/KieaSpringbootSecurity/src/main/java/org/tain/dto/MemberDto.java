package org.tain.dto;

import java.time.LocalDateTime;

import org.tain.domain.MemberEntity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberDto {

	private Long id;
	private String email;
	private String password;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.id(id)
				.email(email)
				.password(password)
				.build();
	}
	
	@Builder
	public MemberDto(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
}
