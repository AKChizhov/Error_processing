import java.util.Arrays;

public class App {

    static class Count {
        private int count;
        public Count() {
        }
        public Count(int count) {
            this.count = count;
        }
        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            if (this.count < 0) {
                throw new RuntimeException("Не может быть отрицательным !!!");
            }
            this.count++;
        }
    }

    static void loop(int bound, Count count) {
        for (int index = 0; index < bound; index++) {
            count.increment();
        }
    }

    static int displayCount(Count count) {
        if (count == null) {
            throw new NullPointerException("Значения нет!!");
        }
        return count.getCount();
    }

    static int[] trimArray(int[] array, int bound) {
        if (bound < 0 || bound > array.length) {
            throw new ArrayIndexOutOfBoundsException("Проверьте число-индекс, оно за пределами массива !!");
        }
        int[] newArray = new int[bound];
        for (int index = 0; index < bound; index++) {
            newArray[index] = array[index];
        }
        return newArray;
    }

    static int [] subtractionTwoArrays(int [] arrayA, int [] arrayB){
        if (arrayA.length != arrayB.length) {
            throw new RuntimeException("Длины массивов разные !!! ");
        }
        int [] outputArray = new int[arrayA.length];
        for (int i = 0; i < arrayA.length; i++) {
            outputArray[i] = arrayA[i] - arrayB[i];
        }
        return outputArray;
    }

    public static void logger() throws Exception {
        Count count = new Count(10);
        System.out.println("\n\tПроверяем метод 1 - есть / нет :");// case 1
        try {
            System.out.println("\tЗначение "+displayCount(count));
            count = null;
            System.out.println("\n\tЗначение "+displayCount(count));
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("\n\tПроверяем метод 2 - за пределам");// case 2
        int[] array = { 0, 1, 2, 3, 4, 5 };
        try {
            System.out.println("\n\tИсходный массив"+Arrays.toString(trimArray(array, 6)));
            System.out.println("\n\tВыводим 4-е первые элементы массива");
            System.out.println("\t"+Arrays.toString(trimArray(array, 4)));// По какой выводим - по 4
            System.out.println("\n\tВыводим 7-ь превых элементы массива");
            System.out.println(Arrays.toString(trimArray(array, 7)));// По какой выводим - по 7 - за пределом
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("\n\tПроверяем метод 3 - невозможность отрицательного значения");// case 3
        try {
            count = new Count(0);
            count.increment();
            System.out.println("\t"+count.getCount());
            count.setCount(-3);
            count.increment();
            System.out.println(count.getCount());

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("\n\tПроверяем метод 4 - если размерности разные");// case 3

        int[] array_1 = { 0, 1, 2, 3, 4, 5, 6 };
        int[] array_2 = { 6, 5, 4, 3, 2, 1, 0 };
        int[] array_3 = { 1, 2, 3 };
        System.out.println("\n\t1-ый массив\n\t"+Arrays.toString(array_1));
        System.out.println("\n\t2-ой массив\n\t"+Arrays.toString(array_2));
        System.out.println("\n\t3-ий массив\n\t"+Arrays.toString(array_3));
        System.out.println("\n\tИз 1 вычитаем 2\t");
        System.out.println("\t"+Arrays.toString(subtractionTwoArrays(array_1, array_2)));
        System.out.println("\n\tИз 1 вычитаем 3");
        System.out.println("\t"+Arrays.toString(subtractionTwoArrays(array_1, array_3)));

    }

    public static void main(String[] args) throws Exception {
        logger();

        long start = System.currentTimeMillis();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
    }

}