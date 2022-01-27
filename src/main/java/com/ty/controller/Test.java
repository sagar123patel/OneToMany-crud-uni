package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dao.AmazonDao;
import com.ty.dto.AmazonOrder;
import com.ty.dto.Item;

public class Test {
	public static void main(String[] args) {
		
		
		
		Item item = new Item();
		item.setId(1);
		item.setName("Pen");
		item.setPrice(25);
		item.setQty(5);

		
		Item item2 = new Item();
		item2.setId(2);
		item2.setName("Laptop");
		item2.setPrice(55555);
		item2.setQty(3);

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item2);

		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setId(1);
		amazonOrder.setAdd("Mp");
		amazonOrder.setItems(items);
		
		AmazonDao dao=new AmazonDao();
		dao.save(amazonOrder);

		
	}
}
