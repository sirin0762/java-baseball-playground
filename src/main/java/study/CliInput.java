package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CliInput implements Input {
    @Override
    public String input(String order) throws IOException {
        System.out.print(order);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
