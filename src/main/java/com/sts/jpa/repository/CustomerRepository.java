package com.sts.jpa.repository;

import com.sts.jpa.dto.OrderResponse;
import com.sts.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT new com.sts.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
    List<OrderResponse> getJoinInformation();
}
