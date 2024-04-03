import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processador.boleto.Boleto;
import processador.boleto.Fatura;
import processador.boleto.ProcessadorDeBoletos;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ProcessadorDeBoletosTesteVerde {

    ProcessadorDeBoletos pb;

    @BeforeEach
    void criaFatura() throws ParseException {
        Fatura fatura = new Fatura("03-03-2024", "Mirlla", 1500.00);
        this.pb = new ProcessadorDeBoletos();
        pb.criaFatura(fatura);
    }

    @Test
    void adicionaEGetBoleto() {

        Boleto b1 = new Boleto("1010101010", "03-03-2024", 600);
       // pb.adicionaBoleto(b1);
        assertEquals("Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: 600,00", pb.getBoletos());

        Boleto b2 = new Boleto("1010101010", "03-03-2024", 500);
        //pb.adicionaBoleto(b2);
        assertEquals("Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: 600,00\n" +
                "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: 500,00", pb.getBoletos());
    }

    @Test
    void setValorBoletosEExtrato() {

        Boleto b1 = new Boleto("1010101010", "03-03-2024", 600);
    //    pb.adicionaBoleto(b1);
        pb.setValorBoletos();
        assertEquals( "Data: 03-03-2024\n" +
                "Valor Total: 1500,00\n" +
                "Nome do Cliente: Mirlla\n" +
                "Status: NÃO PAGA\n" +
                "\n" +
                "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: 600,00", pb.extrato());
    }

}