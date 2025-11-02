package lotto.domain.customer;

import lotto.exception.lotto.LottoCountException;
import lotto.exception.lotto.BonusNumberIsDuplicatedException;
import lotto.exception.lotto.NormalNumberIsDuplicatedException;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        validateNumberLength(numbers);
        validateDuplicateNormalNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Number> numbers) {
        return new Lotto(numbers);
    }

    private void validateNumberLength(List<Number> numbers) {
        if (numbers.size() != 6) {
            throw new LottoCountException();
        }
    }

    private void validateDuplicateNormalNumber(List<Number> numbers) {
        int originCount = numbers.size();
        long distinctCount = getDistinctCount(numbers);
        if (distinctCount != originCount) {
            throw new NormalNumberIsDuplicatedException();
        }
    }

    public void validateDuplicatedBonusNumber(Number number) {
        if(contains(number)) {
            throw new BonusNumberIsDuplicatedException();
        }
    }

    public int countMatchingWinningLotto(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    private long getDistinctCount(List<Number> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    public String toDisplay() {
        return numbers.stream()
                .sorted()
                .map(Number::toDisplay)
                .collect(Collectors.joining(", ", "[", "]"));
    }

}
