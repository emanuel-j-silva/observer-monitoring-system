package org.example;

import org.example.observers.ACDevice;
import org.example.observers.SSADevice;
import org.example.observers.SSDevice;
import org.example.subject.Dam;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dam dam = new Dam("Dam 1","Belo Horizonte");
        SSDevice ssDevice1 = new SSDevice((long) 1);
        SSADevice ssaDevice1 = new SSADevice((long) 1);
        ACDevice acDevice1 = new ACDevice((long) 1);
        dam.registerObserver(ssDevice1);
        dam.registerObserver(acDevice1);

        // INVALID EARTHQUAKES: DEVICE NOT RECORDED
        ssaDevice1.hasEarthquake(dam,8);
        ssaDevice1.hasEarthquake(dam, (long) 7.5);
        ssaDevice1.hasEarthquake(dam,9);
        dam.registerObserver(ssaDevice1);

        System.out.println("EARTHQUAKE 1");
        ssDevice1.hasEarthquake(dam);
        System.out.println("EARTHQUAKE 2");
        ssaDevice1.hasEarthquake(dam,8);
        System.out.println("EARTHQUAKE 3");
        ssDevice1.hasEarthquake(dam);

        //INVALID EARTHQUAKE: VALUE UNDER LIMIT
        System.out.println("EARTHQUAKE 4 (INVALID)");
        ssaDevice1.hasEarthquake(dam, 3);
        System.out.println("EARTHQUAKE 5");
        ssDevice1.hasEarthquake(dam);
        System.out.println("EARTHQUAKE 6");
        ssaDevice1.hasEarthquake(dam,9);
        System.out.println("UNREGISTERING THE SS DEVICE");
        dam.unregisterObserver(ssDevice1);
        // INVALID EARTHQUAKE: DEVICE NOT RECORDED
        System.out.println("EARTHQUAKE 7 (INVALID)");
        ssDevice1.hasEarthquake(dam);
        System.out.println("EARTHQUAKE 8");
        ssaDevice1.hasEarthquake(dam, (long) 9.5);
        System.out.println("Dam: "+ dam.getName() + " | " + "City: " + dam.getCity() +
                " | Number of earthquakes recorded by devices: " + dam.getEarthquakeCounter());

    }
}