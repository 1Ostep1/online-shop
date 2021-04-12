package com.example.greenshop.Controllers;

import com.example.greenshop.Entity.Product;
import com.example.greenshop.Repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Controller
public class MainController {

    @Autowired
    private productRepo ProductRepo;

    @GetMapping("/")
    public String main(Model model){
        Iterable<Product> products = ProductRepo.findAll();
        model.addAttribute("products",products);
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }

}
