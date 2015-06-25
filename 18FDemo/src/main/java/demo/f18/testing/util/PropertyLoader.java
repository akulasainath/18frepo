package demo.f18.testing.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/*
 * Class that extracts properties from the prop file.
 * 
 * 
 */
public class PropertyLoader {

	private final static String PROP_FILE = "/application.properties";
	private final static String PROP_FILE_TEST = "test.properties";
	
        public PropertyLoader() {}

	public static String loadProperty(String name) {
		Properties props = new Properties();
		try {
			props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = "";

		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
	
	public static HashMap<String, String> getDynamicProperties() {
		
		Properties props = new Properties();
		InputStream input = null;
	 
		try {
	 
			input = new FileInputStream(PROP_FILE_TEST);
	 
			// load a properties file
			props.load(input);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		HashMap<String, String> dynamic_test_properties = new HashMap<String, String>();
		Enumeration<Object> keys = props.keys();
		
		while(keys.hasMoreElements()){
			String key = (String) keys.nextElement();
			dynamic_test_properties.put(key, props.getProperty(key));
		}
		
		return dynamic_test_properties;
	}
	
	public static void addDynamicProperty(String propertyName, String propertyValue){
		
		Properties props = new Properties();
		OutputStream output = null;
	 
		HashMap<String, String> dynamic_test_properties = getDynamicProperties();
		
		try {
			
			output = new FileOutputStream(PROP_FILE_TEST);
	 
			for (String key: dynamic_test_properties.keySet() ) {
				
				props.setProperty(key, dynamic_test_properties.get(key));
			}
			
			props.setProperty(propertyName, propertyValue);
			
			// save properties to project root folder
			props.store(output, null);
	 
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
	}
}