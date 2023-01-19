package hello.hellospirng;

import hello.hellospirng.repository.MemberRepository;
import hello.hellospirng.repository.MemoryMemberRepository;
import hello.hellospirng.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링이 뜰때 Configuration을 읽고 스프링빈에 memberService와 memberRepository를 등록해준다
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();//인터페이스는 new가 안되므로 구현체인 MemoryMemberREpository를 사용
    }
}
