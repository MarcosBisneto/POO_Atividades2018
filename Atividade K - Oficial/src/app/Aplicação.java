package app;

import java.util.ArrayList;
import model.User;
import negocio.Processo;
import model.Quadro;
import model.Lista;
import model.Log;
import model.Card;
import model.Comentario;
import model.Etiquetas;
import java.util.Scanner;

public class Aplicação {
	private static Scanner input = new Scanner(System.in);
    private static boolean logadoStatus = false;
    private static Processo processo = new Processo();
    
    private static void criarQuadro(){
        input = new Scanner(System.in);
        System.out.print("Titulo: ");
        String titulo = input.nextLine();
        processo.addQuadro(titulo);
    }
    
    
    private static void listarQuadros(){
        ArrayList<Quadro> quadros = processo.getQuadroCadastrados();
        if (quadros.isEmpty()){
            System.out.println("Não há quadros!");
        }
        for (int i = 0; i < quadros.size(); i++){
            System.out.printf(">> %dº Quadro: %s\n", i+1, quadros.get(i).getTitulo());
        }
    }
    
    
    private static void selecionarQuadro(){
        input = new Scanner(System.in);
        listarQuadros();
        System.out.print("Opcao: ");
        int opcao = input.nextInt();
        if (processo.selecionarQuadro(opcao-1)){
            System.out.println("Entrou...");
        } else {
            System.out.println("Esse quadro não existe!");
        }
    }
    
    
    private static void criarTarefa(){
        input = new Scanner(System.in);
        System.out.print("Titulo: ");
        String titulo = input.nextLine();
        processo.addTarefa(titulo);
    }
    
    
    private static void listarTarefas(){
        ArrayList<Lista> tarefas = processo.getTarefasCadastrada();
        if (tarefas.isEmpty()){
            System.out.println("Nenhum registro localizado!");
        }
        for (int i = 0; i < tarefas.size(); i++){
            System.out.printf("%d - %s\n", i+1, tarefas.get(i).getTitulo());
        }
    }
    
    //selecionar tarefa para entrar
    private static void entrarTarefa(){
        input = new Scanner(System.in);
        listarTarefas();
        System.out.print(">> Opcao: ");
        int opcao = input.nextInt();
        if (processo.selecionarTarefa(opcao-1)){
            System.out.println("Entrou...");
        }
    }
    
    
    private static void criarCartao(){
        input = new Scanner(System.in);
        System.out.print("Titulo: ");
        String titulo = input.nextLine();
        processo.addCartao(titulo);
    }
    
    
    private static void listarCartoes(){
        ArrayList<Card> cards = processo.getCartoesCadastrados();
        if (cards.isEmpty()){
            System.out.println("Nenhum card localizado!");
        }else {
        for (int i = 0; i < cards.size(); i++){
            System.out.printf("%dº Card: %s\n", i+1, cards.get(i).getTitulo());
        }
      }
    }
    
    
    private static void listarListaDeCartoes(){
        ArrayList<Card> cards = processo.getCartoesCadastrados();
        if (cards.isEmpty()){
            System.out.println("Não há Cards!");
        }
        for (int i = 0; i < cards.size(); i++){ 
        	System.out.printf("\n******************************************\n");
        	System.out.printf("%dº Card", i+1);
            System.out.printf("- Titulo - %s\n", cards.get(i).getTitulo());
            System.out.printf("- Descrição - %s\n", cards.get(i).getDescricao());
            
            System.out.println(">> Comentario(s) Feito(s): ");
            for (int j = 0; j < cards.get(i).getComentarios().size(); j++){
                System.out.printf("~ \t - %s - %s\n",cards.get(i).getComentarios().get(j).getComentario(),cards.get(i).getComentarios().get(j).getDataHora());
            }
            
            System.out.println(">> Etiqueta(s) Aplicada(s): ");
            for (int j = 0; j < cards.get(i).getEtiquetas().size(); j++){
                System.out.printf("~ \t - %s - %s\n",cards.get(i).getEtiquetas().get(j).getTitulo(),cards.get(i).getEtiquetas().get(j).getCor());
            	System.out.printf("\n******************************************\n");
            }
        }
    }
    
    
    private static void selecionarCartao(){
        input = new Scanner(System.in);
        listarTarefas();
        System.out.print(">> Opcao: ");
        int opcao = input.nextInt();
        if (processo.selecionarCartao(opcao-1)){
            System.out.println("Entrou...");
        }
    }
    
    
    private static void adicionarDescricao(){
        input = new Scanner(System.in);
        System.out.print("Descricao: ");
        String descricao = input.nextLine();
        processo.addDescricao(descricao);
    }
    
    private static void adicionarComentario(){
        input = new Scanner(System.in);
        System.out.print("Comentario: ");
        String comentario = input.nextLine();
        processo.addComentario(comentario);
    }
    
    
    private static void adicionarEtiqueta(){
        input = new Scanner(System.in);
    	System.out.printf("\n******************************************\n");
        System.out.print(">> Titulo da Etiqueta: ");
        String titulo = input.nextLine();
        System.out.print(">> Cor da Etiqueta: ");
        String cor = input.nextLine();
        processo.addEtiqueta(titulo, cor);
    }
    
    
    private static void moverCard(){
        input = new Scanner(System.in);
        
    	System.out.printf("\n******************************************\n");
        System.out.println(">> Selecione a Tarefa para mover");
        listarTarefas();
        System.out.println(">> Opçãoo: ");
        int tarefa = input.nextInt();
        
        System.out.println(">> Selecione o cartao de destino");
        listarCartoes();
        System.out.println(">> Opção: ");
        int cartao = input.nextInt();
        
        processo.moverCartao(tarefa, cartao-1);
    }
    
    
    private static void mostrarLog(){
        ArrayList<Log> logs = processo.getLog();
        int contador = 0;
        
        if (logs.size() == 0){
            System.out.println("Não há registros de atividades.\n");
        } else {
        	System.out.printf("******************************************\n");
        	System.out.println(">>> REGISTROS DE ATIVIDADES REALIZADAS - OGS.\n");
        	for (int i = 0; i < logs.size(); i++){
        		contador = contador +1;
                System.out.printf(">>" +contador+ "º Registro: %s\n", logs.get(i).getLog());
            	System.out.printf("__________________________________________\n");
            }
        }
        
    }
            
