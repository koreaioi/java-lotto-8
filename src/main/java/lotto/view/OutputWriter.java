package lotto.view;

public class OutputWriter {

    public void printMoneyRequestMessage() {
        System.out.println(ViewMessage.REQUEST_MONEY.getMessage());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

}
