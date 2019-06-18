package Chess;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class ChessMatch {

	private Board board;

	public ChessMatch()
	{
		board = new Board(8,8);
		initialSetup();
		
	}

	

	public ChessPiece[][] getPieces ()
	{
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i=0; i<board.getRows(); i++)
		{
			for(int j=0; j<board.getColumns(); j++) {

				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition)
	{
		//Converter posição fonte e destino para posições da matriz
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		//Essa posição tem peça?
		validateSourcePosition(source);
		
		validateTargetPosition(source,target);
		Piece capturedPiece = makeMove(source,target);
		
		return (ChessPiece)capturedPiece;
		
	}
	
	private Piece makeMove(Position source, Position target)
	{
		//remove peça da fonte e eventual peça no destino;
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		
		board.placePiece(p, target);
		
		//retorna a peça que foi comida
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position)
	{
		if (!board.thereIsAPiece(position))
		{
			throw new ChessException("No piece at source position.");
		}
		//existem movimentos possíveis?
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible move for selected piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target)
	{
		//A posição de destino será válida a partir da matriz de possibilidade
		//da peça que está se movendo.
	
		if(!board.piece(source).possibleMove(target)){
			throw new ChessException("Selected Piece cannot be moved to target position");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece)
	{
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
	}
	
	private void initialSetup()
	{
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

	}

}
