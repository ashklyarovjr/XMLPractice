package Task.Medicine;

import Task.Medicine.Version.Version;

import java.util.ArrayList;
import java.util.List;


public class Medicine {
    private String name;
    private String pharm;
    private String group;
    private List<String> analogs;
    private List<Version> versions;

    public Medicine() {
        setAnalogs(new ArrayList<>());
        setVersions(new ArrayList<>());
    }

    public Medicine(String name, String pharm, String group) {
        this.setName(name);
        this.setPharm(pharm);
        this.setGroup(group);
        setAnalogs(new ArrayList<>());
        setVersions(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(List<String> analogs) {
        this.analogs = analogs;
    }

    public void addAnalog(String analog) {
        getAnalogs().add(analog);
    }

    public List<Version> getVersions() {
        return versions;
    }

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
