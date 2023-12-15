import java.util.*;
public class tictactoe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row= 0; row<board.length; row++){
            for( int col = 0; col < board[row].length; col++){
                board[row][col]='_';


            }
        }

        char player ='X';
        boolean GameOver = false;

        Scanner Input = new Scanner(System.in);

        while(!GameOver){
            PrintBoard(board);
                System.out.println("Please Enter The Row And Column following the below format:\n0,0   0,1   0,2 \n1,0   1,1   1,2\n2,0   2,1   2,2\n\nPlease Enter the Row First and then the Column:");
                int row = Input.nextInt();
                int column = Input.nextInt();

                if(board[row][column]== '_'){
                    board[row][column]=player;
                    GameOver = HaveWon(board, player);
                    if(GameOver){
                        System.out.println("player" + player + "has won");
                    }
                    else{
                        if(player=='X'){
                            player = 'O';
                        }
                        else{
                            player = 'X';
                        }
                    }
                }
                else{
                    System.out.println("Space already Occupied. Please enter new Location");
                }
        }
        PrintBoard(board);

    }


    public static void PrintBoard(char[][] board){
         for(int row= 0; row<board.length; row++){
            for( int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col]+" ");
            }
                System.out.println();
        }

    }

    public static boolean HaveWon(char[][] board, char player){
        //check rows
        for(int row= 0; row<board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            } 
        }
        
        //check column
        for(int col= 0; col<board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            } 
        }

        //check diagonal
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }

        
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }

    
}
