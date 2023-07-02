public class NumberNotTrueException extends RuntimeException{
    public NumberNotTrueException() {
        super("\tНеправильно введен номер телефона, надо из 7 цифр так : 1234567 ");
    }
}
