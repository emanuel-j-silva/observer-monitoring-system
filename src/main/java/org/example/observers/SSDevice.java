package org.example.observers;

import org.example.subject.Dam;
import org.example.subject.Subject;

public class SSDevice implements Observer{
    private Long id;
    private boolean earthquakeNotify = false;
    private boolean redAlert = false;

    public SSDevice(Long id) {
        this.id = id;
    }

    public void hasEarthquake(Subject s){
        if (!s.getObservers().contains(this)) return;
        earthquakeNotify = true;
        ((Dam) s).incrementCounter();

    }
    @Override
    public void update(Subject s) {
        if (((Dam) s).getEarthquakeCounter() >= 2){
            redAlert = true;
            System.out.println("RED ALERT ACTIVATED ON SS DEVICE " + id);
        }
        earthquakeNotify = false;
    }

    public Long getId() {
        return id;
    }

    public boolean isRedAlert() {
        return redAlert;
    }
}
