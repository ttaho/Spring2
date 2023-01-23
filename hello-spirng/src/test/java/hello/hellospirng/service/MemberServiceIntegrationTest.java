package hello.hellospirng.service;

import hello.hellospirng.domain.Member;
import hello.hellospirng.repository.MemberRepository;
import hello.hellospirng.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //이게 있기때문에 @AfterEach는 필요가없다.. test할때 insert를 해주고 끝나면 롤백한다.
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

//    //test와 원래것과 같은 DB를 사용하기 위해 아래와 같이 수정한다.
//    @BeforeEach
//    public void beforeEach(){
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//    @AfterEach//Test 하나하나 끝날때마다 호출
//    public void afterEach(){
//        memberRepository.clearStore();
//    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try{
//            memberService.join(member2);
//            fail();
//        }
//        catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("1212");
//        }

        //then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}