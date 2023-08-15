package com.grocer.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.grocer.dao.DBInventoryConnection;
import com.grocer.dao.IInventoryDao;
import com.grocer.dao.InventoryDaoImpl;
import com.grocer.model.Grocery;

public class PopulateInventory {
	public static void populate() {
		try(Connection connection = DBInventoryConnection.openConnection();
				IInventoryDao service = new InventoryDaoImpl();){
			String query="truncate table inventory";
			Statement statement = connection.createStatement();
			statement.execute(query);
			System.out.println(service.insertGrocery(new Grocery("Potato", 40d, 200)));
			System.out.println(service.insertGrocery(new Grocery("Tomato", 30d, 200)));
			System.out.println(service.insertGrocery(new Grocery("Onion", 20d, 300)));
			System.out.println(service.insertGrocery(new Grocery("Ginger", 60d, 150)));
			System.out.println(service.insertGrocery(new Grocery("Carrot", 25d, 250)));
			System.out.println(service.insertGrocery(new Grocery("Lettuce", 15d, 100)));
			System.out.println(service.insertGrocery(new Grocery("Cucumber", 18d, 180)));
			System.out.println(service.insertGrocery(new Grocery("Bell Pepper", 35d, 180)));
			System.out.println(service.insertGrocery(new Grocery("Banana", 25d, 150)));
			System.out.println(service.insertGrocery(new Grocery("Apple", 30d, 120)));
			System.out.println(service.insertGrocery(new Grocery("Orange", 22d, 180)));
			System.out.println(service.insertGrocery(new Grocery("Mango", 50d, 100)));
			System.out.println(service.insertGrocery(new Grocery("Strawberry", 40d, 80)));
			System.out.println(service.insertGrocery(new Grocery("Blueberry", 45d, 100)));
			System.out.println(service.insertGrocery(new Grocery("Pineapple", 35d, 120)));
			System.out.println(service.insertGrocery(new Grocery("Watermelon", 20d, 200)));
			System.out.println(service.insertGrocery(new Grocery("Grapes", 28d, 150)));
			System.out.println(service.insertGrocery(new Grocery("Kiwi", 30d, 100)));
			System.out.println(service.insertGrocery(new Grocery("Avocado", 50d, 90)));
			System.out.println(service.insertGrocery(new Grocery("Pear", 35d, 120)));
			System.out.println(service.insertGrocery(new Grocery("Peach", 40d, 100)));
			System.out.println(service.insertGrocery(new Grocery("Plum", 30d, 150)));
			System.out.println(service.insertGrocery(new Grocery("Cherry", 45d, 80)));
			System.out.println(service.insertGrocery(new Grocery("Apricot", 28d, 120)));
			System.out.println(service.insertGrocery(new Grocery("Lemon", 25d, 160)));
			System.out.println(service.insertGrocery(new Grocery("Lime", 20d, 140)));
			System.out.println(service.insertGrocery(new Grocery("Pomegranate", 55d, 70)));
			System.out.println(service.insertGrocery(new Grocery("Raspberry", 38d, 110)));
			System.out.println(service.insertGrocery(new Grocery("Cauliflower", 30d, 120)));
			System.out.println(service.insertGrocery(new Grocery("Broccoli", 25d, 130)));
			System.out.println(service.insertGrocery(new Grocery("Spinach", 18d, 150)));
			System.out.println(service.insertGrocery(new Grocery("Kale", 20d, 140)));
			System.out.println(service.insertGrocery(new Grocery("Zucchini", 22d, 160)));
			System.out.println(service.insertGrocery(new Grocery("Eggplant", 28d, 140)));
			System.out.println(service.insertGrocery(new Grocery("Artichoke", 35d, 100)));
			System.out.println(service.insertGrocery(new Grocery("Asparagus", 30d, 120)));
			System.out.println(service.insertGrocery(new Grocery("Mushroom", 15d, 180)));
			System.out.println(service.insertGrocery(new Grocery("Brussels Sprout", 20d, 150)));
			System.out.println(service.insertGrocery(new Grocery("Cabbage", 20d, 180)));
			System.out.println(service.insertGrocery(new Grocery("Sweet Potato", 25d, 160)));
			System.out.println(service.insertGrocery(new Grocery("Pumpkin", 30d, 150)));
			System.out.println(service.insertGrocery(new Grocery("Butternut Squash", 35d, 140)));
			System.out.println(service.insertGrocery(new Grocery("Radish", 18d, 200)));
			System.out.println(service.insertGrocery(new Grocery("Beetroot", 22d, 180)));
			System.out.println(service.insertGrocery(new Grocery("Cilantro", 10d, 250)));
			System.out.println(service.insertGrocery(new Grocery("Thyme", 12d, 220)));
			System.out.println(service.insertGrocery(new Grocery("Rosemary", 15d, 210)));
			System.out.println(service.insertGrocery(new Grocery("Basil", 14d, 230)));
			System.out.println(service.insertGrocery(new Grocery("Parsley", 8d, 240)));
			System.out.println(service.insertGrocery(new Grocery("Oregano", 10d, 230)));
			System.out.println(service.insertGrocery(new Grocery("Chives", 9d, 250)));
			System.out.println(service.insertGrocery(new Grocery("Dill", 11d, 220)));
			System.out.println(service.insertGrocery(new Grocery("Sage", 12d, 210)));
			System.out.println(service.insertGrocery(new Grocery("Mint", 7d, 260)));
			System.out.println(service.insertGrocery(new Grocery("Lavender", 14d, 230)));
			System.out.println(service.insertGrocery(new Grocery("Coriander", 9d, 240)));
			System.out.println(service.insertGrocery(new Grocery("Bay Leaf", 6d, 270)));
			System.out.println(service.insertGrocery(new Grocery("Tarragon", 10d, 220)));
			System.out.println(service.insertGrocery(new Grocery("Marjoram", 8d, 250)));
			System.out.println(service.insertGrocery(new Grocery("Cinnamon", 15d, 200)));
			System.out.println(service.insertGrocery(new Grocery("Nutmeg", 12d, 230)));
			System.out.println(service.insertGrocery(new Grocery("Cloves", 10d, 240)));
			System.out.println(service.insertGrocery(new Grocery("Vanilla Bean", 20d, 180)));
			System.out.println(service.insertGrocery(new Grocery("Cumin", 9d, 260)));
			System.out.println(service.insertGrocery(new Grocery("Paprika", 7d, 270)));
			System.out.println(service.insertGrocery(new Grocery("Turmeric", 11d, 220)));
			System.out.println(service.insertGrocery(new Grocery("Chili Powder", 8d, 250)));
			System.out.println(service.insertGrocery(new Grocery("Saffron", 50d, 100)));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
