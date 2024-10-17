package cleancode.studycafe.mission.model.pass.locker;

import cleancode.studycafe.mission.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.model.pass.StudyCafeSeatPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafeLockerPassesTest {

    @DisplayName("seatPass로 필터링한 lockerPass를 반환한다.")
    @Test
    void findLockerPassBySeatPass() {
        // given
        StudyCafeLockerPass lockerPass1 = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);
        StudyCafeLockerPass lockerPass2 = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED,12, 700000, 0.15);

        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(Arrays.asList(lockerPass1, lockerPass2));

        // when
        Optional<StudyCafeLockerPass> lockerPassBy = lockerPasses.findLockerPassBy(seatPass);

        // then
        assertTrue(lockerPassBy.isPresent());
        assertThat(lockerPassBy.get()).isEqualTo(lockerPass2);
    }
}
