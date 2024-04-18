package PilhaTemplete;

import java.util.Scanner;

public class bee1062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int N = scanner.nextInt();
            if (N == 0) break;
            while (true) {
                PilhaDuracell<Integer> A = new PilhaDuracell<>();
                PilhaDuracell<Integer> estacao = new PilhaDuracell<>();
                PilhaDuracell<Integer> B = new PilhaDuracell<>();
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
                while (!A.isEmpty() || !estacao.isEmpty() || !B.isEmpty()) {
                    if (!A.isEmpty() && !B.isEmpty() && A.peek().equals(B.peek())) {
                        A.pop();
                        B.pop();
                    } else if (!estacao.isEmpty() && !B.isEmpty() && estacao.peek().equals(B.peek())) {
                        estacao.pop();
                        B.pop();
                    } else if (!A.isEmpty()) {
                        estacao.push(A.pop());
                    } else {
                        break;
                    }
                }
                if (A.isEmpty() && estacao.isEmpty() && B.isEmpty()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}

