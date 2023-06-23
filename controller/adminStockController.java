package eStoreProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eStoreProduct.DAO.stockSummaryDAO;
import eStoreProduct.model.HSNCodeModel;
import eStoreProduct.model.productCategoryModel;
import eStoreProduct.model.productStockModel;
import eStoreProduct.model.productsModel;
import eStoreProduct.model.stockSummaryModel;

@Controller
public class adminStockController {
	private stockSummaryDAO ssd;
	/*
	 * private HSNCodeModel a; private productCategoryModel b; private productsModel
	 * c; private productStockModel d;
	 */

	@Autowired
	adminStockController(stockSummaryDAO stockdao) {
		ssd = stockdao;
		/*
		 * a = hsnm; b = pcm; c = pm; d = psm;
		 */
	}

	@GetMapping("/listStock")
	public String showStocks(Model model) {
		System.out.println("enter stock controller");
		List<stockSummaryModel> stocks = (List<stockSummaryModel>) ssd.getStocks();
		model.addAttribute("stocks", stocks);
		return "stockSummary";
	}

}
