package com.example.greenshop.Repo;

import com.example.greenshop.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface productRepo extends CrudRepository<Product, Long> {
    public List<Product> findAllByTypesAndSex(String type,String sex);
}
