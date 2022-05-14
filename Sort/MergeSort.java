package Sort;

import Generic.Generic;

public class MergeSort extends Algoritmo implements Operacoes{
    private int tipoOrdenacao;
    private long atr = 0;
    private long co = 0;

    public Generic<?,?>[] ordenar(Generic<?, ?>[] vetor, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;
        Generic<?,?>[] Temp = new Generic<?,?>[vetor.length];

        this.atr++;

        return MergeMain(vetor, Temp, 0, vetor.length-1);
    }

    public Generic<?,?>[] MergeMain(Generic<?,?>[] vetor, Generic<?,?>[] T, int esq, int dir){
        int meio;

        if(esq < dir){
            this.co++;
            this.atr++;

            meio = (esq + dir)/2;
            MergeMain(vetor, T, esq, meio);
            MergeMain(vetor, T, meio + 1, dir);
            Merge(vetor, T, esq, meio + 1, dir);
        }

        return vetor;
    }

    public void Merge(Generic<?,?>[] vetor, Generic<?,?>[] T, int esqPos, int dirPos, int dirFim){
        int esqFim = dirPos - 1;
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while(esqPos <= esqFim && dirPos <= dirFim){
            this.co += 2;
            if(this.tipoOrdenacao == 1){
                if(vetor[esqPos].comparator(vetor[dirPos]) <= 0){
                    T[tempPos++] = vetor[esqPos++];

                    this.co++;
                    this.atr++;
                }else{
                    T[tempPos++] = vetor[dirPos++];

                    this.atr++;
                }
            }else{
                if(vetor[esqPos].comparator(vetor[dirPos]) >= 0){
                    T[tempPos++] = vetor[esqPos++];

                    this.co++;
                    this.atr++;
                }else{
                    T[tempPos++] = vetor[dirPos++];

                    this.atr++;
                }
            }
        }

        while(esqPos <= esqFim) {
            T[tempPos++] = vetor[esqPos++];

            this.co++;
            this.atr++;
        }
        while(dirPos <= dirFim) {
            T[tempPos++] = vetor[dirPos++];

            this.co++;
            this.atr++;
        }

        for(int i = 0; i < numElem; i++, dirFim--){
            vetor[dirFim] = T[dirFim];

            this.co++;
            this.atr += 3;
        }

        this.atr += 3;
    }

    @Override
    public long getAtr() {
        return this.atr;
    }

    @Override
    public long getComp() {
        return this.co;
    }

    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
