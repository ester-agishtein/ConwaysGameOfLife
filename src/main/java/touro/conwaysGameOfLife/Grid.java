package touro.ConwaysGameOfLife;

public class Grid {

    private boolean[][] board;
    private Direction[] directions = Direction.values();

    private final int WIDTH = 20;
    private final int HEIGHT =20;



    public Grid() { this.board = new boolean[WIDTH][HEIGHT];
    }


    public void makeMove() {
        boolean[][] tempBoard = new boolean[WIDTH][HEIGHT];

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                int aliveNeighbors = countAliveNeighbors(x, y);

                if (isAlive(x,y)) {
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                       tempBoard[x][y] = false;

                    } else if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                        tempBoard[x][y] = true;
                    }
                }
                else {
                    if (aliveNeighbors == 3) {
                        tempBoard[x][y] = true;
                    }
                }
            }
        }
        board = tempBoard;
    }

    public int countAliveNeighbors(int x, int y) {
        int aliveNeighborCount = 0;
        for (Direction d : directions) {
            boolean isAlive = checkDirection(d, x, y);      //check neighbor status
            if (isAlive) {                                    //if neighbor cell is has true val, increment live neighbors
                aliveNeighborCount++;
            }
        }
        return aliveNeighborCount;
    }

    public boolean isAlive(int x, int y) {
        return board[x][y];
    }

    public void setAlive(int x, int y) {
        board[x][y] = true;
    }

    /**
     * @return value of cell is 0 - dead
     */
    public void setDead(int x, int y) {
        board[x][y] = false;

    }


    public boolean checkDirection(Direction direction, int x, int y) {
        switch (direction) {
            case North:
                if (outOfBounds(x, y + 1)) {
                    return false;
                } else {
                    return board[x][y + 1];
                }

            case East:
                if (outOfBounds(x + 1, y)) {
                    return false;
                } else {
                    return board[x + 1][y];
                }

            case South:
                if (outOfBounds(x, y - 1)) {
                    return false;
                } else {
                    return board[x][y - 1];
                }

            case West:
                if (outOfBounds(x - 1, y)) {
                    return false;
                } else {
                    return board[x - 1][y];
                }

            case NorthEast:
                if (outOfBounds(x + 1, y + 1)) {
                    return false;
                } else {
                    return board[x + 1][y + 1];
                }
            case NorthWest:
                if (outOfBounds(x - 1, y + 1)) {
                    return false;
                } else {
                    return board[x - 1][y + 1];
                }
            case SouthEast:
                if (outOfBounds(x + 1, y - 1)) {
                    return false;
                } else {
                    return board[x + 1][y - 1];
                }
            case SouthWest:
                if (outOfBounds(x - 1, y - 1)) {
                    return false;
                } else {
                    return board[x - 1][y - 1];
                }
            default:
                throw new RuntimeException("An error occurred");    //why does this prevent needing a return statement?
        }
    }


    /**
     * @param x,y
     * @return true if a cell is out of bounds
     */
    public boolean outOfBounds(int x, int y) {
        return x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT;
    }

    public void clearBoard() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setDead(x, y);
            }

        }
    }

    public boolean[][] getBoard() {
        return board;
    }

}
