/**
 * Created by ??????? on 23.09.2015.
 */
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by bpali on 12.09.2015.
 */
public class Main {

    static void generate(int a, int b, int mass[][]){
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                Random rand = new Random();
               mass[i][k] = rand.nextInt(2);
            }
        }
    }
    static void showMass(int a, int b, int mass[][]){
        for (int i = 0; i < a; i++) {
            System.out.println();
            for (int k = 0; k < b; k++) {
                System.out.print(mass[i][k]);
            }
        }
    }
   static int countArrayIslands(int a, int b, int[][] mass){
       return  countHorizontal(a,b,mass) +countStartHorizontal(a,mass) + countStartVertical(b,mass) + countVertical(a,b,mass);
   }

    static int countStartHorizontal(int a,int[][] mass) {
        int count = 0;
        for (int i = 0; i < a; i++) {
            if ((mass[i][0] == 1) && mass[i][1] == 1) {
                count = count + 1;
            }
        }
        return count;
    }

    static int  countHorizontal(int a,int b, int[][] mass)
    {
        int count =0;
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b - 2; k++) {
                if ((((mass[i][k]) == 0) && ((mass[i][k + 1]) == 1) && ((mass[i][k + 2]) == 1) )) {
                    count++;
                }
            }
        }
        return count;
    }
    static int  countVertical(int a,int b, int[][] mass)
    {
        int count =0;
        for (int i = 0; i < b-2; i++) {
            for (int k = 0; k < a; k++) {

                if ((((mass[i][k]) == 0) && ((mass[i+1][k]) == 1) && ((mass[i+2][k ]) == 1) )) {
                    count++;
                }
            }
        }
        return count;
    }

    static int countStartVertical(int b,int[][] mass) {
        int count = 0;

        for (int i = 0; i < b; i++) {

//
            if ((mass[0][i] == 1) && mass[1][i] == 1) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть кількість рядків массиву:");
        int a = sc.nextInt();
        System.out.println("Введіть кількість стовпців массиву:");
        int b = sc.nextInt();
        int[][] mass = new int[a][b];
        generate(a,b,mass);
        showMass(a, b, mass);
        int count = countArrayIslands(a,b,mass);
        System.out.println();
        System.out.println("Кількість островів: " + count);

        }
    }

