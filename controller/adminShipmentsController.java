package eStoreProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eStoreProduct.DAO.OrderDAO;
import eStoreProduct.DAO.orderProductDAO;
import eStoreProduct.model.orderModel;
import eStoreProduct.model.orderProductsModel;

@Controller
public class adminShipmentsController {

	private OrderDAO od;
	private orderModel om;
	private orderProductsModel opm;
	private orderProductDAO opd;

	@Autowired
	adminShipmentsController(OrderDAO ord, orderModel omd, orderProductsModel opmd, orderProductDAO orderproductdao) {
		od = ord;
		om = omd;
		opm = opmd;
		opd = orderproductdao;
	}

	@GetMapping("/displayProcessedOrdersInShipments")
	public String showProcessedOrders(Model model) {
		List<orderModel> orders = od.getAllOrders();
		model.addAttribute("orders", orders);
		return "shipmentProgressPage";
	}

	@GetMapping("/displayProcessedOrderProductsToUpdateStatus")
	public String showProcessedOrderProducts(@RequestParam(value = "orderId") int o_id, Model model) {
		System.out.println("show OrderProducts");
		List<orderProductsModel> orderproducts = opd.getOrderWiseOrderProducts(o_id);
		model.addAttribute("orderproducts", orderproducts);
		return "orderProductsListPage";
	}

	@PostMapping("/updateOrderProductStatus")
	public String updateStatusOrderProducts(@Validated orderProductsModel opm1, Model model) {
		System.out.println(
				"show update OrderProducts orderId" + opm1.getOrdr_id() + " product id:" + opm1.getProd_id() + "\n");
		opd.updateOrderProductStatus(opm1.getOrdr_id(), opm1.getProd_id(), opm1.getShipment_status());
		System.out.print("updated Op Status");
		List<orderProductsModel> orderproducts = opd.getOrderWiseOrderProducts(opm1.getOrdr_id());
		model.addAttribute("orderproducts", orderproducts);
		return "orderProductsListPage";
	}

	@GetMapping("/displayShippedOrders")
	public String showShippedOrders(Model model) {
		List<orderModel> orders = od.getAllOrders();
		model.addAttribute("orders", orders);
		return "shipmentShippedPage";
	}
}
