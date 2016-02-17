package com.emarte.regurgitator.core;

import static com.emarte.regurgitator.core.CoreTypes.*;

public class CoreEntityPack extends AbstractEntityPack {

	public CoreEntityPack() {
		addConditionBehaviour("contains", new ContainsBehaviour());
		addConditionBehaviour("equals", new EqualsBehaviour());
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

		addRulesBehaviour("ALL_MATCHES", new AllMatchesBehaviour());
		addRulesBehaviour("FIRST_MATCH", new FirstMatchBehaviour());
		addRulesBehaviour("FIRST_MATCH_ONWARDS", new FirstMatchBehaviour());

		addValueGenerator("NUMBER", new NumberGenerator());
		addValueGenerator("UUID", new UuidGenerator());

		addValueProcessor("size-processor", new SizeProcessor(false));
	}
}
