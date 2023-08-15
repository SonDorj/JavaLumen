import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.grocer.dao.DBInventoryConnection;
import com.grocer.dao.IInventoryDao;
import com.grocer.dao.InventoryDaoImpl;
import com.grocer.model.Grocery;

public class temp {
	public static void main(String[] args) {
		try {
			IInventoryDao service = new InventoryDaoImpl();
//			PopulateInventory.populate();
//			System.out.println(service.updateStock(1, 5));
//			System.out.println(service.fetchByID(1));
//			System.out.println(service.deleteGrocery(68));
			DBInventoryConnection.closeConnection();
			
//			Grocery grocery = this.fetchByID(groceryId);
//			if (grocery == null)
//				throw new GroceryNotFoundException("Grocery Id doesn't exist");
//			int oldStock = grocery.getStock();
//			if (oldStock < stock)
//				throw new StockLimitExceededException("Not enough Stock");
			Map<Integer, Grocery> groceries = service.fetchAll();
			Collection<Grocery> prin = groceries.values();
			prin.stream().forEach(System.out::println);
			
		} catch (SQLException  e) {
			System.out.println(e.getMessage());
		}
	}
}
