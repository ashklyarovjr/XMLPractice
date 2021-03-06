package Task.Medicine_Structure;

import Task.Medicine_Structure.Version.Version;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "medicine")
public class Medicine {


    private String name;


    private String pharm;


    private String group;


    private List<String> analogs;


    private List<Version> versions;

    public Medicine() {
        setAnalogs(new LinkedList<>());
        setVersions(new LinkedList<>());
    }

    public Medicine(String name, String pharm, String group) {
        this.setName(name);
        this.setPharm(pharm);
        this.setGroup(group);
        setAnalogs(new LinkedList<>());
        setVersions(new LinkedList<>());
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    @XmlElement(name = "pharm")
    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getGroup() {
        return group;
    }

    @XmlElement(name = "group")
    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getAnalogs() {
        return analogs;
    }

    @XmlElementWrapper(name = "analogs")
    public void setAnalogs(List<String> analogs) {
        this.analogs = analogs;
    }

    public void addAnalog(String analog) {
        getAnalogs().add(analog);
    }

    public List<Version> getVersions() {
        return versions;
    }

    @XmlElementWrapper(name = "versions")
    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public void addVersion(Version version) {
        getVersions().add(version);
    }

    @Override
    public String toString() {
        return "Medicine: " +
                "Name: " + getName() + '\n' +
                "Pharm: " + getPharm() + '\n' +
                "Group: " + getGroup() + '\n' +
                "Analogs: " + getAnalogs() + '\n' +
                "Versions: " + getVersions();
    }
}
