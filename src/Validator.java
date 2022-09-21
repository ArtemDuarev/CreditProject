public class Validator {
    private final Writer writer = new Writer();
    private final Reader reader = new Reader();

    //метод проверяет правильность введенных пользователем данных(отсутствия букв, пробелов)
    //на вход идет int для выбора правильного вопроса
    //возвращает обработанные данные по кредиту
    public int validateAndReadData(int questionNumber){
        String rawCreditInfo;
        int creditInfo ;
        while (true) {
            rawCreditInfo = reader.read(chooseQuestion(questionNumber));
            try {
                creditInfo = Integer.parseInt(rawCreditInfo);
                if(creditInfo <= 0) {
                    writer.write("Число должно быть больше нуля");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                writer.write("Введён неверный формат числа(пример: 12; 1; 456; 1233 и т.д.)");
            }
        }
        return creditInfo;
    }

    //метод для определения нужного вопроса к пользователю
    //возвращает этот самый ответ
    private String chooseQuestion(int questionNumber){
        String loanAmountQuestion = "Сумма кредита(в рублях): ",
                interestRateQuestion = "Процентная ставка(в процентах): ",
                loanTermQuestion = "Срок кредитования(месяцев): ";

        return switch (questionNumber) {
            case 1 -> loanAmountQuestion;
            case 2 -> interestRateQuestion;
            case 3 -> loanTermQuestion;
            default -> "Выбран несуществующий номер вопроса";
        };
    }
}