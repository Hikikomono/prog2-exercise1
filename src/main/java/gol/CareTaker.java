package gol;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    //Memento Datenobjekt zu Liste hinzufügen
    public void add(Memento state){
        mementoList.add(state);
    }
    //Memento Datenobjekt aus Liste auslesen
    public Memento get(int index){
        return mementoList.get(index);
    }
}
