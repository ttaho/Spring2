package hello.hellospirng;

import hello.hellospirng.repository.*;
import hello.hellospirng.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

//스프링이 뜰때 Configuration을 읽고 스프링빈에 memberService와 memberRepository를 등록해준다
@Configuration
public class SpringConfig {

    private EntityManager em;
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

//    private DataSource dataSource; //추가해줘야
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();//인터페이스는 new가 안되므로 구현체인 MemoryMemberREpository를 사용
        //이제는 H2 DB를 쓸거기떄문에 위에껀 주석처리
        //return new JdbcMemberRepository(dataSource);

        //JdbcTemplate사용하기
        //return new JdbcTemplateMemberRepository((dataSource));

        //Jpa 사용하기
        return new JpaMemberRepository(em);
    }
}
