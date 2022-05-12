package Sort;

import Generic.Generic;

public class InsertionSort implements Operacoes{
    private int tipoOrdenacao;
    private int atr = 0;
    private int co = 0;

    public void ordenar(Generic<?,?> []vetor, int tamanho, int tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;
        int i, j;
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
