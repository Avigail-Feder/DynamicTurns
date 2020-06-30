package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import entities.Message;
import entities.User;



public class MessageDAO {

//הוספת הודעת משתמש
	public static BooleanResponse addMessage(Message message) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		System.out.println("in DAO");
		try {
			em.getTransaction().begin();
			try {
				em.persist(message);
				em.getTransaction().commit();
				return new BooleanResponse(true);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				em.getTransaction().rollback();
				return new BooleanResponse(false);
			}
		} finally {
			em.close();
		}

	}
	
}