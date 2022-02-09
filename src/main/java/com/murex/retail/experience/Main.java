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
   public static LinkedList<String> list = new LinkedList<>();

   public static void main(String[] args) throws URISyntaxException {
      new Main().runMurexRetailExperience();
   }

   String runMurexRetailExperience() throws URISyntaxException {
      readCSVFileUsingNIO();
      for (String s : list) logger.info(s);
      StringBuilder builder = new StringBuilder();
      for(String s : list) builder.append(s).append("\n");
      return builder.toString();
   }

   public static void readCSVFileUsingNIO() throws URISyntaxException {
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
}
