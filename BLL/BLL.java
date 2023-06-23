/*
 * package eStoreProduct.BLL;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Component;
 * 
 * import eStoreProduct.DAO.ProductDAO; import eStoreProduct.DAO.cartDAO; import eStoreProduct.model.ServiceableRegion;
 * import eStoreProduct.model.custCredModel; import eStoreProduct.model.hsnModel; import
 * eStoreProduct.utility.ProductStockPrice;
 * 
 * @Component public class BLL { ProductDAO pdaoimp; cartDAO cartimp; List<ProductStockPrice> products = null;
 * List<ProductStockPrice> product2 = null;
 * 
 * @Autowired public BLL(ProductDAO productdao, cartDAO ca) { pdaoimp = productdao; cartimp = ca; }
 * 
 * public double getCartCost(int id) { double cartcost = 0.0; List<ProductStockPrice> cproducts =
 * cartimp.getCartProds(id); for (ProductStockPrice p : cproducts) { cartcost += p.getPrice() * p.getQuantity(); }
 * return cartcost; }
 * 
 * public double getCartCost(List<ProductStockPrice> al) { double cost = 0.0; for (ProductStockPrice p : al) { cost +=
 * p.getPrice() * p.getQuantity(); } return cost; }
 * 
 * public double getOrderGST(List<ProductStockPrice> al) { double gst = 0.0; for (ProductStockPrice ps : al) { gst +=
 * (ps.getGst() * ps.getPrice()) / 100; } return gst; }
 * 
 * public ProductStockPrice individualTotalfair(custCredModel cust, int pid, int qty) {
 * 
 * String spin = cust.getCustSpincode(); int spincode = Integer.parseInt(spin); ServiceableRegion rgn =
 * cartimp.getRegionByPincode(spincode); ProductStockPrice p = pdaoimp.getProductById(pid);
 * 
 * int prod_gstc_id=pdaoimp.getproductgstcid(pid); p.setProd_gstc_id(prod_gstc_id);
 * 
 * p.setQuantity(qty); setgsts(p, spin); double price = p.getPrice(); p.setQtyprice(price * qty); double totalprice =
 * p.getQtyprice();
 * 
 * double shipcharge = 0.0, wholeprice = 0.0; if (totalprice >= 0 && totalprice <= 1000) { shipcharge = 65; } double
 * surcharge = rgn.getSrrgPriceSurcharge(); System.out.println("surcharge==" + surcharge);
 * 
 * double pricewaiver = rgn.getSrrgPriceWaiver(); wholeprice = (shipcharge + surcharge) - pricewaiver;
 * ProductStockPrice.setTotal(wholeprice + totalprice); double prprice = p.getQtyprice();
 * System.out.println("In 2nd======" + prprice); double prpercentage = (prprice / totalprice) * 100; double scharge =
 * (prpercentage * wholeprice) / 100; System.out.println(scharge);
 * 
 * p.setShipcharge(scharge);
 * 
 * return p;
 * 
 * }
 * 
 * public void setgsts(ProductStockPrice p, String spin) { // double cost = p.getProd_price(); double mrp = p.getMrp();
 * System.out.println("In bll=mrp=" + mrp); System.out.println("In bll=gstc_id=" + p.getProd_gstc_id()); hsnModel hsn =
 * cartimp.getHSNCodeByProductId(p.getProd_gstc_id()); double sgst = hsn.getSgst(); System.out.println("In BLL=sgst=" +
 * sgst);
 * 
 * double igst = hsn.getIgst(); double cgst = hsn.getCgst(); System.out.println("In BLL=cgst=" + cgst);
 * 
 * if (!spin.startsWith("53")) { System.out.println("In in in chennai");
 * 
 * igst = (igst / 100) * mrp; cgst = (cgst / 100) * mrp; double gst = cgst + igst; p.setGst(gst);
 * System.out.println("gst: " + p.getGst());
 * 
 * p.setCgst(cgst); System.out.println("cgst: " + p.getCgst()); p.setIgst(igst); System.out.println("gst: " +
 * p.getIgst()); } else { System.out.println("In chennai"); cgst = (cgst / 100) * mrp; sgst = (sgst / 100) * mrp; double
 * gst = cgst + sgst; p.setCgst(cgst); p.setSgst(sgst); p.setGst(gst); System.out.println("In chennai" + p.getGst());
 * 
 * }
 * 
 * }
 * 
 * public void calculateTotalfair(custCredModel cust) { double pr = 0.0; product2 =
 * cartimp.getCartProds(cust.getCustId()); String spin = cust.getCustSpincode(); int spincode = Integer.parseInt(spin);
 * 
 * ServiceableRegion rgn = cartimp.getRegionByPincode(spincode);
 * 
 * for (ProductStockPrice p : product2) { double cost = p.getPrice(); setgsts(p, spin);
 * 
 * int qty = p.getQuantity(); cost = cost * qty; p.setQtyprice(cost); System.out.println("totalqtyprice++=" +
 * p.getQtyprice()); pr = pr + cost;
 * 
 * } calculatesurcharge(product2, pr, rgn);
 * 
 * }
 * 
 * public void calculatesurcharge(List<ProductStockPrice> products, double totalprice, ServiceableRegion rgn) {
 * System.out.println("In 2nd method"); double shipcharge = 0.0, wholeprice = 0.0; if (totalprice >= 0 && totalprice <=
 * 1000) { shipcharge = 65; } double surcharge = rgn.getSrrgPriceSurcharge(); System.out.println("surcharge==" +
 * surcharge);
 * 
 * double pricewaiver = rgn.getSrrgPriceWaiver(); wholeprice = (shipcharge + surcharge) - pricewaiver;
 * ProductStockPrice.setTotal(wholeprice + totalprice);
 * 
 * for (ProductStockPrice p : products) { double prprice = p.getQtyprice(); System.out.println("In 2nd======" +
 * prprice); double prpercentage = (prprice / totalprice) * 100; double scharge = (prpercentage * wholeprice) / 100;
 * System.out.println(scharge);
 * 
 * p.setShipcharge(scharge);
 * 
 * }
 * 
 * }
 * 
 * public List<ProductStockPrice> GetQtyItems2() { return product2; } }
 */

