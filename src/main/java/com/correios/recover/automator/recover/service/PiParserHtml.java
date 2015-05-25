
package com.correios.recover.automator.recover.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class PiParserHtml implements PiParser{
    
    @Override
    public String getPIFromHtml(String html) {
        final Document parse = Jsoup.parse(html);
        final Element first = parse.select("b.dicadestaque").first();
        final String text = first.text();
        return text;
    }

}
