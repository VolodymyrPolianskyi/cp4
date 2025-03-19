package pl.vpolianskyi.creditcard;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static  org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    void cardIsIdentifiedWithNumber(){
        var number = "1234-5678";

        var card = new CreditCard(number);

        assertEquals("1234-5678", card.getNumber());
    }

    @Test
    void assignInitialCredit(){
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1300));
        assertEquals(BigDecimal.valueOf(1300), card.getBalance());
    }

    @Test
    void limitCantBeLowerThanThreshold(){
        var card = new CreditCard("1234-5678");
        try{
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Exeption should be thrown");
        } catch (CreditBelowThresholdException e ){
            assertTrue(true);
        }
    }

    @Test
    void limitCantBeLowerThanThresholdV2(){
        var card = new CreditCard("1234-5678");

        assertThrows(
                CreditBelowThresholdException.class,
                ()-> card.assignCredit(BigDecimal.valueOf(50))
        );
    }

    @Test
    void limitCantBeLowerThanThresholdV3(){
        var card = new CreditCard("1234-5678");
        assertThrows(
                CreditBelowThresholdException.class,
                ()-> card.assignCredit(BigDecimal.valueOf(99))
        );

        assertDoesNotThrow(()->card.assignCredit(BigDecimal.valueOf(100)));
    }

    @Test
    void creditCantBeAssignedTwice(){
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1300));

        assertThrows(
                CreditCantBeAssignedTwice.class,
                () -> card.assignCredit(BigDecimal.valueOf(1300))
        );
    }
    @Test
    void itAllowsToWithdrawSomeMoney(){
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1300));

        card.withdraw(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(1200), card.getBalance());
    }

    @Test
    void cantWithdrawWhenNotEnoughMoney(){
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1300));

        card.withdraw(BigDecimal.valueOf(1240));
        assertThrows(
                NotEnoughException.class,
                ()->card.withdraw(BigDecimal.valueOf(199))
        );
    }

}
