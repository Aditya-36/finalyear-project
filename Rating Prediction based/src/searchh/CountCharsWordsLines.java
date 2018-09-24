package searchh;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class CountCharsWordsLines {
    public static long[] count(String filename) throws IOException {
        long[] counts = new long[3];
        try(InputStream in = new FileInputStream("D:\\loadd\\users.txt");
            Reader reader = new InputStreamReader(in, Charset.forName(","));
            Reader buffer = new BufferedReader(reader)
        ) {
            int c;
            String newLineChar = System.lineSeparator();
            while((c = reader.read()) != -1) {
                char character = (char) c;
                if(character == '\n') {
                    counts[2]++;
                    counts[1]++;
                    counts[0]++;
                } else if(Character.isWhitespace(character)) {
                    counts[1]++;
                    counts[0]++;
                } else {
                    counts[0]++;
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            throw new IllegalArgumentException();
        }
        long[] counts = count(args[0]);
        System.out.printf("Chars: %d; Words: %d; Lines: %d;\n", counts[0], counts[1], counts[2]);
    }
}