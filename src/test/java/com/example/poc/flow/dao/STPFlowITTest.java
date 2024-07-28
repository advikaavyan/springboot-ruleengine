package com.example.poc.flow.dao;

import com.example.poc.flow.StpMessageController;
import com.example.poc.flow.ser.InboundMessageDaoService;
import com.example.poc.flow.ser.MessageFlowTrackerDaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@ActiveProfiles("test")
//@ContextConfiguration(classes = {AdaptorApp.class, TestLiquibaseConfig.class})
/*@ContextConfiguration(classes = TestLiquibaseConfig.class)*/

// when @Transactional //java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "entities" is null
/*@ContextConfiguration(classes = {AdaptorApp.class, LiquibaseTestConfig.class})*/
/*@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)*/

/*@Transactional*/
public class STPFlowITTest {


    @Autowired
    private StpMessageController stpMessageController;

    @Autowired
    private InboundMessageDaoService inboundMessageDaoService;
    @Autowired
    private MessageFlowTrackerDaoService messageFlowTrackerDaoService;

    private String NEWM_TRADE = "src/test/resources/messages/newm.json";

    private String NEWM_HEADER_DUPE = "src/test/resources/messages/newm_HeaderDupe.json";
    private String AMEND_TRADE = "src/test/resources/messages/amend.json";


    private String CANC_TRADE = "src/test/resources/messages/canc.json";

    @Test
    @Transactional
    public void playNewM() {
        stpMessageController.createMessage(getMessage(NEWM_TRADE));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());
    }

    @Test
    public void playSameMessageTwice() {

        stpMessageController.createMessage(getMessage(NEWM_TRADE));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            stpMessageController.createMessage(getMessage(NEWM_TRADE));
        });

        String expectedSubstring = "Duplicate Message: BME_HEADER_DUPE Already Trade with uuid = ";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedSubstring), "Exception message does not contain expected substring.");
    }

    @Test
    public void playSameMessageTwiceJustUpdateHeaderUUID() {

        stpMessageController.createMessage(getMessage(NEWM_TRADE));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());


        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            stpMessageController.createMessage(getMessage(NEWM_HEADER_DUPE));
        });
        String expectedSubstring = "Duplicate Message: BASKET_VERSION_DUPE- NEWM Already Trade with same uuid, basket and version";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedSubstring), "Exception message does not contain expected substring.");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + messageFlowTrackerDaoService.findAll().size());
    }

    @Test
    @Transactional
    public void playAmend() {

        stpMessageController.createMessage(getMessage(NEWM_TRADE));

        stpMessageController.createMessage(getMessage(AMEND_TRADE));
        Assertions.assertTrue((inboundMessageDaoService.findAll().size() == 2), "Two Trades to be present in system");
    }

    @Test
    public void playAmend1() {

        stpMessageController.createMessage(getMessage(NEWM_TRADE));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());
        System.out.println("NO LEGS PRESENT IN THE SYSTEM " + messageFlowTrackerDaoService.findAll().size());

  /*   List<MessageFlowTracker> aaaa = messageFlowTrackerDaoService.findAll();
     for(MessageFlowTracker messageFlowTracker : aaaa){
         System.out.println("+++++++++++++++++++++++++++++ "+messageFlowTracker.getInboundMessage());
     }
*/
        stpMessageController.createMessage(getMessage(AMEND_TRADE));
        Assertions.assertTrue((inboundMessageDaoService.findAll().size() == 2), "Two Trades to be present in system");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + messageFlowTrackerDaoService.findAll().size());
    }

    @Test
    public void playCanc() {
        stpMessageController.createMessage(getMessage(CANC_TRADE));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + messageFlowTrackerDaoService.findAll().size());
    }

    @Test
    public void playNewmThenCanc() {

        stpMessageController.createMessage(getMessage(NEWM_TRADE));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());

        stpMessageController.createMessage(getMessage(CANC_TRADE));
        System.out.println("NO TRADE PRESENT IN THE SYSTEM " + inboundMessageDaoService.findAll().size());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + messageFlowTrackerDaoService.findAll().size());
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