package lotto.exception.number;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class NumberIsZeroException extends LottoException {
    public NumberIsZeroException() {
        super(ErrorMessage.LOTTO_IS_ZERO.getMessage());
    }
}
