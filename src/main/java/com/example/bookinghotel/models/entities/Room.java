package com.example.bookinghotel.models.entities;
import com.example.bookinghotel.models.enums.EBedType;
import com.example.bookinghotel.models.enums.ETypeOfView;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Table(name = "room")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int capacity;
    @Enumerated(EnumType.STRING)
    EBedType bedType;
    float square;
    boolean wifi;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    Hotel hotel;
    @Enumerated(EnumType.STRING)
    ETypeOfView typeOfView;
    boolean active;

}
