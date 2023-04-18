package com.ekart.dao;

import com.ekart.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IOrdersRepository extends JpaRepository<Orders, Long> {

}
