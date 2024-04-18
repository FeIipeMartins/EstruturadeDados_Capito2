package Stackjava;

import java.util.Scanner;
import java.util.Stack;

public class bee1062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int N = scanner.nextInt();
            if (N == 0) break;
            while (true) {
                Stack<Integer> A = new Stack<>();
                Stack<Integer> estacao = new Stack<>();
                Stack<Integer> B = new Stack<>();
                int x = scanner.nextInt();
                if (x == 0) {
                    System.out.println();
                    break;
                }
                A.push(x);
                B.push(1);
                for (int i = 2; i <= N; ++i) {
                    x = scanner.nextInt();
                    A.push(x);
                    B.push(i);
                }
                while (!A.empty() || !estacao.empty() || !B.empty()) {
                    if (!A.empty() && !B.empty() && A.peek().equals(B.peek())) {
                        A.pop();
                        B.pop();
                    } else if (!estacao.empty() && !B.empty() && estacao.peek().equals(B.peek())) {
                        estacao.pop();
                        B.pop();
                    } else if (!A.empty()) {
                        estacao.push(A.pop());
                    } else {
                        break;
                    }
                }
                if (A.empty() && estacao.empty() && B.empty()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
