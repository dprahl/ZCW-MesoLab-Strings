package prahl.daniel.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by danielprahl on 5/21/17.
 */
public class DriversLicenseTest {
    DriversLicense license;
    DriversLicense license2;
    @Before
    public void setup(){
         license = new DriversLicense("0", "1", "2", "3", "4", "5", "6", "7", "8");
         license2 = new DriversLicense("a", "b", "c", "d", "e", "f", "g", "h", "i");
    }

    @Test
    public void constructorTest(){
        //given;
        String expected = "5";

        //when;
        String actual = license.getState();

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest(){
        //given;
        String expected = "0,1,2,3,4,5,6,7,8\n";

        //when;
        String actual = license.toString();

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCSVHeaderTest(){
        //given;
        String expected = "licenseNumber,firstName,lastName,street,city,state,birthDate,issueDate,expirationDate\n";

        //when;
        String actual = license.getCSVHeader();

        //then;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void serializeToCSVTest(){
        //given;
        String expected = "licenseNumber,firstName,lastName,street,city,state,birthDate,issueDate,expirationDate\n" +
                        "0,1,2,3,4,5,6,7,8\n";

        //when;
        String actual = license.serializeToCSV();

        //then;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void deserializeFromCSVTest(){
        //given;
        String csv = "licenseNumber,firstName,lastName,street,city,state,birthDate,issueDate,expirationDate\n" +
                "0,1,2,3,4,5,6,7,8\n" + "a,b,c,d,e,f,g,h,i\n";
        String expected = "f";

        //when;
        ArrayList<DriversLicense> licenses = (ArrayList) DriversLicense.deserializeFromCSV(csv);
        String actual = licenses.get(1).getState();

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void serializeToCSVMultipleTest(){
        //given;
        String expected = "licenseNumber,firstName,lastName,street,city,state,birthDate,issueDate,expirationDate\n" +
                "0,1,2,3,4,5,6,7,8\n" + "a,b,c,d,e,f,g,h,i\n";

        //when;
        String csv = license.serializeToCSV();
        String actual = license2.serializeToCSV(csv);

        //then;
        Assert.assertEquals(expected, actual);
    }
}
