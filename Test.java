package chess;
import java.util.Scanner;
public class Test 
{
	public static void main(String[] args) 
  {
        System.out.println("\n"+"\033[1;35m"+"***          Hello Player      ***"+"\033[0m");
        System.out.println(" choos your color in chess game \n (1).White\n (2).Black\n\n\n*for choose the piece you should enter like :\nExample : 0 1");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
		    Game test = new Game(n);
	}

}
