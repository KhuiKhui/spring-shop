package com.example.spring_shop.controllers.impl;

import com.example.spring_shop.controllers.inter.IProductController;
import com.example.spring_shop.entities.impl.Product;
import com.example.spring_shop.response.ResponseData;
import com.example.spring_shop.services.impl.ProductService;
import com.example.spring_shop.validation.impl.beanGroups.AddGroup;
import com.example.spring_shop.validation.impl.beanGroups.DeleteGroup;
import com.example.spring_shop.validation.impl.beanGroups.UpdateGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class ProductController implements IProductController {

    private final Logger logger = Logger.getLogger(ProductController.class.getName());
    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @GetMapping("/")
    public String getProducts(Model model) {
        ResponseData data = productService.getProducts();
        model.addAttribute("data", data.getJsonArrayData());
//        model.addAttribute("errorDesc", data.getResDesc());
//        model.addAttribute("errorCode", data.getResCode());
        return "index";
    }

    @Override
    @GetMapping("/add")
    public String addForm(Model model) {

        model.addAttribute("addFormProduct", new Product());
        return "/pages/add";
    }

    @Override
    @PostMapping("/add")
    public String addSubmit(@Validated(AddGroup.class) @ModelAttribute("addFormProduct") Product product, BindingResult res, Model model) {

        if (res.hasErrors()) {
            return "/pages/add";
        }

        ResponseData data = productService.createProduct(product.getName(), product.getPrice());

        return "redirect:/";
    }

    @Override
    @GetMapping("/update")
    public String updateForm(Model model) {
        model.addAttribute("updFormProduct", new Product());
        return "/pages/update";
    }

    @Override
    @PostMapping("/update")
    public String updateSubmit(@Validated(UpdateGroup.class) @ModelAttribute("updFormProduct") Product product, BindingResult res, Model model) {
        if (res.hasErrors()) {
            return "/pages/update";
        }
        ResponseData data = productService.updateProduct(product.getId(), product.getName(), product.getPrice());
        model.addAttribute("updFormProduct", new Product());
        return "redirect:/";
    }

    @Override
    @GetMapping("/delete")
    public String deleteForm(Model model) {
        model.addAttribute("deleteFormProduct", new Product());
        return "/pages/delete";
    }

    @Override
    @PostMapping("/delete")
    public String deleteSubmit(@Validated(DeleteGroup.class) @ModelAttribute("deleteFormProduct") Product product, BindingResult res, Model model) {
        logger.info("Res: " + res);
        if (res.hasErrors()) {
            logger.info("ERROR");
            return "/pages/delete";
        }
        ResponseData data = productService.deleteProduct(product.getId());
        return "redirect:/";
    }

}