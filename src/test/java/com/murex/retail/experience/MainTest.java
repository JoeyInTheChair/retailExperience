package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void requirement1() {
        Main main = new Main();
        if (main.mList == null) {
            System.out.println("mList\tNULL");
        } else {
            System.out.println("mList\tSize = "+main.mList.size());
        }
        main.requirement1();

        if (main.mList == null) {
            System.out.println("mList\tNULL");
        } else {
            System.out.println("mList\tSize = "+main.mList.size());
        }
    }
}