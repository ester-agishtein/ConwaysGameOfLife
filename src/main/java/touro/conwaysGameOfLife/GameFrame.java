package touro.ConwaysGameOfLife;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Grid grid;
    private GridView gridView;
    private JPanel panel;
    private JButton clear;
    private JButton next;

    public GameFrame(GridView gridView, Grid grid) {
        this.grid = grid;
        this.gridView = gridView;

        setSize(420, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());

        clear = new JButton("Clear");
        clear.addActionListener(actionEvent -> reset());
        next = new JButton("Next >");
        next.addActionListener(actionEvent -> nextMove());

        panel = new JPanel(new FlowLayout());

        panel.add(clear);
        panel.add(next);

        add(gridView);
        add(panel, BorderLayout.SOUTH);

    }


    private void nextMove() {
        grid.makeMove();
        gridView.repaint();
    }

    private void reset() {
        grid.clearBoard();
        gridView.repaint();
    }
}