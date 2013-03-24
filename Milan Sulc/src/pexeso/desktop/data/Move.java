package pexeso.desktop.data;

/**
 *
 * @author Felix
 */
public class Move {

    protected Coordinate move1;
    protected Coordinate move2;

    public Move(Coordinate move1, Coordinate move2) {
        this.move1 = move1;
        this.move2 = move2;
    }

    public Coordinate getMove1() {
        return move1;
    }

    public void setMove1(Coordinate move1) {
        this.move1 = move1;
    }

    public Coordinate getMove2() {
        return move2;
    }

    public void setMove2(Coordinate move2) {
        this.move2 = move2;
    }
    
    public boolean isSuccess() {
        return false;
    }

    @Override
    public String toString() {
        return "Move{" + "1# [" + move1 + "] 2# [" + move2 + ']';
    }
}
