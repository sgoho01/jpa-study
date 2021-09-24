package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Gunho.Song
 * @date : 2021-09-10
 */
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // insert code
            Member member1 = new Member();
            member1.setUsername("helloAA");

            Member member2 = new Member();
            member2.setUsername("helloBB");

            Member member3 = new Member();
            member3.setUsername("helloCC");

            System.out.println("1 =======================");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            System.out.println("member1 id : " + member1.getId());
            System.out.println("member2 id : " + member2.getId());
            System.out.println("member3 id : " + member3.getId());

            System.out.println("2 =======================");

            // select code
            /*Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember id : " + findMember.getId());
            System.out.println("findMember name : " + findMember.getName());*/

            // delete code
            /*Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);*/

            // update code
            /*Member findMember = em.find(Member.class, 1L);
            findMember.setName("helloJpa");*/

            // jpql
            /*List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for (Member member1 : result) {
                System.out.println("member1 = " + member1.getName());
            }*/

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
