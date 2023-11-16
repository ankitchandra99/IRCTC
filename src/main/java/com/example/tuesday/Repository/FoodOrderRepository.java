package com.example.tuesday.Repository;

import com.example.tuesday.Entity.FoodOrder;
import com.example.tuesday.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {

}
