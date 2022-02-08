package com.murex.retail.experience;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

   private static final Logger logger = LogManager.getLogger(Main.class);

   public static void main(String[] args) throws URISyntaxException {
      LinkedList<String> list = new LinkedList<>();
      readCSVFileUsingNIO(list);
      loggerPrint(list);
   }

   public static void readCSVFileUsingNIO(LinkedList<String> list) throws URISyntaxException {
      try {
         List<String> lines = readResourceFile();
         for(String s : lines)
            list.add(s.replace(",", "\t|\t"));
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   private static List<String> readResourceFile() throws IOException, URISyntaxException {
      return Files.readAllLines(Paths.get(ClassLoader.getSystemResource("Inventory.csv").toURI()));
   }

   public static void loggerPrint(LinkedList<String> list) {

      for(String s : list) {
         logger.info(s);
      }
   }
}
