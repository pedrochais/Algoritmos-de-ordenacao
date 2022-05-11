package Sort;
import Generic.Generic;

public class SelectionSort {
    public static Generic<?,?>[] ordenar(Generic<?,?>[] vetor){
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
}
