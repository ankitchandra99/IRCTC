package com.example.tuesday.Service;

import com.example.tuesday.Entity.Passenger;
import com.example.tuesday.Entity.Train;
import com.example.tuesday.Repository.PassengerRepository;
import com.example.tuesday.Repository.TrainRepository;
import com.example.tuesday.RequestDto.NoOfFemalePassByAgeAndDateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepo;

    @Autowired TrainRepository trainRepository;
    public String addPassenger(Passenger passenger, Integer trainId)
    {
        Optional<Train> optionalTrain=trainRepository.findById(trainId);
        Train train=optionalTrain.get();
        passenger.setTrain(train);
        List<Passenger> list=train.getPassengerList();
        list.add(passenger);
        train.setPassengerList(list);
        trainRepository.save(train);
        return "added";
    }

    public int NoOfFemalePassByAgeAndDate(NoOfFemalePassByAgeAndDateDto noOfFemalePassByAgeAndDateDto)
    {
        int start = noOfFemalePassByAgeAndDateDto.getStartAge();
        int end = noOfFemalePassByAgeAndDateDto.getEndAge();
        String dest = noOfFemalePassByAgeAndDateDto.getDestination();
        List<Passenger>passengerList = passengerRepo.findAll();
        int count=0;
        for(Passenger p : passengerList)
        {
            int age = p.getAge();
            Train t = p.getTrain();
            if(age > start && age <= end && t.getDestination().equals(dest))
            {
                count++;
            }
        }
        return count;
    }

}