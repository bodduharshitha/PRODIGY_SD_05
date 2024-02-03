import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class ProductScraper {
    public static void main(String[] args) {
        try {
            // Replace the URL with the website you want to scrape
            String url = "https://books.toscrape.com/";
            Document document = Jsoup.connect(url).get();

            // Create a CSV file to store the extracted data
            FileWriter csvWriter = new FileWriter("product_data.csv");
            csvWriter.append("Title,Price,Rating\n");

            // Extract product information
            Elements products = document.select("h3 a");
            for (Element product : products) {
                String title = product.attr("title");
                Element priceElement = product.parent().nextElementSibling().select("p.price_color").first();
                String price = (priceElement != null) ? priceElement.text() : "N/A";
                Element ratingElement = product.parent().nextElementSibling().select("p.star-rating").first();
                String rating = (ratingElement != null) ? ratingElement.attr("class").replaceAll("[^A-Za-z]", "") : "N/A";

                // Write data to CSV
                csvWriter.append(title).append(",").append(price).append(",").append(rating).append("\n");
            }

            csvWriter.close();
            System.out.println("Data extraction completed. Check product_data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
