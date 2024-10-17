package cleancode.studycafe.mission.model.pass.locker;

import cleancode.studycafe.mission.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafeLockerPassTest {

    @DisplayName("lockerPass와 주어진 PassType이 같은지 확인한다.")
    @Test
    void isSamePassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);

        // when
        boolean samePassType = lockerPass.isSamePassType(StudyCafePassType.HOURLY);

        // then
        assertFalse(samePassType);
    }

}
