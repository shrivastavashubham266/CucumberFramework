
package helperclasses;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import utilities.ResourceHelper;


/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */
@SuppressWarnings("rawtypes")
public class LoggerHelper {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class clas) {
		if(root)
			return Logger.getLogger(clas);
		
		PropertyConfigurator.configure(ResourceHelper
				.getResourcePath("configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}

}
