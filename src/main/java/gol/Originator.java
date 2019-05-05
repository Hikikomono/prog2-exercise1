package gol;

public class Originator {
    String state;

    //tmp state setzen
    public void setState(String state){
        this.state = state;
    }
    //tmp state in Memento Datenobjekt speichern
    public Memento saveStateToMemento(String state){
        return new Memento(state);
    }
    //Memento Datenobjekt state auslesen und in tmp state speichern
    public void getStateFromMemento(Memento state){
        this.state = state.getState();
    }
}
