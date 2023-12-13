/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

import java.util.Properties;

import static com.emarte.regurgitator.core.Log.getLog;

public class CorePropertiesHandler implements ConfigPropertiesHandler {
    private static final Log LOG = getLog(CorePropertiesHandler.class);
    private static final String PUNCTUATIONS = "`~!@#$%^&*()_+{}|:\"<>?-=[];'.\\/,'";
    private static final String STRING_TYPE_EXC_MSG = "Invalid string type separator - separator value must be a single character punctuation mark";

    static final String STRING_TYPE_SEPARATOR = "string.type.separator";

    @Override
    public void handle(Properties properties) throws RegurgitatorException {
        if(properties.containsKey(STRING_TYPE_SEPARATOR)) {
            String separator = properties.getProperty(STRING_TYPE_SEPARATOR);
            if(separator.length() > 1 || !PUNCTUATIONS.contains(separator)) {
                throw new RegurgitatorException(STRING_TYPE_EXC_MSG);
            }

            LOG.debug("Setting string type separator to '{}'", separator);
            StringType.setSeparator(separator.charAt(0));
        }
    }
}
