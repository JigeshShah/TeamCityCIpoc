package SupportLibraries;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AppiumHelper {
	private long timeout = 30;
	private AppiumDriver AndDriver;
	private String browserName="";
	private String device="";
	private String deviceName="";
	private String platformVersion="";
	private String platformName="";
	private String appPackage="";
	private String appActivity="";
	private String noReset="";
	private String fullReset="";

	
	@BeforeMethod
	public AppiumDriver<WebElement> setUpCapabilities(String path) throws Exception {
		try
		{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		getDataForCapabalities(path);
		if(!getBrowserName().isEmpty())
		{
			capabilities.setCapability("browserName", getBrowserName());
			capabilities.setCapability("device", getDevice());
			capabilities.setCapability("deviceName", getDeviceName());
			capabilities.setCapability("platformVersion", getPlatformVersion());
			capabilities.setCapability("platformName", getPlatformName());
			capabilities.setCapability("appPackage", getAppPackage());
			capabilities.setCapability("appActivity", getAppActivity());
		}
		else{
			capabilities.setCapability("noReset",getNoReset());
            capabilities.setCapability("fullReset",getFullReset());
			capabilities.setCapability("device", getDevice());
			capabilities.setCapability("deviceName", getDeviceName());
			capabilities.setCapability("platformVersion", getPlatformVersion());
			capabilities.setCapability("platformName", getPlatformName());
			capabilities.setCapability("appPackage", getAppPackage());
			capabilities.setCapability("appActivity", getAppActivity());
		}
		
		
		AndDriver = new AndroidDriver <WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		System.out.println(AndDriver);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return AndDriver;
		
	}
	
	public void getDataForCapabalities(String path)
	{
		Properties prop = null;
		FileInputStream propFile = null;
		prop= new Properties();
		try {
			propFile= new FileInputStream(path);
			prop.load(propFile);
			
			setBrowserName(prop.getProperty("browserName"));
			setDevice(prop.getProperty("device"));
			setDeviceName(prop.getProperty("deviceName"));
			setPlatformVersion(prop.getProperty("platformVersion"));
			setPlatformName(prop.getProperty("platformName"));
			setAppPackage(prop.getProperty("appPackage"));
			setAppActivity(prop.getProperty("appActivity"));
			if(prop.getProperty("Uninstall").trim().equalsIgnoreCase("False"))
			{
				setNoReset("true");
				setFullReset("false"); 
			}
			else
			{
				setNoReset("false");
				setFullReset("true"); 
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

	public String getAppActivity() {
		return appActivity;
	}

	public void setAppActivity(String appActivity) {
		this.appActivity = appActivity;
	}


	public String getNoReset() {
		return noReset;
	}

	public void setNoReset(String noReset) {
		this.noReset = noReset;
	}

	public String getFullReset() {
		return fullReset;
	}

	public void setFullReset(String fullReset) {
		this.fullReset = fullReset;
	}


}
