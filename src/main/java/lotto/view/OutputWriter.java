package lotto.view;

public class OutputWriter {

    public void printMoneyRequestMessage() {
        System.out.println(ViewMessage.REQUEST_MONEY.getMessage());
    }

    public void printWinningNumberRequestMessage() {
        printLineSeparator();
        System.out.println(ViewMessage.WINNING_NUMBER.getMessage());
    }

    public void printBonusNumberRequestMessage() {
        printLineSeparator();
        System.out.println(ViewMessage.BONUS_NUMBER.getMessage());
    }

    public void printLottoQuantity(String quantity) {
        System.out.println(ViewMessage.LOTTO_QUANTITY.getMessage(quantity));
    }

    public void printLottoBundle(String lottoBundle) {
        System.out.println(lottoBundle);
    }

    public void printStatisticsInformationMessage(String result) {
        printLineSeparator();
        System.out.println(ViewMessage.WINNING_STATISTIC.getMessage());
        System.out.println(ViewMessage.DASH.getMessage());
        System.out.println(result);
    }

    public void printLottoRoi(String lottoRoi) {
        System.out.println(ViewMessage.LOTTO_ROI.getMessage(lottoRoi));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLineSeparator() {
        System.out.println();
    }

}
