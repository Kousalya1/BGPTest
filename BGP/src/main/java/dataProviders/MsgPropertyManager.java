package dataProviders;

import java.io.IOException;
import java.util.Properties;

public class MsgPropertyManager {
	
	private static Properties envProperties = new Properties();
	private static final String PROPERTIES_FILE = "message.properties";

	static {
		try {
			envProperties.load(MsgPropertyManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
		} catch (IOException e) {
			throw new RuntimeException("Property file is not found" + e);
		}
	}
	
	public static String getEligibilityWarnMsg() {
		return envProperties.getProperty("eligibilityWarnMsg");
	}
	
	public static String getSmePortalUrl() {
		return envProperties.getProperty("smePortal");
	}
	
}
