package com.emarte.regurgitator.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

import static com.emarte.regurgitator.core.CoreTypes.SET_OF_STRING;
import static com.emarte.regurgitator.core.CoreTypes.STRING;
import static org.junit.Assert.*;

public class CorePropertiesHandlerTest {
    @Test
    public void testCorePropertiesHandler() {
        try {
            assertEquals(new HashSet<String>(Arrays.asList("ABC", "DEF", "GHI")), SET_OF_STRING.convert("ABC,DEF,GHI,ABC"));
            assertEquals("ABC,DEF", STRING.convert(Arrays.asList("ABC", "DEF")));

            Properties properties = new Properties();
            properties.setProperty(CorePropertiesHandler.STRING_TYPE_SEPARATOR, "|");

            new CorePropertiesHandler().handle(properties);

            assertEquals(new HashSet<String>(Arrays.asList("ABC", "DEF", "GHI")), SET_OF_STRING.convert("ABC|DEF|GHI|ABC"));
            assertEquals("ABC|DEF", STRING.convert(Arrays.asList("ABC", "DEF")));
        } catch (RegurgitatorException e) {
            fail("Exception: " + e.getMessage());
        }
    }
}