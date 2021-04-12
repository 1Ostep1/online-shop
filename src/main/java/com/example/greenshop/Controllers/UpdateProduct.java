package com.example.greenshop.Controllers;

import com.example.greenshop.Entity.Product;
import com.example.greenshop.Repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UpdateProduct {

    @Autowired
    private productRepo ProductRepo;

    @GetMapping("/product/{id}/edit")
    public String productEdit(@PathVariable(value = "id") long id, Model model) {
        if(!ProductRepo.existsById(id)) {
            return "redirect:/";
        }

        Optional<Product> product = ProductRepo.findById(id);
        ArrayList<Product> res = new ArrayList<>();
        product.ifPresent(res::add);
        model.addAttribute("product", res);
        return "product-edit";
    }

    @PostMapping("/product/{id}/edit")
    public  String productPostUpdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String price, @RequestParam String url, Model model){
        Product product = ProductRepo.findById(id).orElseThrow();
        product.setName(name);
        product.setPrice(price);
        product.setImageUrl(url);
        ProductRepo.save(product);
        return  "redirect:/";

    }

}
