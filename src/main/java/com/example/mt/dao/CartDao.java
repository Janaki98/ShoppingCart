package com.example.mt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mt.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

}
