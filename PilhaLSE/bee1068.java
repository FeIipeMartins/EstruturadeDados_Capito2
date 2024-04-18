package PilhaLSE;

import PilhaLSE.PilhaPanasonic;
 
public class bee1068 {
    public static void main(String[] args) {
        String[] expressoes = { "a+(b*c)-2-a", "(a+b*(2-c)-2+a)*2", "(a*b-(2+c)", "2*(3-a))", ")3+b*(2-c)(" };
        for (String expressao : expressoes) {
            String resultado = verificarParenteses(expressao);
            System.out.println(resultado);
        }
    }
    public static String verificarParenteses(String expressao) {
        PilhaPanasonic pilha = new PilhaPanasonic();
        for (char c : expressao.toCharArray()) {
            if (c == '(') {
                pilha.push("(");
            } else if (c == ')') {
                if (pilha.isEmpty()) {
                    return "incorrect";
                }
                pilha.pop();
            }
        }
        if (pilha.isEmpty()) {
            return "correct";
        } else {
            return "incorrect";
        }
    }
}
