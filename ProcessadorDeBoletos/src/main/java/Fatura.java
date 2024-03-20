import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fatura {

    //Usar Date, validar todas as Strings se são vazias ou nulas e não permitir valor negativo
    private String dataFatura;

    private String nomeCliente;

    private double valorTotal;

    private double valorRestante;

    private ArrayList<Boleto> boletos;
    private String status;

    public Fatura(String dataFatura, String nomeCliente, double valorTotal) throws ParseException {

        if (dataFatura == null || dataFatura.isEmpty()) {
            throw new IllegalArgumentException("Data da fatura não pode ser nula ou vazia!");
        }

        if (nomeCliente == null || nomeCliente.isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio!");
        }

        if (valorTotal <= 0) {
            throw new IllegalArgumentException("Valor total da fatura deve ser maior que zero!");
        }

        this.dataFatura = dataFatura;


        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
        this.valorRestante = valorTotal;
        this.status = "NÃO PAGA";
        this.boletos = new ArrayList<Boleto>();

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

    public void pagaFatura(Boleto boleto){
        this.valorRestante -= boleto.getValorPago();
        boletos.add(boleto);
        if (valorRestante>=0){
            this.status = "NÃO PAGA";
        }
    }

    public double getValorRestante() {
        return valorRestante;
    }

    @Override
    public String toString() {
        String saidaBoletos = "";
        for (Boleto boleto : this.boletos){
            if(saidaBoletos == "") {
                saidaBoletos += boleto.toString();
            }else{
                saidaBoletos += "\n" + boleto.toString();
            }
        }


        return "Data: " + this.dataFatura + "\n" +
                "Valor Total: " + getValorFormatado() + "\n" +
                "Nome do Cliente: " + this.nomeCliente + "\n" +
                "Status: " + this.status + "\n" + saidaBoletos;
    }
}
