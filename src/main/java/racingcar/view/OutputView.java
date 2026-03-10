package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
  public void printRound(List<Car> cars) {
    StringBuilder sb = new StringBuilder();
    for (Car car : cars) {
      sb.append(car.getName()).append(" : ");
      sb.append("-".repeat(car.getPosition()));
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public void printWinners(List<Car> winners) {
    StringBuilder sb = new StringBuilder();
    sb.append("최종 우승자 : ");
    for (int i = 0; i < winners.size(); i++) {
      sb.append(winners.get(i).getName());
      if (i != winners.size() - 1) {
        sb.append(", ");
      }
    }
    System.out.print(sb);
  }
}
