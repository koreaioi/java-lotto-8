package lotto.exception.money;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class MoneyIsNegativeException extends LottoException {
    public MoneyIsNegativeException() {
        super(ErrorMessage.MONEY_IS_NEGATIVE.getMessage());
    }
}
