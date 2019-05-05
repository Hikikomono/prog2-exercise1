package gol;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton implements Observer{
    @Override
    public void getUpdate(Subject s) {
        if(s instanceof Cell){
            if(((Cell)s).getState()){
                this.setBackground(Color.GREEN);
            }
            else{
                this.setBackground(Color.RED);
            }
        }
    }
}
