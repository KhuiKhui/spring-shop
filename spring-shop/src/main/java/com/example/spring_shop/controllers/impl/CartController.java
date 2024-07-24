package com.example.spring_shop.controllers.impl;


import com.example.spring_shop.components.CartItem;
import com.example.spring_shop.controllers.inter.ICartController;
import com.example.spring_shop.entities.impl.Product;
import com.example.spring_shop.repos.UserRepository;
import com.example.spring_shop.response.ResponseData;
import com.example.spring_shop.services.impl.OrderDetailsService;
import com.example.spring_shop.services.impl.OrderService;
import com.example.spring_shop.services.impl.ProductService;
import com.example.spring_shop.services.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController implements ICartController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final OrderDetailsService orderDetailsService;
    private Map<Integer, CartItem> products = new HashMap<>();
    private List<Product> productsList = new ArrayList<>();
    private ProductService productService;
    private OrderService orderService;

    public CartController(ProductService productService, OrderService orderService, UserService userService, UserRepository userRepository, OrderDetailsService orderDetailsService) {
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.orderDetailsService = orderDetailsService;
    }

    @Override
    @GetMapping("/cart")
    public String getCartItems(Model model) {
        model.addAttribute("cart", this.products.values());
        model.addAttribute("total", orderService.getTotal(products.values()));
        return "/pages/cart";
    }

    @GetMapping("/cart/id/{id}")
    public String addItemsFromShop(@PathVariable("id") int id, Model model) {
        ResponseData product = productService.getProductById(id);
        if (!products.containsKey(id)) {
            products.put(id, new CartItem(product.getJsonData(), 1));
        } else {
            products.get(id).increaseQuantity();
        }
        return "redirect:/";
    }

    @GetMapping("/cart/id/{id}/add")
    public String addItems(@PathVariable("id") int id, Model model) {
        ResponseData product = productService.getProductById(id);
        if (!products.containsKey(id)) {
            products.put(id, new CartItem(product.getJsonData(), 1));
        } else {
            products.get(id).increaseQuantity();
        }
        model.addAttribute("cart", this.products.values());
        model.addAttribute("total", orderService.getTotal(products.values()));
        return "/pages/cart";
    }

    @GetMapping("/cart/id/{id}/del")
    public String delItems(@PathVariable("id") int id, Model model) {
        if (!products.containsKey(id)) {
            return "/pages/cart";
        } else {
            if (products.get(id).getQuantity() == 1) {
                products.remove(id);
                return "/pages/cart";
            }
            products.get(id).decreaseQuantity();
        }
        model.addAttribute("cart", this.products.values());
        model.addAttribute("total", orderService.getTotal(products.values()));
        return "/pages/cart";
    }

    @GetMapping("/cart/id/{id}/remove")
    public String removeItems(@PathVariable("id") int id, Model model) {
        if (!products.containsKey(id)) {
            return "/pages/cart";
        } else {
            products.remove(id);
        }
        model.addAttribute("cart", this.products.values());
        model.addAttribute("total", orderService.getTotal(products.values()));
        return "/pages/cart";
    }


    @Override
    @GetMapping("/cart/checkout")
    public String checkout(Model model) {
        String username = userService.getCurrentUserCred().getResData();
        //String name = jo.getString("username");
        //User user = (User) userService.getUserByName(userName).getResData();
        int userId = userRepository.findByName(username).get().getId();
        ResponseData order = orderService.createOrder(this.products.values(), userId);
        ResponseData orderDetails = orderDetailsService.createOrderDetails(this.products.values(), order);
        this.products.clear();
        return "redirect:/";
    }
}
