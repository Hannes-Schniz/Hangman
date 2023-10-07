import java.io.*;
import java.util.Random;

public class Reader {

    private static final File file = new File(new File("").getAbsolutePath().concat("/words.txt"));

    public static String getRandomLine() throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(file));

        int randomNumber = new Random().nextInt(999);

        for (int i = 0; i < randomNumber; i++) {
            br.readLine();
        }

        return br.readLine();
    }
}
