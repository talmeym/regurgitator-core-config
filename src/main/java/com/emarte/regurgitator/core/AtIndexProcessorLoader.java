/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

import static com.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class AtIndexProcessorLoader {
    AtIndexProcessor buildAtIndexProcessor(String source, String value, Log log) throws RegurgitatorException {
        log.debug("Loaded index processor");
        return new AtIndexProcessor(loadValueSource(source, value));
    }
}
