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

        Fatura fatura = new Fatura("18/03/2024","Mirlla", 1000);
        ProcessadorDeBoletos processadorBoletos = new ProcessadorDeBoletos();
        int faturaId = processadorBoletos.criaFatura(fatura);
        Boleto boleto1 = new Boleto("1nju2113A","18/03/2024",1);
        Boleto boleto2 = new Boleto("1nju2113A","18/03/2024",990);
        Boleto boleto3 = new Boleto("1nju2113A","18/03/2024",9);;

        processadorBoletos.pagaFatura(faturaId, boleto1);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 999.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto2);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 1.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto3);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 0.0);
        assertTrue(fatura.getPago());
       assertTrue(processadorBoletos.getFatura(faturaId).getBoletosSize() == 3);
    }

    @Test
    public void testCT2Particao() throws ParseException {
        Fatura fatura = new Fatura("18/03/2024","Mirlla", 1000);
        ProcessadorDeBoletos processadorBoletos = new ProcessadorDeBoletos();
        int faturaId = processadorBoletos.criaFatura(fatura);
        Boleto boleto1 = new Boleto("1nju2113A","18/03/2024",1);
        Boleto boleto2 = new Boleto("1nju2113A","18/03/2024",998);
        Boleto boleto3 = new Boleto("1nju2113A","18/03/2024",51);;
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
        Fatura fatura = new Fatura("18/03/2024","Mirlla", 1000);
        ProcessadorDeBoletos processadorBoletos = new ProcessadorDeBoletos();
        int faturaId = processadorBoletos.criaFatura(fatura);
        Boleto boleto1 = new Boleto("1nju2113A","18/03/2024",1);
        Boleto boleto2 = new Boleto("1nju2113A","18/03/2024",998);
        processadorBoletos.pagaFatura(faturaId, boleto1);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 999.0);
        assertFalse(fatura.getPago());
        processadorBoletos.pagaFatura(faturaId, boleto2);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 1.0);
        assertFalse(fatura.getPago());
        assertTrue(processadorBoletos.getFatura(faturaId).getBoletosSize() == 2);
    }

    @Test
    public void testCT2Tabela() throws ParseException {
        Fatura fatura = new Fatura("18/03/2024","Mirlla", 1000);
        ProcessadorDeBoletos processadorBoletos = new ProcessadorDeBoletos();
        int faturaId = processadorBoletos.criaFatura(fatura);
        Boleto boleto1 = new Boleto("1nju2113A","18/03/2024",100);
        processadorBoletos.pagaFatura(faturaId, boleto1);
        assertTrue(processadorBoletos.getFatura(faturaId).getValorRestante() == 900.0);
        assertFalse(fatura.getPago());
        assertTrue(processadorBoletos.getFatura(faturaId).getBoletosSize() == 1);
    }
}
