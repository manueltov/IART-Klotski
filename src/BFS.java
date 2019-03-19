import java.io.*;
import java.util.*;

public class BFS {

    private Board originalBoard; //original starting board
    private Board goalBoard; // end game
    private Board currentBoard; //the board we have just taken out of the fringe
    private PriorityQueue<Node> myQueue;
    private HashSet<Board> boardSeen; //hashset of all repeat boards
    private Node temp;
    private int moveCount;
    private int boardMove;
    private int numBoard;
    private long startTime;
    private long stopTime;
    private ArrayList<Node> nodes;

    public BFS(Board stardBoard, Board goalBoard) {

        this.originalBoard = stardBoard;
        this.goalBoard = goalBoard;
        this.currentBoard = stardBoard;

        this.boardMove = 0;
        this.boardMove = 0;
        this.numBoard = 0;
        this.startTime = 0;
        this.startTime = 0;

        boardSeen = new HashSet<Board>();
        boardSeen.add(stardBoard);

        nodes = new ArrayList<Node>();
    }

    public boolean tryMoveDirection(Point point, String direction) {
        HashMap<Point, Piece> currentboardMap = this.currentBoard.getboardMap();

        if (currentboardMap.containsKey(point)) {
            Point upperLeftPoint = currentboardMap.get(point).getUpperPoint();
            Point movePoint = new Point(-1, -1);
            switch (direction) {
                case "left":
                    movePoint = new Point(upperLeftPoint.getX() - 1, upperLeftPoint.getY());
                    break;

                case "right":
                    movePoint = new Point(upperLeftPoint.getX() + 1, upperLeftPoint.getY());
                    break;

                case "up":
                    movePoint = new Point(upperLeftPoint.getX(), upperLeftPoint.getY() - 1);
                    break;

                case "down":
                    movePoint = new Point(upperLeftPoint.getX(), upperLeftPoint.getY() + 1);
                    break;
            }

            try {
                currentBoard.makeMove(currentboardMap.get(point), movePoint);
                if (currentBoard.getisValid() == false)
                    return false;
                System.out.println(boardSeen.size());
                if (!boardSeen.contains(currentBoard)) {
                    Node n = new Node(currentBoard);
                    this.nodes.add(n);
                    boardSeen.add(currentBoard);
                }
            } catch (IllegalStateException e) {
                return false;
            }

        } else {
            return false;
        }
        return true;
    }

    public void findAllPossibleMoves() {
        HashMap<Point, Piece> currTray = currentBoard.getboardMap(); //our board implementation

        for (int i = 0; i < currentBoard.getWidth(); i++) {
            for (int j = 0; j < currentBoard.getHeight(); j++) {
                if (!currTray.containsKey(new Point(i, j))) { //looks for empty spaces until it finds one

                    if (i - 1 >= 0) //tries moving piece from the left right down and up of that empty space
                        this.tryMoveDirection(new Point(i - 1, j), "right");
                    if (i + 1 < currentBoard.getWidth())
                        this.tryMoveDirection(new Point(i + 1, j), "left");
                    if (j - 1 >= 0)
                        this.tryMoveDirection(new Point(i, j - 1), "down");
                    if (j + 1 < currentBoard.getHeight()) {
                        this.tryMoveDirection(new Point(i, j + 1), "up");
                        //System.out.println("asdddddddddddddddddddddddddd");
                    }
                }
            }
        }
    }

    public Board getCurrBoard() {
        return currentBoard;
    }

    public ArrayList<Node> getNodes() {
        return this.nodes;
    }


}
