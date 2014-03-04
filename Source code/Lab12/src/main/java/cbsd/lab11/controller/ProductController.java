package cbsd.lab11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import cbsd.lab11.service.ProductService;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "list")
    public String list(Model model){
        model.addAttribute("products", productService.getProducts());
        return "product";
    }

    @RequestMapping(value = "search")
    public String search(Model model){
        model.addAttribute("products", productService.getProducts());
        return "productList";
    }

    @RequestMapping(value = "search/{keyword}")
    public String search(@PathVariable("keyword") String keyword, Model model){
        model.addAttribute("products",productService.searchProducts(keyword));
        return "product";
    }
}
