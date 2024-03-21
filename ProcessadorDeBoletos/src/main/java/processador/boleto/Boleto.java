package processador.boleto;

import java.text.DecimalFormat;
import java.util.Date;

public class Boleto {

    private String codigo;

    private String dataBoleto;

    private double valorPago;

    public Boleto(String codigo, String dataBoleto, double valorPago){

        this.valorPago = valorPago;
        this.codigo = codigo;
        this.dataBoleto = dataBoleto;
    }

    public String getDataBoleto() {
        return dataBoleto;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getValorFormatado(){ return String.format("%.2f", this.valorPago);}

    public String getCodigo() {
        return codigo;
    }

    public void setDataBoleto(String dataBoleto) {
        this.dataBoleto = dataBoleto;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {


        return "Tipo: BOLETO\n" +
                "Data: " + this.dataBoleto + "\n"+
                "Valor: "+ this.getValorFormatado();

    }
}
