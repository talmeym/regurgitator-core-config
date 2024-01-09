/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import static uk.emarte.regurgitator.core.CoreTypes.*;

public class CoreEntityPack extends AbstractEntityPack {

    public CoreEntityPack() {
        addConditionBehaviour("contains", new ContainsBehaviour());
        addConditionBehaviour("equals", new EqualsBehaviour());
        addConditionBehaviour("matches", new MatchesBehaviour());
        addConditionBehaviour("exists", new ExistsBehaviour());
        addConditionBehaviour("equals-param", new EqualsParamBehaviour());
        addConditionBehaviour("contains-param", new ContainsParamBehaviour());

        addParameterType("STRING", STRING);
        addParameterType("NUMBER", NUMBER);
        addParameterType("DECIMAL", DECIMAL);

        addParameterType("LIST_OF_STRING", LIST_OF_STRING);
        addParameterType("LIST_OF_NUMBER", LIST_OF_NUMBER);
        addParameterType("LIST_OF_DECIMAL", LIST_OF_DECIMAL);

        addParameterType("SET_OF_STRING", SET_OF_STRING);
        addParameterType("SET_OF_NUMBER", SET_OF_NUMBER);
        addParameterType("SET_OF_DECIMAL", SET_OF_DECIMAL);

        addRulesBehaviour("all-matches", new AllMatchesBehaviour());
        addRulesBehaviour("first-match", new FirstMatchBehaviour());
        addRulesBehaviour("first-match-onwards", new FirstMatchOnwardsBehaviour());

        addValueGenerator("number-generator", new NumberGenerator());
        addValueGenerator("uuid-generator", new UuidGenerator());

        addValueProcessor("size-processor", new SizeProcessor(false));
    }
}
