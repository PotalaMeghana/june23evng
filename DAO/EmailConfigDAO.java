package eStoreProduct.DAO;

import eStoreProduct.model.EmailConfigModel;

public interface EmailConfigDAO {
	void changeEmail(EmailConfigModel ecm);

	EmailConfigModel getEmail();
}