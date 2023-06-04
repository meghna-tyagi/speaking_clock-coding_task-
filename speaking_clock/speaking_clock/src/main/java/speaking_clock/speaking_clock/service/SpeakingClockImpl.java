package speaking_clock.speaking_clock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import speaking_clock.speaking_clock.errorcodes.ErrorCodes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class SpeakingClockImpl implements SpeakingClocking {

    @Autowired
    private TImeWordsConverter timeWordsConverter;

    @Override
    public String currentTime() {
        String timeInWords = "";
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String[] time = currentTime.split(":");
        timeInWords = timeWordsConverter.convertHoursIntoWords(time[0]);
        timeInWords = timeInWords + " " + timeWordsConverter.convertMinuteIntoWords(time[1]);
        System.out.println(currentTime);
        return timeInWords;
    }

    @Override
    public String handleInput(String time) {
        if (time.isBlank() || time.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorCodes.STRING_IS_EMPTY);
        }
        return ErrorCodes.TIME_HANDLED;
    }

    @Override
    public String handleInputForMidDayAndMidNight(String time) {
        if (time.isBlank() || Objects.isNull(time)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorCodes.STRING_IS_EMPTY);
        }

        String[] amOrPm = time.split(" ");
        String[] timeforTweleve = amOrPm[0].split(":");
        if (timeforTweleve[0].equals("12") && timeforTweleve[1].equals("00") && amOrPm.equals("AM"))
            return ErrorCodes.MID_NIGHT;

        else if (timeforTweleve[1].equals("12") && timeforTweleve[1].equals("00") && amOrPm.equals("PM"))
            return ErrorCodes.MID_NIGHT;
        else
            return null;
    }
}