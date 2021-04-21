package jpabook.jpashop.relationmap;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    /**
     * new ArrayList<>();를 하는이유는 관례이다. Add할때 null이 안뜨기때문
     * mappedBy 는 Member엔티티 객체의 team이다. 연관이 있는 변수이름
     */
    /**
     * 일대다 단방향 연관관계는 실무에서 거의사용하지 않고 추천하지 않음
     * @OneToMany
     * @JoinColumn(name = "TEAM_ID")
     * 일대다 => 다대일로 만들어서 객체위주가아닌 DB테이블위주의 코드를 작성하는것이 좋다.
     * 단점
     * 엔티티가 관리하는 외래키가 다른테이블에 있음
     * 연관관계 관리를위해 추가로 Update SQL이 실행됨
     */
    @OneToMany(mappedBy = "team")
    private List<Member2> members = new ArrayList<>();

    public List<Member2> getMembers() {
        return members;
    }

    public void setMembers(List<Member2> members) {
        this.members = members;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Team{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", members=" + members +
//                '}';
//    }
}
