package com.example.mappingfed.Controller;

import com.example.mappingfed.enity.Bus;
import com.example.mappingfed.enity.BusStop;
import com.example.mappingfed.enity.Stop;
import com.example.mappingfed.repository.BusRepository;
import com.example.mappingfed.repository.BusStopRepository;
import com.example.mappingfed.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusStopController {
    private BusRepository busRepository;
    private StopRepository stopRepository;
    private BusStopRepository busStopRepository;


    public BusStopController(BusRepository busRepository, StopRepository stopRepository, BusStopRepository busStopRepository) {
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
        this.busStopRepository = busStopRepository;
    }

@PostMapping
    public ResponseEntity<BusStop>allocateBusRoute(
     @RequestParam long busId,
     @RequestParam long stopId,
     @RequestBody BusStop busStop

    ) {
    Bus bus = busRepository.findById(busId).get();
    Stop stop = stopRepository.findById(stopId).get();

busStop.setBus(bus);
busStop.setStop(stop);
    BusStop save = busStopRepository.save(busStop);
    return new ResponseEntity<>(save, HttpStatus.CREATED);


    }
}
