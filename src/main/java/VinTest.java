import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VinTest {

    private Vin tested = new Vin();

    @Test
    public void shouldValidateLength() {
        //given
        String input = "12345678 7 01234567";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertTrue(actual);

    }
    @Test
    public void shouldValidateLengthTooShort() {
        //given
        String input = "1";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertFalse(actual);

    }
    @Test
    public void shouldValidateLengthTooTooLong() {
        //given
        String input = "123456789012345678";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertFalse(actual);
    }
    @Test
    public void shouldValidateLengthRemoveSeparators() {
        //given
        String input = "12345 678 7 0 12345-67";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertTrue(actual);
    }
    @Test
    public void shouldValidateInvalidChar() {
        //given
        String input = "123456789012345$7";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertFalse(actual);
    }
    @Test
    public void shouldValidateValidCharacters() {
        //given
        String input = "zxcasdaw 2 ZXCASDAW";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertTrue(actual);
    }

    //Test before this point, after adding check digit part were fixed with https://www.cjponyparts.com/resources/check-digit-calculator

    @Test
    public void shouldValidateInvalidateSpecialCharacter() {
        //given
        String input = "1234567890123456 ł";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertFalse(actual);
    }
    @Test
    public void shouldValidateInvalidateSpecialCharacter_I() {
        //given
        String input = "1234567890123456 I";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertFalse(actual);
    }
    @Test
    public void shouldValidateInvalidateSpecialCharacter_O() {
        //given
        String input = "1234567890123456 O";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertFalse(actual);
    }
    @Test
    public void shouldValidateInvalidateSpecialCharacter_Q() {
        //given
        String input = "1234567890123456 Q";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertFalse(actual);
    }
    @Test
    public void shouldGiveNegativeForInvalidLetter() {
        //given
        char input = 'Q';
        //when
        int actual = tested.getCharValue(input);
        //then
        assertTrue(actual < 0);
    }
    @Test
    public void shouldGiveNumberValue() {
        //given
        char input = '5';
        //when
        int actual = tested.getCharValue(input);
        //then
        assertEquals(actual, 5);
    }
    @Test
    public void shouldCheckRest() {
        //given
        //when
        boolean actual = tested.checkRemainder(5,'5');
        //then
        assertEquals(actual,true );
    }
    @Test
    public void shouldCheckRestWithX() {
        //given
        //when
        boolean actual = tested.checkRemainder(10,'X');
        //then
        assertEquals(actual,true );
    }
    @Test
    public void shouldFailCheckRest() {
        //given
        //when
        boolean actual = tested.checkRemainder(1,'X');
        //then
        assertEquals(actual,true );
    }
    @Test
    public void shouldHaveGoodCheckDigit() {
        //given
        String input = "1M8GDM9A X KP042788 ";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertTrue(actual);
    }
    @Test
    public void shouldHaveWrongCheckDigit() {
        //given
        String input = "1M8GDM9A z KP042788 ";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertFalse(actual);
    }
    @Test
    public void shouldHaveGoodCheckDigitAsNumber() {
        //given
        String input = "2M8GDM9A 7 KP042788";
        //when
        boolean actual = tested.isVinValid(input);
        //then
        assertTrue(actual);
    }
}