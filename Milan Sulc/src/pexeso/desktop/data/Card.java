package pexeso.desktop.data;

import java.awt.Cursor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Felix
 */
public class Card extends JLabel implements Comparable<Card>, Cloneable {

    private Icon image;
    private Icon defaultImage;
    private CardState state;

    public Card(Icon image, Icon defaultImage) {
        super(defaultImage);
        state = CardState.HIDE;

        this.image = image;
        this.defaultImage = defaultImage;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Icon getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(Icon defaultImage) {
        this.defaultImage = defaultImage;
    }

    public CardState getState() {
        return state;
    }

    public void setState(CardState state) {
        this.state = state;
    }

    public void release() {
        switch (state) {
            case HIDE:
                setIcon(getImage());
                setState(CardState.SHOW);
                break;
            case SHOW:
                setIcon(getDefaultImage());
                setState(CardState.HIDE);
                break;
            case HOLD:
                break;
        }
    }

    public Card clone() {
        return new Card(getImage(), getDefaultImage());
    }

    @Override
    public int compareTo(Card o) {
        if (getImage().equals(o.getImage())) {
            return 1;
        }
        return -1;
    }

    public boolean isSame(Card c) {
        return compareTo(c) == 1;
    }
}
