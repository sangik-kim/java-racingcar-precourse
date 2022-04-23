package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
    private static final String CAR_NAMES = "pobi,woni,jun";
    private static final int PARTICIPANTS_COUNT = 3;

    @Test
    @DisplayName("자동차 이름을 입력받아 생성한다")
    void 자동차_이름을_입력받아_생성한다() {
        assertThat(Racing.from(CAR_NAMES)).isNotNull();
    }

    @Test
    @DisplayName("쉼표로 구분된 N개의 자동차 이름으로 생성한다")
    void 쉼표로_구분된_N개의_자동차_이름으로_생성한다() {
        assertThat(Racing.from(CAR_NAMES).getParticipants().count()).isEqualTo(PARTICIPANTS_COUNT);
    }
}
