package lotto.exception;

public class MoneyIsNotIntegerException extends LottoException {
    public MoneyIsNotIntegerException() {
        super(ErrorMessage.MONEY_IS_NOT_INTEGER.getMessage());
    }
}
