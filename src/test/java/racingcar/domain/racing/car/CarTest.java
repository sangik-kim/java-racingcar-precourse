package racingcar.domain.racing.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("이름은 5자 이하만 가능하다")
    void 이름은_5자_이하만_가능하다() {
        Car car = new Car("이름", 0);
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("이름이 6자 이상이면 예외처리 한다")
    void 이름이_6자_이상이면_예외처리_한다() {
        assertThatThrownBy(() -> new Car("123456", 0)).isInstanceOf(
                IllegalArgumentException.class);
    }
}
