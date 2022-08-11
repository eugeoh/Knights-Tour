package com.knightstour;

public class Algorithm {

    private final int[][] solutionMatrix;
    private final int[] yMoves = {2, 2, 1, -1, -2, -2, -1, 1};
    private final int[] xMoves = {-1, 1, 2, 2, 1, -1, -2, -2};


    public Algorithm(){
        this.solutionMatrix = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        cleanBoard();
    }

    private void cleanBoard() {
        for(int i=0;i<Constants.BOARD_SIZE;i++){
            for(int j=0;j<Constants.BOARD_SIZE;j++){
                solutionMatrix[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void solveTour() {
        boolean solutionExists = solve(Constants.Y_START, Constants.X_START, 1);

        if (solutionExists){
            printBoard();
        }
        else{
            System.out.println("No solution.");
        }

    }

    private boolean solve(int yPos, int xPos, int moveNumber){
        solutionMatrix[yPos][xPos] = moveNumber;

        for(int m = 0; m <8;m++){
            int nextY = yPos + yMoves[m];
            int nextX = xPos + xMoves[m];

            if(inBounds(nextY, nextX) && unVisited(nextY, nextX)){
                moveNumber += 1;
                solve(nextY, nextX, moveNumber);
            }
        }

        return true;
    }

    private boolean inBounds(int nextY, int nextX) {
        return nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8;
    }

    private boolean unVisited(int nextY, int nextX) {
        return solutionMatrix[nextY][nextX] == Integer.MIN_VALUE;
    }

    private void printBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(solutionMatrix[j][i] + " ");
            }
            System.out.println();
        }
    }

}
