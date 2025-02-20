package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    // Create a new product
    @GetMapping("/create")
    public String createProductPage (Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost (@ModelAttribute Product product) {
        service.create(product);
        return "redirect:list";
    }

    // List all products
    @GetMapping("/list")
    public String productListPage (Model model) {
        List <Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    // Edit a product
    @GetMapping("/edit/{productId}")
    public String editProductPage (@PathVariable String productId, Model model) {
        Product product = service.findProductById(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PutMapping("/edit")
    public String editProductPost (@ModelAttribute Product product) {
        service.update(product);
        return "redirect:list";
    }

    // Delete a product
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct (@PathVariable String productId) {
        Product product = service.findProductById(productId);
        service.delete(product);
        return "redirect:../list";
    }
}