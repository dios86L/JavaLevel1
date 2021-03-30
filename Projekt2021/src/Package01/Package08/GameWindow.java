package Package01.Package08;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame{
    private final int WIN_WIDTH = 600;
    private final int WIN_HEIGHT = 500;

    private final int WIN_POS_X = 300;
    private final int WIN_POS_Y = 100;

    private JButton btnStartGame;
    private JButton btnExitGame;

    private JPanel panelForButton;

    private Settings settings;

    private GameMap gameMap;

    GameWindow(){
        setupWindow();
        prepareButton();
        settings = new Settings(this);
        gameMap = new GameMap();

        add(panelForButton, BorderLayout.SOUTH);
        add(gameMap);
        setVisible(true);

    }

    public void setupWindow () {
        setLocation(WIN_POS_X, WIN_POS_Y);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My game");
        setResizable(false);
    }

    private void prepareButton (){
        btnStartGame = new JButton("Start");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });


        btnExitGame = new JButton("Exit");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelForButton = new JPanel();
        panelForButton.add(btnStartGame);
        panelForButton.add(btnExitGame);
        panelForButton.setLayout(new GridLayout(1, 2));
    }

    void startGameWithUserSet(int gameMod, int fieldSizeX, int fieldSizeY, int winLength){
        gameMap.start(gameMod, fieldSizeX, fieldSizeY, winLength);
    }
}
