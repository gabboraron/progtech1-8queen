package pkg8_queens_problem;

/**
 *
 * @author Sándor
 */
public class chessMatrixElem {
    private int x;
    private int y;
    
    chessMatrixElem(){
        x = 1;
        y = 1;
    }
    
    chessMatrixElem(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
