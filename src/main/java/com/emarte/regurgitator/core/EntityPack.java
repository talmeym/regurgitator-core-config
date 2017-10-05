package com.emarte.regurgitator.core;

interface EntityPack {
    ConditionBehaviour getConditionBehaviour(String id);
    ConfigurationLoader getConfigurationLoader(String id);
    ParameterType getParameterType(String id);
    RulesBehaviour getRulesBehaviour(String id);
    ValueBuilder getValueBuilder(String id);
    ValueGenerator getValueGenerator(String id);
    ValueProcessor getValueProcessor(String id);
}
