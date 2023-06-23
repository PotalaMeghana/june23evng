package eStoreProduct.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eStoreProduct.model.ProductShip;
import eStoreProduct.model.ProductShipMapper;

@Component
public class ProductShipDAOImpl implements ProductShipDAO{
    JdbcTemplate jdbcTemplate;
    private String getAll="SELECT sp.prod_id,prod_title,sps.prod_price,shipment_charges FROM slam_Products sp,slam_productstock sps where sps.prod_id=sp.prod_id";
    private String update="update slam_Products set shipment_charges=? where prod_id=?";

	public ProductShipDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

    @Override
    public List<ProductShip> getAll() {
	// TODO Auto-generated method stub
	List<ProductShip> er= jdbcTemplate.query(getAll,new ProductShipMapper());
	return er;
    }

    @Override
    public boolean update(ProductShip ps) {
	// TODO Auto-generated method stub
	try {
		jdbcTemplate.update(update,ps.getShipment_charges(),ps.getProd_id());
		return true;
		}
		catch(Exception e) {
		    e.printStackTrace();
		    return false;
		}
    }

}
