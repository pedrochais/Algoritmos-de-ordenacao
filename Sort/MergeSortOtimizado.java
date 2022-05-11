package Sort;

import Generic.Generic;

public class MergeSortOtimizado {
    private int tipoOrdenacao;

    public Generic<?,?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;
        Generic<?,?>[] Temp = new Generic<?,?>[vetor.length];

        return MergeMain(vetor, Temp, 0, vetor.length-1);
    }

    public Generic<?,?>[] MergeMain(Generic<?,?>[] vetor, Generic<?,?>[] T, int esq, int dir){
        int meio;

        if(esq < dir){
            if(vetor.length <= 15){
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.ordenar(vetor, vetor.length, this.tipoOrdenacao);
            }else{
                meio = (esq + dir)/2;
                MergeMain(vetor, T, esq, meio);
                MergeMain(vetor, T, meio + 1, dir);
                Merge(vetor, T, esq, meio + 1, dir);
            }
        }

        return vetor;
    }

    public void Merge(Generic<?,?>[] vetor, Generic<?,?>[] T, int esqPos, int dirPos, int dirFim){
        int esqFim = dirPos - 1;
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while(esqPos <= esqFim && dirPos <= dirFim){
            if(this.tipoOrdenacao == 1){
                if(vetor[esqPos].comparator(vetor[dirPos]) <= 0){
                    T[tempPos++] = vetor[esqPos++];
                }else{
                    T[tempPos++] = vetor[dirPos++];
                }
            }else{
                if(vetor[esqPos].comparator(vetor[dirPos]) >= 0){
                    T[tempPos++] = vetor[esqPos++];
                }else{
                    T[tempPos++] = vetor[dirPos++];
                }
            }

        }

        while(esqPos <= esqFim) T[tempPos++] = vetor[esqPos++];
        while(dirPos <= dirFim) T[tempPos++] = vetor[dirPos++];

        for(int i = 0; i < numElem; i++, dirFim--){
            vetor[dirFim] = T[dirFim];
        }
    }
}
