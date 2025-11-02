package lotto.exception.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class NormalNumberIsDuplicatedException extends LottoException {
    public NormalNumberIsDuplicatedException() {
        super(ErrorMessage.NORMAL_NUMBER_IS_DUPLICATED.getMessage());
    }
}
