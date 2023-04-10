package hello.core2.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(1L,member);
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }
}
