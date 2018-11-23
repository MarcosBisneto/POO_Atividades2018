package app;

import java.util.ArrayList;
import model.User;
import negocio.Processos;
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
    private static Processos processo = new Processos();
    
    private static void criarQuadro(){
        input = new Scanner(System.in);
        System.out.print("Titulo: ");
        String titulo = input.nextLine();
        processo.cadastrarQuadro(titulo);
    }
    
    
    private static void listarQuadros(){
        ArrayList<Quadro> quadros = processo.getQuadrosCadastrados();
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
            System.out.println("Entrou...!");
        } else {
            System.out.println("Esse quadro não existe!");
        }
    }
    
    
    private static void criarTarefa(){
        input = new Scanner(System.in);
        System.out.print("Titulo: ");
        String titulo = input.nextLine();
        processo.cadastrarTarefa(titulo);
    }
    
    
    private static void listarTarefas(){
        ArrayList<Lista> tarefas = processo.getTarefasCadastradas();
        if (tarefas.isEmpty()){
            System.out.println("Nenhum registro localizado!");
        }
        for (int i = 0; i < tarefas.size(); i++){
            System.out.printf("%d - %s\n", i+1, tarefas.get(i).getTitulo());
        }
    }
    
    
    private static void selecionarTarefa(){
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
        processo.cadastrarCartao(titulo);
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
    
    
    private static void listagemCompletaDeCartoes(){
        ArrayList<Card> cards = processo.getCartoesCadastrados();
        if (cards.isEmpty()){
            System.out.println("Não há Cards!");
        }
        for (int i = 0; i < cards.size(); i++){ 
        	System.out.printf("%dº Card", i+1);
            System.out.printf(">> Titulo - %s\n", cards.get(i).getTitulo());
            System.out.printf(">> Descricao - %s\n", cards.get(i).getDescricao());
            
            System.out.println("  > Comentario(s) Feito(s): ");
            for (int j = 0; j < cards.get(i).getComentarios().size(); j++){
                System.out.printf("\t - %s - %s\n",cards.get(i).getComentarios().get(j).getComentario(),cards.get(i).getComentarios().get(j).getDataHora());
            }
            
            System.out.println("  > Etiqueta(s) Aplicada(s): ");
            for (int j = 0; j < cards.get(i).getEtiquetas().size(); j++){
                System.out.printf("\t - %s - %s\n",cards.get(i).getEtiquetas().get(j).getTitulo(),cards.get(i).getEtiquetas().get(j).getCor());
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
        processo.adicionarDescricaoAoCartao(descricao);
    }
    
    private static void adicionarComentario(){
        input = new Scanner(System.in);
        System.out.print("Comentario: ");
        String comentario = input.nextLine();
        processo.adicionarComentarioAoCartao(comentario);
    }
    
    
    private static void adicionarEtiqueta(){
        input = new Scanner(System.in);
        System.out.print(">> Titulo da Etiqueta: ");
        String titulo = input.nextLine();
        System.out.print(">> Cor da Etiqueta: ");
        String cor = input.nextLine();
        processo.adicionarEtiquetaAoCartao(titulo, cor);
    }
    
    
    private static void moverCartao(){
        input = new Scanner(System.in);
        
        System.out.println(">> Selecione a tarefa");
        listarTarefas();
        System.out.println(">> Opcao: ");
        int tarefa = input.nextInt();
        
        System.out.println(">> Selecione o cartao");
        listarCartoes();
        System.out.println(">> Opcao: ");
        int cartao = input.nextInt();
        
        processo.moverCartao(tarefa, cartao-1);
    }
    
    
    private static void mostrarLog(){
        ArrayList<Log> logs = processo.getLog();
        int contador = 0;
        
        if (logs.size() == 0){
            System.out.println("Não há registros de atividades.\n");
        } else {
        	System.out.println(">>> REGISTROS DE ATIVIDADES REALIZADAS.\n");
        	for (int i = 0; i < logs.size(); i++){
        		contador = contador +1;
                System.out.printf(">>" +contador+ "º Registro: %s\n", logs.get(i).getLog());
            }
        }
        
    }
            
    private static void cadastarUsuario(){
        input = new Scanner(System.in);
        String nome = "";
        String login = "";
        String senha = "";
        
        while (nome.trim().length() == 0 || login.trim().length() == 0 || senha.trim().length() == 0){
            System.out.print("Nome: ");
            nome = input.nextLine();
            System.out.print("Login: ");
            login = input.nextLine();
            System.out.print("Senha: ");
            senha = input.nextLine();
        }
        if (processo.cadastrarUsuario(nome, login, senha)){
            System.out.println(nome + " Você foi cadastrado(a)!");
        } else {
            System.out.println("Ops! Tente novamente!");
        }
    }
    
    
    private static void login(){
        input = new Scanner(System.in);
        String login = "";
        String senha = "";
        
        while (login.trim().length() == 0 || senha.trim().length() == 0){
            System.out.print(">> Login: ");
            login = input.nextLine();
            System.out.print(">> Senha: ");
            senha = input.nextLine();
        }
        if (processo.login(login, senha)){
            System.out.println("Bem-Vindo!");
            logadoStatus = true;
        } else {
            System.out.println("Ops!Você não foi localizado!");
        }
    }
    
    
    private static void logoff(){
        logadoStatus = false;
        processo.selecionarUsuario(0);
    }
    
    private static int menu(){
        String menu;
        int opcao;

        if (!logadoStatus){
        	// seria o *PRIMEIRO MENU**
            menu = "SEJA BEM VINDO - TRELLAR \n"
            	 + "1 - Login\n" //se clicar nessa opçao vem o formaulario de LOGIN.
                 + "2 - Cadastrar Usuario\n" //se clicar nessa opçao vem o formaulario de cadastro.
                 + "0 - Finalizar\n" //sai.
                 + ">>> ";
        } else {
        	//seria o *SEGUNDO MENU* DEPOIS DEPOIS DE CLICAR NA OPÇÃO DA PRIMEIRA LOGIN 
            menu = "1 -  Criar Novo Quadro\n" //se clicar nessa opçao vem o formaulario NOVO QUADRO.
                 + "2 -  Meus Quadros - Listar Quadros\n" //tela com a lista.
                 + "3 -  Selecionar Quadro\n"
           //  SE CLICAR NA OPÇÃO MOSTRAR QUADROS: *TERCEIRO MENU* DEPOIS DE ENTRAR SELECIONAR O QUADRO.      
                 + "4 -  Cadastrar tarefa\n" //se clicar nessa opçao vem o formaulario NOVO cadastrar tarefa.
                 + "5 -  Listar tarefas\n" // listas tarefas. 
                 + "6 -  Selecionar tarefa\n"

            // DEPOIS DE SELECIONAR A TAREFA, APARECE O *QUARTO MENU*
                 + "7 -  Adicionar Card\n"
                 + "8 -  Listar Cards\n"      
                 + "9 -  Selecionar Cards\n"
            /// *QUINTO MENU* DEPOIS DE SELECIONAR UM CARD
                 + "10 - Adicionar descrição ao card\n"
                 + "12 - Adicionar comentario ao cartao\n"
                 + "13 - Adicionar etiqueta ao cartao\n"
                 + "14 - Alternar cartao para outra tarefa\n"
                 + ">>> ";
        }
        
        System.out.println("********************************");
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
                        selecionarTarefa();
                        break;
                    case 7:
                        criarCartao();
                        break;
                    case 8:
                        listagemCompletaDeCartoes();
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
                        moverCartao();
                        break;
                    case 15:
                        mostrarLog();
                        break;
                    case 16:
                        logoff();
                    case 0:
                        System.out.println("Sistema finalizado!");
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                        break;
                }
            } else {
                switch (opcao) {
                    case 1:
                        login();
                        break;
                    case 2:
                        cadastarUsuario();
                        break;
                    case 0:
                        System.out.println("Sistema finalizado!");
                    default:
                        System.out.println("Opcao invalida!");
                        break;
                }
            }
        }
    }
    
}
