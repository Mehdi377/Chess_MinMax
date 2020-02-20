package chess;

import java.text.BreakIterator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	Board play;
	boolean white=true;
	boolean black=true;
	boolean checkmate=false;
  Scanner in= new Scanner(System.in);
  public Game()
	{
            
		Board play= new Board();
		playGame(white, play);
        }
	public Game(int num)
	{
            if(num==1){
		Board play= new Board();
		playGame(white, play);
            }
            else if(num==2){
                Board play= new Board();
		playGameB(black, play);
            }
	}
	
	public void playGame(boolean white, Board b){
		if(checkmate == false)
		{ 
			if(white==true)
			{
			
				System.out.printf("%nWhite Player make move%n");
				b.printBoard();
				System.out.printf("%nEnter piece initial location:\n");
                                String LocX;
                                String LocY;
				int initLocX=0;
				int initLocY=0;
				int ch1;
		       LocX=in.next();
		                LocY=in.next();
                                while(!isNumeric(LocX)&& !isNumeric(LocY) ){
                                    System.out.println("\nPlease enter int");
                                    LocX=in.next();
		                LocY=in.next();
                                }
                                if(isNumeric(LocX)&& isNumeric(LocY) ){
                                    initLocX=Integer.parseInt(LocX);
                                    initLocY=Integer.parseInt(LocY);
                                }

				if(initLocX>8 || initLocY>8 || initLocX<0 || initLocY<0 )
				{
					System.out.printf("%nMove was not made due to invalid input");
					playGame(true,b);
					return;
				}
				if(b.getPiece(initLocX, initLocY)==null||b.getPiece(initLocX, initLocY).getColor()!=true)
				{
					System.out.println("Invalid piece try again!");
					playGame(white, b);
					return;
				}
				System.out.print("Enter piece destination:\n");
                                String destX,destY;
				int destLocX=0;
                                int destLocY=0;
                                destX=in.next();
		                destY=in.next();
                                while(!isNumeric(destX)&& !isNumeric(destY) ){
                                    System.out.println("\nPlease enter int");
                                    destX=in.next();
		                destY=in.next();
                                }
                                if(isNumeric(destX)&& isNumeric(destY) ){
                                    destLocX=Integer.parseInt(destX);
                                    destLocY=Integer.parseInt(destY);
                                }
				
                                //حرکت مهره 
				moveVerify v= new moveVerify(initLocX, initLocY, destLocX, destLocY, white, b);
				Board check=v.changedBoard();
				if(b.getPiece(initLocX, initLocY)!=null)
				{
					System.out.printf("%nMove was not made due to invalid input");
					playGame(true,b);
					return;
				}
				else
				{
                                    //جابه جایی مهره انجام شده
					System.out.printf("%nMove was made next player");
					playGame(false,b);
					return;
				}	
			}
			if(white==false)
			{
//                            نوبت مهره ی حریف است که مهره ی ود را جابهجا کند
				System.out.printf("%nBlack Player make move%n");
				b.printBoard();
				MinMax a=new MinMax();
				a.MiniMax(3,false, b,true,20);
				a.getFinalBoard();
				playGame(true,a.getFinalBoard());
				return;
			}
		}
	}
        
//        برای وقتی که رنگ مهره رو سیاه انتخاب کرده باشیم
//        مثل متد بالاست هیچ فرقی نداره
        public void playGameB(boolean black, Board b){
		
		if(checkmate == false)
		{
			if(black==true)
			{
			
				System.out.printf("%nblack Player make move%n");
				b.printBoard();
				System.out.printf("%nEnter piece initial location:");
                                String LocX, LocY;
				int initLocX=0;
				int initLocY=0;
				int ch1;
		         LocX=in.next();
		                LocY=in.next();
                                while(!isNumeric(LocX)&& !isNumeric(LocY) ){
                                    System.out.println("\nPlease enter int");
                                    LocX=in.next();
		                LocY=in.next();
                                }
                                if(isNumeric(LocX)&& isNumeric(LocY) ){
                                    initLocX=Integer.parseInt(LocX);
                                    initLocY=Integer.parseInt(LocY);
                                }

				if(initLocX>8 || initLocY>8 || initLocX<0 || initLocY<0 )
				{
					System.out.printf("%nMove was not made due to invalid input");
					playGameB(true,b);
					return;
				}
				
				if(b.getPiece(initLocX, initLocY)==null||b.getPiece(initLocX, initLocY).getColor()!=true)
				{
					System.out.println("Invalid piece try again!");
					playGameB(black, b);
					return;
				}
				System.out.println("Enter piece destination:");
                                String destX,destY;
				int destLocX=0;
                                int destLocY=0;
                                destX=in.next();
		                destY=in.next();
                                while(!isNumeric(destX)&& !isNumeric(destY) ){
                                    System.out.println("\nPlease enter int");
                                    destX=in.next();
		                destY=in.next();
                                }
                                if(isNumeric(destX)&& isNumeric(destY) ){
                                    destLocX=Integer.parseInt(destX);
                                    destLocY=Integer.parseInt(destY);
                                }

				moveVerify v= new moveVerify(initLocX, initLocY, destLocX, destLocY, white, b);
				Board check=v.changedBoard();
				if(b.getPiece(initLocX, initLocY)!=null)
				{
					System.out.printf("%nMove was not made due to invalid input");
					playGameB(true,b);
					return;
				}
				else
				{
					System.out.printf("%nMove was made next player");
					playGameB(false,b);
					return;
				}	
			}
			if(black==false)
			{
				System.out.printf("%nWhite Player make move%n");
				b.printBoard();
				MinMax a=new MinMax();
				a.MiniMax(3,false, b,true,20);
				a.getFinalBoard();
				playGameB(true,a.getFinalBoard());
				return;
			}
		}
	}
        public static boolean isNumeric(String str)
{
    for (char c : str.toCharArray())
    {
        if (!Character.isDigit(c)) return false;
    }
    return true;

}
}
