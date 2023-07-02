public class BirthdateIsNotException extends  RuntimeException{
    public BirthdateIsNotException() {
        super("\tНеправильно введена дата дня рождения, надо ДД(день).ММ(месяц).УУУУ(год) ");
    }
}
