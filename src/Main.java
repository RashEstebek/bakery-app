import Decorators.*;
import Factory.*;
import Observer.AddItemPublisher;
import Observer.ISubscriber;
import Payment.PayByCreditCard;
import Payment.PayByPayPal;
import Payment.Shop;
import Products.*;
import OrderState.StatusState;

import java.util.Scanner;

import OrderState.*;

public class Main {
    static String customerName;

    public static void main(String[] args) {

        AddItemPublisher.getInstance().addSubscriber(ShoppingCart.getInstance());
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""

                \s
                =====================SWEET BAKERY========================
                 Welcome to the Sweet Bakery! Tell us your name, please:\s""");

        customerName = scanner.next();

        customerChoice(customerName);
    }

    private static void customerChoice(String customerName) {
        StatusState statusState = new NotPicked();
        Status status = new Status();
        status.setStatus(statusState);

        Scanner scanner = new Scanner(System.in);
        Shop tiramisu = new Tiramisu();
        Shop napoleon = new NapoleonCake();
        Shop cheesecake = new Cheesecake();
        Shop redvelvet = new RedVelvet();
        Shop whoopie = new WhoopiePie();
        status.showStatus();
        System.out.println("Choose what do you want, " + customerName);
        System.out.println("""
                1. Tiramisu - 400 KZT\s
                2. Napoleon cake - 500 KZT\s
                3. Cheesecake - 480 KZT\s
                4. Red velvet - 400 KZT\s
                5. Whoopie pie - 480 KZT\s
                0. return""");

        int c = scanner.nextInt();
        status.changeStatus();
        switch (c) {
            case 1 -> tiramisuCream(customerName, tiramisu, status);
            case 2 -> napoleonCream(customerName, napoleon, status);
            case 3 -> cheesecakeCream(customerName, cheesecake, status);
            case 4 -> redVelvetCream(customerName, redvelvet, status);
            case 5 -> whoopieCream(customerName, whoopie, status);
            case 0 -> {
            }
        }
    }

    private static void creamChoice(Scanner scanner, String customerName, int cream, Confectionery confectionery, int sum, int price, Shop product, Status status) {
        System.out.println("""
                \n
                =============== CREAMS ===============
                What cream do you want?:\s
                 1. Chantilly cream - 130 KZT\s
                 2. Charlotte cream - 150 KZT\s
                 3. Protein cream - 70 KZT\s
                 """);

        int t = scanner.nextInt();
        switch (t) {
            case 1 -> {
                confectionery = new ChantillyCream(confectionery);

                price += 130;
                toppings(scanner, confectionery, customerName, cream, sum, price, product, status);
            }
            case 2 -> {
                confectionery = new CharlotteCream(confectionery);
                price += 150;
                toppings(scanner, confectionery, customerName, cream, sum, price, product, status);
            }
            case 3 -> {
                confectionery = new ProteinCream(confectionery);
                price += 70;
                toppings(scanner, confectionery, customerName, cream, sum, price, product, status);
            }
        }
    }

    private static void toppings(Scanner scanner, Confectionery confectionery, String customerName, int cream, int sum, int price, Shop product, Status status) {

        System.out.println("do you want to add another cream? \n 1. yes \n 2. no");
        int adding = scanner.nextInt();
        if (adding == 1) {
            cream++;
            creamChoice(scanner, customerName, cream, confectionery, sum, price, product, status);
        } else {
            System.out.println("Do you want to add toppings?\n 1. yes \n 2. no");
            int r = scanner.nextInt();
            if (r == 1) {
                sum = sum + price;
                toppingChoice(confectionery, sum, product, status);
            } else {
                int priceWithoutTop = sum + price;
                status.changeStatus();
                status.showStatus();

                AddItemPublisher.getInstance().publish(confectionery.getDescription() + ", cream servings: " + cream +
                        "\n total price = " + priceWithoutTop + " KZT");
//               ShoppingCart.getInstance().addProduct(confectionery.getDescription()+ ", cream servings: " + cream +
//                       "\n total price = " + priceWithoutTop + " KZT");
//                ShoppingCart.getInstance().showProduct();
                paymentChoice(product, status, customerName);
            }
        }
    }

    private static void tiramisuCream(String customerName, Shop tiramisu, Status status) {
        status.showStatus();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much servings do you want?");
        int serv = scanner.nextInt();
        Confectionery confectionery;
        ConfectioneryFactory confectioneryFactory = new TiramisuFactory();
        confectionery = confectioneryFactory.createConfectionery();
        int sum = 0;
        for (int i = 0; i < serv; i++) {
            sum += confectionery.price();
        }
//
        System.out.println("Do you want to add cream? \n 1. yes \n 2. no");
        int choice = scanner.nextInt();
        status.showStatus();
        if (choice == 1) {
            int cream = 1;
            int price = 0;
            creamChoice(scanner, customerName, cream, confectionery, sum, price, tiramisu, status);
        } else {
            System.out.println("Do you want to add toppings?\n 1. yes \n 2. no");
            int r = scanner.nextInt();
            if (r == 1) {
                toppingChoice(confectionery, sum, tiramisu, status);
            } else {
                status.changeStatus();
                status.showStatus();
                AddItemPublisher.getInstance().publish(confectionery.getDescription() + "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().addProduct(confectionery.getDescription()+ "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().showProduct();
                paymentChoice(tiramisu, status, customerName);
            }
        }
    }

    private static void napoleonCream(String customerName, Shop napoleon, Status status) {
        status.showStatus();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much servings do you want?");
        int serv = scanner.nextInt();
        Confectionery confectionery;
        ConfectioneryFactory confectioneryFactory = new NapoleonCakeFactory();
        confectionery = confectioneryFactory.createConfectionery();

        int sum = 0;
        for (int i = 0; i < serv; i++) {
            sum += confectionery.price();
        }

        System.out.println("Do you want to add cream? \n 1. yes \n 2. no");
        int choice = scanner.nextInt();
        status.showStatus();
        if (choice == 1) {
            int cream = 1;
            int price = 0;
            creamChoice(scanner, customerName, cream, confectionery, sum, price, napoleon, status);
        } else {

            System.out.println("Do you want to add toppings?\n 1. yes \n 2. no");
            int r = scanner.nextInt();
            if (r == 1) {
                toppingChoice(confectionery, sum, napoleon, status);
            } else {
                status.changeStatus();
                status.showStatus();
                AddItemPublisher.getInstance().publish(confectionery.getDescription() + "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().addProduct(confectionery.getDescription()+ "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().showProduct();
                paymentChoice(napoleon, status, customerName);
            }
        }

    }

    private static void cheesecakeCream(String customerName, Shop cheesecake, Status status) {
        status.showStatus();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much servings do you want?");
        int serv = scanner.nextInt();
        Confectionery confectionery;
        ConfectioneryFactory confectioneryFactory = new CheesecakeFactory();
        confectionery = confectioneryFactory.createConfectionery();

        int sum = 0;
        for (int i = 0; i < serv; i++) {
            sum += confectionery.price();
        }

        System.out.println("Do you want to add cream? \n 1. yes \n 2. no");
        int choice = scanner.nextInt();
        status.showStatus();
        if (choice == 1) {
            int cream = 1;
            int price = 0;
            creamChoice(scanner, customerName, cream, confectionery, sum, price, cheesecake, status);
        } else {

            System.out.println("Do you want to add toppings?\n 1. yes \n 2. no");
            int r = scanner.nextInt();
            if (r == 1) {
                toppingChoice(confectionery, sum, cheesecake, status);
            } else {
                status.changeStatus();
                status.showStatus();
                AddItemPublisher.getInstance().publish(confectionery.getDescription() + "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().addProduct(confectionery.getDescription() + "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().showProduct();
                paymentChoice(cheesecake, status, customerName);
            }
        }

    }

    private static void redVelvetCream(String customerName, Shop redvelvet, Status status) {
        status.showStatus();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much servings do you want?");
        int serv = scanner.nextInt();
        Confectionery confectionery;
        ConfectioneryFactory confectioneryFactory = new RedvelvetFactory();
        confectionery = confectioneryFactory.createConfectionery();

        int sum = 0;
        for (int i = 0; i < serv; i++) {
            sum += confectionery.price();
        }

        System.out.println("Do you want to add cream? \n 1. yes \n 2. no");
        int choice = scanner.nextInt();
        status.showStatus();
        if (choice == 1) {
            int cream = 1;
            int price = 0;
            creamChoice(scanner, customerName, cream, confectionery, sum, price, redvelvet, status);
        } else {

            System.out.println("Do you want to add toppings?\n 1. yes \n 2. no");
            int r = scanner.nextInt();
            if (r == 1) {
                toppingChoice(confectionery, sum, redvelvet, status);
            } else {
                status.changeStatus();
                status.showStatus();
                AddItemPublisher.getInstance().publish(confectionery.getDescription() + "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().addProduct(confectionery.getDescription() + "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().showProduct();
                paymentChoice(redvelvet, status, customerName);
            }
        }

    }

    private static void whoopieCream(String customerName, Shop whoopie, Status status) {
        status.showStatus();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much servings do you want?");
        int serv = scanner.nextInt();
        Confectionery confectionery;
        ConfectioneryFactory confectioneryFactory = new WhoopieFactory();
        confectionery = confectioneryFactory.createConfectionery();

        int sum = 0;
        for (int i = 0; i < serv; i++) {
            sum += confectionery.price();
        }

        System.out.println("Do you want to add cream? \n 1. yes \n 2. no");
        int choice = scanner.nextInt();
        status.showStatus();
        if (choice == 1) {
            int cream = 1;
            int price = 0;
            creamChoice(scanner, customerName, cream, confectionery, sum, price, whoopie, status);
        } else {

            System.out.println("Do you want to add toppings?\n 1. yes \n 2. no");
            int r = scanner.nextInt();
            if (r == 1) {
                toppingChoice(confectionery, sum, whoopie, status);
            } else {
                status.changeStatus();
                status.showStatus();
                AddItemPublisher.getInstance().publish(confectionery.getDescription() + "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().addProduct(confectionery.getDescription() + "in " + serv + " servings" + " for " + sum + " KZT");
////                ShoppingCart.getInstance().showProduct();
                paymentChoice(whoopie, status, customerName);
            }
        }

    }

    private static void toppingChoice(Confectionery confectionery, int sum, Shop product, Status status) {
        status.showStatus();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                \n
                =============== TOPPINGS ===============
                What topping do you prefer?:\s
                 1. Chocolate - 100 KZT\s
                 2. Gingerbread - 90 KZT\s               
                 3. Mastic - 160 KZT""");

