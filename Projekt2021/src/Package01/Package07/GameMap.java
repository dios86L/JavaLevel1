package Package01.Package07;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    public static final int GM_PVE = 0;
    public static final int GM_PVP = 0;

    GameMap (){
        setBackground(Color.CYAN);
    }

    void start(int gameMod,int fieldSizeX, int fieldSizeY, int winLength){
        System.out.println("fieldSizeX > " + fieldSizeX +
                "fieldSizeY > " + fieldSizeY +
                "winLength > " + winLength +
                "gameMod > " + gameMod);
    }
}
