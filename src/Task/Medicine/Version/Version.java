package Task.Medicine.Version;

import Task.Medicine.Version.Company.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Shkliarov on 5/6/2015.
 */
public class Version {
    String version;
    List<Company> companies;

    public Version(String version) {
        this.version = version;
        companies = new ArrayList<>();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company company){
        getCompanies().add(company);
    }

    @Override
    public String toString() {
        return "Version: " + getVersion() + '\n' +
                "Companies: " + getCompanies();
    }
}
