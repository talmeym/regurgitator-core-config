/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

abstract class IdentifySessionLoader {
    Step buildIdentifySession(String id, String source, String value, Log log) throws RegurgitatorException {
        int numberSet = 0;
        numberSet += source != null ? 1 : 0;
        numberSet += value != null ? 1 : 0;

        if(numberSet == 0) {
            throw new RegurgitatorException("Source or value is required");
        }

        ContextLocation location = source != null ? new ContextLocation(source) : null;
        log.debug("Loaded identify session '{}'", id);
        return new IdentifySession(id, new ValueSource(location, value));
    }
}
