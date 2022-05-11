package Sort;

import Generic.Generic;
import java.lang.Math;

public class HeapSort {
    private int tipoOrdenacao;

    public void ordenar(Generic<?,?>[] vetor, int n, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;

        buildHeap(vetor, n - 1);

        for(int i = n - 1; i >= 1; i--){
            Generic<?,?> temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            if(tipoOrdenacao == 1) {
                MaxHeapify(vetor, 0, i - 1);
            }else{
                MinHeapify(vetor, 0, i - 1);
            }
        }
    }

    private void buildHeap(Generic<?,?>[] vetor, int n){
        for(int i = (int)Math.floor((double)n/2); i >= 0; i--){
            if(this.tipoOrdenacao == 1){
                MaxHeapify(vetor, i, n);
            }else{
                MinHeapify(vetor, i, n);
            }
        }
    }

    private void MaxHeapify(Generic<?,?>[] vetor, int i, int n){
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

    private void MinHeapify(Generic<?,?>[] vetor, int i, int n){
        int menor;
        int esq = 2*i;
        int dir = 2*i+1;

        if(esq <= n && vetor[esq].comparator(vetor[i]) < 0){
            menor = esq;
        }else{
            menor = i;
        }

        if(dir <= n && vetor[dir].comparator(vetor[menor]) < 0){
            menor = dir;
        }

        if(menor != i){
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
            MinHeapify(vetor, menor, n);
        }
    }
}
