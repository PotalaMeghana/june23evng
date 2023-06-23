package eStoreProduct.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eStoreProduct.model.OrderValueWiseShippingCharge;
import eStoreProduct.model.OrderValueWiseShippingChargeMapper;


@Component
public class OrderValueWiseShippingChargeDAOImpl implements OrderValueWiseShippingChargeDAO{
	JdbcTemplate jdbcTemplate;
	
    
    private String getall="select * from public.slam_ordervaluewiseshippingcharges";
    private String addCharge="insert into slam_ordervaluewiseshippingcharges(ordrvl_from,ordrvl_to,ordrvl_shippingamount) values(?,?,?)";
    private String removeCharge="delete from slam_ordervaluewiseshippingcharges where ordvl_id=?";
    private String updateCh="update slam_ordervaluewiseshippingcharges set ordrvl_from=?,ordrvl_to=?,ordrvl_shippingamount=? where ordvl_id=?";
    
    @Autowired
	public OrderValueWiseShippingChargeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
    
    
    @Override
    public List<OrderValueWiseShippingCharge> getAll() {
	// TODO Auto-generated method stub
	System.out.println("in getAll");
	List<OrderValueWiseShippingCharge> oscl=jdbcTemplate.query(getall,new OrderValueWiseShippingChargeMapper());
	return oscl;
    }

    @Override
    public boolean addCharge(OrderValueWiseShippingCharge ord) {
	// TODO Auto-generated method stub
	try {
	jdbcTemplate.update(addCharge,ord.getOrdvlFrom(),ord.getOrdvlTo(),ord.getOrdvlShippingAmount());
	return true;
	}
	catch(Exception e) {
	    e.printStackTrace();
	    return false;
	}
	//return false;
    }

    @Override
    public boolean deleteCharge(OrderValueWiseShippingCharge ord) {
        // TODO Auto-generated method stub
        try {
            jdbcTemplate.update(removeCharge, ord.getOrdvlId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean updateCharge(OrderValueWiseShippingCharge ord) {
	try {
            jdbcTemplate.update(updateCh, ord.getOrdvlFrom(),ord.getOrdvlTo(),ord.getOrdvlShippingAmount(),ord.getOrdvlId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
