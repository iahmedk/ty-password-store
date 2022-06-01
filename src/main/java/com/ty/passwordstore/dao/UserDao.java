package com.ty.passwordstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.passwordstore.dto.User;

public class UserDao {

	public User saveUser(User user) {

		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public boolean validateUser(String email, String password) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();
		String jpql = "SELECT u from User u where email = ?1 AND password = ?2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<User> list = query.getResultList();

		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}