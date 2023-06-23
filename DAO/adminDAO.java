package eStoreProduct.DAO;

import eStoreProduct.model.adminModel;

public interface adminDAO {

	public adminModel getAdmin(String email, String psd);

	public void updateAdmin(adminModel am);
}
