public class Iterator {
    private final Writer writer = new Writer();
    private final Reader reader = new Reader();
    private final Validator validator = new Validator();
    private final Calculator calculator = new Calculator();

    public void interact(){
        String welcomeMessage = "Доброго времени суток! Для расчёта ежемесячного платежа по кредиту введите следующие" +
                " данные:",
                continueQuestion = "Желаете продолжить (да/нет)?",
                positiveAnswerKey = "да",
                negativeAnswerKey = "нет",
                loanRatePerMonthAnswer = "Ваш ежемесячный платёж составит: ",
                exitKey;
        //переменные int хранят порядковый номер для высвечивания правильного вопроса
        int loanAmountQuestion = 1,
                interestRateQuestion = 2,
                loanTermQuestion = 3;

        while (true){
            writer.write(welcomeMessage);

            //переменные для присвоения готовых данных
            int loanAmount = validator.validateAndReadData(loanAmountQuestion), //Сумма кредита
                    interestRate = validator.validateAndReadData(interestRateQuestion), //Процентная ставка
                    loanTerm =validator.validateAndReadData(loanTermQuestion); //Срок кредитования

            //вывод в консоль и подсчёт полученных данных
            writer.write(loanRatePerMonthAnswer + calculator.calculate(loanAmount, interestRate, loanTerm));

            //цикл для завершения программы
            while (true) {
                exitKey = reader.read(continueQuestion);
                if(exitKey.equalsIgnoreCase(positiveAnswerKey))
                    break;
                else if (exitKey.equalsIgnoreCase(negativeAnswerKey))
                    return;
                else
                    writer.write("Неправильный вариант ответа(только да/нет)");
            }
        }
    }
}