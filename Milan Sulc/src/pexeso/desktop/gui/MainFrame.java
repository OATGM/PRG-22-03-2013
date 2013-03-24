package pexeso.desktop.gui;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pexeso.desktop.control.Controller;
import pexeso.desktop.control.MoveEvent;
import pexeso.desktop.data.Card;
import pexeso.desktop.data.CardState;
import static pexeso.desktop.data.CardState.HIDE;
import static pexeso.desktop.data.CardState.HOLD;
import static pexeso.desktop.data.CardState.SHOW;
import pexeso.desktop.data.Coordinate;
import pexeso.desktop.data.Move;
import pexeso.desktop.data.SuccessMove;
import pexeso.desktop.data.Timer;

/**
 *
 * @author Felix
 */
public class MainFrame extends javax.swing.JFrame {

    private int cols;
    private int rows;
    private Card turn1;
    private Card turn2;
    private Controller controller;
    private ArrayList<Card> cards;
    private ArrayList<Move> moves;
    private ArrayList<MoveEvent> moveEvents;
    private Timer stopwatch;
    private int time;
    
    MainFrame(int cols, int rows) {
        // Default values
        this.cols = cols;
        this.rows = rows;
        this.cards = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.moveEvents = new ArrayList<>();
        this.time = 0;

        // Init GUI components
        initComponents();

        // Start game
        start(cols, rows);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        board = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logging = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        totalMovesLabel = new javax.swing.JLabel();
        totalMovesField = new javax.swing.JLabel();
        successMovesLabel = new javax.swing.JLabel();
        successMovesField = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        timerField = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileMenuNewGame = new javax.swing.JMenuItem();
        fileMenuExit = new javax.swing.JMenuItem();

        jLabel14.setText("jLabel14");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pexeso");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pexeso/resources/favicon.png")));

        board.setLayout(new java.awt.GridLayout(rows, cols));

        logging.setEditable(false);
        logging.setColumns(20);
        logging.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        logging.setRows(5);
        jScrollPane1.setViewportView(logging);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        totalMovesLabel.setText("Total moves:");

        totalMovesField.setText("0");

        successMovesLabel.setText("Success moves:");

        successMovesField.setText("0");

        timerLabel.setText("Timer:");

        timerField.setText("0s");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalMovesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalMovesField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(successMovesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(successMovesField)
                .addGap(41, 41, 41)
                .addComponent(timerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timerField)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalMovesLabel)
                    .addComponent(totalMovesField)
                    .addComponent(successMovesLabel)
                    .addComponent(successMovesField)
                    .addComponent(timerLabel)
                    .addComponent(timerField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileMenu.setText("File");

        fileMenuNewGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        fileMenuNewGame.setText("New game");
        fileMenuNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuNewGameActionPerformed(evt);
            }
        });
        fileMenu.add(fileMenuNewGame);

        fileMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        fileMenuExit.setText("Exit");
        fileMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuExitActionPerformed(evt);
            }
        });
        fileMenu.add(fileMenuExit);

        menu.add(fileMenu);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(561, 319));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fileMenuNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuNewGameActionPerformed
        start(cols, rows);
    }//GEN-LAST:event_fileMenuNewGameActionPerformed

    private void fileMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fileMenuExitActionPerformed

    /**
     * Starts game with cols/rows
     *
     * @param cols
     * @param rows
     */
    public void start(int cols, int rows) {

        // Clean all cards/components
        board.removeAll();

        // Clean stats before game
        logging.setText(null);
        moves.clear();
        moveEvents.clear();

        // Make new deskboard
        this.cols = cols;
        this.rows = rows;

        // Add cards
        int count = (cols * rows) / 2;
        ArrayList<Card> cards = createCards(count);

        if (cards == null) {
            showErrorMessageDialog("No cards. You can't play.");
        }

        for (Card c : cards) {
            board.add(c);
        }

        // Create timer
        if (stopwatch != null) {
            // Stop and reset (in case of new game)
            stopwatch.cancel();
            time = 0;
        }
        stopwatch = Timer.createRepeatTask(new Runnable() {
            @Override
            public void run() {
                timerField.setText(String.valueOf(time) + "s");
                time++;
            }
        }, 1, 1);

        // Refresh deskboard
        board.repaint();
        pack();
    }

    /**
     * Create cards
     *
     * @param count int
     * @return ArrayList<Card>
     */
    private ArrayList<Card> createCards(int count) {
        cards = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            // Image filename
            String filename = String.valueOf(i);

            if (i < 10) {
                filename = "0" + String.valueOf(i);
            }

            // Create card
            Card c = new Card(new ImageIcon(getClass().getResource("/pexeso/resources/cards/" + filename + ".png")),
                    new ImageIcon(getClass().getResource("/pexeso/resources/cards/00.png")));

            // Make a copy
            Card copy = c.clone();

            // Create mouse listener
            java.awt.event.MouseAdapter listener = new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Card c = ((Card) evt.getSource());

                    switch (c.getState()) {
                        case HIDE:
                            System.out.println("Generate: cardHideMouseClicked");
                            cardHideMouseClicked(c, evt);
                            break;
                        case SHOW:
                            System.out.println("Generate: cardShowMouseClicked");
                            cardShowMouseClicked(c, evt);
                            break;
                        case HOLD:
                            System.out.println("Generate: cardHoldMouseClicked");
                            cardHoldMouseClicked(c, evt);
                            break;
                    }

                    // Update game stats
                    updateGameState();

                    // Mission complete..
                    if (isComplete()) {
                        stopwatch.cancel();
                        disableCards();
                        showCompleteMessage();
                    }
                }
            };

            // Attach listeners
            c.addMouseListener(listener);
            copy.addMouseListener(listener);

            // Add to list
            cards.add(c);
            cards.add(copy);
        }

        // Shuffle cards
        Collections.shuffle(cards);

        return cards;
    }

    /**
     * ************************** CARD METHODS **************************
     */
    /**
     * Handle click to hidden card
     *
     * @param c
     * @param evt
     * @return void
     */
    private void cardHideMouseClicked(Card c, MouseEvent evt) {
        c.release();

        // Hide on next move..
        if (turn1 != null && turn2 != null) {
            turn1.release();
            turn1 = null;
            turn2.release();
            turn2 = null;
        }

        // Evidence moves..
        if (turn1 == null) {
            turn1 = c;
        } else if (turn2 == null) {
            turn2 = c;
            addMoveEvent(new MoveEvent(turn1, turn2));
        }

        // Is card same? or not same..
        if (turn1 != null && turn2 != null) {

            // Detect coordinates
            board.getComponents();
            Coordinate coords1 = new Coordinate(((cards.indexOf(turn1) + 1) / rows) + 1, ((cards.indexOf(turn1)) / cols) + 1);
            Coordinate coords2 = new Coordinate(((cards.indexOf(turn2) + 1) / rows), ((cards.indexOf(turn2)) / cols) + 1);

            // If is it same, change state to HOLD, otherwise hide card on next move..
            if (turn1.isSame(turn2)) {
                turn1.setState(CardState.HOLD);
                turn2.setState(CardState.HOLD);
                addMove(new SuccessMove(coords1, coords2));
            } else {
                addMove(new Move(coords1, coords2));
            }
        }
    }

    /**
     * Handle click to holded card
     *
     * @param c
     * @param evt
     * @return void
     */
    private void cardHoldMouseClicked(Card c, MouseEvent evt) {
        showInfoMessageDialog("This card is already taken.");
    }

    /**
     * Handle click to showed card
     *
     * @param c
     * @param evt
     * @return void
     */
    private void cardShowMouseClicked(Card c, MouseEvent evt) {
        showInfoMessageDialog("This card is choosen.");
    }

    /**
     * Disable all cards
     *
     * @return void
     */
    private void disableCards() {
        for (Component component : board.getComponents()) {
            component.setEnabled(false);
        }
    }

    /**
     * Enable all cards
     *
     * @return void
     */
    private void enableCards() {
        for (Component component : board.getComponents()) {
            Card card = ((Card) component);
            component.setEnabled(true);
        }
    }

    /**
     * Exists any hidden cards?
     *
     * @return boolean
     */
    private boolean isComplete() {
        for (Component component : board.getComponents()) {
            Card card = ((Card) component);
            if (card.getState() == CardState.HIDE) {
                return false;
            }
        }
        return true;
    }

    /**
     * Update game stats (couters, log, etc..)
     *
     * @return void
     */
    private void updateGameState() {
        // Total moves
        totalMovesField.setText(String.valueOf(moves.size()));

        // Success moves
        int successMoves = 0;
        for (Move m : moves) {
            if (m.isSuccess()) {
                successMoves++;
            }
        }
        successMovesField.setText(String.valueOf(successMoves));

        // Update logs
        updateLogs();
    }

    /**
     * Update logging area
     *
     * @return void
     */
    private void updateLogs() {
        logging.setText(null);
        for (Move m : moves) {
            logging.append(m.toString() + "\n");
        }
    }

    /**
     * Show complete message
     *
     * @return void
     */
    private void showCompleteMessage() {
        showOkMessageDialog("You're winner. Total moves: " + moves.size() + "x. Total time: " + time + "s.");
    }

    /**
     * ************************** MOVE HANDLERS **************************
     */
    /**
     * Record move
     *
     * @param m
     */
    private void addMove(Move m) {
        moves.add(m);
    }

    /**
     * Record move event
     *
     * @param e
     */
    private void addMoveEvent(MoveEvent e) {
        moveEvents.add(e);
    }

    /**
     * ************************** MESSAGE DIALOGS **************************
     */
    /**
     * Show message dialog
     *
     * @param message
     * @param title
     * @param type
     */
    protected void showMessageDialog(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }

    /**
     * Swow error message dialog
     *
     * @param message
     */
    protected void showErrorMessageDialog(String message) {
        this.showMessageDialog(message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Swow info message dialog
     *
     * @param message
     */
    protected void showInfoMessageDialog(String message) {
        this.showMessageDialog(message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Show ok message dialog
     *
     * @param message
     */
    protected void showOkMessageDialog(String message) {
        this.showMessageDialog(message, "OK", JOptionPane.PLAIN_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel board;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fileMenuExit;
    private javax.swing.JMenuItem fileMenuNewGame;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logging;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel successMovesField;
    private javax.swing.JLabel successMovesLabel;
    private javax.swing.JLabel timerField;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel totalMovesField;
    private javax.swing.JLabel totalMovesLabel;
    // End of variables declaration//GEN-END:variables
}
