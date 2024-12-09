import java.util.Comparator;
import java.util.Scanner;

public class ShoppingMain {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("\n ----- Seja bem-vindo ao ShoppingAPP! ----- \n");

        System.out.println("Qual o seu nome?");
        String userName = userInput.nextLine();

        System.out.println("Informe o limite do seu cartão:");
        double userLimit = userInput.nextDouble();

        User usuarioPrincipal = new User(userName, userLimit);

        int userNav = 1;
        while(userNav != 0){

            System.out.println("\n ----- Menu de Compras ----- \n");

            userInput.nextLine();
            System.out.println("O que deseja comprar?");
            String productName = userInput.nextLine();

            System.out.println("Qual o valor do item?");
            double productPrice = userInput.nextDouble();

            Product novoProduto = new Product(productName, productPrice);
            boolean checkPurchase = usuarioPrincipal.userPurchase(novoProduto);

            if (checkPurchase){
                System.out.println("\n ----- Compra realizada com SUCESSO! ----- \n");
                System.out.println(String.format(usuarioPrincipal.getUserName() + " | Novo limite: R$ %.2f ", usuarioPrincipal.getUserLimit()));

                System.out.println("\nSUA LISTA DE COMPRAS:");

                usuarioPrincipal.getListaCompras().sort(Comparator.comparing(Product::getProductPrice));
                int loopCounter = 0;
                for (Product productIndex: usuarioPrincipal.getListaCompras()){
                    loopCounter++;
                    System.out.println("#" + loopCounter + " Item: " + productIndex.getProductName() + " | Valor: R$ " + String.format("%.2f",productIndex.getProductPrice()));
                }

            } else {
                System.out.println("\n ----- Saldo para compra INSUFICIENTE. ----- \n");
                System.out.println(String.format(usuarioPrincipal.getUserName() + " | Limite: R$ %.2f", usuarioPrincipal.getUserLimit()));
                System.out.println(String.format("Saldo necessário: R$ %.2f", novoProduto.getProductPrice()));

                System.out.println("\nSUA LISTA DE COMPRAS:");

                usuarioPrincipal.getListaCompras().sort(Comparator.comparing(Product::getProductPrice));
                int loopCounter = 0;
                for (Product productIndex: usuarioPrincipal.getListaCompras()){
                    loopCounter++;
                    System.out.println("#" + loopCounter + " Item: " + productIndex.getProductName() + " | Valor: R$ " + String.format("%.2f",productIndex.getProductPrice()));
                }
            }

            if (usuarioPrincipal.getUserLimit() > 0){
                System.out.println("\nDeseja continuar as compras?");
                System.out.println("1 - SIM");
                System.out.println("0 - NÃO");
                userNav = userInput.nextInt();

            } else {
                System.out.println("\n(Xii! Você ficou sem limite)");
                System.out.println("\n:/");
                userNav = 0;
            }

            if (userNav == 0){
                System.out.println("\n ----- Compras encerradas! ----- \n");
                System.out.println(String.format("Limite: R$ %.2f", usuarioPrincipal.getUserLimit()));

                System.out.println("\nSUA LISTA DE COMPRAS:");

                usuarioPrincipal.getListaCompras().sort(Comparator.comparing(Product::getProductPrice));
                int loopCounter = 0;
                for (Product productIndex: usuarioPrincipal.getListaCompras()){
                    loopCounter++;
                    System.out.println("#" + loopCounter + " Item: " + productIndex.getProductName() + " | Valor: R$ " + String.format("%.2f",productIndex.getProductPrice()));
                }
            }

        }
    }
}
