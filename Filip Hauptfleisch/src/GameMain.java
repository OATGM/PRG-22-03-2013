

public class GameMain {

	public static void main(String[] args) throws InterruptedException{	
		Board board = new Board();
		board.repaint();
		do{
			board.play();
			System.out.println("Poèet tahù je: " + board.getPocetTahu() + " a poèet úspìšných tahù je: " + board.getPocetUspesnychTahu());
			board.checkState();
		}while(board.getGameState()==true);			

	}

}
