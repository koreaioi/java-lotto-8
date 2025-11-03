package lotto.view;

public class OutputWriter {

    public void printMoneyRequestMessage() {
        print(ViewMessage.REQUEST_MONEY.getMessage());
    }

    public void printWinningNumberRequestMessage() {
        printLineSeparator();
        print(ViewMessage.WINNING_NUMBER.getMessage());
    }

    public void printBonusNumberRequestMessage() {
        printLineSeparator();
        print(ViewMessage.BONUS_NUMBER.getMessage());
    }

    public void printLottoQuantity(String quantity) {
        print(ViewMessage.LOTTO_QUANTITY.getMessage(quantity));
    }

    public void printLottoBundle(String lottoBundle) {
        print(lottoBundle);
    }

    public void printStatisticsInformationMessage(String result) {
        printLineSeparator();
        print(ViewMessage.WINNING_STATISTIC.getMessage());
        print(ViewMessage.DASH.getMessage());
        print(result);
    }

    public void printLottoRoi(String lottoRoi) {
        print(ViewMessage.LOTTO_ROI.getMessage(lottoRoi));
    }

    public void printErrorMessage(String errorMessage) {
        print(errorMessage);
    }

    public void printLineSeparator() {
        System.out.println();
    }

    private void print(String message) {
        System.out.println(message);
    }

}
