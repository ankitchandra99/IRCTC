package com.example.tuesday.Controller;


import com.example.tuesday.Entity.Train;
import com.example.tuesday.RequestDto.NoOfPassengersDto;
import com.example.tuesday.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    TrainService trainService;

    @PostMapping("/addTrain")
    public String addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }

    @GetMapping("/NoOfPassengers")
    public int NoOfPassengers(@RequestBody NoOfPassengersDto noOfPassengersDto)
    {
        return trainService.NoOfPassengers(noOfPassengersDto);
    }
}
