package lotto.view;

import lotto.domain.customer.Money;
import lotto.exception.MoneyIsNotIntegerException;

public class ApplicationView {

    private final InputReader reader;
    private final OutputWriter writer;


    public ApplicationView(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Money getMoney() {
        writer.printMoneyRequestMessage();
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

    private void validateParsingInteger(String value) {
        try{
            Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new MoneyIsNotIntegerException();
        }
    }

}
