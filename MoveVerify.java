package chess;
public class moveVerify {
	boolean white;
	boolean valid;
	boolean check;
	int checkMate=0;
	boolean checkM=false;
	Board out;
        
	public moveVerify()
	{
		
	}
	public moveVerify(int xLoc, int yLoc, int x, int y, boolean white, Board b)
	{
		valid=true;
		out=b;
                
		this.white=white;
              
        if(b.getPiece(xLoc, yLoc).getType()=="P")	
		{
			movePawn(xLoc,yLoc,x,y,b);
			return;
		}
                  if(b.getPiece(xLoc, yLoc).getType()=="R")	
		{
			moveRook(xLoc,yLoc,x,y,b);
			return;
		}
                   if(b.getPiece(xLoc, yLoc).getType()=="k")	
		{
			moveKnight(xLoc,yLoc,x,y,b);
			return;
		}
                   if(b.getPiece(xLoc, yLoc).getType()=="B")	
		{
			moveBishop(xLoc,yLoc,x,y,b);
			return;
		}
                   if(b.getPiece(xLoc, yLoc).getType()=="Q")	
		{
			moveQueen(xLoc,yLoc,x,y,b);
			return;
		}
                   if(b.getPiece(xLoc, yLoc).getType()=="K")	
		{
			moveKing(xLoc,yLoc,x,y,b);
			return;
		}
              

	}
		public boolean getValid()
		{
			return valid;
		}
		 public int valueFunction(Boolean p, Board b) {
				int Black_Pscore=0;
				int Black_inCheckScore=0;
				int White_Pscore=0;
				int White_inCheckScore=0;
				int value=0;
				int middle_Squares=0;
				for(int x=0; x<8;x++)
				{
					for(int z=0; z<8; z++)
					{
                                            
						if(b.getPiece(x, z)!=null)
						{
							if(b.getPiece(x, z).getColor()==true)
							{
								switch(b.getPiece(x, z).getType())
								{
								case"P":White_Pscore=White_Pscore+1;  
								case"Q":White_Pscore=White_Pscore+10;    
								case"R":White_Pscore=White_Pscore+5;   
								case"B":White_Pscore=White_Pscore+3;  
								case"k":White_Pscore=White_Pscore+3;   
								}
							}
							if(b.getPiece(x, z).getColor()==false)
							{
								switch(b.getPiece(x, z).getType())
								{
								case"P":Black_Pscore=Black_Pscore+1;
								case"Q":Black_Pscore=Black_Pscore+10;
								case"R":Black_Pscore=Black_Pscore+5;
								case"B":Black_Pscore=Black_Pscore+3;
								case"k":Black_Pscore=Black_Pscore+3;
								}
							}	
						}
					}
				}
				if(b.getPiece(4, 3)!=null)
				{
					if(b.getPiece(4, 3).getColor()==p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(3, 3)!=null)
				{
					if(b.getPiece(3, 3).getColor()==p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(3, 4)!=null)
				{
					if(b.getPiece(3, 4).getColor()==p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(4, 4)!=null)
				{
					if(b.getPiece(4, 4).getColor()==p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(4, 3)!=null)
				{
					if(b.getPiece(4, 3).getColor()!=p)
					{
						middle_Squares=middle_Squares-1;
					}
				}
				if(b.getPiece(3, 3)!=null)
				{
					if(b.getPiece(3, 3).getColor()!=p)
					{
						middle_Squares=middle_Squares-1;
					}
				}
				if(b.getPiece(3, 4)!=null)
				{
					if(b.getPiece(3, 4).getColor()!=p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(4, 4)!=null)
				{
					if(b.getPiece(4, 4).getColor()!=p)
					{
						middle_Squares=middle_Squares-1;
					}
				}
				if(check(b))
				{
					White_inCheckScore=50;
					Black_inCheckScore=50;
				}	
				if(p)
				{
					 value=(White_Pscore-Black_Pscore)+Black_inCheckScore-White_inCheckScore+middle_Squares;
				}
				if(!p)
				{
				     value=(Black_Pscore-White_Pscore)+White_inCheckScore-Black_inCheckScore+middle_Squares;
				}
			    	b.setValue(value);
			    	return value;
			    }
		public Board changedBoard()
		{
			return out;	
		} 
		public boolean check(Board b)
		{
			int a=0;
			int c=0;
			for(int x=0; x<8; x++)
			{
				for(int y=0; y<8; y++)
				{
					if(b.getPiece(x, y)!=null)
					{
						if(b.getPiece(x, y).getType()=="K")
						{
							a=x;
							c=y;
						}
					}
				}
			}
				if(a+1<8 && c+2<8 && a-1>=0)
				{
				if(b.getPiece(a+1, c+1)!=null)	
				{
					if((b.getPiece(a+1, c+1).getType()=="P"&&b.getPiece(a+1, c+1).getType()=="Q"))	
					{
						return true;
					}
				}
				if(b.getPiece(a-1, c+1)!=null)	
				{
					if((b.getPiece(a-1, c+1).getType()=="P"&&b.getPiece(a-1, c+1).getType()=="Q"))	
					{
						return true;
					}
				}
				}
			
			for(int e=a+1; e<8;e++)
			{
				
				if(b.getPiece(e, c)!=null)
				{
					if((b.getPiece(e, c).getType()!="R"||b.getPiece(e, c).getType()!="Q"))
					{
						break;
					}
					if((b.getPiece(e, c).getType()=="R" )||(b.getPiece(e, c).getType()=="Q" ))
					{ 
						return true;
					}
				}
				
			}
			for(int e=a-1; e>=0;e--)
			{
				
				if(b.getPiece(e, c)!=null)
				{
					if((b.getPiece(e, c).getType()!="R"||b.getPiece(e, c).getType()!="Q"))
					{
						break;
					}
					if((b.getPiece(e, c).getType()=="R" )||(b.getPiece(e, c).getType()=="Q" ))
					{
						return true;
					}
				}
				
			}
			for(int e=c+1; e<8;e++)
			{
				
				if(b.getPiece(e, c)!=null)
				{
					if((b.getPiece(e, c).getType()!="R"||b.getPiece(e, c).getType()!="Q"))
					{
						break;
					}
					if((b.getPiece(e, c).getType()=="R" )||(b.getPiece(e, c).getType()=="Q" ))
					{
						return true;
					}
				}
				
			}
			for(int e=c-1; e>=0;e--)
			{
				
				if(b.getPiece(e, c)!=null)
				{
					if((b.getPiece(e, c).getType()!="R"||b.getPiece(e, c).getType()!="R"))
					{
						break;
					}
					if((b.getPiece(e, c).getType()=="R" )||(b.getPiece(e, c).getType()=="Q"))
					{
						return true;
					}
				}
				
			}
			int check=c+1;
			for(int e=a+1; e<8;e++)
			{
				if(check==8)
				{
					break;
				}
				if(b.getPiece(e, check)!=null)
				{
					if((b.getPiece(e, check).getType()!="B" || b.getPiece(e, check).getType()!="Q"))
					{
						break;
					}
					if((b.getPiece(e, check).getType()=="B" )||(b.getPiece(e, check).getType()=="Q" ))
					{
						return true;
					}
				}
				check++;
				
			}
		    check=c-1;
			for(int e=a+1; e<8;e++)
			{
				if(check<0)
				{
					break;
				}
				if(b.getPiece(e, check)!=null)
				{
					if((b.getPiece(e, check).getType()!="B"|| b.getPiece(e, check).getType()!="Q"))
					{
						break;
					}
					if((b.getPiece(e, check).getType()=="B" )||(b.getPiece(e, check).getType()=="Q"))
					{
						return true;
					}
				}
				check--;
				
			}
				check=c-1;
				for(int e=a-1; e>=0;e--)
				{
					if(check<0 || check>7 || e<0 || e>7 )
					{
						break;
					}
					if(b.getPiece(e, check)!=null && b.getPiece(e, c)!=null)
					{
						if((b.getPiece(e, check).getType()!="B" || b.getPiece(e, check).getType()!="Q"))
						{
							break;
						}
						if((b.getPiece(e, check).getType()=="B" )||(b.getPiece(e, check).getType()=="Q" ))
						{
							return true;
						}
					}
					check--;
					
				}
				check=c+1;
				for(int e=a-1; e>=0;e--)
				{
					if(check>7)
					{
						break;
					}
					if(b.getPiece(e, check)!=null)
					{
						if((b.getPiece(e, check).getType()!="B" || b.getPiece(e, check).getType()!="Q"))
						{
							break;
						}
						if((b.getPiece(e, check).getType()=="B" )||(b.getPiece(e, check).getType()=="Q" ))
						{
							return true;
						}
					}
					check++;
					
				}
				check=a;
				int check2=c;
				if(check-2<8 && check+2<8 && check2+1<8 && check-2>=0 && check2+1>=0)
				{
					if(b.getPiece(check+2, check2+1)!=null)
					{
						if(b.getPiece(check+2, check2+1).getType()=="k")
						{
							return true;
						}
					}
				}
				if(check+2<8&check2-1>=0)
				{
				if(b.getPiece(check+2, check2-1)!=null)
				{
					if(b.getPiece(check+2, check2-1).getType()=="k")
					{
						return true;
					}
				}
				}
				if(check-2>=0&&check2+1<8)
				{
				if(b.getPiece(check-2, check2+1)!=null)
				{
					if(b.getPiece(check-2, check2+1).getType()=="k")
					{
						return true;
					}
				}
				}
				if(check-2>=0&&check2-1>=0)
				{
					
				if(b.getPiece(check-2, check2-1)!=null)
				{
					if(b.getPiece(check-2, check2-1).getType()=="k")
					{
						return true;
					}
				}
				}
				if(check2-2>=0 &&check+1<8)
				{
				if(b.getPiece(check2-2, check+1)!=null)
				{
					if(b.getPiece(check2-2, check+1).getType()=="k")
					{
						return true;
					}
				}
				}
				if(check2+2<8&check-1>=0)
				{
				if(b.getPiece(check2+2, check-1)!=null)
				{
					if(b.getPiece(check2+2, check-1).getType()=="k")
					{
						return true;
					}
				}
				}
				if(check2-2>=0&&check+1<8)
				{
				if(b.getPiece(check2-2, check+1)!=null)
				{
					if(b.getPiece(check2-2, check+1).getType()=="k")
					{
						return true;
					}
				}
				}
				if(check2-2>=0&&check-1>=0)
				{
					
				if(b.getPiece(check2-2, check-1)!=null)
				{
					if(b.getPiece(check2-2, check-1).getType()=="k")
					{
						return true;
					}
				}
				}
				return false;
		} 
		public void Moved(int i, int j, int x, int z, Board a)
		{	
			if(x<8 && z<8 && x>=0 && z>=0 && a.getPiece(x, z)!=null)
			{
				if(a.getPiece(i, j).getColor()==a.getPiece(x, z).getColor())
				{
					valid=false;
					return;
				}
				if(a.getPiece(i, j).getColor()!=a.getPiece(x, z).getColor())
				{	
					Piece swap=a.getPiece(i, j);
					Piece hold=a.getPiece(x, z);
					a.setPiece(x, z, swap);
					a.setPiece(i, j, null);
					if(check(a)==true)
					{ 
						valid = false;
						a.setPiece(x, z, hold);
						a.setPiece(i, j, swap);
						checkMate++;
						return;
					}
                                        
					if(check(a)==false)
					{
						return;
					}
					out=a;
					valid=true;
					checkMate=0;
					return;
				}
				valid=false;
				return;
				
			}
			if(x<8 && z<8 && i<8 && j<8 && x>=0 && z>=0 && i>=0 && j>=0 && valid && a.getPiece(i, j)!=null && a.getPiece(x, z)==null)
			{ 
				Piece swap=a.getPiece(i, j);
				a.setPiece(x, z, swap);
				a.setPiece(i, j, null);
				if(check(a)==true)
				{
					valid = false;
					a.setPiece(x, z, null);
					a.setPiece(i, j, swap);
					checkMate++;
					return;
				}
				if(check(a)==false)
				{
					out=a;
					valid=true;
					checkMate=0;
					valueFunction(white,a);
					return;
				}
			}
			valid=false;
			return;
		}		
		public void movePawn(int i,int j, int x, int z, Board b){
			if(b.getPiece(i, j)==null)
			{
				valid=false;
				return;
			}
			if(white==true) 
            {         
                if((b.getPiece(i, j).getFirst())==true)
                {
                    if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
                    {
                        if(b.getPiece(x, z)!=null)
                        {
                            Moved(i,j,x,z,b);
                            return;
                        }

                        if(b.getPiece(x, z)==null)
                        {
                            valid=false;
                            return;
                        }

                    }
                    if((j-z<3 && j-z>0) && i-x==0 && b.getPiece(x, z)==null )
                    {
                        b.getPiece(i, j).setFirst();
                        Moved(i,j,x,z,b);
                        return;
                    }
                    else
                        valid=false;
                        return;
			}
			if(b.getPiece(i, j).getFirst()==false)
			{
				if((x-i==1 && z-j==-1) || (x-i==-1 && z-j== -1) )
				{
					if(b.getPiece(x, z)!=null)
					{
						Moved(i,j,x,z,b);
						return;
					}
					
					if(b.getPiece(x, z)==null)
					{
						valid=false;
						return;
					}
					
				}
				if((j-z<=2 && j-z>=0) && i-x==0 && b.getPiece(x, z)==null)
					{
					Moved(i,j,x,z,b);
					return;
					}
					else
						valid=false;
						return;
				}
			valid=false;
			return;
			}
			if(white!=true) {
				if((b.getPiece(i, j).getFirst())==true)
				{
					if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
					{
						if(b.getPiece(x, z)!=null)
						{
							Moved(i,j,x,z,b);
							return;
						}
						
						if(b.getPiece(x, z)==null)
						{
							valid=false;
							return;
						}
						
					}
					if((z-j<3 && z-j>0) && i-x==0 && x<7 && z<7 && x>=0 && z>=0 && b.getPiece(x, z)==null)
					{
						b.getPiece(i, j).setFirst();
						Moved(i,j,x,z,b);
						return;
					}
					else
						valid=false;
						return;
						
					
				}
				if(b.getPiece(i, j).getFirst()==false)
				{
					if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
					{
						if(b.getPiece(x, z)!=null)
						{
							Moved(i,j,x,z,b);
							return;
						}
						
						if(b.getPiece(x, z)==null)
						{
							valid=false;
							return;
						}
						
					if((z-j<2 && z-j>0) && i-x==0&& b.getPiece(x, z)==null)
					{
						Moved(i,j,x,z,b);
						return;
					}
					else
						valid=false;
						return;
				}
				}
				valid=false;
				return;
			}
		}
		public void moveRook(int i, int j, int x, int z, Board b)
		{
			if(i-x!=0 && j-z==0)
			{
				for(int p=i+1; p<x;p++)
				{
					if(b.getPiece(p, j)!=null)
					{
						valid=false;
						return;
						
					}
				}
				valid=true;
				Moved(i,j,x,z,b);
				return;
				
			}
			if(i-x==0 && j-z<0)
				{
				for(int p=j+1; p<z;p++)
				{
					if(b.getPiece(i, p)!=null)
					{
						valid=false;
						return;
					}
				}
					valid=true;
					Moved(i,j,x,z,b);
					return;
				}
			if(i-x==0 && j-z>0)
			{
				
			for(int p=j-1; p>z;p--)
			{
				if(b.getPiece(i, p)!=null)
				{
					valid=false;
					return;
				}
			}
				valid=true;
				Moved(i,j,x,z,b);
				return;
			}
			valid=false;
			return;
			
			}
		public void moveKnight(int i, int j, int x, int z, Board b)
		{
			if((x-i==2 && (z-j==1 || z-j==-1))|| (x-i==-2 && (z-j==1 || z-j==-1))|| (z-j==2 && (x-i==1 || x-i==-1)) || (z-j==-2 && (x-i==1 || x-i==-1)))
			{
				valid=true;
				Moved(i,j,x,z,b);
				return;
			}
			else
			{
				valid=false;
				return;
			}
		}
		public void moveBishop(int i, int j, int x, int z, Board b)
		{
			if(b.getPiece(i, j)==null)			{
				valid=false;
				return;
			}
			
			if(i-x==j-z || x-i==z-j || i-x==(j-z)*-1 || x-i==(z-j)*-1)
			{
				if(i-x>0&&j-z>0)
				{
					int check=j-1;
					for(int p=i-1; p>x;p--)
					{
						if(check>7 || check<0 || p>7 || p<0)
						{
							valid=false;
							return;
						}
						if(b.getPiece(p, check)!=null)
						{
							valid=false;
							return;
						}
						check--;
					}
					valid=true;
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x>0&&j-z<0)
				{
					int check=j-1;
					for(int p=i+1; p<x;p++)
					{
						if(b.getPiece(p, check)!=null)
						{
							valid=false;
							return;
						}
						check--;
					}
					valid=true;
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x<0&&j-z>0)
				{
					int check=j-1;
					for(int p=i+1; p<x;p++)
					{
						if(b.getPiece(p, check)!=null){
							valid=false;
							return;
						}
						check--;
					}
					valid=true;
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x<0&&j-z<0)
				{
					int check=j+1;
					for(int p=i+1; p<x;p++)
					{
						if(b.getPiece(p, check)!=null)
						{
							valid=false;
							return;
						}
						check++;
					}
					valid=true;
					Moved(i,j,x,z,b);
					return;
				}
				
			}
			valid=false;
			return;
		}  
		public void moveQueen(int i, int j, int x, int z, Board b)
		{
			if(b.getPiece(i, j)==null)
			{
				valid=false;
				return;
			}
			if(i-x==j-z || x-i==z-j || i-x==(j-z)*-1 || x-i==(z-j)*-1)
			{
				if(i-x>0&&j-z>0)
				{
					int check=j-1;
					for(int p=i-1; p>x;p--)
					{
						if(check>7 || check<0 || p>7 || p<0)
						{
							valid=false;
							return;
						}
						if(b.getPiece(p, check)!=null)
						{
							valid=false;
							return;
						}
						check--;
					}
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x>0&&j-z<0)
				{
					int check=j-1;
					for(int p=i+1; p<x;p++)
					{
						if(b.getPiece(p, check)!=null)
						{
							valid=false;
							return;
						}
						check--;
					}
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x<0&&j-z>0)
				{
					int check=j+1;
					for(int p=i-1; p>x;p--)
					{
						if(b.getPiece(p, check)!=null)
						{
							valid=false;
							return;
						}
						check++;
					}
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x<0&&j-z<0)
				{
					int check=j+1;
					for(int p=i+1; p<x;p++)
					{
						if(b.getPiece(p, check)!=null)
						{
							valid=false;
							return;
						}
						check++;
					}
					valid=true;
					Moved(i,j,x,z,b);
					return;
			}
			
			if(i-x==0 && j-z!=0)
			{
				for(int p=j; p<x;p++)
				{
					if(b.getPiece(i, p)!=null)
					{
						valid=false;
						return;
					}
				}
				for(int p=i; p<z;p++)
				{
					if(b.getPiece(p, j)!=null)
					{
						valid=false;
						return;
					}
				}
				
			Moved(i,j,x,z,b);
			return;
		}
			valid=false;
			return;
			}
			if(i-x!=0 && j-z==0)
			{
				for(int p=i+1; p<x;p++)
				{
					if(b.getPiece(p, j)!=null)
					{
						valid=false;
						return;
					}
				}
				Moved(i,j,x,z,b);
				return;
				
			}
			if(i-x==0 && j-z<0)
				{
				for(int p=j+1; p<z;p++)
				{
					if(b.getPiece(i, p)!=null)
					{
						valid=false;
						return;
					}
				}
					Moved(i,j,x,z,b);
					return;
				}
			if(i-x==0 && j-z>0)
			{				
			for(int p=j-1; p>z;p--)
			{
				if(b.getPiece(i, p)!=null)
				{
					valid=false;
					return;
				}
			}
				Moved(i,j,x,z,b);
				return;
			}
			valid=false;
			return;
			
		}
		public void moveKing(int i, int j, int x, int z, Board b)
		{
		
			if((i-x==1 && j-z==0) || (i-x==-1 && j-z==0) || (i-x==0 && j-z==1) || (i-x==0 && j-z==-1)|| (i-x==1 && j-z==1)|| (i-x==1 && j-z==-1)|| (i-x==-1 && j-z==1)|| (i-x==-1 && j-z==-1))
			{
				Moved(i,j,x,z,b);
				return;
			}
			else 
				valid=false;
				return;
		}
}
