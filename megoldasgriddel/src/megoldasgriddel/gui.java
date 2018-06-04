package megoldasgriddel;

import java.awt.Color;
import java.util.Vector;

/**
 *
 * @author Sándor
 */
public class gui {
    queens queens;
    GridButtonPanel gpanel;
    
    public gui() {
        queens = new queens();
        gpanel = new GridButtonPanel(queens, this);
        gpanel.display();
        colorAsChessTable(gpanel);
    }

    /**
     * color the grid to look like a chess table.
     * @param gpanel 
     */
    private void colorAsChessTable(GridButtonPanel gpanel) {
        boolean black = false;
        for(int idxI = 0; idxI<gpanel.N; ++idxI ){
            for(int idxJ = 0; idxJ<gpanel.N; ++idxJ ){
                if(black){
                    gpanel.getGridButton(idxI, idxJ).setBackground(Color.black);
                    black = false;
                } else {
                    gpanel.getGridButton(idxI, idxJ).setBackground(Color.white);
                    black = true;
                }
                gpanel.getGridButton(idxI, idxJ).setText("");
            }
            if (black) {
                black = false;
            } else {
                black = true;
            }
        }
    }
    
    /**
     * recolor to gray all the available buttons.
     */
    public void showAvailableTiles(){
        for(int idx=0; idx<queens.availableTiles().size(); ++idx){
            coordinate tmpCoord = (coordinate) queens.availableTiles().get(idx);
            gpanel.getGridButton(tmpCoord.x, tmpCoord.y).setBackground(Color.gray);
        }
        System.out.println("*******************************************************");
    }
    
    /** 
     * recolor the table at a click, and save the queen.
     */
    public void recolorChessTableAndSaveTheQueen(int x, int y){
        coordinate coord = new coordinate(x,y);
        queens.addAQueen(coord);
        colorAsChessTable(gpanel);
        showAvailableTiles();
    }
    
}