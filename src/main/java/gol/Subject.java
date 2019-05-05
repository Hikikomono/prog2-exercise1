package gol;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject { //abstract weil nie objekt davon erstellt wird
    //Liste
    private List<Observer> observers = new ArrayList<>();
    //addToList()
    public void registerObserver(Observer observer){
        observers.add(observer);
    }
    //notifyAll()
    public void notifyAllObservers(Cell c){
        for(Observer observer : observers){
            observer.getUpdate(c);
        }
    }
}
