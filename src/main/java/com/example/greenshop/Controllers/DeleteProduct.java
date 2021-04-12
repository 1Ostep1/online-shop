package com.example.greenshop.Controllers;

import com.example.greenshop.Entity.Product;
import com.example.greenshop.Repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteProduct {

    @Autowired
    private productRepo ProductRepo;

    @PostMapping("/product/{id}/delete")
    public String productDelete(@PathVariable(value = "id") long id, Model model){
        Product product = ProductRepo.findById(id).orElseThrow();
        ProductRepo.delete(product);
        return "redirect:/";
    }

}
