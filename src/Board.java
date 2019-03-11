/**
 * Esta classe define um tabuleiro.
 * Eh composto por uma array multidimensional de pecas
 */
public class Board {

    public Piece[][] board;

    /**
     * Construtor de Board
     * Ao crir um novo Board, eh inicializado um
     * tabuleiro de Pecas de 5 por 4
     */
    public Board() {
        board = new Piece[5][4];
    }
}
