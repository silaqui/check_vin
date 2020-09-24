
public class Vin {

    private final static int[] LETTER_VALUES = {
            1, 2, 3, 4, 5, 6, 7, 8, 0,
            1, 2, 3, 4, 5, 0, 7, 0, 9,
            2, 3, 4, 5, 6, 7, 8, 9
    };
    private final static int[] POSITION_WEIGHT = {
            8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2
    };

    public boolean isVinValid(String input) {
        String vin = getFormattedVim(input);
        if (checkLength(vin)) {
            return false;
        } else {
            int checkSum = getCheckSum(vin);
            int remainder = checkSum % 11;
            char check = vin.charAt(8);
            return checkRemainder(remainder, check);
        }
    }

    private String getFormattedVim(String input) {
        return input
                .replaceAll("-", "")
                .replaceAll(" ", "")
                .toUpperCase();
    }

    private boolean checkLength(String vin) {
        return vin.length() != 17;
    }

    private int getCheckSum(String vin) {
        int checkSum = 0;
        char[] charArray = vin.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            int charValue = getCharValue(charArray[i]);
            checkSum += POSITION_WEIGHT[i] * charValue;
        }
        return checkSum;
    }

    int getCharValue(char c) {
        if (c >= 'A' && c <= 'Z') {
            int letterValue = LETTER_VALUES[c - 'A'];
            return letterValue == 0 ? -1 : letterValue;
        } else if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return -1;
        }
    }

    boolean checkRemainder(int remainder, char check) {
        if (remainder == 10 && check == 'X') {
            return true;
        } else {
            return remainder == (check - '0');
        }
    }

}




