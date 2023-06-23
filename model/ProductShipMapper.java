package eStoreProduct.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductShipMapper implements RowMapper<ProductShip> {

	@Override
	public ProductShip mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
	    ProductShip ps=new ProductShip();
	    ps.setProd_id(rs.getInt("prod_id"));
	    ps.setProd_title(rs.getString("prod_title"));
	    ps.setProd_price(rs.getDouble("prod_price"));
	    ps.setShipment_charges(rs.getDouble("shipment_charges"));
	    return ps;
	}

}
