package com.test.controller;


import com.test.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping("/getTacoTruckNames")
    public List<String> getTacoTruckNames() {
        return truckService.getTacoTruckNames();
    }
}
