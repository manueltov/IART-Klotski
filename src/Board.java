import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Board {

	private HashMap<Point, Piece>boardMap;
	private int boardWidth; 
	private int boardHeight;
	private Piece goalPiece;
	private ArrayList<String> moves;
	private HashSet<Piece> pieces;
	private boolean isvalid;
	private int gx;

	public Board(int height, int width, Piece goalPiece) {

		if (height > 256 || width > 256)
			throw new IllegalArgumentException("Exceeded maximum allowed configuration for tray size.");
		if (height < 0 || width < 0)
			throw new IllegalArgumentException("Size must be a nonnegative number.");

		this.boardHeight=height;
		this.boardWidth=width;
		this.goalPiece = goalPiece;
		this.boardMap=new HashMap<Point, Piece>();
		this.moves=new ArrayList<String>();
		this.pieces=new HashSet<Piece>();
		this.gx=0;
		
	}

	public Piece getGoalPiece() {
		return goalPiece;
	}
	
	public int getGx() {
		return gx;
	}
	
	public void setGx(int num) {
		this.gx=num;
	}

	public Board(int height, int width, Board parent, Piece goalPiece) {  // constructor for making a board that isn't the initial configuration board

		if (height > 256 || width > 256)
			throw new IllegalArgumentException("Exceeded maximum allowed configuration for tray size.");
		if (height < 0 || width < 0)
			throw new IllegalArgumentException("Size must be a nonnegative number.");

		boardWidth = width;
		boardHeight = height;

		this.goalPiece = goalPiece;

		this.gx=parent.getGx()+1;
		
		this.boardHeight=height;
		this.boardWidth=width;
		this.boardMap=new HashMap<Point, Piece>();
		this.moves=new ArrayList<String>();
		this.pieces=new HashSet<Piece>();
	
		this.goalPiece=goalPiece;

		pieces.addAll(parent.pieces);
		moves.addAll(parent.moves);
		//System.out.println(moves.size());

		if (parent.boardMap != null) {
			boardMap.putAll(parent.boardMap);
		}
	}

	public void clearPiece(Piece piece) {  // remove a piece in board

		for (int j = piece.getUpperPoint().getX(); j <= piece.getLowePoint().getX(); j++) {
			for (int k = piece.getUpperPoint().getY(); k <=piece.getLowePoint().getY();k++) {
				boardMap.remove(new Point(j,k));
				pieces.remove(piece);
			}
		}
	}

	public void insertPieceBoard(Piece piece) {  //insert piece in board

		for (int j = piece.getUpperPoint().getX(); j <= piece.getLowePoint().getX(); j++) {
			for (int k = piece.getUpperPoint().getY(); k <= piece.getLowePoint().getY(); k++) {
				boardMap.put(new Point(j,k), piece);
				pieces.add(piece);
			}
		}
	}

	
	public int calculateManhattan(){

		Piece goalPicePosition= this.getGoalPiece();

		int sumdistance = 0; //calculates distance between  piece in current board and goal board
		for (Piece i: this.getPieces()){
			if ((goalPicePosition.getPieceType().equals(i.getPieceType()))){
				sumdistance += Math.abs((i.getUpperPoint().getX() - goalPicePosition.getUpperPoint().getX()));
				sumdistance += Math.abs((i.getUpperPoint().getY() - goalPicePosition.getUpperPoint().getY()));
			}
		}
		return sumdistance;
	}
	
	public boolean validMove(Piece piece, Point point) {  //checks  is the new point   is a valid move 

		point.validatePoint();
		//System.out.println(point.toString());
		if (point.getX()>(boardWidth-1)|| point.getY() > (boardHeight-1)) {

			this.isvalid=false;

			return false;
		}

		clearPiece(piece);

		for (int j = point.getX(); j < point.getX() + piece.getWidth(); j++) {
			for (int k = point.getY(); k < point.getY() +piece.getHeight(); k++) {
				if (boardMap.containsKey(new Point(j,k))) {
					this.isvalid=false;
					insertPieceBoard(piece);
					return false;
				}
			}
		}
		this.isvalid=true;
		return true;
	}

	public Board makeMove(Piece piece, Point point)throws IllegalStateException{
		Piece temp =new Piece(piece.getUpperPoint(), piece.getLowePoint());    // piece.copyPiece();//copy of the piece being moved
		if (!validMove(piece, point)) {

			throw new IllegalStateException("not a valid move!");
		}
		else{
			insertPieceBoard(piece);//refill the piece in because we are creating a new Board with the updated piece position  
			temp.changeOrientation(point, new Point(point.getX() + piece.getWidth()-1, point.getY() + piece.getHeight()-1));
		}


		Board board = new Board(boardHeight, boardWidth, this, goalPiece);




		board.clearPiece(piece);
		board.insertPieceBoard(temp);

		String moveMade = "("+Integer.toString(piece.getUpperPoint().getX()) + " " +  Integer.toString(piece.getUpperPoint().getY()) + ")"+ "->"+ "("+Integer.toString(point.getX()) + " " + Integer.toString(point.getY())+")";
		board.moves.add(moveMade);
		//System.out.println(moveMade);
		return board;
	}

	public void addPiece(Piece piece) throws IllegalStateException {
		if (boardMap.containsValue(piece))
			throw new IllegalStateException("piece already in board!");
		if (!validMove(piece, piece.getUpperPoint())) {
			throw new IllegalStateException("not a valid piece position!");
		}
		insertPieceBoard(piece);
	}

	public HashMap<Point, Piece> getboardMap() {
		return boardMap;
	}

	public String toString() {  //prints out the size of the piece at each location for example a 1x1 piece at 0,0 would just be the number 1 at the location 0,0
		//System.out.println("Board");
		String board = "";

		board +="+---------------+\n";
		for (int j = 0; j < boardHeight; j++) {
			for (int k = 0; k < boardWidth; k++) {
				if (boardMap.containsKey(new Point(k,j))) {
					Piece piece = boardMap.get(new Point(k,j));
					int size = piece.getHeight() * piece.getWidth();
					board += "| "+Integer.toString(size)+" ";
				} else{
					board += "| O ";
				}
			}
			board +="|";
			board += "\n";
			board +="+---------------+";
			board += "\n";
		}
		return board;
	}

	@Override
	public boolean equals(Object o) {
		Board board = (Board) o;
		if (board.boardHeight != boardHeight || board.boardWidth != boardWidth)
			return false;
		else if (!this.boardMap.equals(board.boardMap)) {  //same board if map are equal
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int hashCode(){ //new hashCode
		int rtn = 0;
		for (Piece piece: boardMap.values()) {
			rtn += Math.pow(piece.getUpperPoint().getX(), 2) + Math.pow(piece.getUpperPoint().getY(), 3) + Math.pow(piece.getLowePoint().getX(), 4) + Math.pow(piece.getLowePoint().getY(), 5);
		}
		return rtn;
	}

	public int getHeight() {
		return boardHeight;
	}

	public int getWidth() {
		return boardWidth;
	}

	public HashSet<Piece> getPieces() {
		return pieces;
	}

	public ArrayList<String>getMoves(){
		return this.moves;
	}

	public String displayMoves() { //prints all the moves made previously to get to this board in myMoves
		String allMoves = "";
		for (int i = 0; i < moves.size(); i++) {
			allMoves += moves.get(i);
			allMoves += "\n";
		}
		return allMoves;
	}

	public boolean getisValid() {
		// TODO Auto-generated method stub
		return this.isvalid;
	}

	public boolean isOK() throws IllegalStateException {
		ArrayList<Point> occupied = new ArrayList<Point>();
		if (pieces != null) {
			for (Piece current : pieces) {
				ArrayList<Point> tempPoints = new ArrayList<Point>();

				//This checks to make sure the piece are within the actual board dimensions.
				if (current.getUpperPoint().getX()< 0 || current.getUpperPoint().getY() < 0 || current.getLowePoint().getX() > boardWidth || current.getLowePoint().getY() > boardHeight)
					throw new IllegalStateException("isOK Error: pieces go out of dimensions given.");

				//This checks to make sure the upper left point values are smaller or equal to the lower right point values.
				if (current.getUpperPoint().getX() > current.getLowePoint().getX() || current.getUpperPoint().getY() > current.getLowePoint().getY())
					throw new IllegalStateException("isOK Error: The piece' point values are not correctly inputted as upper left and lower right coordinates.");

				//This adds piece into an array list by converting them into points, 
				//so the values of piece that occupy more than two spaces can be checked for all of the piece they occupy.
				for (int j=current.getUpperPoint().getX(); j <= current.getLowePoint().getX(); j++) {
					for (int k=current.getUpperPoint().getY(); k <= current.getLowePoint().getY(); k++) {
						tempPoints.add(new Point(j, k));
					}
				}
				//This checks for overlapping piece.
				for (Point checkPoint : tempPoints) {
					if (occupied.contains(checkPoint)) {
						throw new IllegalStateException("isOK Error: Overlapping piece space at (" + checkPoint.getX() + "," + checkPoint.getY() + ")");
					} else {
						occupied.add(checkPoint);
					}
				}
			}
		}
		return true;
	}
}
