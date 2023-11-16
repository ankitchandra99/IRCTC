package com.example.tuesday.Controller;

import com.example.tuesday.Entity.FoodOrder;
import com.example.tuesday.Service.FoodOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food order")
public class FoodOrderController
{

    FoodOrderService foodService = new FoodOrderService();
    @PostMapping("/addFoodOrder")
    public String addFoodOrder(@RequestBody FoodOrder foodOrder) {

        return foodService.addFoodOrder(foodOrder);

    }
}