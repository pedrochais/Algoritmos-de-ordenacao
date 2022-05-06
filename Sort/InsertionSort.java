package Sort;

import Generic.Generic;

public class InsertionSort {
    public static void insertionSort (Generic<?,?> []vetor, int tamanho) {
        int i, j;
        Generic<?,?> key;
        for(j = 1; j < tamanho; j++){
            key = vetor[j];
            i = j - 1;
            while(i >= 0 && vetor[i].comparator(key) > 0){ //Ordenação em ordem crescente
                vetor[i+1] = vetor[i];
                i--;
            }
            vetor[i+1] = key;
        }
    }
}
