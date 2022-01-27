package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.AmazonOrder;
import com.ty.dto.Item;

public class AmazonDao {

	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("item");
		return entityManagerFactory.createEntityManager();
	}

	public void save(AmazonOrder amazonOrder) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityTransaction.commit();
		System.out.println("Save");

	}
	
	public AmazonOrder getDetail(int id) {
		entityManager=getEntityManager();
		return entityManager.find(AmazonOrder.class, id);
	}
	
	public void delete(int id) {
		entityManager=getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		AmazonOrder amazonOrder= entityManager.find(AmazonOrder.class, id);
		if(amazonOrder != null) {
		entityManager.remove(amazonOrder);
		entityTransaction.commit();
		System.out.println("Delete Data");
		}
	}
	
	public void addNewItem(List<Item> items,int id) {
		entityManager=getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		AmazonOrder amazonOrder = entityManager.find(AmazonOrder.class, id);
		List<Item> items2=amazonOrder.getItems();
			items2.addAll(items);
			entityManager.merge(amazonOrder);
			entityTransaction.commit();
			
		}
		
	    
}
