package lotto.domain;

import lotto.domain.customer.Number;
import lotto.exception.number.NumberIsNotLottoRangeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 로또번호는_1과45사이의_수이다() {
        int minLottoNumber = 1;
        int middleLottoNumber = 23;
        int maxLottoNumber = 45;

        Assertions.assertThatCode(()-> Number.from(minLottoNumber))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(()-> Number.from(middleLottoNumber))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(()-> Number.from(maxLottoNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또번호가_음수이면_예외가_발생한다() {
        int negative = -1;
        Assertions.assertThatThrownBy(() -> Number.from(negative))
                .isInstanceOf(NumberIsNotLottoRangeException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호가_0이면_예외가_발생한다() {
        int zero = 0;
        Assertions.assertThatThrownBy(() -> Number.from(zero))
                .isInstanceOf(NumberIsNotLottoRangeException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호가_45보다_크면_예외가_발생한다() {
        int overLottoNumber = 46;

        Assertions.assertThatThrownBy(() -> Number.from(overLottoNumber))
                .isInstanceOf(NumberIsNotLottoRangeException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
