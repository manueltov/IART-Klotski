/**
 * Esta classe eh que eh a do Jogo
 * Esta cria um tabuleiro e colaca pecas nele
 * E gere as jogadas
 */
public class Game {

    private Board board;

    public Game(int level) {
        board = Utilities.loadLevel(level);
    }

    /**
     * Metodo para adicionar pecas ao tabuleiro
     *
     * @param piece - peca a adicionar
     * @return Retorna 0 caso peca tenha sido adicionada corretamente
     * Retorna -1 caso contrario
     */
   /* private int addPiece(Piece piece, int x, int y) {
        if (Utilities.pecaEncaixaTabuleiro(piece, x, y)) {
            board.board[x][y] = piece;
            return 0;
        } else {
            return -1;
        }
    }*/

    /**
     * Metodo para remover pecas ao tabuleiro
     *
     * @param piece - peca a remover
     * @return Retorna 0 caso peca tenha sido removida corretamente
     * Retorna -1 caso contrario
     */
    /*private int removePiece(Piece piece) {
        if (Utilities.existePecaTabuleiro(piece)) {
            board.board[piece.getX()][piece.getY()] = null;
            return 0;
        } else
            return -1;
    }*/

}
