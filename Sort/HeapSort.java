package Sort;

import Generic.Generic;
import java.lang.Math;

public class HeapSort extends Algoritmo implements Operacoes{
    private int tipoOrdenacao; //Crescente ou decrescente
    private long atr = 0; //Quantidade de atribuições
    private long co = 0; //Quantidade de comparações

    public Generic<?, ?>[] ordenar(Generic<?, ?>[] vetor, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;
        int n = vetor.length;

        buildHeap(vetor, n - 1);

        for(int i = n - 1; i >= 1; i--){
            //Realiza a troca dos valores
            Generic<?,?> temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            this.co++;
            this.atr += 5;
            //Verifica o tipo de ordenação, caso seja crescente o MaxHeapify será usado, caso for decrescente o MinHeapify será usado.
            if(tipoOrdenacao == 1) {
                MaxHeapify(vetor, 0, i - 1);
            }else{
                MinHeapify(vetor, 0, i - 1);
            }
        }

        return vetor;
    }

    private void buildHeap(Generic<?,?>[] vetor, int n){
        for(int i = (int)Math.floor((double)n/2); i >= 0; i--){
            this.co++;
            this.atr += 2;
            //Verifica o tipo de ordenação, caso seja crescente o MaxHeapify será usado, caso for decrescente o MinHeapify
            if(this.tipoOrdenacao == 1){
                MaxHeapify(vetor, i, n);
            }else{
                MinHeapify(vetor, i, n);
            }
        }
    }

    private void MaxHeapify(Generic<?,?>[] vetor, int i, int n){
        int maior;
        int esq = 2*i; //Calcula o filho da esquerda
        int dir = 2*i+1; //Calcula o filho da direita

        this.atr += 2;

        if(esq <= n && vetor[esq].comparator(vetor[i]) > 0){ //Busca o maior elemento
            maior = esq;

            this.co += 2;
            this.atr++;
        }else{
            maior = i;

            this.atr++;
        }

        if(dir <= n && vetor[dir].comparator(vetor[maior]) > 0){ //Busca o maior elemento
            maior = dir;

            this.co += 2;
            this.atr++;
        }

        if(maior != i){
            //Realiza a troca dos valores
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
        int esq = 2*i; //Calcula o filho da esquerda
        int dir = 2*i+1; //Calcula o filho da direita

        this.atr += 2;
        if(esq <= n && vetor[esq].comparator(vetor[i]) < 0){ //Busca o menor elemento
            menor = esq;

            this.co += 2;
            this.atr++;
        }else{
            menor = i;

            this.atr++;
        }

        if(dir <= n && vetor[dir].comparator(vetor[menor]) < 0){ //Busca o menor elemento
            menor = dir;

            this.co += 2;
            this.atr++;
        }

        if(menor != i){
            //Realiza a troca dos valores
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;

            this.co++;
            this.atr += 3;
            MinHeapify(vetor, menor, n);
        }
    }

    @Override
    public long getAtr() {
        return this.atr;
    }

    @Override
    public long getComp() {
        return this.co;
    }

    //Reinicia a quantidade de atribuições e de comparações
    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
