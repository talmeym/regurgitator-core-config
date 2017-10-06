/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

public interface CoreConfigConstants {
    String ID = "id";
    String SOURCE = "source";
    String NAME = "name";
    String TYPE = "type";
    String GENERATOR = "generator";
    String MERGE = "merge";
    String BUILDER = "builder";
    String PROCESSOR = "processor";
    String VALUE = "value";
    String FILE = "file";

    // decision
    String RULES = "rules";
    String STEPS = "steps";
    String RULE = "rule";
    String STEP = "step";
    String CONDITION = "condition";
    String BEHAVIOUR = "behaviour";
    String EXPECTATION = "expectation";
    String DEFAULT_STEP = "default-step";

    // extract
    String FORMAT = "format";
    String INDEX = "index";

    // substitute
    String TOKEN = "token";
    String REPLACEMENT = "replacement";

    // number generator
    String MAX = "max";

    // index-of-processor
    String LAST = "last";

    // sequence
    String ISOLATE = "isolate";

    // size processor
    String AS_INDEX ="as-index";

    // record message
    String FOLDER ="folder";
}
