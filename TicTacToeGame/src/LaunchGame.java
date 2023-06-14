import java.util.Random;
import java.util.Scanner;


class TicTacToe{
	
	static char[][] board = new char[3][3];      //by default character will store /u0000
	
	public TicTacToe() {
		init();
	}
	
	void init(){
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j]=' ';
			}
		}
	}
	
	void dispBoard() {
		System.out.println("-------------");
		for(int i=0; i<board.length; i++) {
			System.out.print("| ");
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	static void placeMark(int row, int col, char mark) {
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			board[row][col]=mark;
		}else {
			System.out.println("Invalid Position");
		}
	}
	
	static boolean checkColWin() {
		for(int j=0; j<=2; j++) {
			if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
				return true;
			}
		}
		return false;
		
	}
	static boolean checkRowWin() {
		for(int i=0; i<=2; i++) {
			if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
				return true;
			}
		}
		return false;
		
	}
	static boolean checkDiaWin() {
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
			return true;
		}
		return false;
		
	}
	
	static boolean checkDraw() {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}
	
		
}

abstract class Player{
	String name;
	char mark;
	abstract void makeMove();
	static boolean validMove(int row,int col) {
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			if(TicTacToe.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
}
class HumanPlayer extends Player{
	HumanPlayer(String name, char mark){
		this.name=name;
		this.mark=mark;
	}
	void makeMove() {
		int row,col;
		do {
			Scanner sc=new Scanner(System.in);
			row=sc.nextInt();
			col=sc.nextInt();
			
		}while(!validMove(row,col));
		TicTacToe.placeMark(row,col,mark);
	}
}

class AIPlayer extends Player{
	AIPlayer(String name, char mark){
		this.name=name;
		this.mark=mark;
	}
	void makeMove() {
		int row,col;
		do {
			Random r=new Random();
			row=r.nextInt();
			col=r.nextInt();
		}while(!validMove(row,col));
		TicTacToe.placeMark(row,col,mark);
	}
}






public class LaunchGame {

	public static void main(String[] args) {
		TicTacToe t =new TicTacToe();
		HumanPlayer p1=new HumanPlayer("Alice",'X');
		HumanPlayer p2=new HumanPlayer("Bob",'O');
		Player cp=p1;
		
		while(true) {
			System.out.println(cp.name+" turn");
			cp.makeMove();
			t.dispBoard();
			if(t.checkColWin() || t.checkRowWin() || t.checkDiaWin()) {
				System.out.println(cp.name+" has won!!");
				break;
			}else if(t.checkDraw()){
				System.out.println("The match is draw");
				break;
			}else {
				if(cp==p1) {
					cp=p2;
				}
				else {
					cp=p1;
				}
			}
		}
//		TicTacToe t =new TicTacToe();
//		
//		Scanner scan=new Scanner(System.in);
//		System.out.println("1.Play with Humans \n2.Play with AI");
//		int n=scan.nextInt();
//		scan.nextLine();
//		while(true) {
//			if(n==1) {
//				System.out.println("Enter name and mark(X OR O)of player1:");
//				String name1=scan.nextLine();
//				String mark1=scan.next();
//				char c1=mark1.charAt(0);
//				HumanPlayer p1=new HumanPlayer(name1,c1);
//				System.out.println("Enter name and mark(X OR O)of player2:");
//				String name2=scan.nextLine();
//				String mark2=scan.next();
//				char c2=mark2.charAt(0);
//				HumanPlayer p2=new HumanPlayer(name2,c1);
//			}else {
//				System.out.println("Enter name and mark(X OR O):");
//				String name1=scan.nextLine();
//				String mark1=scan.next();
//				char c1=mark1.charAt(0);
//				HumanPlayer p1=new HumanPlayer(name1,c1);
//				char ch;
//				if(c1=='O') {
//					ch='X';
//				}else {
//					ch='O';
//				}
//				AIPlayer p2=new AIPlayer("TAI",ch);
//				
//				
//			}
//			
//			Player cp=p1;
//			cp.makeMove();
//			t.dispBoard();
//			if(t.checkColWin() || t.checkRowWin() || t.checkDiaWin()) {
//				System.out.println(cp.name+"has won!!");
//				break;
//			}else if(t.checkDraw()){
//				System.out.println("The match is draw");
//				break;
//			}else {
//				if(cp==p1) {
//					cp=p2;
//				}
//				else {
//					cp=p1;
//				}
//			}
//			
//		}
//	
	}

}
