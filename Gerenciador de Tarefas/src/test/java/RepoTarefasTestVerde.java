import codigo.Prioridade;
import codigo.RepoTarefas;
import codigo.Tarefa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RepoTarefasTestVerde {

    @Test
    void addTarefa() {
        RepoTarefas repoTarefas = new RepoTarefas();
        String titulo = "Teste";
        int idTarefa = repoTarefas.addTarefa(titulo);

        assertEquals(1, idTarefa);
    }

    @Test
    void removeTarefa() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Teste");

        String retorno = repoTarefas.removeTarefa(1);
        assertEquals("codigo.Tarefa excluída!", retorno);
    }

    @Test
    void getTarefa() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("codigo.Tarefa 1");
        repoTarefas.addTarefa("codigo.Tarefa 2");


        Tarefa tarefa = repoTarefas.getTarefa(1);

        assertNotNull(tarefa);
        assertEquals("codigo.Tarefa 1", tarefa.getTitulo());
    }

    @Test
    void editTitulo() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("codigo.Tarefa 1");
        repoTarefas.addTarefa("codigo.Tarefa 2");

        repoTarefas.editTitulo(1, "codigo.Tarefa 2");
        Tarefa tarefa = repoTarefas.getTarefa(1);

        assertNotNull(tarefa);
        assertEquals("codigo.Tarefa 2", tarefa.getTitulo());

    }

    @Test
    void editDescricao() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("codigo.Tarefa 1");
        repoTarefas.addTarefa("codigo.Tarefa 2");


        Tarefa tarefa = repoTarefas.getTarefa(1);
        repoTarefas.editDescricao(1, "codigo.Tarefa de Código");

        assertNotNull(tarefa);
        assertEquals("codigo.Tarefa de Código", tarefa.getDescricao());
    }

    @Test
    void editDataVencimento() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("codigo.Tarefa 1");
        repoTarefas.addTarefa("codigo.Tarefa 2");

        repoTarefas.editDataVencimento(1, new Date("03/03/2003"));
        assertEquals(new Date("03/03/2003"), repoTarefas.getTarefa(1).getDataVencimento());
    }

    @Test
    void editPrioridade() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("codigo.Tarefa 1");
        repoTarefas.addTarefa("codigo.Tarefa 2");

        repoTarefas.editPrioridade(1, 1);
        repoTarefas.editPrioridade(2, 2);

        assertEquals(Prioridade.ALTA, repoTarefas.getTarefa(1).getPrioridade());
    }

    @Test
    void orderByDataVencimento() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("codigo.Tarefa 1");
        repoTarefas.addTarefa("codigo.Tarefa 2");
        repoTarefas.editDataVencimento(1, new Date("01/01/2000"));
        repoTarefas.editDataVencimento(1, new Date("31/12/2024"));
        ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) repoTarefas.orderByDataVencimento();
        assertEquals(2, tarefas.get(1).getId());
    }

    @Test
    void orderByPrioridade() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("codigo.Tarefa 1");
        repoTarefas.addTarefa("codigo.Tarefa 2");
        repoTarefas.editPrioridade(1, 1);
        repoTarefas.editPrioridade(2, 2);
        ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) repoTarefas.orderByPrioridade();
        assertEquals(2, tarefas.get(1).getId());
    }
}