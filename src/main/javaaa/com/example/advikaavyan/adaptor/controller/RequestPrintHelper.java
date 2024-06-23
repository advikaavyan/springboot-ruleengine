package com.example.advikaavyan.adaptor.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;


@Slf4j
public class RequestPrintHelper {


    public void printAll(HttpServletRequest request) {
        InetAddress id = null;
        try {
            id = InetAddress.getLocalHost();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ getHostName   "+ id);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


      /*  printRequestParameters(request);
        System.out.println("############################################################################################");*/
        printRequestHeaders(request);

        System.out.println("############################################################################################");

        /*printRequestAttributes(request);
        System.out.println("############################################################################################");
*/
    }

    private void printRequestParameters(HttpServletRequest request) {
        System.out.println("Request Parameters:");
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);

            for (String paramValue : paramValues) {
                System.out.println(paramName + " = " + paramValue);
            }
        }
    }

    private void printRequestAttributes(HttpServletRequest request) {
        System.out.println("\nRequest Attributes:");
        Enumeration<String> attributeNames = request.getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = request.getAttribute(attributeName);
            System.out.println(attributeName + " = " + attributeValue);
        }
    }

    private void printRequestHeaders(HttpServletRequest request) {
        System.out.println("\nRequest Headers:");
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + " = " + headerValue);
        }
    }
}
