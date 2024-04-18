package Stackjava;

import java.util.Scanner;
import java.util.Stack;

public class bee1077 {
    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); 
        for (int k = 0; k < N; ++k) {
            String expressao = scanner.nextLine();
            int tam = expressao.length();
            Stack<Character> pilha = new Stack<>();
            for (int i = 0; i < tam; ++i) {
                char c = expressao.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    System.out.print(c);
                } else if (c == '(' || c == '^') {
                    pilha.push(c);
                } else if (c == ')') {
                    while (!pilha.isEmpty() && pilha.peek() != '(') {
                        System.out.print(pilha.pop());
                    }
                    if (!pilha.isEmpty()) pilha.pop();
                } else {
                    while (!pilha.isEmpty() && pilha.peek() != '(' && precedencia(c) <= precedencia(pilha.peek())) {
                        System.out.print(pilha.pop());
                    }
                    pilha.push(c);
                }
            }
            while (!pilha.isEmpty()) {
                System.out.print(pilha.pop());
            }
            System.out.println();
        }
    }
}
