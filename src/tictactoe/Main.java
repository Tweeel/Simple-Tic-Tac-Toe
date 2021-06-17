package tictactoe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char[][] xo = new char[3][3];
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        int index1=0;
        int index2=0;
        int test = 0;
        afficher_mat(xo);
        Scanner scanner = new Scanner(System.in);
        boolean result=true;

        while (result) {
            test=0;
            while (test == 0) {
                index1 = scanner.nextInt();
                index2 = scanner.nextInt();
                if (index1 > 3 || index2 > 3) System.out.println("Coordinates should be from 1 to 3!");
                else if (xo[index1 - 1][index2 - 1] == 'X' || xo[index1 - 1][index2 - 1] == 'O')
                    System.out.println("This cell s occupied! Choose another one!");
                else {
                    xo[index1 - 1][index2 - 1] = 'X';
                    test++;
                }
            }
            afficher_mat(xo);
            fill(index1,index2,player1);
            result=check_winner(xo, player1, player2);
            if(result==false) System.exit(0);

            test = 0;
            while (test == 0) {
                index1 = scanner.nextInt();
                index2 = scanner.nextInt();
                if (index1 > 3 || index2 > 3) System.out.println("Coordinates should be from 1 to 3!");
                else if (xo[index1 - 1][index2 - 1] == 'X' || xo[index1 - 1][index2 - 1] == 'O')
                    System.out.println("This cell s occupied! Choose another one!");
                else {
                    xo[index1 - 1][index2 - 1] = 'O';
                    test++;
                }
            }
            afficher_mat(xo);
            fill(index1,index2,player2);
            result=check_winner(xo, player1, player2);
            if(result==false) System.exit(0);

        }

    }

    public static void afficher_mat(char[][] xo) {
        System.out.println("---------");
        for (char[] chars : xo) {
            System.out.print("|");
            for (char aChar : chars) {
                System.out.print(" " + aChar);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public static boolean check_winner(char[][] xo, List<Integer> player1, List<Integer> player2) {

        List<Integer> toprow = Arrays.asList(1, 2, 3);
        List<Integer> midrow = Arrays.asList(4, 5, 6);
        List<Integer> botrow = Arrays.asList(7, 8, 9);
        List<Integer> leftcol = Arrays.asList(1, 4, 7);
        List<Integer> midcol = Arrays.asList(2, 5, 8);
        List<Integer> rightcol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<>();
        winning.add(toprow);
        winning.add(midrow);
        winning.add(botrow);
        winning.add(leftcol);
        winning.add(midcol);
        winning.add(rightcol);
        winning.add(cross1);
        winning.add(cross2);
        int conteur1 = 0;
        int conteur2 = 0;
        for(List l: winning)
        {
            if(player1.containsAll(l)) conteur1++;
            else if(player2.containsAll(l)) conteur2++;
        }

        if (player1.size() - player2.size() > 1 || player2.size() - player1.size() > 1) {
            System.out.println("Impossible");
            System.exit(0);
        } else if (conteur1 == 1) {
            System.out.println("X wins");
            return false;
        } else if (conteur2 == 1) {
            System.out.println("O wins");
            return false;
        } else if (player1.size() + player2.size() <9) {
            return true;
        } else if (conteur1 == 0 && conteur2 == 0) {
            System.out.println("Draw");
            return false;
        }
        return true;
    }

    public static void fill(int i,int j,List<Integer> player){
        int index = 0;
        if      (i == 1 && j == 1) index = 1;
        else if (i == 1 && j == 2) index = 2;
        else if (i == 1 && j == 3) index = 3;
        else if (i == 2 && j == 1) index = 4;
        else if (i == 2 && j == 2) index = 5;
        else if (i == 2 && j == 3) index = 6;
        else if (i == 3 && j == 1) index = 7;
        else if (i == 3 && j == 2) index = 8;
        else if (i == 3 && j == 3) index = 9;
        player.add(index);
    }
}