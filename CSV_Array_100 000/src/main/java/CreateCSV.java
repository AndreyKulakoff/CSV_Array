import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class CreateCSV {
    static int x;
    static int y;

    static int[] oneArray;
    static int q;


    public static void writeLine() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("D:\\csv\\Example_1000"));
        Scanner in = new Scanner(System.in);
        System.out.println("Введи ширину массива  ");
        x = in.nextInt();
        System.out.println("Введи количество строк ");
        y = in.nextInt();

        System.out.println("Введи диапазон случайных чисел: ");
        q = in.nextInt();
        oneArray = new int[x];
        Random rand = new Random();
        int count = 0;

        while (count < y) {
            for (int i = 0; i < oneArray.length; i++) {

                oneArray[i] = rand.nextInt(q);
                printWriter.write(String.valueOf(oneArray[i]));
                printWriter.write(" ");
            }
            count += 1;

            System.out.println("create - " + count);
            printWriter.write("\r\n");
        }

        printWriter.flush();
    }
}
