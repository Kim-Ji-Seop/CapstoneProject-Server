package Capstone.uou.domain.user.repository;

import Capstone.uou.domain.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUid(String uid);

    @Override
    <S extends Member> S save(S entity);
}
