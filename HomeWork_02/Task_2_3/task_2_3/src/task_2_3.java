/*public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

 */

import java.util.Scanner;

public class task_2_3 {
    static String inputString() {
        Scanner scan = new Scanner(System.in, "Cp866");
        System.out.print("\tВведите сообщение: ");
        String input = scan.nextLine();
        if (input.trim().isEmpty()) {  // если введна пустая строка или пробелы
            scan.close();
            throw new RuntimeException("\tПустое сообщение!\nСообщение должно иметь содержание.");
        }
        scan.close();
        return input;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\n\tЗадача №3 к семинару №2");
        try {
            System.out.println("\tВведено : "+inputString());
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }

    }
}