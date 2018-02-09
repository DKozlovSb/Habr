package com.example.danila.examapplication;
/**
 * Created by Danila on 06.02.2018.
 */

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class Test {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Test nash = new Test();
        nash.run();

    }

    public  String run() throws IOException, URISyntaxException{
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        Rss result = objectMapper.readValue(
                new URL("https://habrahabr.ru/rss/hubs/all/"),
                Rss.class);
       return result.toString();
    }
}

@JacksonXmlRootElement(localName = "rss")
class Rss{
    @JacksonXmlProperty(isAttribute=true)
    String version = "empty";

    @JacksonXmlProperty(localName = "channel")
    Channel channel;

    @Override
    public String toString() {
        return "rss version: "+version+" contains: \n" + channel.toString();
    }
}

class Channel{
    @JacksonXmlProperty(isAttribute=false, localName = "title")
    String title = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "link")
    String link = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "description")
    String description = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "language")
    String language = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "managingEditor")
    String managingEditor = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "generator")
    String generator = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "pubDate")
    String pubDate = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "lastBuildDate")
    String lastBuildDate = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "image")
    Image image;


    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(isAttribute=false, localName = "item")
    Item[] items;


    @Override
    public String toString() {
        String s = "Channel{" + "\n" +
                "title='" + title + "'\n" +
                "link='" + link + "'\n" +
                "description='" + description + "'\n" +
                "language='" + language + "'\n" +
                "managingEditor='" + managingEditor + "'\n" +
                "generator='" + generator + "'\n" +
                "pubDate='" + pubDate + "'\n" +
                "lastBuildDate='" + lastBuildDate + "'\n" +
                "image=" + image;

        for (Item i: items ) {
            s = s + i.toString() + "\n";
        }
        s= s+ "}";
        return s;
    }
}


class Item{
    @JacksonXmlProperty(isAttribute=false, localName = "title")
    String title = "empty";


    @JacksonXmlProperty(isAttribute= false, localName = "guid")
    Guid guid;


    @JacksonXmlProperty(isAttribute= false, localName = "link")
    String link = "empty";


    @JacksonXmlProperty(isAttribute= false, localName = "description")
    String description = "empty";


    @JacksonXmlProperty(isAttribute= false, localName = "pubDate")
    String pubDate = "empty";


    @JacksonXmlProperty(namespace = "dc",isAttribute= false, localName = "creator")
    String dcCreator = "empty";

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(isAttribute= false, localName = "category")
    Category[] categories;


    @Override
    public String toString() {
        return pubDate + " " + title;
    }
}
class Guid{
    @JacksonXmlProperty(isAttribute= true, localName = "isPermaLink")
    boolean isPermaLink = false;

    @JacksonXmlText
    String guid = "empty";

}

class Image{
    @JacksonXmlProperty(isAttribute= false, localName = "link")
    String link = "empty";

    @JacksonXmlProperty(isAttribute= false, localName = "url")
    String url = "empty";


    @JacksonXmlProperty(isAttribute=false, localName = "title")
    String title = "empty";
}

class Category{
    @JacksonXmlText
    String category = "empty";

}