package eStoreProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eStoreProduct.DAO.CategoryDAO;
import eStoreProduct.DAO.ProductDAO;
import eStoreProduct.DAO.stockSummaryDAO;
import eStoreProduct.model.Category;
import eStoreProduct.model.Product;
import eStoreProduct.model.stockSummaryModel;

@Controller
public class adminMasterEntryController {

	private stockSummaryDAO ssd;

	private final ProductDAO pdaoimp;
	private final CategoryDAO cdaoimp;

	@Autowired
	adminMasterEntryController(stockSummaryDAO stockdao, ProductDAO productdao, CategoryDAO categorydao) {
		ssd = stockdao;
		pdaoimp = productdao;
		cdaoimp = categorydao;
	}

	@RequestMapping(value = "/showEditableStocks", method = RequestMethod.GET)
	public String showEditableStocks(Model model) {
		System.out.println("enter masterEntry controller");
		List<stockSummaryModel> stocks1 = (List<stockSummaryModel>) ssd.getStocks();
		model.addAttribute("stocks1", stocks1);
		return "editableStocks";
	}

	@GetMapping("/updateMasterEntryTables")
	public String showUpdatedEditableStocks(@Validated stockSummaryModel ssm, Model model) {
		System.out.println("enter updated masterEntry controller");
		ssd.updateStocks(ssm.getProd_id(), ssm.getImage_url(), ssm.getProd_gstc_id(), ssm.getReorderlevel(),
				ssm.getProd_stock(), ssm.getProd_mrp());
		List<stockSummaryModel> stocks1 = (List<stockSummaryModel>) ssd.getStocks();
		System.out.println("enter updated masterEntry controller23");
		model.addAttribute("stocks1", stocks1);
		return "editableStocks";
	}

	@GetMapping("/addNewProductInTheMasterEntry")
	public String addNewProductInMasterEntry(Model model) {
		System.out.println("enter addNewProductController controller");

		return "addNewProduct";
	}

	@RequestMapping(value = "/createNewProduct", method = RequestMethod.POST)
	public String createProductNew(@Validated Product prod, Model model) {
		pdaoimp.createProduct(prod);
		return "AddedProduct";

	}

	@GetMapping("/addNewCategorytInTheMasterEntry")
	public String addNewCategorytInMasterEntry(Model model) {
		System.out.println("enter addNewCategoryController controller");

		return "addNewCategoryForm";
	}

	@RequestMapping(value = "/createNewCategory", method = RequestMethod.POST)
	public String createProductNew(@Validated Category catg, Model model) {
		cdaoimp.addNewCategory(catg);
		return "AddedCategory";

	}

}