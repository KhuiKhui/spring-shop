package com.example.spring_shop.controllers.inter;

import com.example.spring_shop.entities.impl.Product;
import com.example.spring_shop.validation.impl.beanGroups.AddGroup;
import com.example.spring_shop.validation.impl.beanGroups.DeleteGroup;
import com.example.spring_shop.validation.impl.beanGroups.UpdateGroup;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public interface IProductController {
    @GetMapping("/")
    String getProducts(Model model);

    @GetMapping("/add")
    String addForm(Model model);

    @PostMapping("/add")
    String addSubmit(@Validated(AddGroup.class) @ModelAttribute("addFormProduct") Product product, BindingResult res, Model model);

    @GetMapping("/update")
    String updateForm(Model model);


    @PostMapping("/update")
    String updateSubmit(@Validated(UpdateGroup.class) @ModelAttribute("updFormProduct") Product product, BindingResult res, Model model);

    @GetMapping("/delete")
    String deleteForm(Model model);

    @PostMapping("/delete")
    String deleteSubmit(@Validated(DeleteGroup.class) @ModelAttribute("deleteFormProduct") Product product, BindingResult res, Model model);
}
