import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ProcessadorDeBoletos {

    private ArrayList<Boleto> boletos;

    private ArrayList<Fatura> faturas;

    private double valorBoletos;

    public ProcessadorDeBoletos() {

        this.boletos = new ArrayList<Boleto>();
        this.faturas = new ArrayList<Fatura>();

    }

    public void criaFatura(Fatura fatura){
        this.faturas.add(fatura);
    }

    public void pagaFatura(int numeroFatura, Boleto boleto) {

        if (boleto == null) {
            throw new IllegalArgumentException("Boleto não pode ser nulo!");
        }

        this.faturas.get(numeroFatura - 1).pagaFatura(boleto);
    }

    public ArrayList<Fatura> getFaturas() {
        return faturas;
    }

    public String getBoletos() {
        String saida = "";
        for (Boleto boleto : boletos) {
            if (saida.isEmpty()) {
                saida += boleto.toString();
            } else {
                saida += "\n" + boleto.toString();
            }
        }

        return saida;
    }

    public void setValorBoletos() {

        for (Boleto boleto : boletos) {
            this.valorBoletos += boleto.getValorPago();
        }
    }

    public String extrato() {
        String saida = "";

        for(Fatura fatura : faturas){
            if(saida == ""){
                saida += fatura.toString();
            }else{
                saida += "\n" + fatura.toString();
            }
        }

        return saida;
    }
}
