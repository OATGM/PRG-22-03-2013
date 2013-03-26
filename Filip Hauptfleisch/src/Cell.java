
public class Cell {

	private boolean clicked = false;
	int content = 0; 	


	public Cell(int i, int j) {
	}

	public void setContent(int cont){
		this.content = cont;
	}

	public int getContent(){
		return content;
	}



	public void setClicked(boolean click){
		this.clicked = click;
	}


	public boolean getClicked(){
		return clicked;
	}



	public void paint() {
		if(clicked == true){
			System.out.print((char)content);
		}

		else{
			System.out.print("X");
		}
	}
}

