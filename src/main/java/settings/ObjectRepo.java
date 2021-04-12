
package settings;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */
public class ObjectRepo {
	
	public static WebDriver driver;
	public static IconfigReader reader;
	public static Map<String, Object> data = new LinkedHashMap<String, Object>();
}

