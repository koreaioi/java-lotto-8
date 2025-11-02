package lotto.view;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.Money;
import lotto.domain.customer.Number;
import lotto.domain.processor.WinningLotto;
import lotto.exception.money.MoneyIsNotIntegerException;

import java.util.List;

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
        while (true) {
            try {
                String value = reader.readValue();
                validateParsingInteger(value);
                return Money.from(Integer.parseInt(value));
            } catch (IllegalArgumentException e) {
                writer.printErrorMessage(e.getMessage());
            }
        }
    }

    public Lotto requestWinningNormalLotto() {
        writer.printWinningNumberRequestMessage();
        while (true) {
            try{
                List<String> numbers = reader.readValues();
                numbers.forEach(this::validateParsingInteger);
                return Lotto.from(getNumberList(numbers));
            }catch (IllegalArgumentException e) {
                writer.printErrorMessage(e.getMessage());
            }
        }
    }

    public WinningLotto requestBonusLotto(Lotto lotto) {
        writer.printBonusNumberRequestMessage();
        while (true) {
            try {
                String value = reader.readValue();
                validateParsingInteger(value);
                Number bonusNumber = Number.from(Integer.parseInt(value));
                return WinningLotto.of(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                writer.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Number> getNumberList(List<String> list) {
        return list.stream()
                .map(Integer::parseInt)
                .map(Number::from)
                .toList();
    }

    public void printLottoSet(String quantity, String lottoBundle) {
        writer.printLottoQuantity(quantity);
        writer.printLottoBundle(lottoBundle);
    }

    private void validateParsingInteger(String value) {
        try{
            Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new MoneyIsNotIntegerException();
        }
    }

}
