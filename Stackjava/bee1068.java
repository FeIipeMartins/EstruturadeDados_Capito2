package Stackjava;

import java.util.Scanner;
import java.util.Stack;

public class bee1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> pilha = new Stack<>();
        while (scanner.hasNext()) {
            String expressao = scanner.next();
            pilha.clear();
            int tam = expressao.length();
            int i;
            for (i = 0; i < tam; ++i) {
                if (expressao.charAt(i) == '(') {
                    pilha.push('(');
                } else if (expressao.charAt(i) == ')') {
                    if (pilha.empty()) break;
                    else pilha.pop();
                }
            }
            if (i == tam && pilha.empty()) System.out.println("correct");
            else System.out.println("incorrect");
        }
    }
}
