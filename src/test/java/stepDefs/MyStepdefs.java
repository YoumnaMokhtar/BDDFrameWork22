package stepDefs;

import Resources.TestData;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class MyStepdefs extends Utils {

    RequestSpecification res;
    ResponseSpecification respc;
    Response respon;
    TestData data  =new TestData();

//    @When("add place palyload")
//    public void addPlacePalyload() throws IOException {
//             respc= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//             res=given().log().all().spec(requestSpecification()).contentType(ContentType.JSON).body(data.addplacepayload());
//
//        }

    @When("use calls {string} with post http request")
    public void useCallsWithPostHttpRequest(String endpoint) {
         respon=res.when().post(endpoint).
                then().log().all().spec( respc ).extract().response();

    }

    @Then("the response api  call is sucess and status code is {int}")
    public void theResponseApiCallIsSucessAndStatusCodeIs(int int1) {
      Assert.assertEquals(respon.getStatusCode(),200);

    }

    @Then("{string} in response body is {string}")
    public void inResponseBodyIs(String keyVlaue, String Excpectedvalue) {
        String resp=respon.asString();
        JsonPath js=new JsonPath(resp);
      Assert.assertEquals (js.get(keyVlaue).toString(),Excpectedvalue);
    }

    @Given("add place palyload with {string} and {string}and{string}")
    public void addPlacePalyloadWithAndAnd(String name, String address, String language) throws IOException {
        respc= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res=given().log().all().spec(requestSpecification()).contentType(ContentType.JSON).body(data.addplacepayload(name,address,language));

    }
}
