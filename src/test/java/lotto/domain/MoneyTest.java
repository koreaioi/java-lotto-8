package lotto.domain;

import lotto.domain.customer.Money;
import lotto.exception.MoneyIsNegativeException;
import lotto.exception.MoneyIsNotThousandUnitException;
import lotto.exception.MoneyIsZeroException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    void 구입금액이_0이면_예외가_발생한다() {
        assertThatThrownBy(() -> Money.from(0))
                .isInstanceOf(MoneyIsZeroException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> Money.from(-1000))
                .isInstanceOf(MoneyIsNegativeException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_1000단위가__아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Money.from(500))
                .isInstanceOf(MoneyIsNotThousandUnitException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
