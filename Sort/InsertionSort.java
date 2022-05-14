package Sort;

import Generic.Generic;

public class InsertionSort extends Algoritmo implements Operacoes{
    private int tipoOrdenacao;
    private long atr = 0;
    private long co = 0;

    public Generic<?, ?>[] ordenar(Generic<?, ?> []vetor, int tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;
        int i, j;
        int tamanho = vetor.length;
        Generic<?,?> key;

        if(this.tipoOrdenacao == 1){
            for(j = 1; j < tamanho; j++){
                key = vetor[j];
                i = j - 1;
                while(i >= 0 && vetor[i].comparator(key) > 0){ //Ordenação em ordem crescente
                    vetor[i+1] = vetor[i];
                    i--;

                    this.co += 2;
                    this.atr += 2;
                }
                vetor[i+1] = key;

                this.co++;
                this.atr += 5;
            }
        }else{
            for(j = 1; j < tamanho; j++){
                key = vetor[j];
                i = j - 1;
                while(i >= 0 && vetor[i].comparator(key) < 0){ //Ordenação em ordem decrescente
                    vetor[i+1] = vetor[i];
                    i--;

                    this.co += 2;
                    this.atr += 2;
                }
                vetor[i+1] = key;

                this.co++;
                this.atr += 5;
            }
        }

        return vetor;
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
