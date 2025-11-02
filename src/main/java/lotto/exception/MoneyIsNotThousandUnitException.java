package lotto.exception;

public class MoneyIsNotThousandUnitException extends LottoException {
    public MoneyIsNotThousandUnitException() {
        super(ErrorMessage.MONEY_IS_NOT_THOUSAND_UNIT.getMessage());
    }
}
