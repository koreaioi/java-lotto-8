package lotto.exception;

public class MoneyIsZeroException extends LottoException {
    public MoneyIsZeroException() {
        super(ErrorMessage.MONEY_IS_ZERO.getMessage());
    }
}
