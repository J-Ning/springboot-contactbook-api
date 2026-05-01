package org.example.service;

import lombok.Synchronized;
import org.springframework.stereotype.Service;

@Service
public class NetworkSegment implements NetworkSegmentInterface {

    public String howdy() {
        return NetworkSegmentInterface.hi();
    }

    public String networkSegment(String ip, String mask) {
        String[] ipSplit = ip.split("\\.");
        String[] maskSplit = mask.split("\\.");

        int[] segmentNetwork = new int[4];
        for(int i = 0; i < 4; i++) {
            segmentNetwork[i] = Integer.parseInt(ipSplit[i]) & Integer.parseInt(maskSplit[i]);
        }

        return "Segment Network of the following ip: " + ip + " and  mask: " + mask + " is " +
                segmentNetwork[0] + "." + segmentNetwork[1] + "." + segmentNetwork[2] + "." + segmentNetwork[3];
    }

    private int counter = 0;

    @Synchronized
    public int incAndGet() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException ignored) {
        }
        counter++;

        return counter;
    }
}
