package Filas;

import java.util.Comparator;
import java.util.Scanner;

public class Bee1548 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casosTeste = scanner.nextInt();
        for (int i = 0; i < casosTeste; i++) {
            int numAlunos = scanner.nextInt();
            Dequee<Integer> fila = new Dequee<>();
            Dequee<Integer> filaOrdenada = new Dequee<>();
            for (int j = 0; j < numAlunos; j++) {
                int nota = scanner.nextInt();
                fila.addLast(nota);
                filaOrdenada.addLast(nota);
            }
            filaOrdenada.sort(Comparator.reverseOrder());
            int alunosSemTroca = 0;
            while (!fila.isEmpty()) {
                Integer notaOriginal = fila.removeFirst();
                Integer notaOrdenada = filaOrdenada.removeFirst();
                if (notaOriginal.equals(notaOrdenada)) {
                    alunosSemTroca++;
                }
            }
            System.out.println(alunosSemTroca);
        }
        scanner.close();
    }
}
