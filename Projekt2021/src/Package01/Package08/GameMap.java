package Package01.Package08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {
    public static final int GM_PVE = 0;
    public static final int GM_PVP = 0;

    private int gameMod;
    private  int fieldSizeX;
    private  int fieldSizeY;
    private int winLength;

    private int[][] map;

    private int cellWidth;
    private int cellHeight;

    private  final  int EMPTY_DOT = 0;
    private  final  int HUMAN_DOT = 1;
    private  final  int AI_DOT = 2;

    private final Random RANDOM = new Random();

    private final int STATE_DRAW = 0;
    private final int STATE_HUMAN_WIN = 1;
    private final int STATE_AI_WIN = 2;

    private final String MSG_WIN_HUMAN = "HUMAN_WIN";
    private final String MSG_WIN_AI = "AI_WIN";
    private final String MSG_DRAW = "DRAW";

    private int stateGameOver;

    private boolean isGameOver;

    private boolean initMap;

    GameMap (){
        setBackground(Color.CYAN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        initMap = false;
    }

    void start(int gameMod,int fieldSizeX, int fieldSizeY, int winLength){
        this.gameMod = gameMod;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        map = new int[fieldSizeX][fieldSizeY];
        System.out.println("fieldSizeX > " + fieldSizeX +
                "fieldSizeY > " + fieldSizeY +
                "winLength > " + winLength +
                "gameMod > " + gameMod);
        isGameOver = false;
        initMap = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private  void update (MouseEvent e){
        if (initMap){
            return;
        }
        if (isGameOver){
            return;
        }
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;

        if (!isValidCell(cellX,cellY)|| !isEmptyCell(cellX,cellY)){
            return;
        }
        map[cellY][cellX] = HUMAN_DOT;
        if (checkWin(HUMAN_DOT)){
            System.out.println("Human win!");
            setGameOver (STATE_HUMAN_WIN);
            return;
        }

        if (isFullMap()){
            System.out.println("Draw!");
            setGameOver (STATE_DRAW);
            return;
        }
        aiTurn();
        repaint();

        if (checkWin(AI_DOT)){
            System.out.println("AI win!");
            setGameOver (STATE_AI_WIN);
            return;
        }
        if (isFullMap()){
            System.out.println("Draw!");
            setGameOver (STATE_DRAW);
            return;
        }
    }

    private void setGameOver (int gameOverState){

        stateGameOver = gameOverState;
        isGameOver = true;
        repaint();
    }

    private void render (Graphics g) {
        if (!initMap){
            return;
        }
        int width =getWidth();
        int height = getHeight();
        cellWidth = width/fieldSizeX;
        cellHeight = height/fieldSizeY;
        paintMap(g, width, height);

        for (int y = 0;y<fieldSizeY;y++){
            for (int x = 0;x<fieldSizeX;x++){
                if (isEmptyCell(x,y)){
                    continue;
                }
                if (map[y][x] == HUMAN_DOT){
                    g.setColor(Color.GREEN);
                    g.fillOval(x*cellWidth,y*cellHeight,cellWidth,cellHeight);
                } else if (map[y][x] == AI_DOT){
                    g.setColor(Color.RED);
                    g.fillOval(x*cellWidth,y*cellHeight,cellWidth,cellHeight);
                } else {
                    throw new RuntimeException("Invalid paint in x: " + x + " y: " + y);
                }
            }
        }
        if (isGameOver){
            showMessegeGameOver (g);
        }
    }

    private void showMessegeGameOver (Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,200,getWidth(), 70);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 50));
        switch (stateGameOver){
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 200, getHeight()/2);
                break;
            case STATE_HUMAN_WIN:
                g.drawString(MSG_WIN_HUMAN, 200, getHeight()/2);
                break;
            case STATE_AI_WIN:
                g.drawString(MSG_WIN_AI, 200, getHeight()/2);
                break;
            default:
                throw new RuntimeException("Invalid paint text" + stateGameOver);
        }
        System.out.println("Somebody win!");
    }

    private void paintMap( Graphics g, int width, int height) {
        g.setColor(Color.BLUE);
        for (int i = 0; i < fieldSizeY; i++){
            int y = i*cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i< fieldSizeX; i++){
            int x = i*cellWidth;
            g.drawLine(x, 0, x, height);
        }
    }

    public void  aiTurn () {
        if (turnAIWinCell()){
            return;
        }
        if (turnHumanWinCell()){
            return;
        }
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        map[y][x] = AI_DOT;
    }

    private  boolean turnAIWinCell(){
        for (int j = 0; j<fieldSizeY; j++){
            for (int i = 0; i<fieldSizeX; i++){
                if (isEmptyCell(j, i)){
                    map[i][j] = AI_DOT;
                    if(checkWin(AI_DOT)){
                        return true;
                    }
                    map[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }

    private  boolean turnHumanWinCell(){
        for (int i = 0; i<fieldSizeY; i++){
            for (int j = 0;j<fieldSizeX;j++){
                if (isEmptyCell(j,i)){
                    map[i][j] = HUMAN_DOT;
                    if (checkWin(HUMAN_DOT)){
                        map[i][j] = AI_DOT;
                        return true;
                    }
                    map[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }

    private boolean checkWin (int character){
        for (int i = 0;i<fieldSizeX;i++){
            for (int j = 0;j<fieldSizeY;j++){
                if (checkLine(i,j,1,0,winLength, character)){
                    return true;
                }
                if (checkLine(i,j,1,1,winLength, character)){
                    return true;
                }
                if (checkLine(i,j,0,1,winLength, character)){
                    return true;
                }
                if (checkLine(i,j,1,-1,winLength, character)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, int character){
        final int farX = x+(len-1)*vx;
        final int farY = y+(len-1)*vy;
        if (!isValidCell(farX,farY)){
            return false;
        }
        for (int i = 0;i<len;i++){
            if (map[y+i*vy][x+i*vx] !=character){
                return false;
            }
        }
        return true;
    }

    public boolean isFullMap(){
        for (int i = 0;i<fieldSizeY;i++){
            for (int j = 0;j<fieldSizeX;j++){
                if (map[i][j] == EMPTY_DOT){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidCell(int x, int y){
        return x >= 0 && x<fieldSizeX && y >= 0 && y<fieldSizeY;
    }

    public boolean isEmptyCell(int x,int y){
        return map[y][x] == EMPTY_DOT;
    }


}
