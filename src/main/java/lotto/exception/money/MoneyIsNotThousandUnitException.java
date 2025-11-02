package lotto.exception.money;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class MoneyIsNotThousandUnitException extends LottoException {
    public MoneyIsNotThousandUnitException() {
        super(ErrorMessage.MONEY_IS_NOT_THOUSAND_UNIT.getMessage());
    }
}
