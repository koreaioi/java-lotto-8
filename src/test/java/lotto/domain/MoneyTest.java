package lotto.domain;

import lotto.domain.customer.Money;
import lotto.exception.MoneyIsNegativeException;
import lotto.exception.MoneyIsNotThousandUnitException;
import lotto.exception.MoneyIsZeroException;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MoneyTest {

    @Test
    void 구입금액이_0이면_예외가_발생한다() {
        int zero = 0;

        Assertions.assertThatThrownBy(() -> Money.from(zero))
                .isInstanceOf(MoneyIsZeroException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_음수이면_예외가_발생한다() {
        int negative = -1000;

        Assertions.assertThatThrownBy(() -> Money.from(negative))
                .isInstanceOf(MoneyIsNegativeException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_1000단위가__아니면_예외가_발생한다() {
        int notThousandUnit = 500;

        Assertions.assertThatThrownBy(() -> Money.from(notThousandUnit))
                .isInstanceOf(MoneyIsNotThousandUnitException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_정상적으로_인식되는지_테스트한다() {
        int normalMoney = 5000;

        Assertions.assertThatCode(() -> Money.from(normalMoney))
                .doesNotThrowAnyException();
    }

}
