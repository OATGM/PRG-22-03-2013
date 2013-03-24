package pexeso.desktop.data;

/**
 *
 * @author Felix
 */
public class SuccessMove extends Move {

    public SuccessMove(Coordinate move1, Coordinate move2) {
        super(move1, move2);
    }

    public boolean isSuccess() {
        return true;
    }

    @Override
    public String toString() {
        return "Move{" + "1# [" + move1 + "] 2# [" + move2 + "] +";
    }
}
