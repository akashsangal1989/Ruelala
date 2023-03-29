package sample;

import org.aeonbits.owner.ConfigCache;

public class ConfigFactorysample {

	public static ConfigFactory getconfig() {
		return ConfigCache.getOrCreate(ConfigFactory.class);
	}
}
