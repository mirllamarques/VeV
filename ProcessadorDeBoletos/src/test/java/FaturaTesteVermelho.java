import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processador.boleto.Fatura;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;



class FaturaTesteVermelho {

    Fatura f1; // Nome Vazio
    Fatura f2; // Nome nulo
    Fatura f3; // Data inexistente
    Fatura f4; // Data nula
    Fatura f5; // Valor negativo


    @BeforeEach
    void criaFatura() throws ParseException {
        this.f1 = new Fatura("03-03-2024", "", 4200.00);
        this.f2 = new Fatura("03-03-2024", null, 4200.00);
        this.f3 = new Fatura("32-02-2024", "Mirlla", 4200.00);
        this.f4 = new Fatura(null, "Mirlla", 4200.00);
        this.f5 = new Fatura("03-03-2024", "Mirlla", -4200.00);
    }
    @Test
    void geToString() {

        //Não deveria permitir ter nome vazio
        assertEquals(f1.toString(), "Data: 03-03-2024\n" +
                "Valor Total: 4200,00\n" +
                "Nome do Cliente: \n" +
                "Status: NÃO PAGA");

        //Não deveria permitir ter nome nulo
        assertEquals(f2.toString(), "Data: 03-03-2024\n" +
                "Valor Total: 4200,00\n" +
                "Nome do Cliente: null\n" +
                "Status: NÃO PAGA");

        //Não deveria ser possível adicionar data inexistente
        assertEquals(f3.toString(), "Data: 32-02-2024\n" + // Data inválida
                "Valor Total: 4200,00\n" +
                "Nome do Cliente: Mirlla\n" +
                "Status: NÃO PAGA");

        //Não deveria ser possível adicionar data nula
        assertEquals(f4.toString(), "Data: null\n" + // Data inválida
                "Valor Total: 4200,00\n" +
                "Nome do Cliente: Mirlla\n" +
                "Status: NÃO PAGA");

        //Não deveria ser possível adicionar valores negativos
        assertEquals(f5.toString(), "Data: 03-03-2024\n" +
                "Valor Total: -4200,00\n" + // Valor negativo
                "Nome do Cliente: Mirlla\n" +
                "Status: NÃO PAGA");
    }

    @Test
    void getSetDataFatura() {
        //não deveria ser possível ter data vazia
        assertEquals(f4.getDataFatura(), null);
        f4.setDataFatura("");
        assertEquals(f4.getDataFatura(), "");
        //não deveria ser possível ter data nula
        f4.setDataFatura(null);
        assertEquals(f4.getDataFatura(), null);
    }

    @Test
    void getSetNomeCliente() {
        //não deveria ser possível ter nome vazio
        f2.setNomeCliente("");
        assertEquals(f2.getNomeCliente(), "");
        //não deveria ser possível ter nome nulo
        f2.setNomeCliente(null);
        assertEquals(f2.getNomeCliente(), null);
    }


    @Test
    void getSetValorTotal() {
        //não deveria ser possível ter valor negativo
        f2.setValorTotal(-500);
        assertEquals(f2.getValorTotal(), -500);
    }

    @Test
    void getSetStatus() {
        //Só deveria ter pago ou não pago
        f1.setStatus(false);
        assertFalse( f1.getPago());

    }


}