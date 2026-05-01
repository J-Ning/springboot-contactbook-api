package org.example.controller;

import org.example.service.NetworkSegment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/networksegment")
public class ControllerNetworkSegment {

    private final NetworkSegment networkSegment;

    @Autowired
    public ControllerNetworkSegment(NetworkSegment maskService) { this.networkSegment = maskService; }

    @PostMapping("/hi")
    public String hi() { return networkSegment.howdy(); }

    @PostMapping("/ipmask")
    public String networkSegment(@RequestParam String ip, String mask){

        return networkSegment.networkSegment(ip,mask);
    }

    @PostMapping("/synchronizedcounter")
    public int synchronizedCounter() { return networkSegment.incAndGet(); }
}
