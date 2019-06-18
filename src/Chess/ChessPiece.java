package Chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereOpponentPiece(Position position)
	{
		//Saber se tem pe�a advers�ria nessa posi��o
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//A cor da pe�a � diferente da cor da pe�a atual?
		return p != null && p.getColor() != color;
	}

}
