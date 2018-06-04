package megoldasgriddel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
        if(queens.isDone()){
            JOptionPane.showMessageDialog(null, "YOU WIN!");
        } else{
            showAvailableTiles();
            if(queens.lose()){
                JOptionPane.showMessageDialog(null, "YOU LOSE!");
            }
        }
        showQueens();
    }

    /**
     * Show queens on the grid
     */
    private void showQueens() {
        for(int idx=0; idx< queens.getQueens().size(); ++idx){
            coordinate tmpCoord = (coordinate) queens.getQueens().get(idx);
            gpanel.getGridButton(tmpCoord.x, tmpCoord.y).setText("Q");
        }
    }
    
    /**
     * The BACK button
     */
    public JButton back(){
        JButton btn = new JButton("BACK");
        btn.setFont(new Font("Arial", Font.PLAIN, 30));

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                queens.removeLastQueen();
                colorAsChessTable(gpanel);
                showQueens();
            }
        });
        
        return btn;
    }
    
    /**
     * The RESET button
     */
    public JButton reset(){
        JButton btn = new JButton("RESET");
        btn.setFont(new Font("Arial", Font.PLAIN, 30));

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                queens.reset();
                colorAsChessTable(gpanel);
            }
        });
        
        return btn;
    }
    
    /**
     * Timer label.
     * @return 
     */
    public JLabel timerLabel(){
        //timer time = new timer(this);
        JLabel lbl = new JLabel("Time: ");
        lbl.setFont(new Font("Arial", Font.PLAIN, 30));
        
        return lbl;
    }
}