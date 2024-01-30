package hello.servelet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
    // 싱글톤이어서 사실 static이 없어도 된다.
    private static final MemberRepository instance = new MemberRepository();
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L; // 가입자 증가할때마다

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository() {// 싱글톤으로 만들려고 한다. private으로 하기

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
        // 이렇게 하는 이유는 ArryaList에 값을 넣거나 조작해도 store에 있는 value를 건들지 않으려고 , store을 보호하기 위해서다
    }

    public void clearStore() {
        store.clear();
    }

}
