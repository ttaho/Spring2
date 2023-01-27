package hello.hellospirng.repository;

import hello.hellospirng.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// 구현 class 작성 할 필요없이 interface만으로 끝냄
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    //이건 만들어주지 않아서 호출해준듯?
    Optional<Member> findByName(String name);
}
