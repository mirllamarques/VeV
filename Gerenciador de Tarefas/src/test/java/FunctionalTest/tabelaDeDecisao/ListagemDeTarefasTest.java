package FunctionalTest.tabelaDeDecisao;

import codigo.RepoTarefas;
import codigo.Tarefa;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ListagemDeTarefasTest {

    @Test
    public void CT1(){
        RepoTarefas repoTarefas1 = new RepoTarefas();
        repoTarefas1.addTarefa("Tarefa1");
        repoTarefas1.addTarefa("Tarefa2");
        repoTarefas1.editDataVencimento(1,new Date());

        assertEquals("Tarefa1", repoTarefas1.getTarefa(1).getTitulo());
    }

    @Test
    public void CT2(){
        RepoTarefas repoTarefas2 = new RepoTarefas();
        repoTarefas2.addTarefa("Tarefa3");
        repoTarefas2.addTarefa("Tarefa4");
        repoTarefas2.getTarefa(1).setTitulo("TarefaVeV");
        assertEquals("Tarefa3", repoTarefas2.getTarefa(2).getTitulo());

    }
}
