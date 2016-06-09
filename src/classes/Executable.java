package classes;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Laba3
 * Created 5/27/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Executable {
    private static final String FILE_NAME = "code_dummy.txt";

    public static void main(String[] args) throws Exception {
        //считываем данные
        String bitString = merge(Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8));
        int[] bits = parseBits(bitString);
        //характеристические полиномы регистров
//        long polynomialL1 = 0b100000000000000000000001010011;
//        long polynomialL2 = 0b1000000000000000000000000001001;
//        long polynomialL3 = 0b10000000000000000000000010101111;
        long polynomialL1 = 0b10000000000000000000001001;
        long polynomialL2 = 0b100000000000000000001000111;
        long polynomialL3 = 0b1000000000000000000000100111;

        GeffeCryptanalysis.breakGeffe(polynomialL1, polynomialL2, polynomialL3, bits);
    }



    private static int[] parseBits(String bitString) {
        int[] bits = new int[bitString.length()];
        for (int i = 0; i < bits.length; i++) {
            char bit = bitString.charAt(i);
            if (bit == '0') {
                bits[i] = 0;
            } else if (bit == '1') {
                bits[i] = 1;
            } else {
                throw new IllegalArgumentException("Unexpected character: " + bit);
            }
        }
        return bits;
    }

    private static String merge(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        lines.forEach(builder::append);
        return builder.toString();
    }
}
