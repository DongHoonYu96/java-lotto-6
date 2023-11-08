package lotto.controller;

import static lotto.domain.LottoNumbers.setRandomLottoNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.PlayerLottoAmount;
import lotto.domain.WinningDetails;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static PlayerLottoAmount playerLottoAmount;
    private static List<List<Integer>> randomLottos = new ArrayList<>();

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();

        Lotto winningLottoNumbers = new Lotto(InputView.inputLottoNumber());

        int bonusNum = InputView.inputBonusNumber();

        OutputView.printPurchaseCount(ticketCount);

        initializeLottos(ticketCount);

        List<Integer> randomNumbers = null;
        for (int i = 0; i < ticketCount; ++i) {
            randomNumbers = setRandomLottoNumbers();
            randomLottos.add(randomNumbers);
            OutputView.printRandomLottoNumbers(randomNumbers);
        }

        List<Integer> rankings = WinningDetails.findRanking(winningLottoNumbers, randomLottos, bonusNum);

        int[] statistics = WinningDetails.findStatistics(rankings);
        OutputView.printResultByRanking(statistics);

    }

    private void initializeLottos(int ticketCount) {
        for (int i = 0; i < ticketCount; ++i) {
            randomLottos.add(new ArrayList<>());
        }
    }

    private int inputPlayerAmount() {
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerPrice());
        return playerLottoAmount.calculateLottoCount();
    }
}
