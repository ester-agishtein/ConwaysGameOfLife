package touro.ConwaysGameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GridView extends JComponent {

    private Grid grid;
    private int CELL_SIZE = 20;


    public GridView(Grid grid) {
        this.grid = grid;
        this.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                  super.mouseClicked(e);
                  setCell(e);
              }

          }
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBoard(g);
    }

    private void paintBoard(Graphics g) {
        boolean board[][] = grid.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    g.setColor(Color.BLUE);
                    g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
                g.setColor(Color.BLACK);
                g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    private void setCell(MouseEvent e) {
        boolean board[][] = grid.getBoard();
        int x = e.getX();
        int y = e.getY();
        int row = x / CELL_SIZE;
        int col = y / CELL_SIZE;
        board[row][col] = !board[row][col];
        repaint();
    }
}







