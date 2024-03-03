import java.util.Date;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class main {

    public static void main(String args []){
//        Date d = new Date("03/03/2001");
//        Tarefa t =  new Tarefa(0,"Teste", "Testando", d);
//        System.out.println(t);
//        System.out.println(repoTarefas.addTarefa("Teste"));
//        //System.out.println(repoTarefas.editDescricao(1, "Testando"));
//        System.out.println(repoTarefas.editDataVencimento(1, d));
//        //System.out.println(repoTarefas.addTarefa("Teste", "Testando", d, "alta"));
        Scanner sc = new Scanner(System.in);
        RepoTarefas repoTarefas = new RepoTarefas();
        while (true){
            System.out.println( "Bem-vind@ ao Gerenciador de tarefas\n" +
                    "O que posso fazer por você?\n" +
                    "1- Adicionar Tarefa\n" +
                    "2- Editar Tarefa\n" +
                    "3- Excluir Tarefa\n" +
                    "4- Listar Tarefas\n" +
                    "5- Sair\n");
            try {
                int action = Integer.parseInt(sc.nextLine());
                if (action == 5) {
                    break;
                } else if (action == 1) {
                    adicionarTarefa();
                } else if(action == 2){
                    int resposta = 0;
                    while (true) {
                        System.out.println("\nQual o id da tarefa que deseja editar?\n");
                        int tarefaID = Integer.parseInt(sc.nextLine());
                        if(isNull(repoTarefas.getTarefa(tarefaID))){
                            System.out.println("Não há tarefas com esse id");
                        } else{
                            break;
                        }
                    }
                    while (true) {
                        System.out.println("\nO que gostaria de editar?\n" +
                                "1- Título\n" + "2-Descrição\n" +
                                "3-Data de Vencimento\n"+ "4-Prioridade\n)");
                        resposta = Integer.parseInt(sc.nextLine());
                        if (resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4) {
                            System.out.println("Opção In1válida");
                        } else {
                            break;
                        }
                    }
                }else if (action == 3){
                    System.out.println("\nQual tarefa que deseja deletar?\n");
                   int tarefaID = Integer.parseInt(sc.nextLine());
                   System.out.println(repoTarefas.removeTarefa(tarefaID));
                }
            } catch (NumberFormatException e){
                System.out.println("Opção Inválida\n");
            }
        }
    }

    public static void adicionarTarefa(){
        Scanner sc = new Scanner(System.in);
        RepoTarefas repoTarefas = new RepoTarefas();

        String titulo;
        String descricao;
        Date dataVencimento;
        String prioridade;

        while (true) {
            System.out.println("\nQual o título da tarefa?\n");
            titulo = sc.nextLine().trim();
            if (titulo.trim().isEmpty()) {
                System.out.println("Sua tarefa precisa de um nome");
            } else {
                break;
            }
        }
        int resposta = 0;
        while (true) {
            try{
                System.out.println("\nQuer adicionar descrição?\n" +
                        "1- Sim\n" + "2-Não\n");
                resposta = Integer.parseInt(sc.nextLine());
                if (resposta != 1 && resposta != 2) {
                    System.out.println("Opção Inválida");
                } else {
                    break;
                }
            }catch (NumberFormatException e){
                    System.out.println("Opção Inválida\n");
                }
            if(resposta == 1) {
                System.out.println("\nQual a descrição da tarefa?\n");
                titulo = sc.nextLine().trim();
            }
        }
    }
}
