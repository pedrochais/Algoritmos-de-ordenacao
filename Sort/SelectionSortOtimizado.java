package Sort;

import Generic.Generic;

public class SelectionSortOtimizado implements Operacoes {
    private int tipoOrdenacao;
    private int atr = 0;
    private int co = 0;

    public Generic<?,?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;

        int n = vetor.length;
        for(int i = 0, j = n - 1; i < j; i++, j--){
            Generic<?,?> min = vetor[i];
            Generic<?,?> max = vetor[i];
            int i_min = i, i_max = i;

            for (int k = i; k <= j; k++) {
                this.co ++;
                this.atr += 2;

                if(this.tipoOrdenacao == 1){ //Ordenação em ordem crescente
                    if (vetor[k].comparator(max) > 0) {
                        max = vetor[k];
                        i_max = k;

                        this.co++;
                        this.atr += 2;
                    } else if (vetor[k].comparator(min) < 0) {
                        min = vetor[k];
                        i_min = k;

                        this.co++;
                        this.atr += 2;
                    }
                }else{ //Ordenação em ordem decrescente
                    if (vetor[k].comparator(max) < 0) {
                        max = vetor[k];
                        i_max = k;

                        this.co++;
                        this.atr += 2;
                    } else if (vetor[k].comparator(min) > 0) {
                        min = vetor[k];
                        i_min = k;

                        this.co++;
                        this.atr += 2;
                    }
                }

            }
            Generic<?,?> temp; //variavel temporaria
            temp = vetor[i];
            vetor[i] = vetor[i_min];
            vetor[i_min] = temp;

            if (vetor[i_min] == max) {
                temp = vetor[j];
                vetor[j] = vetor[i_min];
                vetor[i_min] = temp;

                this.co++;
                this.atr += 3;
            }else {
                temp = vetor[j];
                vetor[j] = vetor[i_max];
                vetor[i_max] = temp;

                this.atr += 3;
            }

            this.co ++;
            this.atr += 11;
        }

        this.atr++;
        return vetor;
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