    private static void cadastarUser(){
        input = new Scanner(System.in);
        String nome = "";
        String login = "";
        String senha = "";
        
        while (nome.trim().length() == 0 || login.trim().length() == 0 || senha.trim().length() == 0){
        	System.out.printf("******************************************\n");
        	System.out.printf(">> SEU CADASTRO\n");
        	System.out.print(" - Nome: ");
            nome = input.nextLine();
            System.out.print(" - Login: ");
            login = input.nextLine();
            System.out.print(" - Senha: ");
            senha = input.nextLine();
        }
        if (processo.cadastrarUser(nome, login, senha)){
            System.out.println(nome + " você foi cadastrado(a)!");
        } else {
            System.out.println("Ops! Tente novamente!");
        }
    }
    
    
    private static void login(){
        input = new Scanner(System.in);
        String login = "";
        String senha = "";
        
        while (login.trim().length() == 0 || senha.trim().length() == 0){
        	System.out.printf("\n******************************************\n");
        	System.out.printf(" >> FAÇA SEU LOGIN\n");
        	System.out.print(" - Login: ");
            login = input.nextLine();
            System.out.print(" - Senha: ");
            senha = input.nextLine();
        }
        if (processo.loginUser(login, senha)){
        	System.out.printf("\n******************************************\n");
            System.out.println("     Seja Bem-Vindo ao Trello App!\n");
            logadoStatus = true;
        } else {
            System.out.println("Ops! Você não foi localizado! Realize o cadastro!");
        }
    }
    
    
    private static void logoff(){
        logadoStatus = false;
        processo.selecionarUser(0);
    }
    
    private static int menu(){
        String menu;
        int opcao;

        if (!logadoStatus){
        	//menu1
            menu = "1 - Fazer Login\n"
                 + "2 - Cadastrar Usuario\n"
                 + "0 - Sair\n"
                 + ">>> ";
        } else {
        	//menu2
            menu = "1 -  Criar Novo Quadro\n"
                 + "2 -  Listar Quadros\n"
                 + "3 -  Selecionar Quadro\n"
                 + "15 - Mostrar log\n"
      
                 //menu3
                 
                 + "4 -  Adicionar Tarefa\n"
                 + "5 -  Mostrar Tarefas\n"
                 + "6 -  Selecionar tarefa\n"
                 + "16 - Voltar " //voltar para o menu anterior
                 //menu4
                 + "7 -  Adicionar Card\n"
                 + "8 -  Mostrar Card\n"
                 + "9 -  Selecionar Card\n"
                 + "16 - Voltar " //voltar para o menu anterior
                 //menu5
                 + "10 - Adicionar Descrição ao card\n"
                 + "12 - Adicionar Comentario ao card\n"
                 + "13 - Adicionar Etiqueta ao card\n"
                 + "14 - Mover Cards\n"
                 + "16 - Voltar " //voltar para o menu anterior
                 + "0 -  Sair\n"
                 + ">>> ";
        }
        System.out.print(menu);
        opcao = input.nextInt();
        return opcao;
    }
    
    public static void main(String[] args) {
        int opcao = 1;
        
        while (opcao != 0){
            opcao = menu();
            
            if (logadoStatus){
                switch (opcao) {
                    case 1:
                        criarQuadro();
                        break;
                    case 2:
                        listarQuadros();
                        break;
                    case 3:
                        selecionarQuadro();
                        break;
                    case 4:
                        criarTarefa();
                        break;
                    case 5:
                        listarTarefas();
                        break;
                    case 6:
                        entrarTarefa();
                        break;
                    case 7:
                        criarCartao();
                        break;
                    case 8:
                        listarListaDeCartoes();
                        break;
                    case 9:
                        selecionarCartao();
                        break;
                    case 10:
                        adicionarDescricao();
                        break;
                    case 12:
                        adicionarComentario();
                        break;
                    case 13:
                        adicionarEtiqueta();
                        break;
                    case 14:
                        moverCard();
                        break;
                    case 15:
                        mostrarLog();
                        break;
                    case 16:
                        logoff();
                    case 0:
                        System.out.println("Sistema Finalizado!");
                        System.out.printf("\n******************************************\n");
                        break;
                    default:
                        System.out.println("Opcao Invalida!");
                        System.out.printf("\n******************************************\n");
                        break;
                }
            } else {
                switch (opcao) {
                    case 1:
                        login();
                        break;
                    case 2:
                        cadastarUser();
                        break;
                    case 0:
                        System.out.println("Sistema Finalizado!");
                        System.out.printf("\n******************************************\n");
                    default:
                        System.out.println("Opcao Invalida!");
                        System.out.printf("\n******************************************\n");
                        break;
                }
            }
        }
    }
    
}
