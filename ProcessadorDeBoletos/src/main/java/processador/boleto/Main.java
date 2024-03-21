package processador.boleto;

import processador.boleto.Boleto;
import processador.boleto.Fatura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        int opcao;

        while(true){

            System.out.println("""
                O que gostaria de fazer?
                1- Cadastrar fatura.
                2- Pagar fatura.
                3- Ver extrato e sair.""");

            String entrada = br.readLine();
            if(entrada.isEmpty()){
                System.out.println("Opção inválida, tente novamente.");
                continue;
            }
            opcao = Integer.parseInt(entrada);


            if (opcao != 1 && opcao != 2 && opcao != 3 ) {
                System.out.println("Opção inválida, tente novamente.");
                opcao = Integer.parseInt(br.readLine());
            }

            switch (opcao) {
                case 1:

                    System.out.println("Informe seu nome:");
                    String nomeCliente = br.readLine();

                    System.out.println("Informe a data da fatura no formato dd-MM-yyyy :");
                    String dataFatura = br.readLine();

                    while (dataFatura.length() != 10) {
                        System.out.println("Formato inválido, tente novamente.");
                        dataFatura = br.readLine();
                    }

                    System.out.println("Informe o valor total para pagamento:");
                    double valorTotal = Double.parseDouble(br.readLine().replace(",", "."));

                    Fatura fatura = new Fatura(dataFatura, nomeCliente, valorTotal);
                    processadorDeBoletos.criaFatura(fatura);

                    System.out.println("processador.boleto.Fatura " +processadorDeBoletos.getFaturas().size()+  " criada.");

                    break;

                case 2:

                    System.out.println("Informe o número da fatura.");
                    int numero = Integer.parseInt(br.readLine());
                    if(numero > processadorDeBoletos.getFaturas().size()){

                        System.out.println("processador.boleto.Fatura não existente.");

                    }

                    System.out.println("Informe o valor do boleto: ");
                    double valorBoleto = Double.parseDouble(br.readLine().replace(",", "."));

                    System.out.println("Informe o código do processador.boleto.Boleto: ");
                    String codigoBoleto = br.readLine();


                    System.out.println("Informe a data do boleto no formato dd-MM-yyyy :");
                    String dataBoleto = br.readLine();

                    while (dataBoleto.length() != 10) {
                        System.out.println("Formato inválido, tente novamente.");
                        dataBoleto = br.readLine();
                    }

                    Boleto boleto = new Boleto(codigoBoleto, dataBoleto, valorBoleto);

                    processadorDeBoletos.pagaFatura(numero, boleto);

                    System.out.println("FATURA " + numero + " "+ (processadorDeBoletos.getFaturas().get(numero).getPago() ? "NÃO PAGO" : "PAGO"));

                    break;

                case 3:
                    System.out.println(processadorDeBoletos.extrato());
                    break;
            }

            if(opcao == 3) {
                break;
            }
        }
    }

}