package com.example.greenshop.Controllers;

import com.example.greenshop.Entity.Product;
import com.example.greenshop.Repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class addProduct {
    @Autowired
    private productRepo ProductRepo;

    @GetMapping("/add")
    public String productAdd(Model model){
        return "product-add";
    }

    @PostMapping("/add")
    public String blogNewAdd(@RequestParam String name, @RequestParam String price,
                             @RequestParam String info, @RequestParam String imageUrl, @RequestParam String types,@RequestParam String sex, Model model){
        Product product = new Product(name,price,info,imageUrl,types,sex);
        ProductRepo.save(product);
        return "redirect:/";
    }

}