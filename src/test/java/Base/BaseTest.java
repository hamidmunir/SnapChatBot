package Base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    AppiumDriverLocalService service;
    @Parameters({"portNumber","deviceName","systemPort"})
    @BeforeMethod
    public void beforeTest(String portNumber, String deviceName, String systemPort) throws Exception {
        startAppiumService(portNumber);
        DriverManager.initializeDriver(deviceName, portNumber,systemPort);

    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
        if(service!=null){
            service.stop();
        }
    }

    public void startAppiumService(String portNumber){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(Integer.parseInt(portNumber));
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Appium service started at port "+portNumber);

    }

}
