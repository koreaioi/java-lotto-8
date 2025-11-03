package lotto.view;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.Money;
import lotto.domain.customer.Number;
import lotto.domain.customer.LottoRank;
import lotto.domain.customer.WinningLotto;
import lotto.exception.money.MoneyIsNotIntegerException;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static lotto.domain.customer.LottoRank.*;
import static lotto.view.ViewMessage.LOTTO_STATISTIC;

public class ApplicationView {

    private final InputReader reader;
    private final OutputWriter writer;

    public ApplicationView(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Money getMoney() {
        writer.printMoneyRequestMessage();
        Money money = requestMoney();
        return money;
    }

    public WinningLotto getWinningLotto() {
        Lotto lotto = requestWinningNormalLotto();
        WinningLotto winningLotto = requestBonusLotto(lotto);
        return winningLotto;
    }

    public Money requestMoney() {
        return requestValidInput(() -> {
            String value = reader.readValue();
            validateParsingInteger(value);
            return Money.from(Integer.parseInt(value));
        });
    }

    public Lotto requestWinningNormalLotto() {
        writer.printWinningNumberRequestMessage();
        return requestValidInput(() -> {
            List<String> numbers = reader.readValues();
            validateParsingInteger(numbers);
            return Lotto.from(getNumberList(numbers));
        });
    }

    public WinningLotto requestBonusLotto(Lotto lotto) {
        writer.printBonusNumberRequestMessage();
        return requestValidInput(() -> {
            String value = reader.readValue();
            validateParsingInteger(value);
            return WinningLotto.of(lotto, Number.from(Integer.parseInt(value)));
        });
    }

    public void printLottoSet(String quantity, String lottoBundle) {
        writer.printLineSeparator();
        writer.printLottoQuantity(quantity);
        writer.printLottoBundle(lottoBundle);
    }

    public void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        List<LottoRank> resultRanks = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
        String result = resultRanks.stream()
                .map(rank -> {
                    return LOTTO_STATISTIC.getMessage(rank.toDisplay(), String.valueOf(statistics.get(rank)));
                })
                .collect(Collectors.joining(System.lineSeparator()));
        writer.printStatisticsInformationMessage(result);
    }

    public void printLottoRoi(String result) {
        writer.printLottoRoi(result);
    }

    private List<Number> getNumberList(List<String> list) {
        return list.stream()
                .map(Integer::parseInt)
                .map(Number::from)
                .toList();
    }

    private void validateParsingInteger(List<String> values) {
        values.forEach(this::validateParsingInteger);
    }

    private void validateParsingInteger(String value) {
        try{
            Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new MoneyIsNotIntegerException();
        }
    }

    private <T> T requestValidInput(Supplier<T> task) {
        while (true) {
            try {
                return task.get();
            } catch (IllegalArgumentException e) {
                writer.printErrorMessage(e.getMessage());
            }
        }
    }

}
