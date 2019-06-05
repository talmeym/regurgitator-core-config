package com.emarte.regurgitator.core;

abstract class RemoveAtIndexProcessorBuilder {
    RemoveAtIndexProcessor buildRemoveAtIndexProcessor(String source, String value, Log log) throws RegurgitatorException {
        if(source == null && value == null) {
            throw new RegurgitatorException("Source or value is required");
        }

        log.debug("Loaded remove at processor");
        return new RemoveAtIndexProcessor(new ValueSource(source != null ? new ContextLocation(source) : null, value));
    }
}
