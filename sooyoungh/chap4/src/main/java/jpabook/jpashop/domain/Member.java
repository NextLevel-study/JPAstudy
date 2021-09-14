package jpabook.jpashop.domain;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter // 여기서만 잠깐 편의상 사용
@NoArgsConstructor
@Entity
@Table(name="MBR") // DB에 연결될 이름
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public void setName(String username) {
        this.username = username;

    }
    //Getter, Setter…
}