package eStoreProduct.BLL;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eStoreProduct.DAO.ProductDAO;
import eStoreProduct.DAO.cartDAO;
import eStoreProduct.model.ServiceableRegion;
import eStoreProduct.model.custCredModel;
import eStoreProduct.model.hsnModel;
import eStoreProduct.utility.ProductStockPrice;

@Component
public class BLL {
	ProductDAO pdaoimp;
	cartDAO cartimp;
	List<ProductStockPrice> products = null;
	List<ProductStockPrice> product2 = null;

	@Autowired
	public BLL(ProductDAO productdao, cartDAO ca) {
		pdaoimp = productdao;
		cartimp = ca;
	}

	public double getCartCost(int id) {
		double cartcost = 0.0;
		List<ProductStockPrice> cproducts = cartimp.getCartProds(id);
		for (ProductStockPrice p : cproducts) {
			cartcost += p.getPrice() * p.getQuantity();
		}
		return cartcost;
	}

	public double getCartCost(List<ProductStockPrice> al) {
		double cost = 0.0;
		for (ProductStockPrice p : al) {
			cost += p.getPrice() * p.getQuantity();
		}
		return cost;
	}

	public double getOrderGST(List<ProductStockPrice> al) {
		double gst = 0.0;
		for (ProductStockPrice ps : al) {
			gst += (ps.getGst() * ps.getPrice()) / 100;
		}
		return gst;
	}

