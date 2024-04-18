package PilhaTemplete;

import java.util.Scanner;

public class bee1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaDuracell<Character> pilha = new PilhaDuracell<>();
        while (scanner.hasNext()) {
            String expressao = scanner.next();
            pilha = new PilhaDuracell<>();
            int tam = expressao.length();
            int i;
            for (i = 0; i < tam; ++i) {
                if (expressao.charAt(i) == '(') {
                    pilha.push('(');
                } else if (expressao.charAt(i) == ')') {
                    if (pilha.isEmpty()) break;
                    else pilha.pop();
                }
            }
            if (i == tam && pilha.isEmpty()) System.out.println("correct");
            else System.out.println("incorrect");
        }
    }
}