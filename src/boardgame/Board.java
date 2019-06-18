package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1)
		{
			throw new BoardException("Erro ao criar tabuleiro (menor que 1x1)");
		}
		pieces = new Piece [rows][columns];
		this.rows = rows;
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece (int row, int column)
	{
		if(!PositionExists(row, column))
		{
			throw new BoardException("Position do not exists!");
		}
		return pieces[row][column];
	}

	public Piece piece (Position position)
	{
		if(!PositionExists(position))
		{
			throw new BoardException("Position do not exists!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece (Piece piece, Position position)
	{
		if(thereIsAPiece(position))
		{
			throw new BoardException("Theres already a piace on position " + position);
		}
		pieces [position.getRow()] [position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position)
	{
		//programa��o defensiva (se a posi��o n existe)
		if (!PositionExists(position))
		{
			throw new BoardException("Position do not exists!");

		}
		
		if(piece(position) == null)
		{
			return null;
		}
		//retorna a pe�a retirada, zera na matrix onde ela estava
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
		
	}

	public boolean PositionExists(int row, int column)
	{
		return row >= 0 && row < rows && column >= 0 && column <= columns;
		
	}
	
	public boolean PositionExists(Position position)
	{
		return PositionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position)
	{
		if(!PositionExists(position))
		{
			throw new BoardException("Position do not exists!");
		}
		return piece(position) != null;
	}
	
	

}
