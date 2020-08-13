package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int mode;
    private int fieldSize;
    private int winningLength;
    private static final int PADDING = 10;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;


    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
            }
        });
    }

    private void clickBattleField(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!Logic.isFinished) {
            if(mode == SettingWindow.GAME_MODE_H_VS_A) {
                Logic.humanAiTurn(cellX, cellY);
            } else {
                Logic.humanHumanTurn(cellX, cellY);
            }
        }
        
        repaint();

        if (Logic.isFinished) {
            gameWindow.dialogWin(Logic.winner);
        }
    }


    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize;
        cellWidth = panelWidth / fieldSize;

        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawX(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellWidth * x + PADDING, cellHeight * y + PADDING, cellWidth * (x + 1) - PADDING, cellHeight * (y + 1) - PADDING);
        g.drawLine(cellWidth * x + PADDING, cellHeight * (y + 1) - PADDING, cellWidth * (x + 1) - PADDING, cellHeight * y + PADDING);

    }

    private void drawO(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        //g.drawLine(cellWidth * x, cellHeight * y, cellWidth * (x + 1), cellHeight * (y + 1));
        g.drawOval(cellWidth * x + PADDING, cellHeight * y + PADDING, cellWidth - (PADDING * 2), cellHeight - (PADDING * 2));
    }
}
