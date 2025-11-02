package lotto.exception.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class BonusNumberIsDuplicatedException extends LottoException {
    public BonusNumberIsDuplicatedException() {
        super(ErrorMessage.BONUS_NUMBER_IS_DUPLICATED.getMessage());
    }
}
