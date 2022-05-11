package Sort;

import Generic.Generic;

public class SelectionSortOtimizado {
    public static Generic<?,?>[] ordenar(Generic<?,?>[] vetor) {
        int n = vetor.length;
        for(int i = 0, j = n - 1; i < j; i++, j--){
            Generic<?,?> min = vetor[i];
            Generic<?,?> max = vetor[i];
            int i_min = i, i_max = i;
            for (int k = i; k <= j; k++) {
                if (vetor[k].comparator(max) > 0) {
                    max = vetor[k];
                    i_max = k;
                } else if (vetor[k].comparator(min) < 0) {
                    min = vetor[k];
                    i_min = k;
                }
            }
            Generic<?,?> temp; //variavel temporaria
            temp = vetor[i];
            vetor[i] = vetor[i_min];
            vetor[i_min] = temp;

            if (vetor[i_min] == max) {
                temp = vetor[j];
                vetor[j] = vetor[i_min];
                vetor[i_min] = temp;
            }else {
                temp = vetor[j];
                vetor[j] = vetor[i_max];
                vetor[i_max] = temp;
            }
        }
        return vetor;
    }
}
