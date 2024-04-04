package functionalTests;

import org.junit.Test;
import processador.boleto.Boleto;
import processador.boleto.Fatura;
import processador.boleto.ProcessadorDeBoletos;
import static org.junit.Assert.*;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorBoletos {


    // Testes de partição por equivalência
    @Test
    public void testCT1Particao() throws ParseException {

        Fatura fatura = new Fatura("18/03/2024","Mirlla", 3000);
        ProcessadorDeBoletos processadorBoletos = new ProcessadorDeBoletos();
        int faturaId = processadorBoletos.criaFatura(fatura);
        Boleto boleto1 = new Boleto("abc123","18/03/2024",1);
        Boleto boleto2 = new Boleto("abc123","18/03/2024",990);
        Boleto boleto3 = new Boleto("abc123","18/03/2024",9);
        Boleto boleto4 = new Boleto("abc123","18/03/2024",2);
        Boleto boleto5 = new Boleto("abc123","18/03/2024",999);
        Boleto boleto6 = new Boleto("abc123","18/03/2024",99);
        Boleto boleto7 = new Boleto("abc123", "18/03/2024", 900)

        processadorBoletos.pagaFatura(faturaId, boleto1);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 999.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto2);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 1.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto3);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 0.0);
        assertTrue(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto4);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 1998.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto5);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 999.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto6);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 900.0);
        assertTrue(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto7);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 0.0);
        assertTrue(fatura.getPago());
        assertTrue(processadorBoletos.getFatura(faturaId).getBoletosSize() == 7);

    }

    @Test
    public void testCT2Particao() throws ParseException {
        Fatura fatura = new Fatura("18/03/2024","Mirlla", 1000);
        ProcessadorDeBoletos processadorBoletos = new ProcessadorDeBoletos();
        int faturaId = processadorBoletos.criaFatura(fatura);
        Boleto boleto1 = new Boleto("abc123","18/03/2024",1);
        Boleto boleto2 = new Boleto("abc123","18/03/2024",998);
        Boleto boleto3 = new Boleto("abc123","18/03/2024",51);;
        processadorBoletos.pagaFatura(faturaId, boleto1);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 999.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto2);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 1.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto3);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == -50.0);
        assertTrue(fatura.getPago());
        assertTrue(processadorBoletos.getFatura(faturaId).getBoletosSize() == 3);
    }

    @Test
    public void testCT1Tabela() throws ParseException {
        Fatura fatura = new Fatura("18/03/2024","Mirlla", 2600);
        ProcessadorDeBoletos processadorBoletos = new ProcessadorDeBoletos();
        int faturaId = processadorBoletos.criaFatura(fatura);
        Boleto boleto1 = new Boleto("abc123","18/03/2024",10);
        Boleto boleto2 = new Boleto("abc123","18/03/2024",990);
        Boleto boleto3 = new Boleto("abc123","18/03/2024",100);
        Boleto boleto4 = new Boleto("abc123","18/03/2024",1500);
        processadorBoletos.pagaFatura(faturaId, boleto1);
        processadorBoletos.pagaFatura(faturaId, boleto2);
        processadorBoletos.pagaFatura(faturaId, boleto3);
        processadorBoletos.pagaFatura(faturaId, boleto4);
        assertTrue(processadorBoletos.getFatura(faturaId).getBoletosSize() == 4);
    }

    @Test
    public void testCT2Tabela() throws ParseException {
        Fatura fatura = new Fatura("18/03/2024","Mirlla", 1000);
        ProcessadorDeBoletos processadorBoletos = new ProcessadorDeBoletos();
        int faturaId = processadorBoletos.criaFatura(fatura);
        Boleto boleto1 = new Boleto("abc123","18/03/2024",100);
        Boleto boleto2 = new Boleto("abc123","18/03/2024",200);
        Boleto boleto3 = new Boleto("abc123","18/03/2024",300);
        processadorBoletos.pagaFatura(faturaId, boleto1);
        processadorBoletos.pagaFatura(faturaId, boleto2);
        processadorBoletos.pagaFatura(faturaId, boleto3);
        assertTrue(processadorBoletos.getFatura(faturaId).getBoletosSize() == 3);
    }
}
