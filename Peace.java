package chess;

public class Piece {
	Boolean black;
	Boolean first;
	String type;
	public Piece()
	{
		black=null;
		first=null;
	}
	public void CreatePawn(Boolean b)
	{
		black=b;
		first=true;
		setType("P");
		
		
	}
	public void CreateRook(Boolean b)
	{
		black=b;
		setType("R");
	}
	public void CreateKnight(Boolean b)
	{
		black=b;
		setType("k");
	}
	public void CreateQueen(Boolean b)
	{
		black=b;
		setType("Q");
	}
	public void CreateKing(Boolean b)
	{
		black=b;
		setType("K");
	}
	public void CreateBishop(boolean b) 
	{
		black=b;
		setType("B");
		
	}
	public void setColor(Boolean b) {
		black=b;
	}
	public Boolean getColor(){
		return black;
	}
	public Boolean getFirst()
	{
		return first;
	}
	public void setFirst()
	{
			first=false;
	}
	public void setterFirst(Boolean f)
	{
			first=f;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String pieceType)
	{
		type=pieceType;
	}
      
}
