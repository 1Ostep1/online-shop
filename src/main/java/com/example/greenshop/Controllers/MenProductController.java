package com.example.greenshop.Controllers;

import com.example.greenshop.Entity.Product;
import com.example.greenshop.Repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenProductController {

    @Autowired
    private productRepo ProductRepo;

    @GetMapping("/men")
    public String getMenProduct(Model model){
        Iterable<Product> products = ProductRepo.findAllByTypesAndSex("Clothes","Men");
        Iterable<Product> shoes = ProductRepo.findAllByTypesAndSex("Shoes","Men");
        Iterable<Product> carousel = ProductRepo.findAllByTypesAndSex("carousel","Men");
        model.addAttribute("products",products);
        model.addAttribute("shoes",shoes);
        model.addAttribute("carousel",carousel);
        return "men";
    }

}
