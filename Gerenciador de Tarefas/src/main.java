import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class main {

    static Scanner sc = new Scanner(System.in);
    static RepoTarefas repoTarefas = new RepoTarefas();

    public static void main(String args []){
        
        while (true){
            System.out.println("Bem-vind@ ao Gerenciador de tarefas\n" +
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
                    int tarefaID = 0;

                    while (true) {
                        System.out.println("Qual o id da tarefa que deseja editar?\n");
                        tarefaID = Integer.parseInt(sc.nextLine());
                        if(isNull(repoTarefas.getTarefa(tarefaID))){
                            System.out.println("Não há tarefas com esse id");
                        } else{
                            break;
                        }
                    }
                    while (true) {
                        System.out.println("O que gostaria de editar?\n" +
                                "1- Título\n" + "2-Descrição\n" +
                                "3-Data de Vencimento\n"+ "4-Prioridade\n)");
                        resposta = Integer.parseInt(sc.nextLine());
                        if (resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4) {
                            System.out.println("Opção Inválida");
                        } else {
                            break;
                        }
                    }

                    if (resposta == 1){
                        editTitulo(tarefaID);
                    } else if (resposta == 2){
                        editDescricao(tarefaID);
                    } else if (resposta == 3){
                        editDataVencimento(tarefaID);
                    }else if (resposta == 4){
                        editPrioridade(tarefaID);
                    }

                    System.out.println("Tarefa editada!\n" + repoTarefas.getTarefa(tarefaID).toString()+'\n');


                } else if (action == 3){
                    System.out.println("\nQual tarefa que deseja deletar?\n");
                    int tarefaID = Integer.parseInt(sc.nextLine());
                    System.out.println(repoTarefas.removeTarefa(tarefaID));
                } else if (action == 4){
                    int order =0;

                    while (true) {
                        try{
                            System.out.println("\nQual ordem você prefere?\n" +
                                    "1- Data de vencimento mais próxima\n" + "2-Prioridade\n");
                            order = Integer.parseInt(sc.nextLine());
                            if (order != 1 && order != 2) {
                                System.out.println("Opção Inválida");
                            } else {
                                break;
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Opção Inválida\n");
                        }
                    }

                    if (order == 1){
                        List<Tarefa> lista = repoTarefas.orderByDataVencimento();
                        for (Tarefa tarefa: lista) {
                            System.out.println(tarefa.toString());
                        }
                    }

                    if (order == 2){
                        List<Tarefa> lista = repoTarefas.orderByPrioridade();
                        for (Tarefa tarefa: lista) {
                            System.out.println(tarefa.toString());
                        }
                    }


                } else if (action == 5){
                    break;
                } else {
                    System.out.println("Opção Inválida\n");
                }
            } catch (NumberFormatException e){
                System.out.println("Opção Inválida\n");
            }
        }
    }

    public static void editTitulo(int idTarefa){
        System.out.println("\nQual o título da tarefa?\n");
        String titulo = sc.nextLine().trim();
        repoTarefas.editTitulo(idTarefa, titulo);
    }

    public static void editDescricao(int idTarefa){
        System.out.println("\nQual a descrição da tarefa?\n");
        String descricao = sc.nextLine().trim();
        repoTarefas.editDescricao(idTarefa, descricao);
    }

    public static void editDataVencimento(int idTarefa){
        while (true) {
            System.out.println("\nQual a data de vencimento da tarefa? Use o formato dd/MM/yyyy\n");
            String data = sc.nextLine().trim();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = format.parse(data);
                repoTarefas.editDataVencimento(idTarefa, date);
                break;
            } catch (ParseException e) {
                System.out.println("Formato de data Inválido.");
            }
        }
    }

    public static void editPrioridade(int idTarefa){
        int prioridade =0;

        while (true) {
            try{
                System.out.println("\nQual a prioridade dessa tarefa?\n" +
                        "1- Alta\n" + "2-Média\n" + "3-Baixa\n");
                prioridade = Integer.parseInt(sc.nextLine());
                if (prioridade != 1 && prioridade != 2 && prioridade != 3) {
                    System.out.println("Opção Inválida");
                } else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Opção Inválida\n");
            }
        }

        repoTarefas.editPrioridade(idTarefa, prioridade);

    }

    public static void adicionarTarefa(){
        String titulo;

        while (true) {
            System.out.println("\nQual o título da tarefa?\n");
            titulo = sc.nextLine().trim();
            if (titulo.trim().isEmpty()) {
                System.out.println("Sua tarefa precisa de um nome");
            } else {
                break;
            }
        }

        int idTarefa = repoTarefas.addTarefa(titulo);

        int descricao = 0;

        while (true) {
            try{
                System.out.println("\nQuer adicionar descrição?\n" +
                        "1- Sim\n" + "2-Não\n");
                descricao = Integer.parseInt(sc.nextLine());
                if (descricao != 1 && descricao != 2) {
                    System.out.println("Opção Inválida");
                } else {
                    break;
                }
            }catch (NumberFormatException e){
                    System.out.println("Opção Inválida\n");
            }
        }

        if(descricao == 1) {
            editDescricao(idTarefa);
        }

        int date = 0;

        while (true) {
            try{
                System.out.println("\nQuer adicionar data de vencimento?\n" +
                        "1- Sim\n" + "2-Não\n");
                date = Integer.parseInt(sc.nextLine());
                if (date != 1 && date != 2) {
                    System.out.println("Opção Inválida");
                } else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Opção Inválida\n");
            }
        }

        if(date == 1) {
            editDataVencimento(idTarefa);
        }

        int prioridade = 0;

        while (true) {
            try{
                System.out.println("\nQuer adicionar prioridade da tarefa?\n" +
                        "1- Sim\n" + "2-Não\n");
                prioridade = Integer.parseInt(sc.nextLine());
                if (prioridade != 1 && prioridade != 2) {
                    System.out.println("Opção Inválida");
                } else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Opção Inválida\n");
            }
        }

        if(prioridade == 1) {
            editPrioridade(idTarefa);
        }

        System.out.println("Nova tarefa adicionada!\n" + repoTarefas.getTarefa(idTarefa).toString()+'\n');
    }

}
