package com.example.tuesday.Repository;

import com.example.tuesday.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {
     List<Train> findAllTrainsBySourceAndDestination(String source, String destination);
}
