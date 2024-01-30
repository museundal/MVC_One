package hello.servelet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id; // 식별자 역할
    private String username;
    private int age;

    public Member() {

    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
