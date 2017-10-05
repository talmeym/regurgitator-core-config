package com.emarte.regurgitator.core;

abstract class IdentifySessionLoader {
    Step buildIdentifySession(String id, String source, String value, Log log) throws RegurgitatorException {
        int numberSet = 0;
        numberSet = source != null ? ++numberSet : numberSet;
        numberSet = value != null ? ++numberSet : numberSet;

        if(numberSet == 0) {
            throw new RegurgitatorException("Source or value is required");
        }

        ContextLocation location = source != null ? new ContextLocation(source) : null;
        log.debug("Loaded identify session '{}'", id);
        return new IdentifySession(id, new ValueSource(location, value));
    }
}
