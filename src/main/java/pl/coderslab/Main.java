package pl.coderslab;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                System.out.println(elem.text());
            }
            throw new IOException();
        } catch (IOException e) {
            LOGGER.error("Problem with page parsing!", e);
            //e.printStackTrace();
        }

    }
}
