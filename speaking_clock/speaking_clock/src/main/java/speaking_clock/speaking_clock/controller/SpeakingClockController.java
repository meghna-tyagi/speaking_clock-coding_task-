package speaking_clock.speaking_clock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import speaking_clock.speaking_clock.errorcodes.ErrorCodes;
import speaking_clock.speaking_clock.service.SpeakingClockImpl;

@RestController
@RequestMapping("/clock")
public class SpeakingClockController {

    @Autowired
    private SpeakingClockImpl speakingClockImpl;
    @GetMapping("/getCurrentTime")
    public ResponseEntity<String> getCurrentTime() {
        return new ResponseEntity<>( "It's " +  speakingClockImpl.currentTime(), HttpStatus.OK);
    }


    @GetMapping("/handleDateInput")
    public ResponseEntity<String> handleDateInput(@RequestParam("time") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) String time){
     return new ResponseEntity<>(speakingClockImpl.handleInput(time),HttpStatus.ACCEPTED);
    }
    @GetMapping("/getMidDayAndMidNight")
    public ResponseEntity<String> getMidDayAndMidNight(@RequestParam("time") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) String time){
        try {
            return new ResponseEntity<>(speakingClockImpl.handleInputForMidDayAndMidNight(time), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorCodes.STRING_IS_EMPTY);
        }
    }

}
