package com.example.tuesday.Controller;

import com.example.tuesday.Entity.FoodOrder;
import com.example.tuesday.Entity.Passenger;
import com.example.tuesday.Service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodOrder")
public class FoodOrderController
{

    @Autowired
    private FoodOrderService foodOrderService;

    @PostMapping("/addFoodOrder")
    public ResponseEntity addFoodOrder(@RequestBody FoodOrder foodOrder, @RequestParam("passengerId") Integer passengerId)
    {
        String result=foodOrderService.addFoodOrder(foodOrder,passengerId);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}