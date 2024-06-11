package org.example.subject;

import org.example.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void notifyObservers(){
        for (Observer observer:observers){
            observer.update(this);
        }
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void unregisterObserver(Observer o){
        observers.remove(o);
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
