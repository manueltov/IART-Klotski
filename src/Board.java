/**
 * Esta classe define um tabuleiro
 *
 * Eh composto por uma array multidimensional de pecas
 */
public class Board {

    private char[][] board;

    /**
     * Construtor de Board
     *
     * Ao crir um novo Board, eh inicializado um
     * tabuleiro de Pecas de 5 por 4
     */
    public Board() {
        board = new char[5][4];
    }

    /**
     * Metodo para adicionar pecas ao tabuleiro
     *
     * @param piece - peca a adicionar
     * @return  Retorna 0 caso peca tenha sido adicionada corretamente
     *          Retorna -1 caso contrario
     */
    private int addPiece (Piece piece, int x, int y){
        if(Utilities.pecaEncaixaTabuleiro(piece, x, y)){
            board[x][y] = piece.getType();
            return 0;
        }
        else{
            return -1;
        }
    }

    /**
     * Metodo para remover pecas ao tabuleiro
     *
     * @param piece - peca a remover
     * @return  Retorna 0 caso peca tenha sido removida corretamente
     *          Retorna -1 caso contrario
     */
    private int removePiece (Piece piece){
        if(Utilities.pecaEncaixaTabuleiro(piece, x, y)){
            board[x][y] = piece.getType();
            return 0;
        }
        else{
            return -1;
        }
    }
}
