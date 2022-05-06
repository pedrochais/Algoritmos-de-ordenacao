package Sort;
import Generic.Generic;

public class SelectionSort {
    public static Generic<?,?>[] selectionSort(Generic<?,?>[] vetor){
        for(int i = 0; i < vetor.length - 1; i++){
            int min = i;
            for(int j = i+1; j < vetor.length; j++){
                if(vetor[j].comparator(vetor[min]) < 0){ //  vetor[j] < vetor[min]
                    min = j;
                }
            }
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;
        }
        return vetor;
    }

    public static Generic<?,?>[] selectionSort2(Generic<?,?>[] v) {
        for (int i = 0; i < v.length; i++) {

            int i_menor = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[j].comparator(v[i_menor]) < 0)
                    i_menor = j;

            Generic<?,?> aux = v[i];
            v[i] = v[i_menor];
            v[i_menor] = aux;

        }

        return v;
    }
}
