
package settings;

import browsers.BrowserType;

/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */

public interface IconfigReader {
	public String getUserName();
	public String getPassword();
	public String getWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
}
