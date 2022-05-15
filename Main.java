import Generic.*;
import Sort.*;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    //Função que realiza a cópia do vetor1 para o vetor2.
    public static void copiarVetor(Generic<?,?>[] vetor1, Generic<?,?>[] vetor2){
        for (int i = 0; i < vetor1.length; i++) {
            vetor2[i] = vetor1[i];
        }
    }

    //Geração automática de vetor do tipo de dado A (String, Double)
    public static void gerarVetorDadoA(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...\n");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(GeradorString.getRandomString(10), random.nextDouble());
        }
    }

    //Geração automática de vetor do tipo de dado B (Double, Integer)
    public static void gerarVetorDadoB(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...\n");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(random.nextDouble(), GeradorString.getRandomString(10));
        }
    }

    //Geração automática de vetor do tipo de dado C (Double, Integer)
    public static void gerarVetorDadoC(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...\n");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(random.nextDouble(), random.nextInt(1000));
        }
    }

    //Função que realiza o cálculo do tempo médio de execução do algoritmo de ordenação
    public static double calcularTempoMedio(Generic<?,?>[] vetor, Generic<?,?>[] vetorCp, Algoritmo algoritmo, int repeticoes, int tipoOrdenacao){
        long tempoInicial = 0;
        long tempoFinal = 0;
        double somatorioTempo = 0;
        double tempoMedio = 0;

        //O algoritmo será executado n vezes, após isso será calculado o tempo médio.
        for (int i = 0; i < repeticoes; i++){
            //Reinicia a quantidade de atribuições e comparações para a realização do novo teste.
            algoritmo.reiniciar();

            tempoInicial = System.currentTimeMillis();
            algoritmo.ordenar(vetor, tipoOrdenacao);
            tempoFinal = System.currentTimeMillis();

            somatorioTempo += (tempoFinal - tempoInicial);

            copiarVetor(vetorCp, vetor);
        }

        tempoMedio = somatorioTempo/repeticoes;
        return tempoMedio;
    }

    //Função que imprime todos os dados capturadas da execução do algoritmo de ordenação
    public static void imprimirDados(String dado, String alg, String ordem, int n, int exp, double tempoMedio, long atribuicoes, long comparacoes){
        System.out.println("Tipo: Dado "+dado);
        System.out.println("Algoritmo de ordenação: "+alg+" | Ordem: "+ordem);
        System.out.println("Tamanho do vetor: "+n+" | Quantidade de experimentos: "+exp);
        //Printa o tempo de de execução do algoritmo de ordenação
        System.out.println("Tempo de médio de execução: "+tempoMedio+" ms");
        //Printa a quantidade de atribuições e comparações
        System.out.println("Atribuições: "+atribuicoes+" / Comparações: "+comparacoes);
        System.out.println("");
    }

    public static void main(String[] args) {
        //Instância do comparador
        ComparaGeneric cv = new ComparaGeneric();
        //Instância de lista auxiliar
        List<Generic> aux = new ArrayList<>();
        //Instancia das classes dos algoritmos de ordenação
        SelectionSort ss = new SelectionSort();
        SelectionSortOtimizado sso = new SelectionSortOtimizado();
        QuickSort qs = new QuickSort();
        HeapSort hs = new HeapSort();
        MergeSort ms = new MergeSort();
        MergeSortOtimizado mso = new MergeSortOtimizado();
        //Quantidade de elementos
        int n = 1000;
        //Quantidade de experimentos
        int exp = 100;
        //Instância do vetor original e do vetor cópia
        Generic<?, ?>[] vetor = new Generic[n];
        Generic<?, ?>[] vetorCp = new Generic[n];
        //Inicialização das variáveis
        long atribuicoes = 0;
        long comparacoes = 0;
        double tempoMedio = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        double somatorioTempo = 0;
        //Guarda escolha do algoritmo, da ordem e do tipo de dado.
        String alg = "";
        String ordem = "";
        String dado = "";

        // Execução automática de todos os testes.
        String opcao = "";
        while(!opcao.equals("0")){
            System.out.println("""
                    Escolha um tipo de dado
                    1. Dado A (String, Double)
                    2. Dado B (Double, String)
                    3. Dado C (Double, Integer)
                    0. Encerrar programa
                    """);
            opcao = input.nextLine();

            //Gerar vetores para os diferentes tipos de dados a cada iteração.
            if(opcao.equals("1")){
                System.out.println("""

                        ====================================================================
                        EXECUÇÃO DOS ALGORITMOS DE ORDENAÇÃO | DADOS TIPO A (STRING, DOUBLE)
                        ====================================================================
                        """);
                dado = "A (String, Double)";
                vetor = (Generic<String, Double>[])vetor;
                vetorCp = (Generic<String, Double>[])vetorCp;
                gerarVetorDadoA(vetor, n);
            }else if(opcao.equals("2")){
                System.out.println("""

                        ====================================================================
                        EXECUÇÃO DOS ALGORITMOS DE ORDENAÇÃO | DADOS TIPO B (DOUBLE, STRING)
                        ====================================================================
                        """);
                dado = "B (Double, String)";
                vetor = (Generic<Double, String>[])vetor;
                vetorCp = (Generic<Double, String>[])vetorCp;
                gerarVetorDadoB(vetor, n);
            }else if(opcao.equals("3")){
                System.out.println("""
                        
                        =====================================================================
                        EXECUÇÃO DOS ALGORITMOS DE ORDENAÇÃO | DADOS TIPO C (DOUBLE, INTEGER)
                        =====================================================================
                        """);
                dado = "C (Double, Integer)";
                vetor = (Generic<Double, Integer>[])vetor;
                vetorCp = (Generic<Double, Integer>[])vetorCp;
                gerarVetorDadoC(vetor, n);
            }else if(opcao.equals("0")){
                System.out.println("Programa encerrado.");
                continue;
            }else{
                System.out.println("Digite uma opção válida.");
                continue;
            }
            copiarVetor(vetor, vetorCp);

            /* QUICK SORT */

            alg = "QuickSort";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, qs, exp, 1);
            atribuicoes = qs.getAtr();
            comparacoes = qs.getComp();
            imprimirDados(dado, alg, "Crescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            alg = "QuickSort";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, qs, exp, 2);
            atribuicoes = qs.getAtr();
            comparacoes = qs.getComp();
            imprimirDados(dado, alg, "Decrescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            /* HEAP SORT */

            alg = "HeapSort";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, hs, exp, 1);
            atribuicoes = hs.getAtr();
            comparacoes = hs.getComp();
            imprimirDados(dado, alg, "Crescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            alg = "HeapSort";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, hs, exp, 2);
            atribuicoes = hs.getAtr();
            comparacoes = hs.getComp();
            imprimirDados(dado, alg, "Decrescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            /* MERGE SORT */

            alg = "MergeSort";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, ms, exp, 1);
            atribuicoes = ms.getAtr();
            comparacoes = ms.getComp();
            imprimirDados(dado, alg, "Crescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            alg = "MergeSort";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, ms, exp, 2);
            atribuicoes = ms.getAtr();
            comparacoes = ms.getComp();
            imprimirDados(dado, alg, "Decrescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            /* MERGE SORT OTIMIZADO */

            alg = "MergeSort Otimizado";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, mso, exp, 1);
            atribuicoes = mso.getAtr();
            comparacoes = mso.getComp();
            imprimirDados(dado, alg, "Crescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            alg = "MergeSort Otimizado";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, mso, exp, 2);
            atribuicoes = mso.getAtr();
            comparacoes = mso.getComp();
            imprimirDados(dado, alg, "Decrescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            /* JDK MERGESORT */

            somatorioTempo = 0;
            alg = "JDK Collections";
            for (int i = 0; i < exp; i++){
                aux = Arrays.asList(vetor);
                tempoInicial = System.currentTimeMillis();
                Collections.sort(aux);
                tempoFinal = System.currentTimeMillis();

                somatorioTempo += (tempoFinal - tempoInicial);

                copiarVetor(vetorCp, vetor);
            }

            tempoMedio = somatorioTempo/exp;
            imprimirDados(dado, alg, "Crescente", n, exp, tempoMedio, 0, 0);
            copiarVetor(vetorCp, vetor);

            /* JDK Array (LegacyMergeSort, Timsort) */

            somatorioTempo = 0;
            alg = "JDK Array";
            for (int i = 0; i < exp; i++){
                tempoInicial = System.currentTimeMillis();
                Arrays.sort(vetor, cv);
                tempoFinal = System.currentTimeMillis();

                somatorioTempo += (tempoFinal - tempoInicial);

                copiarVetor(vetorCp, vetor);
            }

            tempoMedio = somatorioTempo/exp;
            imprimirDados(dado, alg, "Crescente", n, exp, tempoMedio, 0, 0);
            copiarVetor(vetorCp, vetor);

            /* SELECTION SORT OTIMIZADO */

            alg = "SelectionSort Otimizado";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, sso, exp, 1);
            atribuicoes = sso.getAtr();
            comparacoes = sso.getComp();
            imprimirDados(dado, alg, "Crescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            alg = "SelectionSort Otimizado";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, sso, exp, 2);
            atribuicoes = sso.getAtr();
            comparacoes = sso.getComp();
            imprimirDados(dado, alg, "Decrescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            /* SELECTION SORT */

            alg = "SelectionSort";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, ss, exp, 1);
            atribuicoes = ss.getAtr();
            comparacoes = ss.getComp();
            imprimirDados(dado, alg, "Crescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            alg = "SelectionSort";
            tempoMedio = calcularTempoMedio(vetor, vetorCp, ss, exp, 2);
            atribuicoes = ss.getAtr();
            comparacoes = ss.getComp();
            imprimirDados(dado, alg, "Decrescente", n, exp, tempoMedio, atribuicoes, comparacoes);
            copiarVetor(vetorCp, vetor);

            System.out.println("[Iteração finalizada: Dado "+dado+"]");
            System.out.println("Pressione ENTER para continuar");
            input.nextLine();
        }
    }
}