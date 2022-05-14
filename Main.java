import Generic.*;
import Sort.*;
import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static int menuDados(){
        int opcao = 0;
        while (true) {
            System.out.println("""
                Escolha o tipo de dado (chave, valor)
                1. Dado A (String, Double)
                2. Dado B (Double, String)
                3. Dado C (Double, Integer)
                """);

            try {
                opcao = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }

            if(opcao == 1 || opcao == 2 || opcao == 3){
                return opcao;
            }else{
                System.out.println("Opção inválida!");
            }
        }
    }

    public static String menu(){
        System.out.print("""
                
                Algoritmos de ordenação
                1. InsertioSort
                2. SelectionSort
                3. MergeSort
                4. QuickSort
                5. HeapSort
                6. SelectionSort Otimizado
                7. MergeSort Otimizado
                8. JDKMergeSort
                9. JDKQuickSort
                10. Executar tudo
                0. Finalizar programa
                
                Digite a opção: """);
        return input.nextLine();
    }

    public static int submenu(){
        int tipoOrdenacao = 0;
        while(true) {
            System.out.print("""
                Tipo de ordenacao
                1. Crescente
                2. Decrescente
                """);

            try {
                tipoOrdenacao = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }

            if(tipoOrdenacao == 1 || tipoOrdenacao == 2){
                return tipoOrdenacao;
            }else{
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void printVetor(Generic<?,?>[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Chave: " + vetor[i].getChave() + " / Valor: " + vetor[i].getValor());
        }
    }

    public static void copiarVetor(Generic<?,?>[] vetor1, Generic<?,?>[] vetor2){
        for (int i = 0; i < vetor1.length; i++) {
            vetor2[i] = vetor1[i];
        }
    }

    public static void gerarVetorDadoA(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(GeradorString.getRandomString(10), random.nextDouble());
        }
    }

    public static void gerarVetorDadoB(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(random.nextFloat(), GeradorString.getRandomString(10));
        }
    }

    public static void gerarVetorDadoC(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(random.nextDouble(), random.nextInt(1000));
        }
    }

    public static double calcularTempoMedio(Generic<?,?>[] vetor, Generic<?,?>[] vetorCp, Algoritmo algoritmo, int repeticoes, int tipoOrdenacao){
        long tempoInicial = 0;
        long tempoFinal = 0;
        double somatorioTempo = 0;
        double tempoMedio = 0;

        for (int i = 0; i < repeticoes; i++){
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
        ComparaGeneric cv = new ComparaGeneric();
        List<Generic> aux = new ArrayList<>();

        //Instancia das classes dos algoritmos de ordenação
        InsertionSort is = new InsertionSort();
        SelectionSort ss = new SelectionSort();
        SelectionSortOtimizado sso = new SelectionSortOtimizado();
        QuickSort qs = new QuickSort();
        HeapSort hs = new HeapSort();
        MergeSort ms = new MergeSort();
        MergeSortOtimizado mso = new MergeSortOtimizado();

        //Algoritmo selecionado
        String alg = "";
        String ordem = "";
        String dado = "";

        //Quantidade de elementos
        int n = 1000;

        //Quantidade de experimentos
        int exp = 100;

        int opcaoDado = menuDados();

        Generic<?, ?>[] vetor = new Generic[n];
        Generic<?, ?>[] vetorCp = new Generic[n];

        if(opcaoDado == 1){
            vetor = (Generic<String, Double>[])vetor;
            vetorCp = (Generic<String, Double>[])vetorCp;
            gerarVetorDadoA(vetor, n);
        }else if(opcaoDado == 2){
            vetor = (Generic<Double, String>[])vetor;
            vetorCp = (Generic<Double, String>[])vetorCp;
            gerarVetorDadoB(vetor, n);
        }else if(opcaoDado == 3){
            vetor = (Generic<Double, Integer>[])vetor;
            vetorCp = (Generic<Double, Integer>[])vetorCp;
            gerarVetorDadoC(vetor, n);
        }

        copiarVetor(vetor, vetorCp);

        //Menu de navegação
        String opcao;
        while(true){
            opcao = menu();
            if(opcao.equals("0")) break; //Sair do programa

            int tipoOrdenacao = 0;
            long atribuicoes = 0;
            long comparacoes = 0;
            double tempoMedio = 0;

            long tempoInicial = 0;
            long tempoFinal = 0;
            double somatorioTempo = 0;


            switch (opcao) {
                case "1": //InsertionSort
                    alg = "InsertionSort";
                    tipoOrdenacao = submenu();

                    tempoMedio = calcularTempoMedio(vetor, vetorCp, is, exp, tipoOrdenacao);

                    atribuicoes = is.getAtr();
                    comparacoes = is.getComp();
                    break;

                case "2": //SelectionSort
                    alg = "SelectionSort";
                    tipoOrdenacao = submenu();

                    tempoMedio = calcularTempoMedio(vetor, vetorCp, ss, exp, tipoOrdenacao);

                    atribuicoes = ss.getAtr();
                    comparacoes = ss.getComp();
                    break;

                case "3": //MergeSort
                    alg = "MergeSort";
                    tipoOrdenacao = submenu();

                    tempoMedio = calcularTempoMedio(vetor, vetorCp, ms, exp, tipoOrdenacao);

                    atribuicoes = ms.getAtr();
                    comparacoes = ms.getComp();
                    break;

                case "4": //QuickSort
                    alg = "QuickSort";
                    tipoOrdenacao = submenu();

                    tempoMedio = calcularTempoMedio(vetor, vetorCp, qs, exp, tipoOrdenacao);

                    atribuicoes = qs.getAtr();
                    comparacoes = qs.getComp();
                    break;

                case "5": //HeapSort
                    alg = "HeapSort";
                    tipoOrdenacao = submenu();

                    tempoMedio = calcularTempoMedio(vetor, vetorCp, hs, exp, tipoOrdenacao);

                    atribuicoes = hs.getAtr();
                    comparacoes = hs.getComp();
                    break;

                case "6": //SelectionSort Otimizado
                    alg = "SelectionSort Otimizado";
                    tipoOrdenacao = submenu();

                    tempoMedio = calcularTempoMedio(vetor, vetorCp, sso, exp, tipoOrdenacao);

                    atribuicoes = sso.getAtr();
                    comparacoes = sso.getComp();
                    break;

                case "7": //MergeSort Otimizado
                    alg = "MergeSort Otimizado";
                    tipoOrdenacao = submenu();

                    tempoMedio = calcularTempoMedio(vetor, vetorCp, mso, exp, tipoOrdenacao);

                    atribuicoes = mso.getAtr();
                    comparacoes = mso.getComp();
                    break;

                case "8": //JDKMergeSort
                    alg = "JDKMergeSort";
                    for (int i = 0; i < exp; i++){
                        aux = Arrays.asList(vetor);
                        tempoInicial = System.currentTimeMillis();
                        Collections.sort(aux);
                        tempoFinal = System.currentTimeMillis();

                        somatorioTempo += (tempoFinal - tempoInicial);

                        copiarVetor(vetorCp, vetor);
                    }

                    tempoMedio = somatorioTempo/exp;

                    break;

                case "9": //JDKQuickSort
                    alg = "JDKQuickSort";
                    for (int i = 0; i < exp; i++){
                        tempoInicial = System.currentTimeMillis();
                        Arrays.sort(vetor, cv);
                        tempoFinal = System.currentTimeMillis();

                        somatorioTempo += (tempoFinal - tempoInicial);

                        copiarVetor(vetorCp, vetor);
                    }

                    tempoMedio = somatorioTempo/exp;

                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            if(tipoOrdenacao == 1) ordem = "Crescente";
            else if(tipoOrdenacao == 2) ordem = "Decrescente";

            if(opcaoDado == 1) dado = "A (String, Double)";
            else if(opcaoDado == 2) dado = "B (Double, String)";
            else if(opcaoDado == 3) dado = "C (Double, Integer)";

            //Print dos dados
            System.out.println("Tipo: Dado "+dado);
            System.out.println("Algoritmo de ordenação: "+alg+" | Ordem: "+ordem);
            System.out.println("Tamanho do vetor: "+n+" | Quantidade de experimentos: "+exp);
            System.out.println("Tempo de médio de execução: "+tempoMedio+" ms");
            System.out.println("Atribuições: "+atribuicoes+" / Comparações: "+comparacoes);
            copiarVetor(vetorCp, vetor);
        }
    }
}