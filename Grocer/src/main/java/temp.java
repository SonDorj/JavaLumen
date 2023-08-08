import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.grocer.dao.DBConnection;
import com.grocer.dao.IInventoryDao;
import com.grocer.dao.InventoryDaoImpl;
import com.grocer.exception.GroceryNotFoundException;
import com.grocer.model.Grocery;

public class temp {
	public static void main(String[] args) {
		try {
			IInventoryDao service = new InventoryDaoImpl();
			Grocery grocery = new Grocery();
			grocery.setGrocery("Book");
			grocery.setPrice(300d);
			grocery.setStock(102);
			System.out.println(service.insertGrocery(grocery));
//			System.out.println(service.deleteGrocery(5));
			Map<Integer, Grocery> result = service.fetchAll();
			Collection <Grocery> items = result.values();
			items.stream().forEach(System.out::println);
			DBConnection.closeConnection();
		} catch (SQLException | GroceryNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
