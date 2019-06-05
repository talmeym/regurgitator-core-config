/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

abstract class AtIndexProcessorLoader {
    AtIndexProcessor buildAtIndexProcessor(String source, String value, Log log) throws RegurgitatorException {
        if(source == null && value == null) {
            throw new RegurgitatorException("Source or value is required");
        }

        log.debug("Loaded index processor");
        return new AtIndexProcessor(new ValueSource(source != null ? new ContextLocation(source) : null, value));
    }
}
