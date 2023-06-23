package eStoreProduct.DAO;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eStoreProduct.model.Regions;
import eStoreProduct.model.RegionsMapper;

@Component
public class RegionDAOImpl implements RegionDAO {

	JdbcTemplate jdbcTemplate;

	public RegionDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private String get_all = "select * from slam_regions";
	private String add_region = "INSERT INTO slam_regions (region_name, region_pin_from, region_pin_to, region_surcharge, region_pricewaiver)\r\n"
			+ "VALUES\r\n" + "  (?, ?, ?, ?, ?);";
	private String del_region = "delete from slam_regions where region_id=?";

	@Override
	public List<Regions> getRegions() {
		try {
			System.out.print("in getregions ");
			List<Regions> regions = jdbcTemplate.query(get_all, new RegionsMapper());
			System.out.print("in query111");
			System.out.print(regions);
			return regions;
		} catch (Exception e) {
			// Handle the exception appropriately (e.g., logging, throwing custom exception, etc.)
			e.printStackTrace();
			return Collections.emptyList(); // or throw an exception if required
		}
	}

	@Override
	public void addRegion(Regions reg) {

		jdbcTemplate.update(add_region, reg.getRegionName(), reg.getRegionPinFrom(), reg.getRegionPinTo(),
				reg.getRegionSurcharge(), reg.getRegionPriceWaiver());

	}

	@Override
	public void removeRegion(int id) {
		jdbcTemplate.update(del_region, id);
	}

}