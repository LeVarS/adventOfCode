import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

class StrategyProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fReader = openFile("strategy.txt");

        if (fReader != null) {
            Hashtable<String, Integer> dict = new Hashtable<String, Integer>();
            int score = 0, result = 0, oppShape, myShape;

            // Populate dictionary
            dict.put("A", 1); // Rock
            dict.put("B", 2); // Paper
            dict.put("C", 3); // Scissors
            dict.put("X", 1); // Rock
            dict.put("Y", 2); // Paper
            dict.put("Z", 3); // Scissors


            String line = "";
            String[] lineArr;
            while (fReader.hasNext()) {
                line = fReader.nextLine();
                lineArr = line.split(" ");

                oppShape = dict.get(lineArr[0]);
                myShape = dict.get(lineArr[1]);
                result = oppShape - myShape; // Integer.compare(oppShape, myShape);

                switch (result) {
                    case 0: // Draw
                        score += (3 + myShape);
                        break;
                    case 2: // My Rock beat Opponent's Scissors
                        score += (6 + myShape);
                        break;
                    case -1: // My Scissors beat Opponent's Paper || My Paper beat Opponent's Rock
                        score += (6 + myShape);
                        break;
                    default: // All possible ways for me to lose. Possible values of 'result' is 1 or -2
                        score += myShape;
                        break;
                }
            }

            System.out.println("The total score is " + score);

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