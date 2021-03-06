package com.example.bookinghotel.dao;

import com.example.bookinghotel.models.entities.City;
import com.example.bookinghotel.models.entities.Hotel;
import com.example.bookinghotel.models.enums.EBedType;import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Long> {

    @Query("select h from Hotel h where h.city = ?1 order by h.currentScore DESC")
    List<Hotel> findAllByCityAndCurrentScore(City city);

    @Query(value = "select * from hotel h where h.city_id = :id and exists (select * from room r where r.hotel_id = h.id and r.bed_type = :#{#bedType.name()})", nativeQuery = true)
    List<Hotel> findAllByCityAndBedType(@Param("id") Long cityId, @Param("bedType") EBedType bedType);
}
