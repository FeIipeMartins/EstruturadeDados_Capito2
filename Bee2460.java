package Filas;

import java.util.Scanner;

public class Bee2460 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Dequee<Integer> fila = new Dequee<>();
        for (int i = 0; i < N; i++) {
            int identificador = scanner.nextInt();
            fila.addLast(identificador);
        }
        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int identificadorSaiu = scanner.nextInt();
            fila.removeFirstOccurrence(identificadorSaiu);
        }
        fila.printDeque();
        scanner.close();
    }
}
