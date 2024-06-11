package org.example.observers;

import org.example.subject.Dam;
import org.example.subject.Subject;

public class ACDevice implements Observer{
    private Long id;
    private boolean alarmSound = false;

    public ACDevice(Long id) {
        this.id = id;
    }

    @Override
    public void update(Subject s) {
        if (((Dam) s).getEarthquakeCounter() >= 6){
                System.out.println("ALARM SOUND ACTIVATED ON AC DEVICE " + id);
            alarmSound = true;
        }
    }
}
