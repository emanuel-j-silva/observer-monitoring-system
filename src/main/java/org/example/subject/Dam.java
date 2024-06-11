package org.example.subject;


public class Dam extends Subject{
    private String name;
    private String city;
    private Integer earthquakeCounter = 0;

    public Dam(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getEarthquakeCounter() {
        return earthquakeCounter;
    }

    public void incrementCounter() {
        this.earthquakeCounter++;
        notifyObservers();
    }
}
