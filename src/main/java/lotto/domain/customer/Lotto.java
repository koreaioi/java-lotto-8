package lotto.domain.customer;

import lotto.exception.lotto.LottoCountException;
import lotto.exception.number.BonusNumberIsDuplicatedException;

import java.util.List;
import java.util.stream.Collectors;

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

    public void validateDuplicatedBonusNumber(Number number) {
        if(contains(number)) {
            throw new BonusNumberIsDuplicatedException();
        }
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    // TODO: 추가 기능 구현

    public String toDisplay() {
        return numbers.stream()
                .map(Number::toDisplay)
                .collect(Collectors.joining(",", "[", "]"));
    }

}
