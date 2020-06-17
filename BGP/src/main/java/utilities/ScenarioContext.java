package utilities;

import java.util.LinkedHashMap;
import java.util.Map;

public class ScenarioContext {

	public Map<String, Object> scenarioContext = new LinkedHashMap<String, Object>();

	public void setContext(Context key, Object value) {
		scenarioContext.put(key.toString(), value);
	}

	public Object getContext(Context key) {
		return scenarioContext.get(key.toString());
	}

}
