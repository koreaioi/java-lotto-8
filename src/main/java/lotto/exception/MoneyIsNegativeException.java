package lotto.exception;

public class MoneyIsNegativeException extends LottoException {
    public MoneyIsNegativeException() {
        super(ErrorMessage.MONEY_IS_NEGATIVE.getMessage());
    }
}
