package com.example.tuesday.Service;

import com.example.tuesday.Entity.FoodOrder;
import com.example.tuesday.Entity.Passenger;
import com.example.tuesday.Entity.Train;
import com.example.tuesday.Repository.FoodOrderRepository;
import com.example.tuesday.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodOrderService {

    @Autowired
     private FoodOrderRepository foodOrderRepository;
    @Autowired
    private PassengerRepository passengerRepo;
    public String addFoodOrder(FoodOrder foodOrder, Integer passengerId)
    {
        Optional<Passenger> optionalPassenger=passengerRepo.findById(passengerId);
        Passenger passenger=optionalPassenger.get();
        foodOrder.setPassenger(passenger);
        List<FoodOrder> list1=passenger.getOrderList();
        list1.add(foodOrder);
        passenger.setOrderList(list1);
        passengerRepo.save(passenger);
        return "added";
    }
}
