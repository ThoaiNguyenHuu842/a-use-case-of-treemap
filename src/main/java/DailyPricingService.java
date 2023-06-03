import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DailyPricingService {
  private static final Map<String, TreeMap<Date, BigDecimal>> MAP_SECURITY_DAILY_PRICING = new HashMap<>();

  public void add(String securityCode, Date date, BigDecimal price) {
    TreeMap<Date, BigDecimal> treeMapDailyPricing = MAP_SECURITY_DAILY_PRICING.get(securityCode);
    if (treeMapDailyPricing == null) {
      treeMapDailyPricing = new TreeMap<>();
      MAP_SECURITY_DAILY_PRICING.put(securityCode, treeMapDailyPricing);
    }
    treeMapDailyPricing.put(date, price);
  }

  public BigDecimal getPrice(String securityCode, Date date) {
    TreeMap<Date, BigDecimal> treeMapDailyPricing = MAP_SECURITY_DAILY_PRICING.get(securityCode);
    if (treeMapDailyPricing == null) {
      throw new IllegalArgumentException(String.format("No pricing data for security code %s", securityCode));
    }

    Entry<Date, BigDecimal> entry = treeMapDailyPricing.floorEntry(date);
    if (entry == null) {
      throw new IllegalArgumentException(String.format("No pricing data found for security code %s and date %s", securityCode, date));
    }
    return entry.getValue();
  }
}
