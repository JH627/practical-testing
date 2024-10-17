package cleancode.studycafe.mission;

import cleancode.studycafe.mission.io.provider.LockerPassFileReader;
import cleancode.studycafe.mission.io.provider.SeatPassFileReader;
import cleancode.studycafe.mission.provider.LockerPassProvider;
import cleancode.studycafe.mission.provider.SeatPassProvider;

public class StudyCafeApplication {

    public static void main(String[] args) {
        SeatPassProvider seatPassProvider = new SeatPassFileReader();
        LockerPassProvider lockerPassProvider = new LockerPassFileReader();

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(
            seatPassProvider, lockerPassProvider
        );
        studyCafePassMachine.run();
    }

}
