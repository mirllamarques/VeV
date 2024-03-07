import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class mainTestVermelho {

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
    void adicionarTarefa() {
        RepoTarefas repoTarefas = new RepoTarefas();
        String titulo = null;

        int idTarefa = repoTarefas.addTarefa(titulo);


        assertEquals(-1, idTarefa);
    }
}