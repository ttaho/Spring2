package hello.hellospirng.service;

import hello.hellospirng.domain.Member;
import hello.hellospirng.repository.MemberRepository;
import hello.hellospirng.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**회원가입**/
    public Long join(Member member){

        //long start = System.currentTimeMillis();// ms단위

// Optional로 한번 감싸면 Optional안에 Member 객체가 있다. 그래서 관련 메소드를 사용가능. Null가능성있으면 Optional쓰면 좋음.
//        Optional<Member> result = memberRepository.findByName(member.getName());
        // result가 Null이 아니라 값이 있으면 아래가 동작됨.
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        //이렇게 해도 됨 이미 findByName이 Optional형태로 뱉으니까 위에처럼 안해도 될듯
        // 같은 이름이 있는 중복 회원 X
//        try {
//            validateDuplicateMember(member); //중복 회원 검증
//            memberRepository.save(member);
//            return member.getId();
//        } finally{
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join = " + timeMs + "ms");
//        }
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }
    /**
     * 전체 회원 조회
     * **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
