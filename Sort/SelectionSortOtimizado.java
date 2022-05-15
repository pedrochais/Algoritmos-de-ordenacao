package Sort;

import Generic.Generic;

public class SelectionSortOtimizado extends Algoritmo implements Operacoes {
    private int tipoOrdenacao; //Crescente ou decrescente
    private long atr = 0; //Quantidade de atribuições
    private long co = 0; //Quantidade de comparações

    public Generic<?,?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;

        int n = vetor.length;
        for(int i = 0, j = n - 1; i < j; i++, j--){ //Seleciona um valor na posição i (início) e na posição j (final)
            Generic<?,?> min = vetor[i];
            Generic<?,?> max = vetor[i];
            int i_min = i, i_max = i;

            for (int k = i; k <= j; k++) { //Percorre o subvetor entre i e j com a variável de controle k
                this.co ++;
                this.atr += 2;

                if(this.tipoOrdenacao == 1){ //Ordenação em ordem crescente
                    if (vetor[k].comparator(max) > 0) { //Busca o valor máximo dentro do subvetor
                        max = vetor[k];
                        i_max = k;

                        this.co++;
                        this.atr += 2;
                    } else if (vetor[k].comparator(min) < 0) { //Busca o valor mínimo dentro do subvetor
                        min = vetor[k];
                        i_min = k;

                        this.co++;
                        this.atr += 2;
                    }
                }else{ //Ordenação em ordem decrescente
                    if (vetor[k].comparator(max) < 0) { //Busca o valor máximo dentro do subvetor
                        max = vetor[k];
                        i_max = k;

                        this.co++;
                        this.atr += 2;
                    } else if (vetor[k].comparator(min) > 0) { //Busca o valor mínimo dentro do subvetor
                        min = vetor[k];
                        i_min = k;

                        this.co++;
                        this.atr += 2;
                    }
                }
            }
            //Realiza a troca dos valores
            Generic<?,?> temp;
            temp = vetor[i];
            vetor[i] = vetor[i_min];
            vetor[i_min] = temp;

            if (vetor[i_min] == max) {
                //Realiza a troca dos valores
                temp = vetor[j];
                vetor[j] = vetor[i_min];
                vetor[i_min] = temp;

                this.co++;
                this.atr += 3;
            }else {
                //Realiza a troca dos valores
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
