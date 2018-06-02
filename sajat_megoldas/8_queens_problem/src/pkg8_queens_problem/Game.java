package pkg8_queens_problem;

import java.util.Vector;

/**
 *
 * @author Sándor
 */
class Game {
    private int gameSize;
    private Vector queensPositions = new Vector();

    Game() {
        gameSize = 0;
    }    

    public void setSize(int i) {
        System.out.println("GAME SIZE: " + i);
        gameSize = i;
    }    
    
    public int getGameSize() {
        return gameSize;
    }

    public Vector getQueensPositions() {
        return queensPositions;
    }
    
    /**
     * Add a new queen to a specific position
     * @param queen chessMatrixElem type
     */
    public void addANewQueen(chessMatrixElem queen ){
        queensPositions.add(queen);
    }
    
    /**
     * Get the possible positions of the queens on table.
     * @return Vector of chessMatrixElems
     */
    public Vector possibleQueenPositions(){
        Vector pqp = new Vector();
        /**
         * Fill with all possible values
         */
        for(int idxI=1; idxI<gameSize; ++idxI){
            for(int idxJ=1; idxJ<gameSize; ++idxJ){
                chessMatrixElem elem = new chessMatrixElem(idxI, idxJ);
                pqp.add(elem);
            }
        }
        
        /**
         * Delete the wrong values.
         */
        for(int idx=0; idx<queensPositions.size(); ++idx){
            //delete by x values and y values
            chessMatrixElem elem = (chessMatrixElem) queensPositions.get(idx);
            for (int idxPQP = 0; idxPQP < pqp.size(); ++idxPQP) {
                chessMatrixElem tmpElem = (chessMatrixElem) pqp.get(idxPQP);
                if(tmpElem.getX() == elem.getX())
                    pqp.remove(tmpElem);
             
                if(tmpElem.getY() == (elem.getY()))
                    pqp.remove(tmpElem);
            }
            
            //delete by diagonals
            int tmpX = elem.getX();
            int tmpY = elem.getY();
            
            int ttmpx = tmpX;
            while(ttmpx != 1){
                --ttmpx;
                --tmpY;
            }
            int ttmpy = tmpY;
            while(ttmpy != 0){
                chessMatrixElem tmpElem = new chessMatrixElem(ttmpx, ttmpy);
                pqp.remove(tmpElem);
                ++ttmpx;
                --ttmpy;
            }
            
            ttmpy = elem.getY();
            ttmpx = elem.getX();
            while(ttmpy != 1){
                --ttmpy;
                --tmpX;
            }
            while(tmpX != 9){
                chessMatrixElem tmpElem = new chessMatrixElem(tmpX, ttmpy);
                pqp.remove(tmpElem);
                ++ttmpx;
                ++ttmpy;
            }
        }
        
        /**/
        for(int idx = 0; idx<pqp.size(); ++idx){
            chessMatrixElem tmp = (chessMatrixElem) pqp.get(idx);
            System.out.println(tmp.getX() + " " + tmp.getY());
        }
        /**/    
        return pqp;
    }

    public boolean isNotPossibleNextQueenValue(int Y) {
        if(queensPositions.size() == 0)
            return true;
        chessMatrixElem lastQueen = (chessMatrixElem) queensPositions.get(queensPositions.size()-1);
        if(lastQueen.getY()+1 == Y){
            return true;
        }
        return false;
    }
}
