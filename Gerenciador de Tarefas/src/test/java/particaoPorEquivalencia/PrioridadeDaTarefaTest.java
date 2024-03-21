package particaoPorEquivalencia;
import codigo.Prioridade;
import codigo.RepoTarefas;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrioridadeDaTarefaTest {

    @Test
    public void CT1(){
        RepoTarefas repoTarefas1 = new RepoTarefas();
        repoTarefas1.addTarefa("Tarefa1");
        assertEquals(1, repoTarefas1.getTarefas().size());
    }

    @Test
    public void CT2(){
        RepoTarefas repoTarefas2 = new RepoTarefas();
        repoTarefas2.addTarefa("Tarefa2");
        assertEquals(null, repoTarefas2.getTarefa(1).getPrioridade());
    }

    @Test
    public void CT3(){
        RepoTarefas repoTarefas3 = new RepoTarefas();
        repoTarefas3.addTarefa("Tarefa3");
        repoTarefas3.getTarefa(1).setPrioridade(Prioridade.ALTA);
        assertEquals(Prioridade.ALTA, repoTarefas3.getTarefa(1).getPrioridade());
    }

    @Test
    public void CT4(){
        RepoTarefas repoTarefas4 = new RepoTarefas();
        repoTarefas4.addTarefa("Tarefa4");
        assertEquals(Prioridade.BAIXA, repoTarefas4.getTarefa(1).getPrioridade());
    }
}