package com.example.tuesday.Service;

import com.example.tuesday.Entity.FoodOrder;
import com.example.tuesday.Repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderService {

    @Autowired
     FoodOrderRepository foodOrderRepository;
    public String addFoodOrder(FoodOrder foodOrder)
    {
        foodOrderRepository.save(foodOrder);
        return "added";
    }
}
