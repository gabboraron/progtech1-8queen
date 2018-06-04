package megoldasgriddel;

/**
 *
 * @author Sándor
 */
public class coordinate {
    public int x;
    public int y;

    public coordinate(){
    }

    public coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return String.format(x + " " + y);
    }
}
