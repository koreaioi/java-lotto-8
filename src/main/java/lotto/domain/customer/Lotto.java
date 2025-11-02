package lotto.domain.customer;

import lotto.exception.lotto.LottoCountException;

import java.util.List;

public class Lotto {
    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Number> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Number> numbers) {
        if (numbers.size() != 6) {
            throw new LottoCountException();
        }
    }

    // TODO: 추가 기능 구현
}
