import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RepoTarefasTestVermelho {

    RepoTarefas repoTarefas = new RepoTarefas();

    @Test
    void addTarefa() {
        RepoTarefas repoTarefas = new RepoTarefas();
        String tituloVazio = "Teste";
        int idTarefa = repoTarefas.addTarefa(tituloVazio);

        assertEquals(-1, idTarefa);
    }

    @Test
    void removeTarefa() {

        RepoTarefas repoTarefas = new RepoTarefas();
        int idInvalido = 999;
        String resultado = repoTarefas.removeTarefa(idInvalido);

        assertEquals("Tarefa Excluída!", resultado);
    }

    @Test
    void getTarefa() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");
        repoTarefas.removeTarefa(1);

        assertEquals(1, repoTarefas.getTarefa(1));
    }

    @Test
    void editTitulo() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");

        repoTarefas.editTitulo(1, "");
        assertEquals("Criar Codigo", repoTarefas.getTarefa(1).toString());
    }

    @Test
    void editDescricao() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");
        repoTarefas.editDescricao(1, "Criar codigo");
        assertEquals("", repoTarefas.getTarefa(1));
    }

    @Test
    void editDataVencimento() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");
        Date data = new Date("18/02/2024");
        repoTarefas.editDataVencimento(1, data);
        assertEquals("", repoTarefas.getTarefa(1).getDataVencimento());
    }

    @Test
    void editPrioridade() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");
        repoTarefas.editPrioridade(1, 3);

        assertEquals("MEDIA", repoTarefas.getTarefa(1).getPrioridade());

    }

    @Test
    void orderByDataVencimento() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");
        repoTarefas.addTarefa("Testar");
        repoTarefas.editPrioridade(1,3);
        repoTarefas.editPrioridade(2, 2);
        repoTarefas.editDataVencimento(1, new Date("01/01/2000"));
        repoTarefas.editDataVencimento(2, new Date("02/01/2000"));
        assertEquals(repoTarefas.orderByPrioridade(), repoTarefas.orderByDataVencimento());

    }

    @Test
    void orderByPrioridade() {
        RepoTarefas repoTarefas = new RepoTarefas();
        repoTarefas.addTarefa("Codar");
        repoTarefas.addTarefa("Testar");
        repoTarefas.editPrioridade(1,3);
        repoTarefas.editPrioridade(2, 2);
        repoTarefas.editDataVencimento(1, new Date("01/01/2000"));
        repoTarefas.editDataVencimento(2, new Date("02/01/2000"));
        assertEquals(repoTarefas.orderByDataVencimento(), repoTarefas.orderByPrioridade());

    }
}