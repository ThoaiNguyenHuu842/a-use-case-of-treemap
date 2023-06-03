import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DailyPricingServiceTest {
  @Test
  public void get_price_success() throws ParseException {
    DailyPricingService dailyPricingService = new DailyPricingService();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dailyPricingService.add("NT2", dateFormat.parse("01/01/2023"), BigDecimal.valueOf(100.5));
    dailyPricingService.add("NT2", dateFormat.parse("01/01/2023"), BigDecimal.valueOf(100.6));
    dailyPricingService.add("NT2", dateFormat.parse("03/01/2023"), BigDecimal.valueOf(100.7));
    dailyPricingService.add("NT2", dateFormat.parse("07/01/2023"), BigDecimal.valueOf(99));
    dailyPricingService.add("NT2", dateFormat.parse("09/01/2023"), BigDecimal.valueOf(102));
    dailyPricingService.add("NT2", dateFormat.parse("15/01/2023"), BigDecimal.valueOf(87.4));

    Assertions.assertEquals(dailyPricingService.getPrice("NT2", dateFormat.parse("11/01/2023")), BigDecimal.valueOf(102), "No pricing data at 11/01/2023, so the date at 09/01/2023 should be used");
  }
}
