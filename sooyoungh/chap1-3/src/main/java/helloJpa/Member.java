package helloJpa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter //편의상 씀, 나중에 바꿀 것
@NoArgsConstructor
public class Member {
    @Id
    private Long id;
    private String name;

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}