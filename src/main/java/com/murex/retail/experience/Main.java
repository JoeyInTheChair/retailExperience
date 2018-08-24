package com.murex.retail.experience;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String filePath = "src/main/resources/Inventory.csv";


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
            e.printStackTrace();
        }
    }
}
