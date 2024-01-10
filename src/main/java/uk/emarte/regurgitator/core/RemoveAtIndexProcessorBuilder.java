package uk.emarte.regurgitator.core;

import static uk.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class RemoveAtIndexProcessorBuilder {
    RemoveAtIndexProcessor buildRemoveAtIndexProcessor(String source, String value, Log log) throws RegurgitatorException {
        log.debug("Loaded remove at processor");
        return new RemoveAtIndexProcessor(loadValueSource(source, value));
    }
}
