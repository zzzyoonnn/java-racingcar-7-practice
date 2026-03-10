package racingcar.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {
  private final List<Car> cars;
  private final Random random;

  public Race(List<Car> cars) {
    this.cars = cars;
    this.random = new Random();
  }

  public void moveCars() {
    for (Car car : cars) {
      if (random.nextInt(10) >= 4) {
        car.move();
      }
    }
  }

  public List<Car> findWinners() {
    int maxDistance = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

    return cars.stream()
            .filter(car -> car.getPosition() == maxDistance)
            .collect(Collectors.toList());
  }

  public List<Car> getCars() {
    return cars;
  }
}
