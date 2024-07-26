package com.example.advikaavyan.adaptor.mycode;

import com.example.advikaavyan.adaptor.dto.MessageData;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


import java.io.StringReader;

public class XMLParser {

    public static MessageData parseXmlMessage(String xmlMessage) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MessageData.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlMessage);
            return (MessageData) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {

            throw new RuntimeException(e);
        }
    }
}
