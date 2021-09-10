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
            /*Member member = new Member();
            member.setId(2L);
            member.setName("helloB");

            em.persist(member);*/

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
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
