import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.HashSet; 
import java.util.Iterator; 



/**
 * Esta classe define um tabuleiro.
 * 
 */
public class Board {

	private HashMap<Point, Piece>boardMap;   
	private int boardWidth;  
	private int boardHeight;  
	private ArrayList<String> moves; 
	private HashSet<Piece> pieces;

    /**
     * Construtor de Board
     * Ao crir um novo Board, eh inicializado um
     * tabuleiro de Pecas de 5 por 4
     */
    public Board(int height,int width) {
    	
    	if (height > 256 || width > 256)   
			throw new IllegalArgumentException("Exceeded maximum allowed configuration for tray size.");  
		if (height < 0 || width < 0)   
			throw new IllegalArgumentException("Size must be a nonnegative number.");  
    	
    	this.boardHeight=height;
    	this.boardWidth=width;
    	this.boardMap=new HashMap<Point, Piece>();
    	this.moves=new ArrayList<String>();
    	this.pieces=new HashSet<Piece>();
    	
        //board = new Piece[5][4];
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
    
    
    
    
    
    public boolean validMove(Piece piece, Point point) {  //checks  is the new point   is a valid move 

		point.validatePoint();

		if (point.getX()> boardWidth || point.getY() > boardHeight) {  
			return false;  
		}  

		clearPiece(piece);  

		for (int j = point.getX(); j < point.getX() + piece.getWidth(); j++) {  
			for (int k = point.getY(); k < point.getY() +piece.getHeight(); k++) {  
				if (boardMap.containsKey(new Point(j,k))) {   
					insertPieceBoard(piece);
					return false;  
				}  
			}  
		}  
		return true;  
	}
    
    
    
    public void makeMove(Piece piece, Point point) throws IllegalStateException {  

		Piece temp = piece.copyPiece();//copy of the piece being moved  
		

		if (!validMove(piece, point)) {  
			throw new IllegalStateException("not a valid move!");  
		}  
		else{
			insertPieceBoard(piece);//refill the piece in because we are creating a new Board with the updated piece position  
			
			temp.changeOrientation(point, new Point(point.getX() + piece.getWidth()-1, point.getY() + piece.getHeight()-1));  
		}  

		
		this.clearPiece(piece);
		this.insertPieceBoard(temp);
		
		String moveMade = Integer.toString(piece.getUpperPoint().getY()) + " " +  Integer.toString(piece.getUpperPoint().getX()) + " " + Integer.toString(point.getY()) + " " + Integer.toString(point.getX());  
		this.moves.add(moveMade); 
	}
    
    
    public void addPiece(Piece piece) throws IllegalStateException {  

		if (boardMap.containsValue(piece))  
			throw new IllegalStateException("piece already in board!");  

		if (!validMove(piece, piece.getUpperPoint())) {  
			throw new IllegalStateException("not a valid piece position!");  
		}  

		insertPieceBoard(piece);
	}  
    
    
    public String displayMoves() { //prints all the moves made previously to get to this board in myMoves

		String allMoves = ""; 
		for (int i = 0; i < moves.size(); i++) { 
			allMoves += moves.get(i); 
			allMoves += "\n"; 
		} 
		return allMoves; 
	} 
    
    public HashMap<Point, Piece> getboardMap() { 
		return boardMap; 
	} 

    
    
	public String toString() {  //prints out the size of the piece at each location for example a 1x1 block at 0,0 would just be the number 1 at the location 0,0
		
		System.out.println("Board");
		String board = "";  
		
		board +="+---------------+\n";
		for (int j = 0; j < boardHeight; j++) {  
			for (int k = 0; k < boardWidth; k++) {  
				if (boardMap.containsKey(new Point(k,j))) {  
					Piece piece = boardMap.get(new Point(k,j)); 
					int size = piece.getHeight() * piece.getWidth(); 
					board += "| "+Integer.toString(size)+" ";  
					
				}  
				else{  
					board += "| O ";  
				} 
			
			}
			board +="|";
			board += "\n";
			
			
			
		}
		board +="+---------------+";
		return board;  
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
    
    
    
    
    
    
}
