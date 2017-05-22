package prahl.daniel.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielprahl on 5/21/17.
 */
public class DriversLicense {
    private String licenseNumber;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String birthDate;
    private String issueDate;
    private String expirationDate;

    public DriversLicense(String licenseNumber, String firstName, String lastName,
                          String street, String city, String state, String birthDate,
                          String issueDate, String expirationDate) {
        this.licenseNumber = licenseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.birthDate = birthDate;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public static List<DriversLicense> deserializeFromCSV(String csvFile){
        ArrayList<DriversLicense> licenses = new ArrayList<DriversLicense>();
        String[] fields;
        String end = "\n";
        String[] subs = csvFile.split(end, -1);
        String regex = ",";
        for(int i =1; i < subs.length-1; i++) {
            fields = subs[i].split(regex, -1);
            licenses.add(new DriversLicense(fields[0], fields[1], fields[2], fields[3],
                                        fields[4], fields[5], fields[6], fields[7], fields[8]));
        }
        return licenses;
    }

    public String getCSVHeader(){
        String header = "licenseNumber,firstName,lastName,street,city,state,birthDate,issueDate,expirationDate\n";
        return header;
    }

    @Override
    public String toString() {
        return String.format(
                "%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                licenseNumber, firstName, lastName,
                street, city, state, birthDate, issueDate, expirationDate);
    }

    public String serializeToCSV(){
        StringBuilder data = new StringBuilder(1000);
        data.append(this.getCSVHeader());
        data.append(this.toString());
        return data.toString();
    }

    public String serializeToCSV(String csvFile) {
        StringBuilder data = new StringBuilder(csvFile);
        data.append(this.toString());
        return data.toString();
    }
}
