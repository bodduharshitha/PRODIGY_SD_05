# Product Scraper

This Java program utilizes the Jsoup library to scrape product information, such as names, prices, and ratings, from an online e-commerce website. In this example, it scrapes book information from [https://books.toscrape.com/](https://books.toscrape.com/) and stores the data in a structured format (CSV file).

## Prerequisites

Make sure you have the Jsoup library added to your project. You can download it from [https://jsoup.org/download](https://jsoup.org/download).

```xml
<!-- Add this dependency to your Maven project -->
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.14.3</version>
</dependency>
