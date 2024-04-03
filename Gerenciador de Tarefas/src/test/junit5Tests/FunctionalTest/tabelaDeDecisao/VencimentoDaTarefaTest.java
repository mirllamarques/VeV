package FunctionalTest.tabelaDeDecisao;

import codigo.RepoTarefas;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class VencimentoDaTarefaTest {

    @Test
    public void CT1(){
        RepoTarefas repoTarefas1 = new RepoTarefas();
        repoTarefas1.addTarefa("Tarefa1");
        repoTarefas1.editDataVencimento(1, new Date(2002, 11, 30));
        assertEquals(new Date(2002, 11, 30), repoTarefas1.getTarefa(1).getDataVencimento());
    }

    @Test
    public void CT2(){
        RepoTarefas repoTarefas2 = new RepoTarefas();
        String [] tarefas = {"Tarefa2", "Tarefa3", "Tarefa3", "Tarefa5", "Tarefa6"};
        for(String tarefa: tarefas){
            repoTarefas2.addTarefa(tarefa);
        }
        repoTarefas2.getTarefa(1).setDataVencimento(new Date(2000, 02, 18));
        assertEquals(new Date(2000, 02, 18), repoTarefas2.getTarefa(1).getDataVencimento());
        assertEquals(5, repoTarefas2.getTarefas().size());
    }

    @Test
    public void CT3(){
        RepoTarefas repoTarefas3 = new RepoTarefas();
        repoTarefas3.addTarefa("Tarefa3");
        assertEquals(null, repoTarefas3.getTarefa(1).getDataVencimento());    }
}
