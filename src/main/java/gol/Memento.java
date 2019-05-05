package gol;

public class Memento {
    private String state;

    //bei erzeugung eines neuen Memento Datenobjekts wird ein String (der zu spechernde state) definiert
    public Memento(String state){
        this.state = state;
    }
    //state (String) wird zurückgegeben
    public String getState(){
        return state;
    }
}
