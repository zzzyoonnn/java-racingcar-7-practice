package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
  private final InputView inputView;
  private final OutputView outputView;

  public Game() {
    this.inputView = new InputView();
    this.outputView = new OutputView();
  }

  public void play() {
    List<String> carNames = inputView.getCarNames();
    int count = inputView.getCount();

    List<Car> cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());

    Race race = new Race(cars);

    for (int i = 0; i < count; i++) {
      race.moveCars();
      outputView.printRound(race.getCars());
    }

    outputView.printWinners(race.findWinners());
  }
}
