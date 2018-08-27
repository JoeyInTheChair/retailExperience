package com.murex.retail.experience;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.annotation.Target;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String filePath = "src/main/resources/Inventory.csv";

    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public List<String> mList;

    void requirement1() {
        Path path = Paths.get(filePath);
        mList = new ArrayList<String>();

        try {
            BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                mList.add(currentLine.replace(",", "\t|\t"));
            }

            for (String line : mList) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("requirement1- IOException");
            e.printStackTrace();
        }
    }

    void requirement2() {
        Path path = Paths.get(filePath);
        mList = new ArrayList<String>();

        try {
            BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                mList.add(currentLine.replace(",", "\t|\t"));
            }

            for (String line : mList) {
                logger.info(line);
            }
        } catch (IOException e) {
            logger.error("requirement1- IOException");
            e.printStackTrace();
        }
    }


}


