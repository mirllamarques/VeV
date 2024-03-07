import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaturaTesteVerde {

    Fatura f1;

    @BeforeEach
    void criaFatura(){
        this.f1 = new Fatura("03-03-2024", "Mirlla", 4200.00);
    }
    @Test
    void geToString() {

        assertEquals(f1.toString(), "Data: 03-03-2024\n" +
                "Valor Total: 4200,00\n" +
                "Nome do Cliente: Mirlla\n" +
                "Status: NÃO PAGA");

    }

    @Test
    void getSetDataFatura() {
        assertEquals(f1.getDataFatura(), "03-03-2024");
        f1.setDataFatura("03-04-2024");
        assertEquals(f1.getDataFatura(), "03-04-2024");
    }

    @Test
    void getSetNomeCliente() {
        assertEquals(f1.getNomeCliente(), "Mirlla");
        f1.setNomeCliente("Mirila");
        assertEquals(f1.getNomeCliente(), "Mirila");
    }


    @Test
    void getSetValorTotal() {
        assertEquals(f1.getValorTotal(), 4200);
        f1.setValorTotal(1500);
        assertEquals(f1.getValorTotal(), 1500);
    }

    @Test
    void getSetStatus() {
        assertEquals( f1.getStatus(), "NÃO PAGA");
        f1.setStatus("PAGA");
        assertEquals( f1.getStatus(), "PAGA");

    }
}