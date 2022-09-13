package hello.core.member;

public interface MemberService {
    public abstract void join(Member member); // 회원가입

    public abstract Member findMember(Long memberId); // 회원조회
}
