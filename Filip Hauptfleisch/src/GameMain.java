

public class GameMain {

	public static void main(String[] args) throws InterruptedException{	
		Board board = new Board();
		board.repaint();
		do{
			board.play();
			System.out.println("Po�et tah� je: " + board.getPocetTahu() + " a po�et �sp�n�ch tah� je: " + board.getPocetUspesnychTahu());
			board.checkState();
		}while(board.getGameState()==true);			

	}

}
