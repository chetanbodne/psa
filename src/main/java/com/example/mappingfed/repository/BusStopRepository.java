package com.example.mappingfed.repository;

import com.example.mappingfed.enity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}