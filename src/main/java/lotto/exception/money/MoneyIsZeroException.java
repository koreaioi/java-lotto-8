package lotto.exception.money;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class MoneyIsZeroException extends LottoException {
    public MoneyIsZeroException() {
        super(ErrorMessage.MONEY_IS_ZERO.getMessage());
    }
}
