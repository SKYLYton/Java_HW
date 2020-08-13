package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    static final int WINDOW_POS_X = 500;
    static final int WINDOW_POS_Y = 300;
    static final int WINDOW_HEIGHT = 555;
    static final int WINDOW_WIDTH = 505;

    private SettingWindow settingWindow;
    private BattleField battleField;

    public GameWindow() {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");

        settingWindow = new SettingWindow(this);
        battleField = new BattleField(this);

        add(battleField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonOk = new JButton("Start new game");
        panel.add(buttonOk);
        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        buttonOk.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSize, int winningLength){
        battleField.startNewGame(mode, fieldSize, winningLength);
    }

    public void dialogWin(String winner){
        int result = JOptionPane.showConfirmDialog(this,
                winner + " Start a new game?", "Game over",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (result == JOptionPane.YES_OPTION){
            settingWindow.setVisible(true);
        } else if (result == JOptionPane.NO_OPTION) {
            System.exit(0);
        }


    }
}
