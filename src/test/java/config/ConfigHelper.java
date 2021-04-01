package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    public static String getEmailUsername(){
        return getAuthorisationConfig().emailUsername();
    }

    public static String getEmailPassword(){
        return getAuthorisationConfig().emailPassword();
    }

    private static AuthorisationConfig getAuthorisationConfig(){
        return ConfigFactory.newInstance().create(AuthorisationConfig.class, System.getProperties());
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    public static String getWebRemoteDriver() {
        // https://%s:%s@selenoid.autotests.cloud/wd/hub/
        return String.format(System.getProperty("web.remote.driver"),
                getWebConfig().webRemoteDriverUser(),
                getWebConfig().webRemoteDriverPassword());
    }

/*    private static AuthorizationConfig getAuthorizationConfig() {
        return ConfigFactory.newInstance().create(
                AuthorizationConfig.class, System.getProperties());
    }*/

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    public static String getWebVideoStorage() {
        return System.getProperty("video.storage");
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage() != null;
    }


}