        int t = scanner.nextInt();
        status.changeStatus();
        switch (t) {


            case 1 -> {
                confectionery = new ChocolateTopper(confectionery);
                sum += 100;
                status.showStatus();
                AddItemPublisher.getInstance().publish(confectionery.getDescription() + sum + " KZT");
////                ShoppingCart.getInstance().addProduct(confectionery.getDescription() + sum + " KZT");
////                ShoppingCart.getInstance().showProduct();
                paymentChoice(product, status, customerName);
            }
            case 2 -> {
                confectionery = new GingerbreadToppers(confectionery);
                sum += 90;
                status.showStatus();
                AddItemPublisher.getInstance().publish(confectionery.getDescription() + sum + " KZT");
////                ShoppingCart.getInstance().addProduct(confectionery.getDescription() + sum + " KZT");
////                ShoppingCart.getInstance().showProduct();
                paymentChoice(product, status, customerName);
            }
            case 3 -> {
                confectionery = new MasticTopper(confectionery);
                sum += 160;
                status.showStatus();
                AddItemPublisher.getInstance().publish(confectionery.getDescription() + sum + " KZT");
////                ShoppingCart.getInstance().addProduct(confectionery.getDescription() + sum + " KZT");
////                ShoppingCart.getInstance().showProduct();
                paymentChoice(product, status, customerName);
            }

        }
    }

    private static void paymentChoice(Shop product, Status status, String customerName) {
        status.changeStatus();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                \n
                 =============== PAYMENT ===============
                 Choose preferable payment method:\s
                 1. Pay by Mastercard credit card \s
                 2. Pay by PayPal account""");
        int t = scanner.nextInt();
        switch (t) {
            case 1 -> {
                product.setPaymentMethod(new PayByCreditCard());

                try {
                    System.out.println("""
                            \n
                             -------- Fill your card info --------
                             Enter card number: """);
                    int card = scanner.nextInt();
                    System.out.println(" Enter cardholder name: ");
                    String name = scanner.next();
                    System.out.println(" Enter CVV/CVN: ");
                    String named = scanner.next();
                    Thread.sleep(1000);
                    System.out.println("Verification..");
                    Thread.sleep(2000);
                    System.out.print("\n" + name + ", ");
                    product.pay();
                    // Delay for 7 seconds
                    Thread.sleep(4000);
                    System.out.println("Processing..");
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                status.showStatus();

            }
            case 2 -> {
                product.setPaymentMethod(new PayByPayPal());
                try {
                    System.out.println("""
                            \n
                             -------- Fill PayPal account info --------
                             Enter login: """);
                    String login = scanner.next();
                    System.out.println(" Enter password: ");
                    String password = scanner.next();
                    Thread.sleep(1000);
                    System.out.println("Verification..");
                    Thread.sleep(2000);
                    System.out.print("\n" + login + ", ");
                    product.pay();
                    Thread.sleep(4000);
                    System.out.println("Processing..");
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                status.showStatus();
                System.out.println();
            }
        }
        status.changeStatus();
        System.out.println("Do you want to buy something again?\n 1. yes \n 2. no");
        int choice1 = scanner.nextInt();
        if (choice1 == 1) {
            customerChoice(customerName);
        } else {
            System.out.println("bye :(");
        }
    }
}

