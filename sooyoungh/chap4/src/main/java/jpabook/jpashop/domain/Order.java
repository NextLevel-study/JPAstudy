package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ORDERS") //order가 예약어인 DB도 있으니까
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId; // 이건 객체지향이 아니라 관계형 DB에 맞춤
    // 참조를 id 값으로 찾고 다시 Member 찾는 방식 => 관계형 DB에 가까움

    // 자바의 객체스러운 방식 => 연관관계 매핑에서 배움
    // private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}

