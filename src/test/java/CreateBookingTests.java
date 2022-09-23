import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class CreateBookingTests extends createBookingConfigurations {

    @Test(priority = 1)
    public void happyScenario(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",1000);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","none");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).
                when().post(url).
                then().statusCode(200);
    }

    @Test(priority = 2)
    public void insertingNumbersInFirstname(){

        JSONObject request = new JSONObject();

        request.put("firstname",123);
        request.put("lastname","Iqbal");
        request.put("totalprice",500);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2020-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","Breakfast");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(500);
    }

    @Test(priority = 3)
    public void insertingNumbersInLastname(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname",123);
        request.put("totalprice",500);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2020-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","Breakfast");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(500);
    }

    @Test(priority = 4)
    public void insertingStringInTotalPrice(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice","XYZ");
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2020-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","Breakfast");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(500);
    }

    @Test(priority = 5)
    public void insertingNonBooleanValueInDeposit(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",1000);
        request.put("depositpaid","XYZ");

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2020-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","Breakfast");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(500);
    }

    @Test(priority = 6)
    public void insertingNonDateValueInCheckIn(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",1000);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin",true);
        bookingdates.put("checkout","2020-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","Breakfast");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(500);
    }

    @Test(priority = 7)
    public void insertingNonDateValueInCheckOut(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",1000);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2020-01-01");
        bookingdates.put("checkout",false);

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","Breakfast");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(500);
    }

    @Test(priority = 8)
    public void insertingNonStringValueInAdditionalNeeds(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",1000);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2019-01-01");
        bookingdates.put("checkout","2020-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds",true);

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(500);
    }


    @Test(priority = 9)
    public void insertingNegativeNumberInTotalPrice(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",-1000);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2019-01-01");
        bookingdates.put("checkout","2020-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds",true);

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(200);
    }


    @Test(priority = 10)
    public void insertingFalseInDeposit(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",1000);
        request.put("depositpaid",false);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2019-01-01");
        bookingdates.put("checkout","2020-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds",true);

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(200);
    }

    @Test(priority = 11)
    public void allFieldsEmpty(){

        JSONObject request = new JSONObject();

        request.put("firstname","");
        request.put("lastname","");
        request.put("totalprice","");
        request.put("depositpaid","");

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","");
        bookingdates.put("checkout","");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(500);
    }


    @Test(priority = 12)
    public void insertingZeroInTotalPrice(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",0);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","none");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(200);
    }


    @Test(priority = 13)
    public void insertingBigNumberInTotalPrice(){

        JSONObject request = new JSONObject();

        request.put("firstname","Zohaib");
        request.put("lastname","Iqbal");
        request.put("totalprice",999999999);
        request.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        request.put("bookingdates",bookingdates);
        request.put("additionalneeds","none");

        RestAssured.given().
                header("Content-Type",ContentType).
                header("Accept",Accept).
                body(request.toString()).when().post(url).
                then().statusCode(200);
    }

}
