import java.io.*;
import java.util.*;

public class Stack1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String expression = br.readLine();
        double[] values = new double[n];
        
        for (int i = 0; i < n; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        int v = 0;
        for(int j = 0; j < expression.length(); j++) {
            char ch = expression.charAt(j);
            // 알파벳
            if(ch >= 'A' && ch <= 'Z') {
                stack.push(values[expression.charAt(j)-'A']);
            } else {
                double d1 = stack.pop();
                double d2 = stack.pop();
                double d3 = 0.0;
                switch(ch) {
                    case '+' :
                        d3 = d2 + d1;
                        break;
                    case '-' :
                        d3 = d2 - d1;
                        break;
                    case '*' :
                        d3 = d2 * d1;
                        break;
                    case '/' :
                        d3 = d2 / d1;
                        break;
                }
                stack.push(d3);
            }
            System.out.println(stack);
        }

        System.out.printf("%.2f", stack.pop());
    }
}