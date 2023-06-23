package eStoreProduct.DAO;

import java.util.List;

import eStoreProduct.model.ProductShip;

public interface ProductShipDAO {
    public List<ProductShip> getAll();
    public boolean update(ProductShip ps);
    
}
