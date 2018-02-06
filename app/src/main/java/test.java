/**
 * Created by Danila on 06.02.2018.
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class test {




    public static void main(String[] args) throws URISyntaxException, IOException {



        test nash = new test();
        nash.run();


    }

    public void run() throws IOException, URISyntaxException{
        URI uri = new URI("https://habrahabr.ru/rss/hubs/all/");

        ObjectMapper objectMapper = new XmlMapper();

        Items items = objectMapper.readValue(
                StringUtils.toEncodedString(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8),
                Items.class);

        System.out.println(items);
    }
}

class Items{
    Item items[];

    @Override
    public String toString() {
        return ""+items.length;
    }
}
class Item {
    @JacksonXmlProperty(localName = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item (String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

