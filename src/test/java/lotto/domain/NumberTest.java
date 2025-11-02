package lotto.domain;

import lotto.domain.customer.Number;
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

}
