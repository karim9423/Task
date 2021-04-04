package targets;

import org.openqa.selenium.InvalidArgumentException;

import webBrowsers.Chrome;
import webBrowsers.Firefox;
import webBrowsers.InternetExplorer;

public class TargetManger {
private static WebTarget target;

public static WebTarget getTarget() {
	return target;
}
private TargetManger() {}
public static void setTarget(String browserName) {
	 if (browserName.equals("Chrome"))
	{
		target = new Chrome();
	}	 else if (browserName.equals("FireFox")) {
		target = new Firefox();
     }
	 else if (browserName.equals("InternetExplorer")) {
		 target = new InternetExplorer();
	     }
	else {
		throw new InvalidArgumentException("Unkown Browser");
	}
	startTarget();
}

public static void startTarget() {
	target.start();
}

}
