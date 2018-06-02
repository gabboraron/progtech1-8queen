package pkg8_queens_problem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * MAIN GUI
 * @author Sándor
 */
public class Gui extends JFrame {
    
    JLabel timer = new JLabel();
    JLabel info = new JLabel();
    JPanel gamePanel = new JPanel();
    JPanel gameStartOptionsPane = new JPanel();
    
    Game game = new Game();
    
    /**
     * Init the Gui, with title, size, close confirmation window.
     * Call the game starter too.
     */
    public Gui() {
        /**
         * Init the main things on ui.
         */
        setTitle("QUEENS PROBLEM");
        setSize(400, 450);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });
        
        /**
         * Init the game specific things on ui.
         */
        gameStartOptionsPane = initGameOptionsPane();
        getContentPane().add(gameStartOptionsPane, BorderLayout.CENTER);   //game starter buttons
    }
    
    /**
     *   Exit confirmation window
     */
    private void onClose() {
        int n = JOptionPane.showConfirmDialog(this, "Valóban ki akar lépni?",
                "Megerősítés", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }
    
    /**
     * Create main options at the start.
     * @return a JPanel, with buttons what has event listeners.
     */
    private JPanel initGameOptionsPane(){
        JPanel panel = new JPanel();
        JButton button8 = new JButton("8X8");
        button8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //(JButton) e.getSource().setText("lol");
                    //this.setText("LOL");
                    JButton tmp = (JButton) e.getSource();
                    tmp.setText("Loading...");
                    //System.out.println("gomb: " + tmp.getText());
                    game.setSize(8);
                    initChessPanel(8);
                }
            });
        panel.add(button8);
        
        /**/
        /*JButton buttonG = new JButton("get");
        buttonG.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //(JButton) e.getSource().setText("lol");
                    //this.setText("LOL");
                    JButton tmp = (JButton) e.getSource();
                    //tmp.setText("Loading...");
                    //System.out.println("gomb: " + tmp.getText());
                    game.possibleQueenPositions();
                }
            });
        panel.add(buttonG);*/
        /**/
        return panel;
    }
    
    /**
     * Create the chess panel, with tiles.
     * @param size 
     */
    private void initChessPanel(int size){
        gamePanel.setLayout(new GridLayout(size,size));
        gamePanel.setMinimumSize(new Dimension (size*100, size*100)); //.setMinimumSize (size*100, size*100);
        int color = 0; //white
        chessMatrixElem value;
        for(int idxX=1; idxX<size+1; ++idxX){
            for(int idxY=1; idxY<size+1; ++idxY){
                value = new chessMatrixElem (idxX,idxY);
                addChessTile(gamePanel, color, value);
                if(color == 1){
                    color = 0;
                } else {
                    color = 1;
                }
            }
            if (color == 1) {
                color = 0;
            } else {
                color = 1;
            }
        }
        
        getContentPane().remove(gameStartOptionsPane);
        getContentPane().revalidate();
        getContentPane().add(gamePanel, BorderLayout.CENTER);
    } 
    
    /**
     * Add a tile to table
     * @param gamePanel
     * @param color
     * @param value 
     */
    private void addChessTile(JPanel gamePanel, int color, chessMatrixElem value) {
        JButton button = new JButton();
        if(color == 0){
            button.setBackground(Color.white);
        } else {
            button.setBackground(Color.black);
        }
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(game.isNotPossibleNextQueenValue(value.getY())){
                    System.out.println("CLICKED: " + value.getX() + " " + value.getY());
                    game.addANewQueen(value);
                    button.setText("♕");
                    //showPossibleTiles(game.possibleQueenPositions());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Wrong place, you can only choose from the next column!",
                            "WRONG COLUMN",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        gamePanel.add(button);
        System.out.println(value.getX() + " " + value.getY() + " ADDED");
    }
    
    /**
     * Recolor the possible values.
     * @param possibleQueenPositions 
     */
    private void showPossibleTiles(Vector possibleQueenPositions) {
        for(int idxX = 1; idxX<)
    }
}
