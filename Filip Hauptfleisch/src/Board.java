import java.util.Scanner;


public class Board {
	private int sizeX = 4, sizeY = 4;
	Cell[][] cells;
	Scanner sc = new Scanner(System.in); 
	int size;
	int gameForm;
	int pocetTahu = 0;
	int pocetUspesnychTahu = 0;
	boolean gameState = true;
	boolean clickedBefore1;
	boolean clickedBefore2;


	public Board() throws InterruptedException{
		System.out.println("Pokud chcete hrát variantu 4x4 stisknìte 1 a potvrïte enter, pokud 8x8 stisknìte 2");
		size = sc.nextInt();
		if(size == 1){
			this.sizeX = 4;
			this.sizeY = 4;
		}
		if(size == 2){
			this.sizeX = 8;
			this.sizeY = 8;

		}
		cells = new Cell[sizeX][sizeY]; 

		for(int i = 0; i < sizeX ; i++){	
			for(int j =0; j<sizeY; j++){

				cells[i][j] = new Cell(i,j);
			}
		}
		System.out.println("Pokud chcete hrát variantu s prvními 30 sec odhalených karet stisknìte 1 a potvrïte enter, pokud normální variantu, stisknìte 2");
		gameForm = sc.nextInt();
		if(gameForm == 1){
			for(int i = 0; i < sizeX ; i++){	
				for(int j =0; j<sizeY; j++){

					cells[i][j].setClicked(true);
				}
			}
			shuffle();
			repaint();
			Thread.sleep(30000);
			for(int i = 0; i < sizeX ; i++){	
				for(int j =0; j<sizeY; j++){

					cells[i][j].setClicked(false);
				}
			}
			repaint();


		}
		else{
			shuffle();
		}


	}

	public void checkState(){
		int state = 0;
		if(sizeX == 4){
			for(int i = 0; i<4; i++){
				for(int j = 0; j<4; j++){
					if(cells[i][j].getClicked()==true){
						state++;
					}
				}
			}
			if(state == 16){
				gameState = false;
				System.out.println("VYHRÁLI JSTE!!");
				System.out.println("Váš poèet tahù byl: " + pocetTahu + " a poèet úspìšných tahù byl: " + pocetUspesnychTahu);
			}

		}

		if(sizeX == 8){
			for(int i = 0; i<8; i++){
				for(int j = 0; j<8; j++){
					if(cells[i][j].getClicked()==true){
						state++;
					}

				}

			}
			if(state == 64){
				gameState = false;
				System.out.println("VYHRÁLI JSTE!!");
				System.out.println("Váš poèet tahù byl: " + pocetTahu + "A poèet úspìšných tahù byl: " + pocetUspesnychTahu);
			}

		}
	}

	public void shuffle(){
		if(sizeX == 4){
			for(int i = 0; i <8; i++){
				int x = (int)( Math.random()*4);
				int y = (int)( Math.random()*4);

				if(cells[x][y].getContent() == 0){ 
					cells[x][y].setContent(65+i);
				}
				else{
					i--;
				}
			}
			for(int i = 0; i <8; i++){
				int x = (int)( Math.random()*4);
				int y = (int)( Math.random()*4);

				if(cells[x][y].getContent() == 0){ 
					cells[x][y].setContent(65+i);

				}
				else{
					i--;
				}
			}
		}

		if(sizeX == 8){
			for(int i = 0; i <32; i++){
				int x = (int)( Math.random()*8);
				int y = (int)( Math.random()*8);

				if(cells[x][y].getContent() == 0){ 
					if(57+i != 88){
						cells[x][y].setContent(57+i);
					}
					else{
						cells[x][y].setContent(49);
					}
				}
				else{
					i--;
				}
			}
			for(int i = 0; i <32; i++){
				int x = (int)( Math.random()*8);
				int y = (int)( Math.random()*8);

				if(cells[x][y].getContent() == 0){ 
					if(57+i != 88){
						cells[x][y].setContent(57+i);
					}
					else{
						cells[x][y].setContent(49);
					}			}
				else{
					i--;
				}
			}

		}
	}

	public void play() throws InterruptedException{
		pocetTahu++;
		System.out.println("Zadejte postupnì souøadnice vašeho tahu - nejprve x a enter, pak y a enter");
		int y = size = sc.nextInt()-1;		
		int x = size = sc.nextInt()-1;
		if(y >= 0 && y <sizeY && x >= 0 && x <sizeX){
			if(cells[x][y].getClicked() == true){
				clickedBefore1 = true;
			}
			
			cells[x][y].setClicked(true);
		}

		else{
			System.out.println("Pište prosím pouze souøadnice, které jsou <= vámi urèeným rozmìrùm!");
		}

		System.out.println("zadejte postupnì souøadnice vašeho druhého tahu - nejprve x a enter, pak y a enter");
		int y1 = size = sc.nextInt()-1;
		int x1 = size = sc.nextInt()-1;
		if(y1 >= 0 && y1 <sizeY && x1 >= 0 && x1 <sizeX){
			if(cells[x1][y1].getClicked() == true){
				clickedBefore2 = true;
			}
			cells[x1][y1].setClicked(true);
		}
		else{

			System.out.println("Pište prosím pouze souøadnice, které jsou <= vámi urèeným rozmìrùm!");
		}

		repaint();
		if(y >= 0 && y <sizeY && x >= 0 && x <sizeX && y1 >= 0 && y1 <sizeY && x1 >= 0 && x1 <sizeX ){

			if(cells[x][y] != cells[x1][y1]){
				if(cells[x][y].getContent() == cells[x1][y1].getContent()){
					pocetUspesnychTahu ++;
					System.out.println("+++ Tah byl úspìšný");
				}
				else{
					if(clickedBefore1 == true){
					cells[x][y].setClicked(false);
					}
					if(clickedBefore2 == true){
					cells[x1][y1].setClicked(false);
					}
				}
			}

			else{
				cells[x][y].setClicked(false);
				cells[x1][y1].setClicked(false);
				System.out.println("Nevybírejte stejné karty!!");
			}
			Thread.sleep(4000);
			clickedBefore1=false;
			clickedBefore2=false;
		}
		repaint();


	}

	public void repaint(){
		for(int i =0; i <1000; i++){
			System.out.println("");
		}

		for(int i = 0; i < sizeX ; i++){	
			for(int j =0; j<sizeY; j++){
				cells[i][j].paint();

			}
			System.out.println("");
		}
	}

	public boolean getGameState() {
		return gameState;
	}

	public int getPocetTahu(){
		return pocetTahu;
	}

	public int getPocetUspesnychTahu(){
		return pocetUspesnychTahu;
	}

}
