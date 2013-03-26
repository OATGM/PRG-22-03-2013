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
		System.out.println("Pokud chcete hr�t variantu 4x4 stiskn�te 1 a potvr�te enter, pokud 8x8 stiskn�te 2");
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
		System.out.println("Pokud chcete hr�t variantu s prvn�mi 30 sec odhalen�ch karet stiskn�te 1 a potvr�te enter, pokud norm�ln� variantu, stiskn�te 2");
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
				System.out.println("VYHR�LI JSTE!!");
				System.out.println("V� po�et tah� byl: " + pocetTahu + " a po�et �sp�n�ch tah� byl: " + pocetUspesnychTahu);
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
				System.out.println("VYHR�LI JSTE!!");
				System.out.println("V� po�et tah� byl: " + pocetTahu + "A po�et �sp�n�ch tah� byl: " + pocetUspesnychTahu);
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
		System.out.println("Zadejte postupn� sou�adnice va�eho tahu - nejprve x a enter, pak y a enter");
		int y = size = sc.nextInt()-1;		
		int x = size = sc.nextInt()-1;
		if(y >= 0 && y <sizeY && x >= 0 && x <sizeX){
			if(cells[x][y].getClicked() == true){
				clickedBefore1 = true;
			}
			
			cells[x][y].setClicked(true);
		}

		else{
			System.out.println("Pi�te pros�m pouze sou�adnice, kter� jsou <= v�mi ur�en�m rozm�r�m!");
		}

		System.out.println("zadejte postupn� sou�adnice va�eho druh�ho tahu - nejprve x a enter, pak y a enter");
		int y1 = size = sc.nextInt()-1;
		int x1 = size = sc.nextInt()-1;
		if(y1 >= 0 && y1 <sizeY && x1 >= 0 && x1 <sizeX){
			if(cells[x1][y1].getClicked() == true){
				clickedBefore2 = true;
			}
			cells[x1][y1].setClicked(true);
		}
		else{

			System.out.println("Pi�te pros�m pouze sou�adnice, kter� jsou <= v�mi ur�en�m rozm�r�m!");
		}

		repaint();
		if(y >= 0 && y <sizeY && x >= 0 && x <sizeX && y1 >= 0 && y1 <sizeY && x1 >= 0 && x1 <sizeX ){

			if(cells[x][y] != cells[x1][y1]){
				if(cells[x][y].getContent() == cells[x1][y1].getContent()){
					pocetUspesnychTahu ++;
					System.out.println("+++ Tah byl �sp�n�");
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
				System.out.println("Nevyb�rejte stejn� karty!!");
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
