package Filas;

import java.util.Comparator;

public class Dequee<T> {
    private No<T> frente;
    private No<T> fim;

    public Dequee() {
        frente = null;
        fim = null;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public void addFirst(T elemento) {
        No<T> novoNo = new No<T>(elemento);
        if (isEmpty()) {
            frente = fim = novoNo;
        } else {
            novoNo.next = frente;
            frente.prev = novoNo;
            frente = novoNo;
        }
    }

    public void addLast(T elemento) {
        No<T> novoNo = new No<T>(elemento);
        if (isEmpty()) {
            frente = fim = novoNo;
        } else {
            fim.next = novoNo;
            novoNo.prev = fim;
            fim = novoNo;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("O deque está vazio.");
            return null;
        } else {
            T elemento = frente.value;
            frente = frente.next;
            if (frente == null) {
                fim = null;
            } else {
                frente.prev = null;
            }
            return elemento;
        }
    }

    public void removeFirstOccurrence(T elemento) {
        No<T> atual = frente;
        while (atual != null) {
            if (atual.value.equals(elemento)) {
                if (atual == frente) {
                    removeFirst();
                    return;
                } else if (atual == fim) {
                    removeLast();
                    return;
                } else {
                    atual.prev.next = atual.next;
                    atual.next.prev = atual.prev;
                    return;
                }
            }
            atual = atual.next;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            System.out.println("O deque está vazio.");
            return null;
        } else {
            T elemento = fim.value;
            fim = fim.prev;
            if (fim == null) {
                frente = null;
            } else {
                fim.next = null;
            }
            return elemento;
        }
    }

    public T first() {
        if (isEmpty()) {
            System.out.println("O deque está vazio.");
            return null;
        } else {
            return frente.value;
        }
    }

    public T last() {
        if (isEmpty()) {
            System.out.println("O deque está vazio.");
            return null;
        } else {
            return fim.value;
        }
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("O deque está vazio.");
        } else {
            No<T> atual = frente;
            while (atual != null) {
                System.out.print(atual.value + " ");
                atual = atual.next;
            }
            System.out.println();
        }
    }

    public void inverter() {
        if (isEmpty() || frente == fim) {
            return;
        }
        No<T> atual = frente;
        No<T> temp = null;
        while (atual != null) {
            temp = atual.next;
            atual.next = atual.prev;
            atual.prev = temp;
            atual = temp;
        }
        temp = frente;
        frente = fim;
        fim = temp;
    }

    public void moverPrimeiroParaFinal() {
        if (isEmpty() || frente == fim) {
            return;
        }
        T primeiro = removeFirst();
        addLast(primeiro);
    }

    public void sort(Comparator<? super T> comparator) {
        if (isEmpty() || frente == fim) {
            return;
        }
        No<T> atual = frente;
        while (atual != null) {
            No<T> temp = atual.next;
            while (temp != null) {
                if (comparator.compare(atual.value, temp.value) > 0) {
                    T tempValue = atual.value;
                    atual.value = temp.value;
                    temp.value = tempValue;
                }
                temp = temp.next;
            }
            atual = atual.next;
        }
    }

    public class No<T> {
        T value;
        No<T> next;
        No<T> prev;

        public No(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}
