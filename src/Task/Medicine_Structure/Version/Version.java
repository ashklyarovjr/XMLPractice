package Task.Medicine_Structure.Version;

import Task.Medicine_Structure.Version.Company.Company;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class Version {
    @XmlElement
    String version;

    @XmlElement
    List<Company> companies;

    public Version(String version) {
        this.version = version;
        companies = new LinkedList<>();
    }

    public Version() {
        companies = new LinkedList<>();
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
        return "\n" + "Version: " + getVersion() + '\n' +
                "Companies: " + getCompanies();
    }
}
