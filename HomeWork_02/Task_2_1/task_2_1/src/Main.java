public class Main {
    public static void main(String[] args) {
    reFactiring2();
    reFactiring3();
}
    public static void reFactiring2(){

        /*Если необходимо, исправьте данный код
                try {
                    int d = 0;
                    double catchedRes1 = intArray[8] / d;
                    System.out.println("catchedRes1 = " + catchedRes1);
                } catch (ArithmeticException e) {
                    System.out.println("Catching exception: " + e);
                }
        */

        try {
            int d = 0;
            int[] intArray = new int[10];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    public static void reFactiring3(){
        /*Если необходимо, исправьте данный код

                try {
                    int a = 90;
                    int b = 3;
                    System.out.println(a / b);
                    printSum(23, 234);
                    int[] abc = { 1, 2 };
                    abc[2] = 9;
                } catch (ArithmeticException ex) {
                    System.out.println("Деление на ноль!");
                } catch (NullPointerException ex) {
                    System.out.println("Указатель не может указывать на null!");
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Индекс массива выходит за пределы допустимого диапазона!");
                } catch (Exception ex) {
                    System.out.println("Что-то пошло не так...");
                }
        */
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }catch (ArithmeticException ex) {
            System.out.println("");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b){
        System.out.println(a + b);
    }
}