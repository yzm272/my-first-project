package org.example.lamda;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LamdaDemo1Test {

    @org.junit.jupiter.api.Test
    void testMain(){
        LamdaDemo2 a=new LamdaDemo2();
        String[] s=new String[0];
        a.main(s);
    }
}