package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.ObjectUtils;

import java.io.*;
import java.util.Properties;

public class Utils {
   public static RequestSpecification req;
public RequestSpecification requestSpecification() throws IOException {

    if(req== null) {
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

        RequestSpecification req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrI"))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
        return req;
    }
    return req;
}
public String getGlobalValue(String key) throws IOException {
    Properties pro= new Properties();
    FileInputStream fil=new FileInputStream("src/test/java/Resources/global.properties");
    pro.load(fil);
   return pro.getProperty(key);

}
}
