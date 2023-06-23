package eStoreProduct.DAO;

import java.util.List;

import eStoreProduct.model.Regions;

public interface RegionDAO {
	List<Regions> getRegions();

	void addRegion(Regions reg);

	void removeRegion(int id);
}
