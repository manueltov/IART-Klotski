/**
 * Esta classe define um tabuleiro
 *
 * Eh composto por uma array multidimensional de pecas
 */
public class Board {

    private Piece[][] board;

    /**
     * Construtor de Board
     *
     * Ao crir um novo Board, eh inicializado um
     * tabuleiro de Pecas de 5 por 4
     */
    public Board() {
        board = new Piece[5][4];
    }

    /**
     * Metodo para adicionar pecas ao tabuleiro
     *
     * @param piece - peca a adicionar
     * @return  Retorna 1 caso peca tenha sido adicionada corretamente
     *          Retorna -1 caso contrario
     */
    private int addPiece (Piece piece){

    }
}
