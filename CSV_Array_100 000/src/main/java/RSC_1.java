import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

import java.util.stream.IntStream;

public class RSC_1 {
    public static void writeLine() throws IOException, CsvValidationException {
        PrintWriter printWriter = new PrintWriter(new File("D:\\csv\\Example_1000_sort"));
        CSVReader csvReader = new CSVReader(new FileReader("D:\\csv\\Example_1000"));
        String[] nextRecord;
        int count_row = 1;
        while ((nextRecord = csvReader.readNext()) != null) {
            for (String cell : nextRecord) {
                int[] numArr = Arrays.stream(cell.split(" ")).mapToInt(Integer::parseInt).toArray();
                if (count_row % 2 != 0) {
                    //System.out.print(cell +"- строка "+count_row);
                    Arrays.sort(numArr);
                    for (int i = 0; i < numArr.length; i++) {
                        printWriter.write(String.valueOf(numArr[i]));
                        printWriter.write(" ");
                    }
                    printWriter.write("\r\n");
                   // System.out.println(Arrays.toString(numArr) + "- строка " + count_row);
                } else {
                    Integer[] numArrInteger = IntStream.of(numArr).boxed().toArray(Integer[]::new);
                    Arrays.sort(numArrInteger, Collections.reverseOrder());
                    for (int i = 0; i < numArrInteger.length; i++) {
                        printWriter.write(String.valueOf(numArrInteger[i]));
                        printWriter.write(" ");
                    }
                    printWriter.write("\r\n");
                    //System.out.println(Arrays.toString(numArrInteger) + "- строка " + count_row);
                }
            }
            System.out.println("sort-"+count_row);
            count_row += 1;

        }
        printWriter.flush();
    }
}
