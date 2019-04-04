public class Node {

	private Board myBoard;
	private int manhatdis,gx,fx;

	public Node(Board b){
		myBoard = b;
		manhatdis=0;
		gx=0;
		fx=0;
	}

	public Board getBoard() {

		return this.myBoard;
	}

	public void setBoard(Board board) {

		this.myBoard=board;
	}

	public void setMath(int manth) {

		this.manhatdis=manth;
	}
	public int getMath() {

		return this.manhatdis;
	}


	public void setGx(int g) {
		this.gx=g;
	}

	public int getGx() {
		return gx;
	}

	public void setFx(int f) {
		this.fx=f;
	}

	public int getFx() {
		return fx;
	}
}
