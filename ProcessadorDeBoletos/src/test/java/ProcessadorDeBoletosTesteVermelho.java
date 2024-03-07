import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProcessadorDeBoletosTesteVermelho {
    
    ProcessadorDeBoletos pb;

    @BeforeEach
    void criaFatura() {
        Fatura fatura = new Fatura("03-03-2024", "Mirlla", 1500.00);
        this.pb = new ProcessadorDeBoletos(fatura);
    }

    @Test
    void adicionaEGetBoleto() {
        //Não deveria ser possível adicionar valores negativos
        Boleto b1 = new Boleto("1010101010", "03-03-2024", -500);
        pb.adicionaBoleto(b1);
        assertEquals( "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: -500,00", pb.getBoletos());

        //Não deveria ser possível adicionar datas vazias
        Boleto b2 = new Boleto("1010101010", "", 500);
        pb.adicionaBoleto(b2);
        assertEquals( "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: -500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: \n" +
                "Valor: 500,00", pb.getBoletos());

        //Não deveria ser possível adicionar data nula
        Boleto b3 = new Boleto("1010101010", null, 500);
        pb.adicionaBoleto(b3);
        assertEquals( "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: -500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: \n" +
                "Valor: 500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: null\n" +
                "Valor: 500,00", pb.getBoletos());

        //Não deveria ser possível adicionar código vazio
        Boleto b4 = new Boleto("", "03-03-2024", 500);
        pb.adicionaBoleto(b4);
        assertEquals( "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: -500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: \n" +
                "Valor: 500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: null\n" +
                "Valor: 500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: 500,00", pb.getBoletos());

        //Não deveria ser possível adicionar código nulo
        Boleto b5 = new Boleto(null, "03-03-2024", 500);
        pb.adicionaBoleto(b5);
        assertEquals( "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: -500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: \n" +
                "Valor: 500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: null\n" +
                "Valor: 500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: 500,00\n" +
                "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: 500,00", pb.getBoletos());

    }

    @Test
    void setValorBoletosEExtrato() {

        Boleto b1 = new Boleto("1010101010", "03-03-2024", -500);
        pb.adicionaBoleto(b1);
        pb.setValorBoletos();
        assertEquals( "Tipo: BOLETO\n" +
                "Data: 03-03-2024\n" +
                "Valor: 1000,00", pb.extrato());
    }

}