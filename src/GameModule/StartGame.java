package GameModule;

import java.util.Scanner;

@SuppressWarnings("serial")
class StartGame extends InitializeBoard{  
	public static int player1WonMatch=0;
	public static int player2WonMatch=0;
	public static String player1Name;
	public static String player2Name;
	
	public static void main(String args[]){  
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Players Name:");
		player1Name=sc.nextLine();
		player2Name=sc.nextLine();
		new InitializeBoard();  
		sc.close();
	}} 