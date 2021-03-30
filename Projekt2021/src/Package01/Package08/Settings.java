package Package01.Package08;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame{
    private GameWindow gameWindow;

    private final int SET_WIDTH = 300;
    private final int SET_HEIGHT = 250;

    private int setPosX;
    private int setPosY;

    private JRadioButton pve;
    private JRadioButton pvp;

    private JSlider sliderMapSize;
    private JSlider sliderWinLen;

    private final String MAP_SIZE_PREFIX = "Map size is ";
    private int MIN_MAP_SIZE = 3;
    private int MAX_MAP_SIZE = 10;
    private int MIN_WIN_LEN = 3;
    private final String WIN_LEN_PREFIX = "Minimal win length is ";

    private JButton saveSettings;

    Settings(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setupWindow(gameWindow);

        addGameModeControl ();
        addFieldsControl ();
        addButtonSaveSettings ();

    }

    private void setupWindow (GameWindow gameWindow){

        Rectangle gameWindowBonds = gameWindow.getBounds();
        setPosX = (int)(gameWindowBonds.getCenterX() - SET_WIDTH/2);
        setPosY = (int)(gameWindowBonds.getCenterY() - SET_HEIGHT/2);

        setLocation(setPosX, setPosY);
        setSize(SET_WIDTH, SET_HEIGHT);

        setTitle("Settings");
        setResizable(false);

        setLayout(new GridLayout(10, 1));
    }

    private void addGameModeControl (){
        add(new JLabel("Choose game mode"));
        pve = new JRadioButton("PVE", true);
        pvp = new JRadioButton("PVP");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(pve);
        buttonGroup.add(pvp);

        add(pve);
        add(pvp);
    }

    private void addFieldsControl (){
        JLabel lbMapSize = new JLabel(MAP_SIZE_PREFIX + MIN_MAP_SIZE);
        JLabel lbWinLen = new JLabel(WIN_LEN_PREFIX + MIN_WIN_LEN);

        sliderMapSize = new JSlider(MIN_MAP_SIZE, MAX_MAP_SIZE, MIN_MAP_SIZE);
        sliderWinLen = new JSlider(MIN_WIN_LEN, MAX_MAP_SIZE, MIN_WIN_LEN);

        add(new Label("Choose map size"));
        add(lbMapSize);
        add(sliderMapSize);
        sliderMapSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderMapSize.getValue();
                lbMapSize.setText(MAP_SIZE_PREFIX + currentValue);
                lbWinLen.setText(WIN_LEN_PREFIX + sliderWinLen.getValue());
                sliderWinLen.setMaximum(currentValue);
            }
        });


        add(new Label("Choose win length"));
        add(lbWinLen);
        add(sliderWinLen);
        sliderWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLen.setText(WIN_LEN_PREFIX + sliderWinLen.getValue());
            }
        });

    }

    private void addButtonSaveSettings (){
        saveSettings = new JButton("Save and start game");
        add(saveSettings);
        saveSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectAllSettings();
            }
        });
    }

    private void collectAllSettings() {
        int gameMod;
        int mapSize;
        int winLen;

        if (pve.isSelected()) {
            gameMod = Package01.Package07.GameMap.GM_PVE;
        } else if (pvp.isSelected()) {
            gameMod = GameMap.GM_PVP;
        } else {
            throw new RuntimeException("Something wrong > incorrect Game Mode");
        }

        mapSize = sliderMapSize.getValue();

        winLen = sliderWinLen.getValue();

        gameWindow.startGameWithUserSet(gameMod, mapSize, mapSize, winLen);

        setVisible(false);
    }
}
