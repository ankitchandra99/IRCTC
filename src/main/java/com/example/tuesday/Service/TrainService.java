package com.example.tuesday.Service;

import com.example.tuesday.Entity.Passenger;
import com.example.tuesday.Entity.Train;
import com.example.tuesday.Repository.PassengerRepository;
import com.example.tuesday.Repository.TrainRepository;
import com.example.tuesday.RequestDto.NoOfPassengersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepo;

    @Autowired
    PassengerRepository passengerRepository;
    public String addTrain(Train train) {
        trainRepo.save(train);
        return "train added";

    }

    public int NoOfPassengers(NoOfPassengersDto noOfPassengersDto)
    {
        String source = noOfPassengersDto.getSource();
        String destination = noOfPassengersDto.getDestination();
        List<Train> trainsList= trainRepo.findAllTrainsBySourceAndDestination(source,destination);

        if(trainsList.isEmpty()) return 0;
        int count=0;
        for(Train t:trainsList)
        {
            List<Passenger>passengerList = t.getPassengerList();
            for(Passenger p:passengerList)
            {
                if(p.getDate().compareTo(noOfPassengersDto.getDate())==0)
                {
                    count++;
                }
            }
        }
        return count;

    }

    public String TrainAndPass(Integer trainId, Integer passId)
    {
        Optional<Train> optionalTrain = trainRepo.findById(trainId);
        if(optionalTrain.isEmpty()) return "invalid trainId";

        Optional<Passenger>optionalPassenger = passengerRepository.findById(passId);
        if(optionalPassenger.isEmpty()) return "invalid passengerId";

        Train t = optionalTrain.get();
        Passenger p = optionalPassenger.get();
        List<Passenger>list = t.getPassengerList();
        list.add(p);
        p.setTrain(t);

        trainRepo.save(t);
        return "mapped";
    }
}
