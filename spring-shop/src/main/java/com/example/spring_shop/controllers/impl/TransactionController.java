//package com.example.spring_shop.controllers;
//
//import com.example.spring_shop.services.impl.OrderService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class TransactionController {
//
//    private final OrderService transactionService;
//
//    public TransactionController(OrderService transactionService) {
//        this.transactionService = transactionService;
//    }
//
//    @GetMapping("/cart/checkout")
//    public String createBulkTransactions() {
//        transactionService.createBulkTransactions();
//        return "index";
//    }
//
//
//}
