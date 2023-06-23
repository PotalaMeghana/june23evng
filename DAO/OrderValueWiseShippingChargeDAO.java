package eStoreProduct.DAO;

import java.util.List;

import eStoreProduct.model.OrderValueWiseShippingCharge;

public interface OrderValueWiseShippingChargeDAO {
    public List<OrderValueWiseShippingCharge> getAll();
    public boolean addCharge(OrderValueWiseShippingCharge ord);
    public boolean deleteCharge(OrderValueWiseShippingCharge ord);
    public boolean updateCharge(OrderValueWiseShippingCharge ord);
}
