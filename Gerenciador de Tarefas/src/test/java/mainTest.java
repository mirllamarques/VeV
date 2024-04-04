import codigo.Prioridade;
import codigo.RepoTarefas;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {

    @Test
    void editTitulo() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");

        assertEquals("Codar", repoTarefas.getTarefa(1).getTitulo());
    }

    @Test
    void criaTarefa1(){
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("");
        assertEquals("", repoTarefas.getTarefa(1).getTitulo());
    }

    @Test
    void criaTarefa2(){
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Tarefa2");
        assertEquals("Tarefa2", repoTarefas.getTarefa(1).getTitulo());
    }

    @Test
    void criaTarefa3(){
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Tarefa3");
        assertEquals("Tarefa3", repoTarefas.getTarefa(1).getTitulo());
    }

    @Test
    void criaTarefa4(){
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Tarefa4");
        assertEquals("Tarefa4", repoTarefas.getTarefa(1).getTitulo());
    }

    @Test
    void removeTarefa1(){
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Tarefa1");
        repoTarefas.removeTarefa(1);

        assertEquals(null, repoTarefas.getTarefa(1));

    }

    @Test
    void removeTarefa2(){
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Tarefa1");
        repoTarefas.removeTarefa(1);

        assertEquals("Tarefa1", repoTarefas.getTarefa(1).getTitulo());

    }

    @Test
    void removeTarefa3(){
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Tarefa2");
        repoTarefas.removeTarefa(2);

        assertEquals("Tarefa2", repoTarefas.getTarefa(1).getTitulo());

    }

    @Test
    void editDescricao() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");
        repoTarefas.editDescricao(1, "Criar códigos");

        assertEquals("Criar códigos", repoTarefas.getTarefa(1).getDescricao());
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
    void adicionarTarefa() {
        RepoTarefas repoTarefas = new RepoTarefas();
        String titulo = "Teste";
        int idTarefa = repoTarefas.addTarefa(titulo);

        assertEquals(1, idTarefa);
    }
}