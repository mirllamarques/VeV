import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Informe a data da fatura no formato dd-MM-yyyy :");
        String dataFatura = scanner.nextLine();

        while (dataFatura.length() != 10) {
            System.out.println("Formato inválido, tente novamente.");
            dataFatura = scanner.nextLine();
        }

        System.out.println("Informe o valor total para pagamento:");
        double valorTotal = scanner.nextDouble();

        Fatura fatura = new Fatura(dataFatura, nomeCliente, valorTotal);

        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos(fatura);

        System.out.println("Informe a quantidade de boletos: ");
        int quantidade = scanner.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Informe o valor do boleto: ");
            double valorBoleto = scanner.nextDouble();

            scanner.nextLine();

            System.out.println("Informe o código do Boleto: ");
            String codigoBoleto = scanner.nextLine();

            System.out.println("Informe a data do boleto no formato dd-MM-yyyy :");
            String dataBoleto = scanner.nextLine();

            while (dataBoleto.length() != 10) {
                System.out.println("Formato inválido, tente novamente.");
                dataBoleto = scanner.nextLine();
            }



            Boleto boleto = new Boleto(codigoBoleto, dataBoleto, valorBoleto);

            processadorDeBoletos.adicionaBoleto(boleto);
        }

        processadorDeBoletos.setValorBoletos();
        processadorDeBoletos.mudaStatus(fatura);
        System.out.println(processadorDeBoletos.extrato());

    }



}