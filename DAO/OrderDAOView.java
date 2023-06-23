package eStoreProduct.DAO;

import java.util.List;


import eStoreProduct.model.OrdersViewModel;


public interface OrderDAOView {
	public List<OrdersViewModel> getorderProds();
	public  OrdersViewModel OrdProductById(Integer productId);
	public void cancelorderbyId(Integer productId,int orderId);
	 public String getShipmentStatus(int productId,int orderId);
		public List<OrdersViewModel> sortProductsByPrice(List<OrdersViewModel> orderLists, String sortOrder);
		public boolean areAllProductsCancelled(int orderId);
		public void updateOrderShipmentStatus(int orderId, String shipmentStatus);

public List<OrdersViewModel> filterProductsByPriceRange(List<OrdersViewModel> productList, double minPrice,
			double maxPrice);
	
}
