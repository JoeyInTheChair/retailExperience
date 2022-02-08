package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void MurexRetailExperienceTest() throws URISyntaxException, IOException {
        Main main = new Main();
        String output = main.runMurexRetailExperience();
        assertEquals(getExpectedOutput(), output);
    }

    private String getExpectedOutput() throws URISyntaxException, IOException {
        List<String> list = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("Inventory.csv").toURI()));
        StringBuilder build = new StringBuilder();
        for(String s : list){
            build.append(s.replace(",", "\t|\t")).append("\n");
        } return build.toString();
    }
}