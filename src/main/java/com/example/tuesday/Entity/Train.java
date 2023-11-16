package com.example.tuesday.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;
    private String trainNo;
    private String source;
    private String destination;

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    List<Passenger> passengerList=new ArrayList<>();
}
