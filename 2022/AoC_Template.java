import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ClassName {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fReader = openFile("filename.txt");

        if (fReader != null) {

            fReader.close();

        } else {
            // 1 Status == File Not Found
            System.exit(1);
        }
    }

    public static Scanner openFile(String fn) {
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