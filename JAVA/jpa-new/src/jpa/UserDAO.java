package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import entities.Destination;
import entities.User;

public class UserDAO {
	// // האם המשתמש רשום
	// public static BooleanResponse isExistUser(String id, String first, String
	// last) {
	// System.out.println("in jpa");
	// EntityManagerFactory emf =
	// Persistence.createEntityManagerFactory("DynnamicTurn");
	// EntityManager em = emf.createEntityManager();
	//
	// try {
	// em.getTransaction().begin();
	// System.out.println("UserDAO, isExistUser: id: " + id + " first: " + first
	// + " last: " + last);
	// User u = em.find(User.class, id);
	//
	// if (u != null)
	// return new BooleanResponse(u.getFirst_name().equals(first) &&
	// u.getLast_name().equals(last));
	// return new BooleanResponse(false);
	// } catch (Exception e) {
	// System.out.println("message" + e.getMessage());
	// System.out.println("didn't success in try");
	// return new BooleanResponse(false);
	// } finally {
	// em.close();
	// }
	//
	// }
	public static void main(String[] args) {
		System.out.println(isExistUser("1", "1", "1"));
	}

	// האם המשתמש רשום
	public static BooleanResponse isExistUser(String firstname, String lastname, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		System.out.println("create emf");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			User user = (User) em
					.createQuery(
							"select u from users u where u.first_name = :firstname and u.last_name = :lastname and u.password = :password")
					.getSingleResult();
			if (user != null)
				return new BooleanResponse(true);
		} catch (Exception e) {
			System.out.println("message" + e.getMessage());
			System.out.println("didn't success in try");
			return new BooleanResponse(false);
		} finally {
			em.close();
			return new BooleanResponse(false);

		}

	}

	// הוספת משתמש
	public static BooleanResponse addUser(User u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		System.out.println("in DAO");
		try {
			em.getTransaction().begin();
			try {
				if (em.find(User.class, u.getId()) == null) {
					em.persist(u);
					em.getTransaction().commit();
					return new BooleanResponse(true);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				em.getTransaction().rollback();
				return new BooleanResponse(false);
			}
		} finally {
			em.close();
			return new BooleanResponse(false);
		}
	}

	// עדכון משתמש
	public static BooleanResponse updateUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User u = em.find(User.class, user.getId());
		if (u != null) {
			em.remove(u);
		}
		em.close();
		return addUser(user);

	}

	// מחיקת משתמש
	public static BooleanResponse deleteUser(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {

			em.remove(em.find(User.class, id));
			em.getTransaction().commit();
			return new BooleanResponse(true);
		} catch (Exception e) {
			return new BooleanResponse(false);
		} finally {
			em.close();
		}

	}

	// קבלת כל המשתמשים
	public static List<User> getUsers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<User> users = em.createQuery("select u from users u").getResultList();
		em.close();
		return users;
	}

	// קבלת משתמש לפי שם וסיסמא
	public static User getUser(String password, String firstname, String lastname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = (User) em
				.createQuery(
						"select u from users u where u.password=password and u.firstname=firstname and u.lastname=lastname")
				.getSingleResult();
		em.close();
		return user;
	}

	// האם המשתמש הוא מנהל
	public static BooleanResponse isManager(String password, String firstname, String lastname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			if (UserDAO.getUser(password, firstname, lastname).getIsManager())
				return new BooleanResponse(true);
		} catch (Exception e) {
			return new BooleanResponse(false);
		} finally {
			em.close();
		}
		return null;
	}

	//
	public static User getUserById(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			User u = em.find(User.class, id);
			if (u != null)
				return u;
		} catch (Exception e) {
			return null;
		}
		return null;
	}
}