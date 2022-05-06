package Sort;

import Generic.Generic;

public class QuickSort {

    public static void quickSort(Generic<?,?>[] vetor, int inicio, int fim){
        if(inicio < fim){
            int posicaoPivo = particiona(vetor, inicio, fim);

            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int particiona(Generic<?,?>[] vetor, int inicio, int fim){
        Generic<?,?> pivo = vetor[inicio];
        int i = inicio + 1, f = fim;

        while(i <= f){
            if(vetor[i].comparator(pivo) <= 0){// vetor[i] <= pivo
                i++;
            }else if(pivo.comparator(vetor[f]) < 0){ //  pivo < vetor[f]
                f--;
            }else{
                Generic<?,?> troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}
