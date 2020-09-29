package boardgame;

public class Piece {
	
	protected Position position;
	private Board borad;	

	public Piece(Board borad) {
		this.borad = borad;
		position = null;
	}	
	
	protected Board getBorad() {
		return borad;
	}
}
