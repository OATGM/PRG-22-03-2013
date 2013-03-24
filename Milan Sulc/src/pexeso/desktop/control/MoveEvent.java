package pexeso.desktop.control;

import pexeso.desktop.data.Card;

/**
 *
 * @author Felix
 */
public class MoveEvent {

    private Card card1;
    private Card card2;

    public MoveEvent(Card card1, Card card2) {
        this.card1 = card1;
        this.card2 = card2;
    }

    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }
}
