package lotto.exception.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class LottoCountException extends LottoException {
    public LottoCountException() {
        super(ErrorMessage.LOTTO_COUNT_IS_SIX.getMessage());
    }
}
