package uk.emarte.regurgitator.core;

import java.io.IOException;

import static uk.emarte.regurgitator.core.FileUtil.getInputStreamForFile;
import static uk.emarte.regurgitator.core.FileUtil.streamToString;

public final class ValueSourceLoader {
    public static ValueSource loadValueSource(String source, String value, String file) throws RegurgitatorException {
        if(source == null && value == null && file == null) {
            throw new RegurgitatorException("Source, value or file is required");
        }

        if(value != null && file != null) {
            throw new RegurgitatorException("Value and file not both allowed");
        }

        if(file != null) {
            try {
                value = streamToString(getInputStreamForFile(file));
            } catch (IOException e) {
                throw new RegurgitatorException("Error loading file: " + file, e);
            }
        }

        ContextLocation location = source != null ? new ContextLocation(source) : null;
        return new ValueSource(location, value);
    }

    public static ValueSource loadValueSource(String source, String value) throws RegurgitatorException {
        if(source == null && value == null) {
            throw new RegurgitatorException("Source or value is required");
        }

        ContextLocation location = source != null ? new ContextLocation(source) : null;
        return new ValueSource(location, value);
    }

    public static String loadValueSourceForProcessor(String value, String file) throws RegurgitatorException {
        if(value == null && file == null) {
            throw new RegurgitatorException("Value or file is required");
        }

        if(value != null && file != null) {
            throw new RegurgitatorException("Value and file not both allowed");
        }

        if(file != null) {
            try {
                value = streamToString(getInputStreamForFile(file));
            } catch (IOException e) {
                throw new RegurgitatorException("Error loading file: " + file, e);
            }
        }

        return value;
    }
}
