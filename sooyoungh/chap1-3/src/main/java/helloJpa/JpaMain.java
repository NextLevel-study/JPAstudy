package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // test1(em, tx); 이건 비영속 -> 영속

        // 이건 영속 -> 준영속
        try {
            //find해서 가져오면 영속 상태임
            Member memberC = em.find(Member.class, 1L );
            memberC.setName("sam"); //더티 체킹
            //em.update(member)       이런 코드없어도 더티체킹으로 해결

            // 준영속 상태로 만들면, 쿼리 안나감 -> DB에 반영X
            // 지금은 이론만 알기, 후에 복잡한 어플리케이션에 쓰임
            //em.detach(memberC);

            //쿼리가 나가는 시점, DB에 저장되는 시점
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }


    static void test1(EntityManager em, EntityTransaction tx) {
        try {
            //비영속
            Member memberA = new Member(1L,"m1");
            Member memberB = new Member(2L,"m2");

            Member memberC = em.find(Member.class, 1L );


            // 영속 상태로 들어감, 지금 DB 저장되는 거 아님
            // 이렇게 영속 상태를 따로 만드는 이유 => 캐싱, 버퍼링 등을 위해
            em.persist(memberA);
            em.persist(memberB);

            //쿼리가 나가는 시점, DB에 저장되는 시점
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

}