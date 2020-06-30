package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Destination;

public class DestinationDAO {
	public static void main(String[] args) {
		
		getDestinations();
		System.out.println("end");
	}

	//���� �� ������
	public static List<Destination> getDestinations() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Destination> resultList = em.createQuery("select d from Destination d").getResultList();
		em.close();
		return resultList;
	}
	//���� ��� ��� ��� ����
	public static Destination getNameById(String id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Destination dest = (Destination)em.createQuery("select d from Destination d where d.id=id").getSingleResult();
		em.close();
		return dest;
	}

}
