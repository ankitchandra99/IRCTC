package com.example.tuesday.Controller;


import com.example.tuesday.Entity.Passenger;
import com.example.tuesday.RequestDto.NoOfFemalePassByAgeAndDateDto;
import com.example.tuesday.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @PostMapping("/addPassenger")
    public ResponseEntity addPassenger(@RequestBody Passenger passenger, @RequestParam("trainId") Integer trainId)
    {
        String result=passengerService.addPassenger(passenger,trainId);
        return new ResponseEntity(result, HttpStatus.OK);
    }


    @GetMapping("/NoOfFemalePassByAgeAndDate")
    public int NoOfFemalePassByAgeAndDate(@RequestBody NoOfFemalePassByAgeAndDateDto noOfFemalePassByAgeAndDateDto)
    {
        return passengerService.NoOfFemalePassByAgeAndDate(noOfFemalePassByAgeAndDateDto);
    }
}
