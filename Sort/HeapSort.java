package Sort;

import Generic.Generic;
import java.lang.Math;

public class HeapSort implements Operacoes{
    private int tipoOrdenacao;
    private int atr = 0;
    private int co = 0;

    public void ordenar(Generic<?,?>[] vetor, int n, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;

        buildHeap(vetor, n - 1);

        for(int i = n - 1; i >= 1; i--){
            Generic<?,?> temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            this.co++;
            this.atr += 5;
            if(tipoOrdenacao == 1) {
                MaxHeapify(vetor, 0, i - 1);
            }else{
                MinHeapify(vetor, 0, i - 1);
            }
        }
    }

    private void buildHeap(Generic<?,?>[] vetor, int n){
        for(int i = (int)Math.floor((double)n/2); i >= 0; i--){
            this.co++;
            this.atr += 2;
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

        this.atr += 2;

        if(esq <= n && vetor[esq].comparator(vetor[i]) > 0){
            maior = esq;

            this.co += 2;
            this.atr++;
        }else{
            maior = i;

            this.atr++;
        }

        if(dir <= n && vetor[dir].comparator(vetor[maior]) > 0){
            maior = dir;

            this.co += 2;
            this.atr++;
        }

        if(maior != i){
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;

            this.co++;
            this.atr += 3;
            MaxHeapify(vetor, maior, n);
        }
    }

    private void MinHeapify(Generic<?,?>[] vetor, int i, int n){
        int menor;
        int esq = 2*i;
        int dir = 2*i+1;

        this.atr += 2;
        if(esq <= n && vetor[esq].comparator(vetor[i]) < 0){
            menor = esq;

            this.co += 2;
            this.atr++;
        }else{
            menor = i;

            this.atr++;
        }

        if(dir <= n && vetor[dir].comparator(vetor[menor]) < 0){
            menor = dir;

            this.co += 2;
            this.atr++;
        }

        if(menor != i){
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;

            this.co++;
            this.atr += 3;
            MinHeapify(vetor, menor, n);
        }
    }

    @Override
    public int getAtr() {
        return this.atr;
    }

    @Override
    public int getComp() {
        return this.co;
    }

    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
