
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random rand = new Random();
    //private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("Teddy Bear", 1));
        toys.add(new Toy("Car", 4));
        toys.add(new Toy("Puzzles", 5));
        toys.add(new Toy("Ball", 2));
        toys.add(new Toy("Balloon", 1));

        ArrayList<String> wonToys = new ArrayList<>();
        System.out.print("Введите количество игрушек для розыгрыша(Не должно превышать общее количество игрушек): ");
        int cntr = sc.nextInt();


        for (int i=0;i<cntr;i++) {
            int lottery;
            if (toys.size() == 1) {
                lottery = 0;
            }else{
                lottery = rand.nextInt(1, toys.size());
            }


            int temp = toys.get(lottery).getAmount();
            toys.get(lottery).setAmount(--temp);
            wonToys.add(toys.get(lottery).getName());

            if(toys.get(lottery).getAmount() == 0){
                System.out.println("Игрушки типа " + toys.get(lottery).getName() + " закончились ");
                toys.remove(lottery);
            }



        }

        System.out.println(wonToys);
        getPrize(wonToys);

    }

    private static void getPrize(List<String> temp){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите название игрушки(Для выхода введите '1'): ");
            String toy = sc.nextLine();

            for (String s : temp) {
                if (toy.equalsIgnoreCase(s)) {
                    try (FileWriter fw = new FileWriter("Prize", true)) {
                        fw.write(s + " ");
                        temp.remove(s);
                        System.out.println("Successfully written data to the file");
                        if(temp.isEmpty()){
                            System.out.println("Список игрушек пуст!");
                            return;
                        }
                        System.out.println(temp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else if (toy.equals("1")) {
                    return;
                }
            }


        }

    }
}


