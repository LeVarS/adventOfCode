import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.NumberFormatException;

class CalorieProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fReader = openFile("calorie_list.txt");

        if (fReader != null) {
            int sum = 0;
            String line = "";

            ArrayList<Integer> arrayList = new ArrayList<Integer>();

            while (fReader.hasNextLine()) {
                line = fReader.nextLine();

                if (line.compareTo("") == 0) {

                    arrayList.add(sum);

                    sum = 0;
                } else {
                    try {
                        sum += Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println(line + " is not a valid Integer. Unable to add to sum.");
                        e.printStackTrace();
                        // 2 Status == Invalid Integer in input file
                        System.exit(2);
                    }
                }
            }
            
            arrayList.sort(Comparator.reverseOrder());
            System.out.println("The most calories being carrried by an elf is " + arrayList.get(0));

            // Part 2 Answer
            sum = 0;
            sum = arrayList.get(0) + arrayList.get(1) + arrayList.get(2);
            System.out.println("The amount calories being carried by the top 3 elves is " + sum);

            fReader.close();

        } else {
            // 1 Status == File Not Found
            System.exit(1);
        }
    }

    public static Scanner openFile(String fn) throws FileNotFoundException {
        Scanner fReader = null;

        try {
            fReader = new Scanner(new File(fn));
        } catch (FileNotFoundException e) {
            System.out.println(fn + " not found. Unable to open.");
            e.printStackTrace();
        }

        return fReader;
    }
}