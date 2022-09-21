import java.text.DecimalFormat;

public class Calculator {
    private final DecimalFormat df = new DecimalFormat("#.##");

    //метод производит непосредственно сами подсчеты по кредиту
    //насчет правильности формулы гарантий у меня нет
    //(пользовался этой статьей https://myfin.by/wiki/term/annuitetnyj-platyozh)
    //возвращает число в строке(возможно нужно было сделать возвращаемый тип в виде числа)
    public String calculate(int loanAmount, int interestRate, int loanTerm){
        double loanRatePerMonth = ((double) interestRate / 12) / 100,
                annuityRatio = calculateAnnuityRatio(loanRatePerMonth, loanTerm);
        return df.format(annuityRatio * loanAmount);
    }

    //метод считает коэффициент аннуитета(см. в ссылке выше)
    private double calculateAnnuityRatio(double loanRatePerMonth, int loanTerm){ //сделать комент поясняющий эту формулу подсчета
        return (loanRatePerMonth * Math.pow(1 + loanRatePerMonth, loanTerm)) /
                (Math.pow(1 + loanRatePerMonth, loanTerm) - 1);
    }
}

