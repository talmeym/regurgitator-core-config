package com.emarte.regurgitator.core;

public interface EntityPack {
	public ConditionBehaviour getConditionBehaviour(String id);
	public ConfigurationLoader getConfigurationLoader(String id);
	public ParameterType getParameterType(String id);
    public RulesBehaviour getRulesBehaviour(String id);
	public ValueBuilder getValueBuilder(String id);
	public ValueGenerator getValueGenerator(String id);
	public ValueProcessor getValueProcessor(String id);
}
