package lotto.exception.number;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class NumberIsNotLottoRangeException extends LottoException {
    public NumberIsNotLottoRangeException() {
        super(ErrorMessage.NUMBER_IS_NOT_LOTTO_RANGE.getMessage());
    }
}
