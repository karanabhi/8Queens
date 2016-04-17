
import java.util.Scanner;

/**
 *
 * @author Abhishek Karan, Shashank Gaurav
 */
public class Queen8 {

    int board[][], visited[][];
    int i, j, k, num1, num2, x, y, z, count, atkpair, nonatkpair, countcol, countrow, l, m, finalcount;

    Queen8() {
        l = m = countrow = countcol = nonatkpair = atkpair = count = i = j = k = num1 = num2 = x = y = z = 0;

        board = new int[8][8];
        visited = new int[200][2];
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }
    }//const

    void showBoard(String status) {
        System.out.println(status);
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println("");
        }
    }//showBoard()

    public static void main(String[] args) {
        Queen8 q8 = new Queen8();
        q8.takeInputs();
        q8.checkControl();
    }//main()

    void checkControl() {
        placeQueenOnBoard();
        countAttackingPairs();
    }//checkControl()

    int generateRandomNum() {
        this.z = (int) (Math.random() * 10);
        if (this.z > 7) {
            this.z /= 7;
        }
        return this.z;
    }//generate_Random_Num

    void placeQueenOnBoard() {
        this.k = 0;
        while (this.k < 8) {
            this.x = generateRandomNum();
            this.y = generateRandomNum();
            //System.out.println(x + "," + y);
            if (checkBoard(this.x, this.y) == false) {
                board[x][y] = 8;
                this.k++;
            }
        }
        showBoard("After Queens Assigned");

    }//placeQueenOnBoard

    boolean checkBoard(int key1, int key2) {
        return board[key1][key2] == 8;
    }//checkBoard

    int chkRow(int row) {
        countrow = 0;
        for (i = 0; i < 8; i++) {
            if (board[row][i] == 8) {
                if (checkvisitedNode(row, i) == false) {
                    //System.out.println("Row: " + row + ", " + i);
                    countrow++;
                }
            }
        }
        return countrow;
    }//chkRow

    int chkCol(int col) {
        countcol = 0;
        for (i = 0; i < 8; i++) {
            if (board[i][col] == 8) {
                if (checkvisitedNode(i, col) == false) {
                    //System.out.println("Col: " + i + ", " + col);
                    countcol++;
                }
            }
        }
        return countcol;
    }//chkRow

    void countAttackingPairs() {

        for (this.j = 0; this.j < 8; this.j++) {
            for (this.k = 0; this.k < 8; this.k++) {
                if (board[this.j][this.k] == 8) {
                    atkpair += chkRow(this.j);
                    atkpair += chkCol(this.k);
                }
            }
        }
        //atkpair = atkpair / 2;
        System.out.println("Attacking Pair=" + atkpair);
        if (finalcount != atkpair) {
            atkpair = 0;
            checkControl();
        }

    }//countAttackingPairs()

    boolean checkvisitedNode(int key1, int key2) {

        for (z = 0; z < visited.length; z++) {
            if (visited[z][0] == key1 && visited[z][1] == key2) {
                return true;
            }
        }
        visited[m][0] = key1;
        visited[m][1] = key2;
        //System.out.println("Visited Nodes: " + visited[m][0] + "," + visited[m][1]);
        m++;
        return false;
    }//visitedBoard()

    void takeInputs() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Count of Attacking Pairs:");
        finalcount = sc.nextInt();
    }//takeInputs()

}//class

