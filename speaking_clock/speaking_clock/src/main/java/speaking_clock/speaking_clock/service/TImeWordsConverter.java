package speaking_clock.speaking_clock.service;

import org.springframework.stereotype.Component;
@Component
public class TImeWordsConverter {
    public String convertHoursIntoWords(String hours) {
        Integer hour = Integer.parseInt(hours);
        if (hour > 12) {
            hour = hour - 12;
            hours = String.valueOf(hour);
        }

        switch (hours) {
            case "00":
                return "";
            case "01":
                return "One";
            case "02":
                return "Two";
            case "03":
                return "Three";
            case "04":
                return "Four";
            case "05":
                return "Five";
            case "06":
                return "Six";
            case "07":
                return "Seven";
            case "08":
                return "Eight";
            case "09":
                return "Nine";
            case "10":
                return "Ten";
            case "11":
                return "Eleven";
            case "12":
                return "Twelve";
        }
        return null;
    }

    public String convertMinuteIntoWords(String minute) {
        switch (minute) {

            case "00":
                return "";

            case "01":
                return "One";

            case "02":
                return "Two";

            case "03":
                return "Three";

            case "04":
                return "Four";

            case "05":
                return "Five";

            case "06":
                return "Six";

            case "07":
                return "Seven";

            case "08":
                return "Eight";

            case "09":
                return "Nine";

            case "10":
                return "Ten";

            case "11":
                return "Eleven";

            case "12":
                return "Tweleve";

            case "13":
                return "Thirteen";

            case "14":
                return "Fourteen";

            case "15":
                return "Fifteen";

            case "16":
                return "Sixteen";

            case "17":
                return "Seventeen";

            case "18":
                return "Eighteen";

            case "19":
                return "Nineteen";

            case "20":
                return "Twenty";

            case "21":
                return "Twenty One";

            case "22":
                return "Twenty Two";

            case "23":
                return "Twenty Three";

            case "24":
                return "Twenty Four";

            case "25":
                return "Twenty Five";

            case "26":
                return "Twenty Six";

            case "27":
                return "Twenty Seven";

            case "28":
                return "Twenty Eight";

            case "29":
                return "Twenty Nine";

            case "30":
                return "Thirty";

            case "31":
                return "Thirty One";

            case "32":
                return "Thirty Two";

            case "33":
                return "Thirty Three";

            case "34":
                return "Thirty Four";

            case "35":
                return "Thirty Five";

            case "36":
                return "Thirty Six";

            case "37":
                return "Thirty Seven";

            case "38":
                return "Thirty Eight";

            case "39":
                return "Thirty Nine";

            case "40":
                return "Fourty";

            case "41":
                return "Fourty One";

            case "42":
                return "Fourty Two";

            case "43":
                return "Fourty Three";

            case "44":
                return "Fourty Four";

            case "45":
                return "Fourty Five";

            case "46":
                return "Fourty Six";

            case "47":
                return "Fourty Seven";

            case "48":
                return "Fourty Eight";

            case "49":
                return "Fourty Nine";

            case "50":
                return "Fifty";

            case "51":
                return "Fifty One";

            case "52":
                return "Fifty Two";

            case "53":
                return "Fifty Three";

            case "54":
                return "Fifty Four";

            case "55":
                return "Fifty Five";

            case "56":
                return "Fifty Six";

            case "57":
                return "Fifty Seven";

            case "58":
                return "Fifty Eight";
        }
        return null;
    }
}
