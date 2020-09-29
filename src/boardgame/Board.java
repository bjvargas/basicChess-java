package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		
		this.tamanhoMinimo(rows, columns);
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}	
	
	public Piece piece(int row, int column) {
		this.posicaoInexistente(row, column);
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		this.posicaoInexistente(position);
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		this.posicaoOcupada(position);
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >=0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return this.positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		this.posicaoInexistente(position);
		return piece(position) != null;
	}
	
	private void tamanhoMinimo(int rows, int columns) {
		if(rows <1 || columns < 1) {
			throw new BoardException("Erro na criação do tabuleiro: Precisa ter no minimo 1 linha e 1 coluna.");
		}
	}
	
	private void posicaoInexistente(int row, int column) {
		if(!this.positionExists(row, column)) {
			throw new BoardException("Posição não existe no tabuleiro.");
		}
	}

	private void posicaoInexistente(Position position) {
		if(!this.positionExists(position)) {
			throw new BoardException("Posição não existe no tabuleiro.");
		}
	}
	
	private void posicaoOcupada(Position position) {
		if(this.thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça na posição: " + position);
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
