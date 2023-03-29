package sample;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ "system:properties", "system:env", "file:${user.dir}/src/test/resources/config.properties" })

public interface ConfigFactory extends Config{

	@DefaultValue("https://www.ruelala.com/boutique/")
	@Key("app")
	String app();
	
	@DefaultValue("Stage")
	@Key("env")
	String env();
	
}
