package com.ibm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ibm.entity.User;

public class Test {
	public static void main(String [] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProiect");
		User user = new User();
		user.setEmail("ioana.ferdoschi@gmail.com");
		user.setEnabled(true);
		user.setName("ioana");
		user.setPassword("567");
		user.setIdUser(27);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		user = em.find(User.class, 27);
		System.out.println(user);
		
		em.getTransaction().begin();
		user.setName("cristina");
		System.out.println("User after updating: "+user);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		
		user=em.find(User.class, 27);
		System.out.println("User after removing: "+user);
	}

}
