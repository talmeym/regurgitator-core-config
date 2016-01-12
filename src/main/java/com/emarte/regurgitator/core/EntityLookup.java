package com.emarte.regurgitator.core;

import java.util.ServiceLoader;

public final class EntityLookup {
	private static final ServiceLoader<EntityPack> ENTITY_PACKS = ServiceLoader.load(EntityPack.class);
	
	public static boolean hasConditionBehaviour(String id) {
		for (EntityPack pack : ENTITY_PACKS) {
			ConditionBehaviour entity = pack.getConditionBehaviour(id);

			if (entity != null) {
				return true;
			}
		}

		return false;
	}

	public static ConditionBehaviour conditionBehaviour(String id) throws RegurgitatorException {
		for (EntityPack pack : ENTITY_PACKS) {
			ConditionBehaviour entity = pack.getConditionBehaviour(id);

			if (entity != null) {
				return entity;
			}
		}

		throw new RegurgitatorException("Cannot load condition behaviour: " + id);
	}

	public static boolean hasConfigurationLoader(String id) {
		for (EntityPack pack : ENTITY_PACKS) {
			ConfigurationLoader entity = pack.getConfigurationLoader(id);

			if (entity != null) {
				return true;
			}
		}

		return false;
	}

	public static ConfigurationLoader configurationLoader(String id) throws RegurgitatorException {
		for (EntityPack pack : ENTITY_PACKS) {
			ConfigurationLoader entity = pack.getConfigurationLoader(id);

			if (entity != null) {
				return entity;
			}
		}

		throw new RegurgitatorException("Cannot load configuration loader: " + id);
	}

	public static boolean hasParameterType(String id) {
		for (EntityPack pack : ENTITY_PACKS) {
			ParameterType entity = pack.getParameterType(id);

			if (entity != null) {
				return true;
			}
		}

		return false;
	}

	public static ParameterType parameterType(String id) throws RegurgitatorException {
		for (EntityPack pack : ENTITY_PACKS) {
			ParameterType entity = pack.getParameterType(id);

			if (entity != null) {
				return entity;
			}
		}

		throw new RegurgitatorException("Cannot load parameter type: " + id);
	}

	public static boolean hasRulesBehaviour(String id) {
		for (EntityPack pack : ENTITY_PACKS) {
			RulesBehaviour entity = pack.getRulesBehaviour(id);

			if (entity != null) {
				return true;
			}
		}

		return false;
	}

	public static RulesBehaviour rulesBehaviour(String id) throws RegurgitatorException {
		for (EntityPack pack : ENTITY_PACKS) {
			RulesBehaviour entity = pack.getRulesBehaviour(id);

			if (entity != null) {
				return entity;
			}
		}

		throw new RegurgitatorException("Cannot load rules behaviour: " + id);
	}

	public static boolean hasValueBuilder(String id) {
		for (EntityPack pack : ENTITY_PACKS) {
			ValueBuilder entity = pack.getValueBuilder(id);

			if (entity != null) {
				return false;
			}
		}

		return false;
	}

	public static ValueBuilder valueBuilder(String id) throws RegurgitatorException {
		for (EntityPack pack : ENTITY_PACKS) {
			ValueBuilder entity = pack.getValueBuilder(id);

			if (entity != null) {
				return entity;
			}
		}

		throw new RegurgitatorException("Cannot load value builder: " + id);
	}

	public static boolean hasValueGenerator(String id) {
		for (EntityPack pack : ENTITY_PACKS) {
			ValueGenerator entity = pack.getValueGenerator(id);

			if (entity != null) {
				return true;
			}
		}

		return false;
	}

	public static ValueGenerator valueGenerator(String id) throws RegurgitatorException {
		for (EntityPack pack : ENTITY_PACKS) {
			ValueGenerator entity = pack.getValueGenerator(id);

			if (entity != null) {
				return entity;
			}
		}

		throw new RegurgitatorException("Cannot load value generator: " + id);
	}

	public static boolean hasValueProcessor(String id) {
		for (EntityPack pack : ENTITY_PACKS) {
			ValueProcessor entity = pack.getValueProcessor(id);

			if (entity != null) {
				return true;
			}
		}

		return false;
	}

	public static ValueProcessor valueProcessor(String id) throws RegurgitatorException {
		for (EntityPack pack : ENTITY_PACKS) {
			ValueProcessor entity = pack.getValueProcessor(id);

			if (entity != null) {
				return entity;
			}
		}

		throw new RegurgitatorException("Cannot load value processor: " + id);
	}
}
