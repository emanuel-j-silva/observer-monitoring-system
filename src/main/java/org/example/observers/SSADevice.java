package org.example.observers;

import org.example.subject.Dam;
import org.example.subject.Subject;

public class SSADevice implements Observer{
    private Long id;
    private final Long safetyLimit = (long) 6.0;
    private boolean earthquakeAboveTheLimit = false;
    private boolean alarmSound = false;

    public SSADevice(Long id) {
        this.id = id;
    }

    public void hasEarthquake(Subject s, long value){
        if (s.getObservers().contains(this) && value > safetyLimit) {
            earthquakeAboveTheLimit = true;
            ((Dam)s).incrementCounter();
        }
    }
    @Override
    public void update(Subject s) {
        if (((Dam) s).getEarthquakeCounter() >= 3){
            alarmSound = true;
            System.out.println("ALARM SOUND ACTIVATED ON SSA DEVICE " + id);
        }
        earthquakeAboveTheLimit = false;
    }
}
