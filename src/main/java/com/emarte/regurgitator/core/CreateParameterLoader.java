/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

abstract class CreateParameterLoader {
    Step buildCreateParameter(String id, ParameterPrototype prototype, String context, String source, String value, String file, ValueProcessor processor, Log log) throws RegurgitatorException {
        int numberSet = 0;
        numberSet = source != null ? ++numberSet : numberSet;
        numberSet = value != null ? ++numberSet : numberSet;
        numberSet = file != null ? ++numberSet : numberSet;

        if(numberSet == 0) {
            throw new RegurgitatorException("Source, value or file is required");
        }

        if(value != null && file != null) {
            throw new RegurgitatorException("Value and file not both allowed");
        }

        if(file != null) {
            try {
                value = FileUtil.streamToString(FileUtil.getInputStreamForFile(file));
            } catch (Exception e) {
                throw new RegurgitatorException("Error loading file: " + file, e);
            }
        }

        ContextLocation location = source != null ? new ContextLocation(source) : null;
        log.debug("Loaded create parameter '{}'", id);
        return new CreateParameter(id, prototype, context, new ValueSource(location, value), processor);
    }
}
