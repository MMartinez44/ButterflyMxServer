package com.marie.butterflymxserver.domain.resident.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResidentTest {

    @Test
    public void constructorTest01(){
        Resident resident = new Resident("Marie", "Martinez", "WorldTraveler11@gmail.com", "2M");
        resident.setId(1l);

        String expected = ("1 Marie Martinez WorldTraveler11@gmail.com 2M");
        String actual = resident.toString();

        Assertions.assertEquals(expected, actual);
    }
}
