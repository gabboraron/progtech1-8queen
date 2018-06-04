package megoldasgriddel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Sándor
 */
public class timer {
    gui gui;

    public timer(gui gui) {
        this.gui = gui;
    }
    
    
    private Timer timer;
    public int time;
    
    
    private void startTimer() {
        time = 60;
        ActionListener countDown = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*if (!paused) {
                    time--;
                }
                if (time == 0) {
                    main.showGameOverMessage("Lejárt az idő!");
                }
                main.setTime(time);*/
                //gui.showTime(time);
            }
        };
        timer = new Timer(1000, countDown);
        timer.start();
    }
}
