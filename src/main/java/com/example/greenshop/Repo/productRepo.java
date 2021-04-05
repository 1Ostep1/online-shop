package com.example.greenshop.Repo;

import com.example.greenshop.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface productRepo extends CrudRepository<Product, Long> {
    public List<Product> findAllByTypesAndSex(String type,String sex);

//    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
//            + " OR p.sex LIKE %?1%"
//            + " OR p.types LIKE %?1%"
//            + " OR CONCAT(p.price, '') LIKE %?1%")
//    public List<Product> search(String keyword);
}
