package eStoreProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eStoreProduct.DAO.EmailConfigDAO;
import eStoreProduct.DAO.OrderValueWiseShippingChargeDAO;
import eStoreProduct.DAO.ProductShipDAO;
import eStoreProduct.DAO.RegionDAO;
import eStoreProduct.DAO.adminDAO;
import eStoreProduct.model.EmailConfigModel;
import eStoreProduct.model.OrderValueWiseShippingCharge;
import eStoreProduct.model.ProductShip;
import eStoreProduct.model.Regions;

@Controller
public class adminSettingsController {
	adminDAO adao;
	EmailConfigDAO edao;
	RegionDAO redao;
	OrderValueWiseShippingChargeDAO owsc;
	ProductShipDAO pdao;

	@Autowired
	public adminSettingsController(adminDAO admindao, EmailConfigDAO edao, RegionDAO redao,
			OrderValueWiseShippingChargeDAO owsc, ProductShipDAO pdao) {
		adao = admindao;
		this.edao = edao;
		this.redao = redao;
		this.owsc = owsc;
		this.pdao = pdao;
	}

	@RequestMapping(value = "/addRegion", method = RequestMethod.POST)
	@ResponseBody
	public String addRegion(@Validated Regions reg, Model model) {
		System.out.println("Admin Page");
		redao.addRegion(reg);
		// call the view
		return "DONE";
	}

	@RequestMapping(value = "/remRegion", method = RequestMethod.POST)
	@ResponseBody
	public String addRegion(@RequestParam("regionId") String id, Model model) {
		System.out.println("Admin Page");
		int Id = Integer.parseInt(id);
		redao.removeRegion(Id);
		// call the view
		return "DONE";
	}

	@RequestMapping(value = "/ShippingRedirect", method = RequestMethod.GET)
	public String shippingRedirect(Model model) {
		System.out.println("shippingRedirect");
		List<Regions> regionList = redao.getRegions();
		System.out.println("shippingRedirect1");
		model.addAttribute("regionList", regionList);
		System.out.println("shippingRedirect2");

		// call the view
		return "regions";
	}

	@RequestMapping(value = "/EmailConfiguration", method = RequestMethod.POST)
	@ResponseBody
	public String emailConfiguration(@Validated EmailConfigModel ecm, Model model) {
		System.out.println("emailConfiguration");

		edao.changeEmail(ecm);
		return "done";
	}

	@RequestMapping(value = "/EmailConfigurationPage", method = RequestMethod.GET)
	public String returnpage(Model model) {
		System.out.println("emailConfigurationpage");
		// EmailConfigDAO edao=new EmailConfigDAOImpl();
		// call the view
		return "emailConfig";
	}

	@RequestMapping(value = "/OrderValueWisePage", method = RequestMethod.GET)
	public String OrderValueWisePage(Model model) {
		System.out.println("OrderValueWisePage");
		List<OrderValueWiseShippingCharge> ocl = owsc.getAll();
		System.out.println("OrderValueWisePage");
		model.addAttribute("chargeList", ocl);
		System.out.println("OrderValueWisePage");

		// call the view
		return "OrderValueWisePage";
	}

	@RequestMapping(value = "/updateCharge", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateCharge(@Validated OrderValueWiseShippingCharge osw, Model model) {

		// call the view
		return owsc.updateCharge(osw);
	}

	@RequestMapping(value = "/addCharge", method = RequestMethod.POST)
	@ResponseBody
	public boolean addCharge(@Validated OrderValueWiseShippingCharge osw, Model model) {

		// call the view
		return owsc.addCharge(osw);
	}

	@RequestMapping(value = "/productWisePage", method = RequestMethod.GET)
	public String ProductWise(Model model) {

		List<ProductShip> ps = pdao.getAll();
		model.addAttribute("plist", ps);
		// call the view
		return "productWisePage";
	}

	@RequestMapping(value = "/prodShipUpdate", method = RequestMethod.POST)
	@ResponseBody
	public boolean prodShipUpdate(@Validated ProductShip ps, Model model) {

		// call the view
		return pdao.update(ps);
	}

}