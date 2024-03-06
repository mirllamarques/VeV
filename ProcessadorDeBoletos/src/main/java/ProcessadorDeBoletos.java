import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProcessadorDeBoletos {

    private ArrayList<Boleto> boletos;

    private Fatura fatura;

    double valorBoletos;

    public ProcessadorDeBoletos(Fatura fatura){
        this.boletos = new ArrayList<Boleto>();
        this.fatura = fatura;
        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");

    }

    public void adicionaBoleto(Boleto boleto){
        this.boletos.add(boleto);
    }

    public String getBoletos() {
        String saida = "";
        for(Boleto boleto : boletos){
            if (saida == ""){
                saida += boleto.toString();
            }else{
                saida += "\n" + boleto.toString();
            }
        }

        return saida;
    }

    public void setValorBoletos() {

        for(Boleto boleto : boletos){
            this.valorBoletos += boleto.getValorPago();
        }
    }

    public void mudaStatus(Fatura fatura){

        if (this.fatura.getValorTotal() <= this.valorBoletos){
            this.fatura.setStatus("PAGO");
        }

    }


    public String extrato(){
        String saida = "";

        saida += fatura.toString() + "\n"+

        "\n" +        getBoletos();

        return saida;
    }


}
