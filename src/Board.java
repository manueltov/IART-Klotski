/**
 * Esta classe define um tabuleiro.
 * Eh composto por uma array multidimensional de pecas
 */
public class Board {

    public char[][] board;

    /**
     * Construtor de Board
     * <p>
     * Ao crir um novo Board, eh inicializado um
     * tabuleiro de Pecas de 5 por 4
     */
    public Board() {
        board = new char[5][4];
    }
}
