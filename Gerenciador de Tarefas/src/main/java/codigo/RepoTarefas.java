package codigo;

import codigo.Tarefa;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class RepoTarefas {

    private HashMap<Integer, Tarefa> tarefas;
    private int idNumber;

    public RepoTarefas(){
        this.tarefas = new HashMap<>();
        this.idNumber = 1;
    }

    public int addTarefa(String titulo){
        Tarefa tarefa = new Tarefa(idNumber, titulo);
        tarefas.put(idNumber,tarefa);
        idNumber += 1;
        return idNumber -1;
    }

    public String removeTarefa(int id){
        String retorno;
        if (isNull(tarefas.get(id))){
            retorno = "Não há tarefas com esse id";
        } else {
            tarefas.remove(id);
            retorno = "codigo.Tarefa excluída!";
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
    public String editPrioridade(int id, int prioridade){
        String retorno;
        Tarefa tarefa = tarefas.get(id);
        if (isNull(tarefa)){
            retorno = "Não há tarefas com esse id";
        } else {
            tarefa.setPrioridade(getPrioridade(prioridade));
            retorno = "codigo.Prioridade alterada com sucesso!" + '\n' +tarefa.toString();
        }
        return retorno;
    }

    public List<Tarefa> orderByDataVencimento() {
        return tarefas.values().stream()
                .sorted(Comparator.comparing(Tarefa::getDataVencimento, Comparator.nullsLast(Date::compareTo)))
                .collect(Collectors.toList());
    }

    public List<Tarefa> orderByPrioridade() {
        return tarefas.values().stream()
                .sorted(Comparator.comparing(Tarefa::getPrioridade, Comparator.nullsLast(Prioridade::compareTo)))
                .collect(Collectors.toList());
    }

    public HashMap<Integer, Tarefa> getTarefas() {
        return tarefas;
    }

    private Prioridade getPrioridade(int prioridade) {
        Prioridade retorno;
        if (prioridade == 1){
            retorno = Prioridade.ALTA;
        } else if(prioridade == 2){
            retorno = Prioridade.MEDIA;
        } else{
            retorno = Prioridade.BAIXA;
        }
        return retorno;
    }

}
