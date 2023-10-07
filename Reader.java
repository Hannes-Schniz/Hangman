import java.io.*;
import java.util.Random;

public class Reader {

    private static File file = new File(new File("").getAbsolutePath().concat("/words.txt"));

    private static int seed;

    public static String getRandomLine() throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(file));

        int randomNumber = new Random(seed).nextInt(100000);

        while (randomNumber > 0) {
            String line = br.readLine();
            if (line == null) {
                br.close();
                br = new BufferedReader(new FileReader(file));
            }
            randomNumber--;
        }

        return br.readLine();
    }

    public static int setSeed() {
        seed = new Random().nextInt();
        return seed;
    }

    public static void setSeed(int seed) {
        Reader.seed = seed;
    }

    public static void switchToGerman() {
        file = new File(new File("").getAbsolutePath().concat("/wordlist-german.txt"));
    }
}
