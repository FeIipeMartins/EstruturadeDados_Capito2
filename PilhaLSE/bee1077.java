package PilhaLSE;

import java.util.Scanner;

import PilhaLSE.PilhaPanasonic;

public class bee1077 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String infix = scanner.nextLine();
            String postfix = infixParaPosfixa(infix);
            System.out.println(postfix);
        }
        scanner.close();
    }
    public static String infixParaPosfixa(String expressao) {
        StringBuilder saida = new StringBuilder();
        PilhaPanasonic pilha = new PilhaPanasonic();
        for (char c : expressao.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                saida.append(c);
            } else if (c == '(') {
                pilha.push("(");
            } else if (c == ')') {
                while (!pilha.isEmpty() && !pilha.peek().equals("(")) {
                    saida.append(pilha.pop());
                }
                pilha.pop(); 
            } else {  
                while (!pilha.isEmpty() && precedencia(pilha.peek()) >= precedencia(String.valueOf(c))) {
                    saida.append(pilha.pop());
                }
                pilha.push(String.valueOf(c));
            }
        }
        while (!pilha.isEmpty()) {
            saida.append(pilha.pop());
        }
        return saida.toString();
    }
    public static int precedencia(String operador) {
        if (operador.equals("^")) {
            return 3;
        } else if (operador.equals("*") || operador.equals("/")) {
            return 2;
        } else if (operador.equals("+") || operador.equals("-")) {
            return 1;
        } else {
            return 0;
        }
    }
}
