package PilhaLSE;

import java.util.Scanner;

import PilhaLSE.PilhaPanasonic;

public class bee1062 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int N = scanner.nextInt();
			if (N == 0) {
				break;
			}
			scanner.nextLine();
			while (true) {
				PilhaPanasonic pilha = new PilhaPanasonic();
				int[] permutacao = new int[N];
				for (int i = 0; i < N; i++) {
					permutacao[i] = scanner.nextInt();
					if (permutacao[i] == 0) {
						break;
					}
				}
				if (permutacao[0] == 0) {
					break;
				}
				int proximoVagaoEsperado = 1;
				boolean possivel = true;
				for (int vagao : permutacao) {
					if (vagao == proximoVagaoEsperado) {
						proximoVagaoEsperado++;
					} else {
						while (!pilha.isEmpty() && Integer.parseInt(pilha.peek()) == proximoVagaoEsperado) {
							pilha.pop();
							proximoVagaoEsperado++;
						}
						pilha.push(String.valueOf(vagao));
					}
				}
				while (!pilha.isEmpty() && Integer.parseInt(pilha.peek()) == proximoVagaoEsperado) {
					pilha.pop();
					proximoVagaoEsperado++;
				}
				if (pilha.isEmpty()) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}
