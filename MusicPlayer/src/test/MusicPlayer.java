package test;
import java.util.*;
public class MusicPlayer {

	public static Scanner s = new Scanner(System.in);
	
	public static void go()
	{
		Player p = new Player();
		System.out.println("*Welcome to Music Player* \nSelect : ");
		while(true)
		{
			System.out.println("1 : Play list");
			System.out.println("2 : Add Song");
			System.out.println("3 : Edit Song");
			System.out.println("4 : Delete Song \n");
			
			int choice = s.nextInt();
			
			switch(choice)
			{
			case 1 :
				System.out.println("Playing Songs");
				Player.play();
				break;
			case 2 :
				System.out.println("Adding Song");
				break;
			case 3 :
				System.out.println("Editing Song");
				break;
			case 4 : 
				System.out.println("Deleting Song");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		go();
	}

}
