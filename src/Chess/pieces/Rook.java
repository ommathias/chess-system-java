package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R"; 
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean [getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//acima da peça (mantem coluna, decrementa linha)
		p.setValues(position.getRow()-1, position.getColumn());
		
		//Enquanto posição existir e nao houver peça, marque como verdadeiro
		while(getBoard().PositionExists(p) && !getBoard().thereIsAPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-1);
			
		}
		
		//peça adversária
		if(getBoard().PositionExists(p)&& isThereOpponentPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;

		}
		
		//Esquerda
		
		p.setValues(position.getRow(), position.getColumn()-1);
		
		//Enquanto posição existir e nao houver peça, marque como verdadeiro
		while(getBoard().PositionExists(p) && !getBoard().thereIsAPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn()-1);
			
		}
		
		//peça adversária
		if(getBoard().PositionExists(p)&& isThereOpponentPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;

		}
		
		//Direita
		
		p.setValues(position.getRow(), position.getColumn()+1);
		
		//Enquanto posição existir e nao houver peça, marque como verdadeiro
		while(getBoard().PositionExists(p) && !getBoard().thereIsAPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn()+1);
			
		}
		
		//peça adversária
		if(getBoard().PositionExists(p)&& isThereOpponentPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;

		}
		
		//Para baixo
		p.setValues(position.getRow()+1, position.getColumn());
		
		//Enquanto posição existir e nao houver peça, marque como verdadeiro
		while(getBoard().PositionExists(p) && !getBoard().thereIsAPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+1);
			
		}
		
		//peça adversária
		if(getBoard().PositionExists(p)&& isThereOpponentPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;

		}
		
		
		
		
		return mat;
	}

}
