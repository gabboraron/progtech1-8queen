package megoldasgriddel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author Sándor
 */
public class queens {

    private Vector queens;

    public queens() {
        queens = new Vector();
    }
    
    /**
     * Add a new queen to vector of queens.
     * @param coord 
     */
    public void addAQueen(coordinate coord){
        queens.add(coord);
    }
    
    /**
     * Get queens Vector
     * @return 
     */
    public Vector getQueens() {
        return queens;
    }
    
    /**
     * Remove the last queen from the table
     */
    public void removeLastQueen(){
        if(queens.size() != 0){
            queens.remove(queens.size()-1);
        } else {
            System.out.println("No more Queen on the table!");
        }
    }
    
    /**
     * Get the available tiles coordinates in a vector.
     * @return vector of coordinates
     * @see coordinate
     */
    /*public Vector availableTiles(){
        System.out.println("CURRENT QUEENS: " + queens);
        Vector at = new Vector();
        //set vectorwith all of elements.
        for (int i = 0; i < GridButtonPanel.N * GridButtonPanel.N; i++) {
            int row = i / GridButtonPanel.N;
            int col = i % GridButtonPanel.N;
            coordinate coord = new coordinate(row, col);
            at.add(coord);
        }
                
        //delete the wrong values from the vector
        for(int idx=0; idx<queens.size(); ++idx){
            at.remove(queens.get(idx));
            //delete row
            for (int idxR=0; idxR<GridButtonPanel.N; ++idxR){
                coordinate tmpCoord = new coordinate (((coordinate) queens.get(idx)).x, idxR);
                //tmpCoord.y = idxR;
                at.remove(tmpCoord);
                System.out.println("REMOVED: " + tmpCoord);
            }
            
            //delete column
            for (int idxC=0; idxC<GridButtonPanel.N; ++idxC){
                coordinate tmpCoord = new coordinate (idxC, ((coordinate) queens.get(idx)).y);
                //tmpCoord.x = idxC;
                at.remove(tmpCoord);
            }
            
            //delete diagonal1
            coordinate tmpCoordOfCurrentQ = (coordinate) queens.get(idx);
            int idxX = tmpCoordOfCurrentQ.x+1;
            int idxY = tmpCoordOfCurrentQ.y+1;
            while(idxX != GridButtonPanel.N+1 ){
                coordinate tmpCoord = new coordinate(idxX,idxY);
                at.remove(tmpCoord);
                ++idxX;
                ++idxY;
            }
            
            //delete diagonal2
            idxX = tmpCoordOfCurrentQ.x;
            idxY = tmpCoordOfCurrentQ.y;
            while(idxX != -1 ){
                coordinate tmpCoord = new coordinate(idxX,idxY);
                at.remove(tmpCoord);
                --idxX;
                ++idxY;
            }*/
    public Vector availableTiles(){
        System.out.println("CURRENT QUEENS: " + queens);
        ArrayList  nat = new ArrayList ();  //not available tiles
        ArrayList  at = new ArrayList ();   //available tiles
                
        //put the wrong values to the vector nat
        for(int idx=0; idx<queens.size(); ++idx){
            nat.add(queens.get(idx));
            System.out.println("REMOVED \t the clciked value " + queens.get(idx));
            //delete row
            for (int idxR=0; idxR<GridButtonPanel.N; ++idxR){
                coordinate tmpCoord = new coordinate (((coordinate) queens.get(idx)).x, idxR);
                //tmpCoord.y = idxR;
                nat.add(tmpCoord);
                System.out.println("REMOVED: \t the row " + tmpCoord);
            }
            
            //delete column
            for (int idxC=0; idxC<GridButtonPanel.N; ++idxC){
                coordinate tmpCoord = new coordinate (idxC, ((coordinate) queens.get(idx)).y);
                //tmpCoord.x = idxC;
                nat.add(tmpCoord);
                System.out.println("REMOVED \t the column " + tmpCoord);
            }
            
            //delete diagonal1
            coordinate tmpCoordOfCurrentQ = (coordinate) queens.get(idx);
            int idxX = tmpCoordOfCurrentQ.x+1;
            int idxY = tmpCoordOfCurrentQ.y+1;
            while(idxX != GridButtonPanel.N ){
                coordinate tmpCoord = new coordinate(idxX,idxY);
                nat.add(tmpCoord);
                ++idxX;
                ++idxY;
                System.out.println("REMOVED \t the diagonal1 " + tmpCoord);
            }
            
            //delete diagonal2
            idxX = tmpCoordOfCurrentQ.x;
            idxY = tmpCoordOfCurrentQ.y;
            while(idxX != -1 ){
                coordinate tmpCoord = new coordinate(idxX,idxY);
                nat.add(tmpCoord);
                --idxX;
                ++idxY;
                System.out.println("REMOVED \t the diagonal2 " + tmpCoord);
            }
        }
        
        //set vector with all of available elements.
        for (int i = 0; i < GridButtonPanel.N * GridButtonPanel.N; i++) {
            int row = i / GridButtonPanel.N;
            int col = i % GridButtonPanel.N;
            coordinate coord = new coordinate(row, col);
            if(!nat.contains(coord)){
                at.add(coord);
            } else {
                System.out.println("not CONTAINS: " + coord);
            }
        }
        
        System.out.println("CURRENT QUEENS: " + queens);
        System.out.println("AVAILABLE TILES: " + at);
        System.out.println("NOT AVAILABLE TILES: " + nat);
        
        //return a vector
        Vector vat = new Vector();
        for (Iterator it = at.iterator(); it.hasNext();) {
            vat.add(it.next());
        }
        return vat;
    }
    
    /**
     * Get if the position is available as a next position of a queen!
     * 
     * @param x the x coordinate of the button
     * @param y the y coordinate of the button
     * @return true if is available, false if not.
     */
    public boolean isThisPositionAvailable(int x, int y){
        coordinate currentBtn = new coordinate(x,y);
        if ((queens.size() == 0) && (y == 0)){       //fst column, fst queen
            return true;
        } else if((queens.size() == 0) && (y != 0)) {
            return false;
        }
        
        coordinate tmpCoord = (coordinate) queens.get(queens.size() - 1);
        int lastQY = tmpCoord.y;
        if ((lastQY + 1 == y) && (availableTiles().contains(currentBtn))) //next column, next queen
            return true;
        

        return false;
    }
    
}
