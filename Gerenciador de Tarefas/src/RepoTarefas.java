import java.util.*;

import static java.util.Objects.isNull;

public class RepoTarefas {

    private HashMap<Integer, Tarefa> tarefas;
    private int idNumber;

    public RepoTarefas(){
        this.tarefas = new HashMap<>();
        this.idNumber = 1;
    }

    public String addTarefa(String titulo){
        Tarefa tarefa = new Tarefa(idNumber, titulo);
        tarefas.put(idNumber,tarefa);
        idNumber += 1;
        return "Nova tarefa adicionada com sucesso!" + "\n" + tarefa.toString();
    }
    public String addTarefa(String titulo, String descricao){
        Tarefa tarefa = new Tarefa(idNumber, titulo, descricao);
        tarefas.put(idNumber,tarefa);
        idNumber += 1;
        return "Nova tarefa adicionada com sucesso!" + "\n" + tarefa.toString();
    }
    public String addTarefa(String titulo, String descricao, Date dataVencimento){
        Tarefa tarefa = new Tarefa(idNumber, titulo, descricao, dataVencimento);
        tarefas.put(idNumber,tarefa);
        idNumber += 1;
        return "Nova tarefa adicionada com sucesso!" + "\n" + tarefa.toString();
    }
    public String addTarefa(String titulo, Date dataVencimento, String prioridade){
        Prioridade priority = getPrioridade(prioridade);
        Tarefa tarefa = new Tarefa(idNumber, titulo, dataVencimento, priority);
        tarefas.put(idNumber,tarefa);
        idNumber += 1;
        return "Nova tarefa adicionada com sucesso!" + "\n" + tarefa.toString();
    }
    public String addTarefa(String titulo, String descricao, String prioridade){
        Prioridade priority = getPrioridade(prioridade);
        Tarefa tarefa = new Tarefa(idNumber, titulo, descricao, priority);
        tarefas.put(idNumber,tarefa);
        idNumber += 1;
        return "Nova tarefa adicionada com sucesso!" + "\n" + tarefa.toString();
    }
    public String addTarefa(String titulo, String descricao, Date dataVencimento, String prioridade){
        Prioridade priority = getPrioridade(prioridade);
        Tarefa tarefa = new Tarefa(idNumber, titulo, descricao, dataVencimento, priority);
        tarefas.put(idNumber,tarefa);
        idNumber += 1;
        return "Nova tarefa adicionada com sucesso!" + "\n" + tarefa.toString();
    }
    public String removeTarefa(int id){
        String retorno;
        if (isNull(tarefas.get(id))){
            retorno = "Não há tarefas com esse id";
        } else {
            tarefas.remove(id);
            retorno = "Tarefa excluída!";
        }
        return retorno;
    }
    public Tarefa getTarefa(int id){
        return tarefas.get(id);
    }
    public String editTitulo(int id, String titulo){
        String retorno;
        Tarefa tarefa = tarefas.get(id);
        if (isNull(tarefa)){
            retorno = "Não há tarefas com esse id";
        } else {
            tarefa.setTitulo(titulo);
            retorno = "Título alterado com sucesso!" + '\n' +tarefa.toString();
        }
        return retorno;
    }
    public String editDescricao(int id, String descricao){
        String retorno;
        Tarefa tarefa = tarefas.get(id);
        if (isNull(tarefa)){
            retorno = "Não há tarefas com esse id";
        } else {
            tarefa.setDescricao(descricao);
            retorno = "Descrição alterada com sucesso!" + '\n' +tarefa.toString();
        }
        return retorno;
    }
    public String editDataVencimento(int id, Date dataVencimento){
        String retorno;
        Tarefa tarefa = tarefas.get(id);
        if (isNull(tarefa)){
            retorno = "Não há tarefas com esse id";
        } else {
            tarefa.setDataVencimento(dataVencimento);
            retorno = "Data de Vencimento alterada com sucesso!" + '\n' +tarefa.toString();
        }
        return retorno;
    }
    public String editPrioridade(int id, String prioridade){
        String retorno;
        Tarefa tarefa = tarefas.get(id);
        if (isNull(tarefa)){
            retorno = "Não há tarefas com esse id";
        } else {
            tarefa.setPrioridade(getPrioridade(prioridade));
            retorno = "Prioridade alterada com sucesso!" + '\n' +tarefa.toString();
        }
        return retorno;
    }

    private Prioridade getPrioridade(String prioridade) {
        Prioridade retorno;
        if (prioridade.toLowerCase() == "alta"){
            retorno = Prioridade.ALTA;
        } else if(prioridade.toLowerCase() == "media"){
            retorno = Prioridade.MEDIA;
        } else{
            retorno = Prioridade.BAIXA;
        }
        return retorno;
    }

}
