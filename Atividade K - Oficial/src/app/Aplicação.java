package app;

import java.util.ArrayList;
import model.User;
import negocio.Processos;
import model.Quadro;
import model.Lista;
import model.Card;
import model.Comentario;
import model.Etiquetas;
import java.util.Scanner;

public class Aplicação {
	    private static Scanner input = new Scanner(System.in);
	    private static boolean statusLogar = false;
	    private static Processos processo = new Processos();
	    
	    public static void main(String[] args) {
	        int opcao = 1;
	        
	        while (opcao != 0){
	            opcao = menu1();
	            
	            if (statusLogar){
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
	                        criarLista();
	                        break;
	                    case 5:
	                        mostrarListas();
	                        break;
	                    case 6:
	                        selecionarLista();
	                        break;
	                    case 7:
	                        criarCartao();
	                        break;
	                    case 8:
	                        listagemCards();
	                        break;
	                    case 9:
	                        selecionarCard();
	                        break;
	                    case 10:
	                        adicionarDescricaoCard();
	                        break;
	                    case 11:
	                        adicionarPrazo();
	                        break;
	                    case 12:
	                        adicionarComentarioCard();
	                        break;
	                    case 13:
	                        adicionarEtiquetaCard();
	                        break;
	                    case 14:
	                        moverCard();
	                        break;
	                    case 15:
	                        logOut();
	                        break;
	                    case 00:
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
	                    case 00:
	                        System.out.println("Sistema finalizado!");
	                    default:
	                        System.out.println("Opcao invalida!");
	                        break;
	                }
	            }
	        }
	    }
	    
	    private static int menu1(){
	        String menu;
	        int opcao=0;

	        if (!statusLogar){
	            menu = "SEJA BEM VINDO - TRELLAR \n"
	            	 + "1 - Login\n"
	                 + "2 - Cadastrar Usuario\n"
	                 + "00 - Finalizar\n"
	                 + "10 - Logoff\n"
	                 + ">>> ";
		        
		        System.out.print(menu);
		        opcao = input.nextInt();
	        }
	        return opcao;
	    }
	    
	    private static int menu2(){
	        String menu2;
	        int opcao=0;

	        if (!statusLogar){
	            menu2 = "OPÇÕES PARA QUADROS \n"
	            	 + "1 - Cadastrar Nova Lista/Tarefa\n"
	                 + "2 - Meus Quadros - Listar Quadros\n"
	                 + "3 - Selecionar um Quadro\n"
	                 + "00 - Finalizar\n"
	                 + ">>> ";
		        
		        System.out.print(menu2);
		        opcao = input.nextInt();
	        }
	        return opcao;
	    }
	    
	    private static int menu3(){
	        String menu3;
	        int opcao=0;

	        if (!statusLogar){
	            menu3 = "OPÇÕES PARA LISTA/TAREFA \n"
		                 + "1 -  Adicionar uma Lista/Tarefa \n"
		                 + "2 -  Mostrar Minhas Listas/Tarefas\n"      
		                 + "3 -  Selecionar uma Lista/Tarefa \n"
		                 + "00 - Finalizar\n"
		                 + ">>> ";
		                  
		        System.out.print(menu3);
		        opcao = input.nextInt();
	        }
	        return opcao;
	    }
	    
	    private static int menu4(){
	        String menu4;
	        int opcao=0;

	        if (!statusLogar){
	            menu4 = "OPÇÕES PARA CARDS \n"
		                 + "1 -  Adicionar Card\n"
		                 + "2 -  Listar Cards\n"      
		                 + "3 -  Selecionar Cards\n"
		                 + "00 - Finalizar\n"
		                 + ">>> ";
		                  
		        System.out.print(menu4);
		        opcao = input.nextInt();
	        }
	        return opcao;
	    }
	    
	    private static int menu5(){
	        String menu5;
	        int opcao=0;

	        if (!statusLogar){
	            menu5 = "OPÇÕES PARA UM CARD \n"
		                 + "10 - Adicionar descrição ao card\n"
		                 + "11 - Adicionar data de entrega ao cartao\n"
		                 + "12 - Adicionar comentario ao cartao\n"
		                 + "13 - Adicionar etiqueta ao cartao\n"
		                 + "14 - Mover Card para outra Lista/Tarefa\n"
		                 + "00 - Finalizar\n"
		                 + ">>> ";
		                  
		        System.out.print(menu5);
		        opcao = input.nextInt();
	        }
	        return opcao;
	    }
	    
	    private static void criarQuadro(){
	        input = new Scanner(System.in);
	        System.out.print("Titulo do Tema: ");
	        String titulo = input.nextLine();
	        processo.cadastrarQuadro(titulo);
	    }
	    
	    
	    private static void listarQuadros(){
	        ArrayList<Quadro> quadros = processo.getQuadrosCadastrados();
	        if (quadros.isEmpty()){
	            System.out.println("Não Localizado!");
	        }
	        for (int i = 0; i < quadros.size(); i++){
	            System.out.printf("%d - %s\n", i+1, quadros.get(i).getTitulo());
	        }
	    }
	    
	    
	    private static void selecionarQuadro(){
	        input = new Scanner(System.in);
	        listarQuadros();
	        System.out.print("Opcao: ");
	        int opcao = input.nextInt();
	        if (processo.selecionarQuadro(opcao)){
	            System.out.println("Alteração feita!");
	        } else {
	            System.out.println("Não realizado, tente de novo!");
	        }
	    }
	    
	    
	    private static void criarLista(){
	        input = new Scanner(System.in);
	        System.out.print("Titulo da Lista: ");
	        String titulo = input.nextLine();
	        processo.cadastrarTarefa(titulo);
	    }
	    
	    
	    private static void mostrarListas(){
	        ArrayList<Lista> listas = processo.getTarefasCadastradas();
	        if (listas.isEmpty()){
	            System.out.println("Não há lista(s)!");
	        }
	        for (int i = 0; i < listas.size(); i++){
	            System.out.printf("%d - %s\n", i, listas.get(i).getTitulo());
	        }
	    }
	    
	    
	    private static void selecionarLista(){
	        input = new Scanner(System.in);
	        mostrarListas();
	        System.out.print("Opcao: ");
	        int opcao = input.nextInt();
	        if (processo.selecionarTarefa(opcao)){
	            System.out.println("Alteração feita!");
	        } else {
	            System.out.println("Não realizado, tente de novo!");
	        }
	    }
	    
	    
	    private static void criarCartao(){
	        input = new Scanner(System.in);
	        System.out.print("Titulo: ");
	        String titulo = input.nextLine();
	        processo.cadastrarCartao(titulo);
	    }
	    
	    
	    private static void listarCards(){
	        ArrayList<Card> cartoes = processo.getCartoesCadastrados();
	        if (cartoes.isEmpty()){
	            System.out.println("Nenhum registro localizado!");
	        }
	        for (int i = 0; i < cartoes.size(); i++){
	            System.out.printf("%d - %s\n", i, cartoes.get(i).getTitulo());
	        }
	    }
	    
	    
	    private static void listagemCards(){
	        ArrayList<Card> cartoes = processo.getCartoesCadastrados();
	        if (cartoes.isEmpty()){
	            System.out.println("Nenhum registro localizado!");
	        }
	        for (int i = 0; i < cartoes.size(); i++){
	            System.out.println("--------------------------------------------");
	            System.out.printf("Titulo - %s\n", cartoes.get(i).getTitulo());
	            System.out.printf("Descricao - %s\n", cartoes.get(i).getDescricao());
	            
	            System.out.println("Comentarios");
	            for (int j = 0; j < cartoes.get(i).getComentarios().size(); j++){
	                System.out.printf("\t - %s - %s\n",
	                        cartoes.get(i).getComentarios().get(j).getComentario(),
	                        cartoes.get(i).getComentarios().get(j).getDataHora());
	            }
	            
	            System.out.println("Etiquetas");
	            for (int j = 0; j < cartoes.get(i).getEtiquetas().size(); j++){
	                System.out.printf("\t - %s - %s\n", 
	                        cartoes.get(i).getEtiquetas().get(j).getTitulo(),
	                        cartoes.get(i).getEtiquetas().get(j).getCor());
	            }
	        }
	    }
	    
	    
	    private static void selecionarCard(){
	        input = new Scanner(System.in);
	        mostrarListas();
	        System.out.print("Opcao: ");
	        int opcao = input.nextInt();
	        if (processo.selecionarCartao(opcao)){
	            System.out.println("Alteracao aplicada com sucesso!");
	        } else {
	            System.out.println("Problemas na selecao, tente novamente!");
	        }
	    }
	    
	    
	    private static void adicionarDescricaoCard(){
	        input = new Scanner(System.in);
	        System.out.print("Descricao: ");
	        String descricao = input.nextLine();
	        processo.adicionarDescricaoAoCartao(descricao);
	    }
	    
	    
	    private static void adicionarPrazo(){
	        input = new Scanner(System.in);
	        System.out.print("Data de entrega: ");
	        String data = input.nextLine();
	        processo.adicionarDataParaEntregaDoCartao(data);
	    }
	    
	    
	    private static void adicionarComentarioCard(){
	        input = new Scanner(System.in);
	        System.out.print("Comentario: ");
	        String comentario = input.nextLine();
	        processo.adicionarComentarioAoCartao(comentario);
	    }
	    
	    
	    private static void adicionarEtiquetaCard(){
	        input = new Scanner(System.in);
	        System.out.print("Etiqueta: ");
	        String titulo = input.nextLine();
	        System.out.print("Cor: ");
	        String cor = input.nextLine();
	        processo.adicionarEtiquetaAoCartao(titulo, cor);
	    }
	    
	    
	    private static void moverCard(){
	        input = new Scanner(System.in);
	        
	        System.out.println("Qual Lista: ");
	        mostrarListas();
	        System.out.println("Card/Opção: ");
	        int cardNumero = input.nextInt();
	        
	        System.out.println("Selecione o Card");
	        listarCards();
	        System.out.println("Opcao: ");
	        int card = input.nextInt();
	        
	        processo.moverCartao(cardNumero, card);
	    }  
	    
	    private static void cadastarUsuario(){
	        input = new Scanner(System.in);
	        String nome = "";
	        String idLogin = "";
	        String senha = "";
	        
	        while (nome.trim().length() == 0 || idLogin.trim().length() == 0 || senha.trim().length() == 0){
	            System.out.print("Nome: ");
	            nome = input.nextLine();
	            System.out.print("Login: ");
	            idLogin = input.nextLine();
	            System.out.print("Senha: ");
	            senha = input.nextLine();
	        }
	        if (processo.cadastrarUsuario(nome, idLogin, senha)){
	            System.out.println("Usuario cadastrado com sucesso!");
	        } else {
	            System.out.println("Problemas no cadastro, tente novamente!");
	        }
	    }
	    
	    
	    private static void login(){
	        input = new Scanner(System.in);
	        String idLogin = "";
	        String senha = "";
	        
	        while (idLogin.trim().length() == 0 || senha.trim().length() == 0){
	            System.out.print("Login: ");
	            idLogin = input.nextLine();
	            System.out.print("Senha: ");
	            senha = input.nextLine();
	        }
	        if (processo.login(idLogin, senha)){
	            System.out.println("Logando! Seja Bem Vindo!");
	            statusLogar = true;
	        } else {
	            System.out.println("Usuario não encontrado!");
	        }
	    }
	    
	    
	    private static void logOut(){
	        statusLogar = false;
	        processo.selecionarUsuario(0);
	    }	

	}
