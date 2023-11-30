public class TicTacToe{
    private boolean gameInProgress;
    private char[][] board;
    private char currentPlayer;
    
    
    public TicTacToe(){
        this.gameInProgress = true;
        this.currentPlayer = 'X';
        this.board = new char[3][3];
        for (int i=0; i<3;i++){
            for (int j=0; j<3;j++){
                this.board[j][i] = '-';
            }
        }
    }
    
    public void displayBoard() {
        System.out.println("Game Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[j][i]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[] getUserMove(){
        int[] liste = new int[2];
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Player "+this.currentPlayer+", please enter row (0-2) and column (0-2):");
        int line = scanner.nextInt();
        int column = scanner.nextInt();
        
        liste[0] = line;
        liste[1] = column;
        
        return liste;
    }

    public void makeMove(int row, int col){
        if (row>=3 || row<0 || col>=3 || col<0 || this.board[row][col] != '-'){
            System.out.println("Invalid move. Please try again.");
        }
        else{
            this.board[row][col] = this.currentPlayer;
            if (this.currentPlayer == 'X'){
                this.currentPlayer = 'O';
            }
            else{
                this.currentPlayer = 'X';
            }
        }
    }
    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (this.board[i][0] == player && this.board[i][1] == player && this.board[i][2] == player) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (this.board[0][j] == player && this.board[1][j] == player && this.board[2][j] == player) {
                return true;
            }
        }
        if (this.board[0][0] == player && this.board[1][1] == player && this.board[2][2] == player) {
            return true;
        }
        if (this.board[0][2] == player && this.board[1][1] == player && this.board[2][0] == player) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isDraw(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(this.board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isGameOver(){
        return checkWin('X') || checkWin('O') || isDraw();
    }
    public void congratulation(){
        if (checkWin('X')){
            System.out.println("Player X wins!");
        }
        else if (checkWin('O')){
            System.out.println("Player O wins!");
        }
        else{
            System.out.println("It's a draw!");
        }
    }
    public void play(){
        displayBoard();
        while(this.gameInProgress){
            int[] liste = getUserMove();
            makeMove(liste[0], liste[1]);
            displayBoard();
            
            if(isGameOver()){
                this.gameInProgress = false;
            }
        }
    }
}
