package ApiTest;

import ApiFolder.ApiInteration;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class ApiTest {

    ApiInteration api = new ApiInteration();

    @Test(priority=1)
    public void testGetWatherWhiteInformation(){
        var birthday = api.getWatherWhiteInformation();
        assertEquals(birthday.trim(),"09-07-1958");
    }

    @Test(priority=2)
    public void testGetallcharactersinformation(){
       api.getallcharactersinformation();
    }
}
