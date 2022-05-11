package Sort;

import Generic.Generic;
import java.lang.Math;

public class HeapSort {

    public static void ordenar(Generic<?,?>[] vetor, int n){
        buildMaxHeap(vetor, n - 1);
        for(int i = n - 1; i >= 1; i--){
            Generic<?,?> temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            MaxHeapify(vetor, 0, i - 1);
        }
    }

    public static void buildMaxHeap(Generic<?,?>[] vetor, int n){
        for(int i = (int)Math.floor((double)n/2); i >= 0; i--){
            MaxHeapify(vetor, i, n);
        }
    }

    public static void MaxHeapify(Generic<?,?>[] vetor, int i, int n){
        int maior;
        int esq = 2*i;
        int dir = 2*i+1;
        if(esq <= n && vetor[esq].comparator(vetor[i]) > 0){
            maior = esq;
        }else{
            maior = i;
        }

        if(dir <= n && vetor[dir].comparator(vetor[maior]) > 0){
            maior = dir;
        }

        if(maior != i){
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;

            MaxHeapify(vetor, maior, n);
        }

    }
/*
    public static void ordenar(Generic<?, ?>[] vetor) {
        buildMaxHeap(vetor, vetor.length-1);
        for(int i = vetor.length - 1; i >= 1; i--) {
            Generic<?, ?> aux = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;

            maxHeapify(vetor, 0, i - 1);
        }
    }

    private static void buildMaxHeap(Generic<?, ?>[] vetor, int tamanho) {
        for(int i = (int)Math.floor((double)tamanho/2); i >= 0; i--) {
            //System.out.println(i);
            maxHeapify(vetor, i, tamanho);
        }
    }

    private static void maxHeapify(Generic<?, ?>[] vetor, int indice, int tamanhoAtual) {
        int e = esq(indice);
        int d = dir(indice);
        int maior;

        if(e <= tamanhoAtual && vetor[e].comparator(vetor[indice]) > 0) {
            maior = e;
        } else {
            maior = indice;
        }

        if (d <= tamanhoAtual && vetor[d].comparator(vetor[maior]) > 0) {
            maior = d;
        }

        if(maior != indice) {
            Generic<?, ?> aux = vetor[maior];
            vetor[maior] = vetor[indice];
            vetor[indice] = aux;

            maxHeapify(vetor, maior, tamanhoAtual);
        }
    }

    private static int esq(int indice) {
        return 2*indice;
    }

    private static int dir(int indice) {
        return 2*indice+1;
    }*/
}
