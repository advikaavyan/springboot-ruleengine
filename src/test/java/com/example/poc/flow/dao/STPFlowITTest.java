package com.example.poc.flow.dao;

import com.example.poc.flow.StpMessageController;
import com.example.poc.flow.model.entity.MessageFlowTracker;
import com.example.poc.flow.ser.InboundMessageDaoService;
import com.example.poc.flow.ser.MessageFlowTrackerDaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@ActiveProfiles("test")
/*@ContextConfiguration(classes = {AdaptorApp.class, LiquibaseTestConfig.class})*/
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class STPFlowITTest {


    @Autowired
    private StpMessageController stpMessageController;

    @Autowired
    private InboundMessageDaoService inboundMessageDaoService;
    @Autowired
    private MessageFlowTrackerDaoService  messageFlowTrackerDaoService;
    @Test
    public void playNewM() {

        String firstSTPMessage = "src/test/resources/messages/createLegs.json";
        stpMessageController.createMessage(getMessage(firstSTPMessage));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());
    }

    @Test
    public void playSameMessageTwice() {

        String firstSTPMessage = "src/test/resources/messages/createLegs.json";
        stpMessageController.createMessage(getMessage(firstSTPMessage));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            stpMessageController.createMessage(getMessage(firstSTPMessage));
        });

        String expectedSubstring = "Duplicate Message: BME_HEADER_DUPE Already Trade with uuid = ";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedSubstring), "Exception message does not contain expected substring.");
    }

    @Test
    public void playSameMessageTwiceJustUpdateHeaderUUID() {

        String firstSTPMessage = "src/test/resources/messages/createLegs.json";
        stpMessageController.createMessage(getMessage(firstSTPMessage));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());

        String sTPMessageWithOnlyUUIDChanged = "src/test/resources/messages/createLegsOnlyUuidChanged.json";
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            stpMessageController.createMessage(getMessage(sTPMessageWithOnlyUUIDChanged));
        });
        String expectedSubstring = "Duplicate Message: BASKET_VERSION_DUPE- NEWM Already Trade with same uuid, basket and version";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedSubstring), "Exception message does not contain expected substring.");
    }

    @Test
    public void playSameMessageWithNewUIIDAndVersion() {

        String firstSTPMessage = "src/test/resources/messages/createLegs.json";
        stpMessageController.createMessage(getMessage(firstSTPMessage));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());

        String sTPMessageWithOnlyUUIDChanged = "src/test/resources/messages/createLegsUuidVersionChanged.json";
        stpMessageController.createMessage(getMessage(sTPMessageWithOnlyUUIDChanged));
        Assertions.assertTrue((inboundMessageDaoService.findAll().size() == 2), "Two Trades to be present in system");

    }

    @Test
    public void playAmend() {

        String firstSTPMessage = "src/test/resources/messages/createLegs.json";
        stpMessageController.createMessage(getMessage(firstSTPMessage));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());
        System.out.println("NO LEGS PRESENT IN THE SYSTEM " + messageFlowTrackerDaoService.findAll().size());


        String sTPMessageWithOnlyUUIDChanged = "src/test/resources/messages/createLegsUuidVersionChanged.json";
        stpMessageController.createMessage(getMessage(sTPMessageWithOnlyUUIDChanged));
        Assertions.assertTrue((inboundMessageDaoService.findAll().size() == 2), "Two Trades to be present in system");

    }


    private String getMessage(String filePath) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }


}