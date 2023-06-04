package speaking_clock.speaking_clock.service;

public interface SpeakingClocking {

    String currentTime();

    String handleInput(String time);


    String handleInputForMidDayAndMidNight(String time);
}
