package lotto.exception.money;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class MoneyIsNotIntegerException extends LottoException {
    public MoneyIsNotIntegerException() {
        super(ErrorMessage.MONEY_IS_NOT_INTEGER.getMessage());
    }
}
