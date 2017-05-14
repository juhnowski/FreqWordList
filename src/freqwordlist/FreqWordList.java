/*
 * This program convert data file of Frequency of mentioning words in dictionaries
 * to javascript file.
 */
package freqwordlist;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilya
 */
public class FreqWordList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File f = new File("word_frequency.js");
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FreqWordList.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (
                FileInputStream inputStream = new FileInputStream("data.txt");
                Scanner sc = new Scanner(inputStream, "UTF-8");
                OutputStream fos = new FileOutputStream("word_frequency.js");
                OutputStreamWriter osr = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
                BufferedWriter bw = new BufferedWriter(osr);) {
            StringBuilder sb = new StringBuilder();
            String class_wrapper
                    = "class FreqWordList { "
                    + " constructor() {"
                    + "   this.version = 1;"
                    + " }";
            sb.append(class_wrapper);
            sb.append("fill() {");

            int i = 0;
            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                i++;

                String[] sarray = line.split(",");
                String word = sarray[0];
                if (word.length() > 0) {
                    sb.append("localStorage.setItem(\"");
                    sb.append(sarray[0]);
                    sb.append("\", \"");
                    int stringTokenizer = new StringTokenizer(" " + line + " ", ";").countTokens() - 1;
                    sb.append(stringTokenizer);
                    sb.append("\");");
                    bw.append(sb.toString());
                    bw.newLine();
                    bw.flush();
                    sb = new StringBuilder();
                }
            }
            sb.append("}}");
            bw.append(sb.toString());
            bw.newLine();
            osr.flush();
            System.out.println("Has been added: " + i + " words.");

            if (sc.ioException() != null) {
                throw sc.ioException();
            }

        } catch (IOException ex) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Please check that data.txt exist");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Logger.getLogger(FreqWordList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
