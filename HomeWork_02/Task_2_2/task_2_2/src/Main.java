import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args){
        getFloat();
    }

    public static void getFloat(){
        //Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
        // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
        // вместо этого, необходимо повторно запросить у пользователя ввод данных.

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            float result = getFloatFromUser(bufferedReader);
            bufferedReader.close();
            System.out.println("\t"+result);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static float getFloatFromUser(BufferedReader bufferedReader){
        final String RD  = "\u001B[31m"; //ANSI_RED
        final String RT = "\u001B[0m";//ANSI_RESET
        final String BE = "\u001B[34m";//ANSI_BLUE
        System.out.print("\n\tВведите число: ");
        float result;
        String temp = null;
        try {
            temp = bufferedReader.readLine();
            result = Float.parseFloat(temp);
        } catch (NumberFormatException | IOException e){
            System.out.println(RD+"\tВведено  < "+BE+ temp  +RD+"  > поэтому  произошла ошибка при преобразовании введенного значения в число типа float "+RT);
            return getFloatFromUser(bufferedReader);
        }

        return result;
    }

}