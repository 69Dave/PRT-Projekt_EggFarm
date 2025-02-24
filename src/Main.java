import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Henhouse henhouse = new Henhouse();

        boolean endProgram = false;
        while (!endProgram) {
            try {
                henhouse.chickenStatus();

                System.out.println();
                System.out.println();
                System.out.println("Hauptmenü");
                System.out.println("---------");
                System.out.println();
                System.out.println("A   -> Alle Eier verkaufen");
                System.out.println("C   -> Chinesisches Huhn kaufen");
                System.out.println("O   -> Österreichisches Huhn kaufen");
                System.out.println("D   -> Deutsches Huhn kaufen");
                System.out.println("U   -> Amerikanisches Huhn kaufen");
                System.out.println("AR -> Huhn zu Argeta-Aufstrich verarbeiten");
                System.out.println("DO -> Huhn zum Tierarzt schicken");
                System.out.println("N   -> Nichts tun");
                System.out.println("E   -> Spiel beenden (aufgeben)");
                System.out.print("\nChoice:");
                String choice = scanner.nextLine().toUpperCase();
                switch (choice) {
                    case "A" -> {
                        henhouse.sellAllEggs();
                    }
                    case "C" -> {
                        Chicken chicken = new ChineseChicken();
                        henhouse.payMoney(chicken.getChickenMoneyPrice());
                        try {
                            henhouse.payEgg(chicken.getChickenEggPrice());
                        } catch (InsufficientEggException e) {
                            throw new RuntimeException(e);
                        }
                        henhouse.add(chicken);
                    }
                    case "O" -> {
                        Chicken chicken = new AustrianChicken();
                        henhouse.payMoney(chicken.getChickenMoneyPrice());
                        try {
                            henhouse.payEgg(chicken.getChickenEggPrice());
                        } catch (InsufficientEggException e) {
                            throw new RuntimeException(e);
                        }
                        henhouse.add(chicken);
                    }
                    case "D" -> {
                        Chicken chicken = new GermanChicken();
                        henhouse.payMoney(chicken.getChickenMoneyPrice());
                        try {
                            henhouse.payEgg(chicken.getChickenEggPrice());
                        } catch (InsufficientEggException e) {
                            throw new RuntimeException(e);
                        }
                        henhouse.add(chicken);
                    }
                    case "U" -> {
                        Chicken chicken = new UsaChicken();
                        henhouse.payMoney(chicken.getChickenMoneyPrice());
                        try {
                            henhouse.payEgg(chicken.getChickenEggPrice());
                        } catch (InsufficientEggException e) {
                            throw new RuntimeException(e);
                        }
                        henhouse.add(chicken);
                    }
                    case "AR" -> {
                        System.out.print("HühnerID angeben: ");
                        String chickenNumberRawInput = scanner.nextLine();
                        int chickenNumberInput = Integer.parseInt(chickenNumberRawInput);
                        henhouse.makeArgetaOutOfChicken(chickenNumberInput);
                    }
                    case "DO" -> {
                        System.out.print("HühnerID angeben: ");
                        String chickenNumberRawInput = scanner.nextLine();
                        int chickenNumberInput = Integer.parseInt(chickenNumberRawInput);
                        henhouse.sendChickenToDoctor(chickenNumberInput);
                    }
                    case "N" -> endProgram = false;
                    case "E" -> endProgram = true;
                    default -> System.out.println("UngültigeAuswahl!");
                }
            } catch (BankruptcyException e) {
                System.out.println("SIE HABEN VERLOREN!!!");
                System.out.println("In der Kassa ist kein Geld mehr!");
            } catch (MissingEggsException e) {
                System.out.println("SIE HABEN VERLOREN!!!");
                System.out.println("Es sind keine Eier da, um ein Huhn zu erzeugen und kein Huhn im Stall, welches Eier legt!");
            }

            henhouse.dailyRun();
        }
    }
}
