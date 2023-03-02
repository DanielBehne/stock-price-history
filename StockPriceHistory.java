import yahoofinance.*;
import java.util.Calendar;
import java.util.List;
import yahoofinance.histquotes.Interval;
/**
 * Retrieve historical stock prices
 */
public class StockPriceHistory 
{
    private final String TICKER = "GOOG";
    
    /**
     * Retrieve the stock price data
     */
    public void run() {
        try {
            System.out.println("Date, Closing price");
            Stock stock = YahooFinance.get(TICKER);
            Calendar from  = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.add(Calendar.MONTH, -1);
            
            List<HistoricalQuote> h = stock.getHistory(from, to, Interval.DAILY);
            System.out.println(stock.getHistory(from, to, Interval.DAILY));
        } catch (Exception e) {
            System.out.println("Error in stock call");    
        }
    }
    
    /**
     * Format a Calendar object to YYYY-MM-DD format
     */
    private String formatDate(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH)+1;
        int day = date.get(Calendar.DATE);
        String monthStr = (month < 10) ? "0"+month : month+"";
        String dayStr = (day < 10) ? "0"+day : day+"";
        
        String dateStr = year+"-"+monthStr+"-"+dayStr;
        return dateStr;
    }
    

    /**
     * Main method to run the program
     */
    public static void main (String[] args) {
        StockPriceHistory sph = new StockPriceHistory();
        sph.run();
    }
}

