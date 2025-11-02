package lotto.exception.number;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class NumberIsNegativeException extends LottoException {
    public NumberIsNegativeException() {
        super(ErrorMessage.LOTTO_IS_NEGATIVE.getMessage());
    }
}
