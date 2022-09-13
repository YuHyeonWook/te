package hello.core.member;

public interface MemberRepository {
    void save(Member member); // 회원을 저장하는 기능
    Member findById(Long memberId); //회원의 id로 회원을 찾는기능

}
