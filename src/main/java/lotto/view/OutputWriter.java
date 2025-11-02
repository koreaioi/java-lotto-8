package lotto.view;

public class OutputWriter {

    public void printMoneyRequestMessage() {
        System.out.println(ViewMessage.REQUEST_MONEY.getMessage());
    }

    public void printWinningNumberRequestMessage() {
        printLineSeparator();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberRequestMessage() {
        printLineSeparator();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printLineSeparator() {
        System.out.println();
    }

}
