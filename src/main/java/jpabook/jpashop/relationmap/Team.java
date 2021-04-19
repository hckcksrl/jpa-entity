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
