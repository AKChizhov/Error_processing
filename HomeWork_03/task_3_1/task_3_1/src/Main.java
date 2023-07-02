import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            CreatingAnEntryInTheDatabase();
            System.out.println("success - успех, данные занесены");
        }catch (FileSystemException | NumberNotTrueException | BirthdateIsNotException | DataIsNot_6_Exception
        |SexException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static void CreatingAnEntryInTheDatabase() throws Exception{
        System.out.println("""

                \tВведите\s
                \t\t Фамилию, имя, отчество,
                \t\t дату рождения (в формате dd.mm.yyyy),
                \t\t номер телефона (число из 7 цифр без разделителей),
                \t\t пол (символ латиницей f или m),
                \tразделенные пробелом\s
                \t :\s""");

        String text;
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            text = bf.readLine();
        }catch (IOException e){
            throw new Exception("\tПроизошла ошибка при работе с консолью");
        }

        String[] array = text.split(" ");
        if (array.length != 6){
            System.out.println("\tВведенное количество данных для данного человека - "+ array.length+ " а это ");
            throw new DataIsNot_6_Exception();
        }

        String lastName = array[0];// Аналог фамилии
        String firstName = array[1];// Аналог имени
        String middleName = array[2];// Аналог отчества

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date birthdate;
        try {
            birthdate = format.parse(array[3]);
        }catch (ParseException e){
            throw new BirthdateIsNotException();
        }

        int phone;

        try {
            phone = Integer.parseInt(array[4]);
        }catch (NumberFormatException e){
            throw new NumberNotTrueException();
        }

        String sex = array[5];
        if (!sex.equalsIgnoreCase("m") && !sex.equalsIgnoreCase("f")){
            throw new SexException();
        }

        String fileName = "files\\" + lastName.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", lastName, firstName , middleName,
                    format.format(birthdate), phone, sex));
        }catch (IOException e){
            throw new FileSystemException("Ошибка файловой системы");
        }

    }



}