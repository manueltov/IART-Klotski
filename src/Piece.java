/**
 * Esta classe define uma Peça
 */
public class Piece {

    // ////////////////////////
    // Variables

    /*      TYPES
    -> a -> blank_space
    -> b -> 1 x 1
    -> c -> 1 x 2
    -> d -> 2 x 1
    -> e -> 2 x 2       */

    // Type
    private char type;

    // Coordinates
    private int x;
    private int y;

    // ////////////////////////
    // Constructor
    public Piece(char type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    // ////////////////////////
    // Getters and Setters

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}