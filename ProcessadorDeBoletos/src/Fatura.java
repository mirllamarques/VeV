import java.text.DecimalFormat;

public class Fatura {

    private String dataFatura;

    private String nomeCliente;

    private double valorTotal;

    private String status;

    public Fatura(String dataFatura, String nomeCliente, double valorTotal){

        this.dataFatura = dataFatura;
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
        this.status = "NÃO PAGA";

    }

    public String getDataFatura() {
        return dataFatura;
    }

    public void setDataFatura(String dataFatura) {
        this.dataFatura = dataFatura;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getValorFormatado() {
        return String.format("%.2f", valorTotal);
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Data: " + this.dataFatura + "\n" +
                "Valor Total: " + getValorFormatado() + "\n" +
                "Nome do Cliente: " + this.nomeCliente + "\n" +
                "Status: " + this.status;
    }
}
