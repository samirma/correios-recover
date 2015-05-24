
package com.correios.recover.automator.recover.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class PiParserHtml implements PiParser{
    
    private static String xpathPi = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/div/div/p[3]/b[1]";

    @Override
    public String getPIFromHtml(String html) {
        final Document parse = Jsoup.parse(html);
        final Element first = parse.select("b.dicadestaque").first();
        final String text = first.text();
        return text;
    }

}
