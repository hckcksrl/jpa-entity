package jpabook.jpashop.relationmap;

import javax.persistence.*;

@Entity
public class Member2 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    /**
     * 연관관계 편의 메소드
     */
    public void setTeam(Team team) {
        this.team = team;

        team.getMembers().add(this);
    }

    /**
     * 단방향 매핑만으로도 이미 연관관계 매핑은 완료
     * 양방향 매핑은 반대 방향으로 조회(객체 그래프 탐색) 기능이 추가된 것 뿐
     * JPQL에서 역방향으로 탐색할 일이 많음
     * 단방향 매핑을 잘 하고 양방향은 필요할 때 추가해도 됨 (테이블에 영향을 주지 않음)
     */
//    @Override
//    public String toString() {
//        return "Member2{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team +
//                '}';
//    }
}
