package hello.hellospirng.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    // DB가 Id를 자동으로 생성시켜줄때 IDENTITY를 사용한다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