	public ProductStockPrice individualTotalfair(custCredModel cust, int pid, int qty) {

		String spin = cust.getCustSpincode();
		int spincode = Integer.parseInt(spin);
		ServiceableRegion rgn = cartimp.getRegionByPincode(spincode);
		ProductStockPrice p = pdaoimp.getProductById(pid);

		int prod_gstc_id = pdaoimp.getproductgstcid(pid);
		p.setProd_gstc_id(prod_gstc_id);

		p.setQuantity(qty);
		setgsts(p, spin);
		double price = p.getPrice();
		p.setQtyprice(price * qty);
		double totalprice = p.getQtyprice();

		List<ProductStockPrice> prds = new ArrayList<>();
		prds.add(p);
		calculatesurcharge(prds, totalprice, rgn);
		return p;

	}

	public void setgsts(ProductStockPrice p, String spin) {
		double salecost = p.getPrice();
		System.out.println("In bll=gstc_id=" + p.getProd_gstc_id());
		hsnModel hsn = cartimp.getHSNCodeByProductId(p.getProd_gstc_id());
		double sgstrate = hsn.getSgst();
		double igstrate = hsn.getIgst();
		double cgstrate = hsn.getCgst();
		double gstrate = hsn.getGst();
		double n1 = salecost * (100 / (100 + gstrate));
		double gstamount = salecost - n1;
		double orgcost = salecost - gstamount;
		System.out.println("original cost" + orgcost);

		if (!spin.startsWith("53")) {
			System.out.println("In Other States");

			double igstamt = (igstrate / 100) * orgcost;

			double gst = igstamt;
			p.setGst(gst);
			System.out.println("gst: " + p.getGst());
			p.setIgst(igstamt);
			System.out.println("gst: " + p.getIgst());
		} else {
			System.out.println("our AP");
			double cgstamt = (cgstrate / 100) * orgcost;
			double sgstamt = (sgstrate / 100) * orgcost;
			double gst = cgstamt + sgstamt;
			p.setCgst(cgstamt);
			p.setSgst(sgstamt);
			p.setGst(gst);
			System.out.println("In AP" + p.getGst());

		}

	}

	public void calculateTotalfair(custCredModel cust) {
		double pr = 0.0;
		product2 = cartimp.getCartProds(cust.getCustId());
		String spin = cust.getCustSpincode();
		int spincode = Integer.parseInt(spin);

		ServiceableRegion rgn = cartimp.getRegionByPincode(spincode);

		for (ProductStockPrice p : product2) {
			double cost = p.getPrice();
			setgsts(p, spin);

			int qty = p.getQuantity();
			cost = cost * qty;
			p.setQtyprice(cost);
			System.out.println("totalqtyprice++=" + p.getQtyprice());
			pr = pr + cost;

		}
		calculatesurcharge(product2, pr, rgn);

	}

	public void calculatesurcharge(List<ProductStockPrice> products, double totalprice, ServiceableRegion rgn) {
		double shipcharge = 0.0, wholeshipmentprice = 0.0, shipgst = 0.0;
		if (totalprice >= 0 && totalprice <= 1000) {
			shipcharge = 65;
		}
		double surcharge = rgn.getSrrgPriceSurcharge();

		double pricewaiver = rgn.getSrrgPriceWaiver();
		wholeshipmentprice = (shipcharge + surcharge) - pricewaiver;

		for (ProductStockPrice p : products) {
			hsnModel hsn = cartimp.getHSNCodeByProductId(p.getProd_gstc_id());
			double prprice = p.getQtyprice();
			double prpercentage = (prprice / totalprice) * 100;
			double scharge = (prpercentage * wholeshipmentprice) / 100;
			double prdshipgst = ((hsn.getGst() / 100) * scharge);
			scharge = scharge + prdshipgst;
			shipgst += prdshipgst;
			System.out.println("each product shipment with gst");
			System.out.println(scharge);

			p.setShipcharge(scharge);

		}
		ProductStockPrice.setTotal(wholeshipmentprice + totalprice + shipgst);

	}

	public List<ProductStockPrice> GetQtyItems2() {
		return product2;
	}
}