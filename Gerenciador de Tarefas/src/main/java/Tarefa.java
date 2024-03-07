import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Objects.isNull;

public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private Date dataVencimento;
    private Prioridade prioridade;

    public Tarefa(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return  "Id: " + id + '\n' +
                "Título: " + titulo + (isNull(descricao)&&isNull(dataVencimento)&&isNull(prioridade) ? "" :
                (isNull(descricao) ? "" : '\n' + "Descrição: " + descricao)+
                (isNull(dataVencimento) ? "" : '\n' + "Data de Vencimento: " + sdf.format(dataVencimento) )+
                (isNull(prioridade) ? "" :'\n' + "Prioridade: " + prioridade ));
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return descricao;
    }


}
