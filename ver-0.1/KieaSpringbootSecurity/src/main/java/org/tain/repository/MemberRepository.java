package org.tain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tain.domain.MemberEntity;


public interface MemberRepository extends JpaRepository<MemberEntity, Long>{

	Optional<MemberEntity> findByEmail(String email);
}
