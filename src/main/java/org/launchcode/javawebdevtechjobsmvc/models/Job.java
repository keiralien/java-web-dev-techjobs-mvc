package org.launchcode.javawebdevtechjobsmvc.models;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // Initialize a unique ID.
    public Job() {
        id = nextId;
        nextId++;
    }

    // Initialize the id and value fields.
    public Job(String aName, Employer anEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency) {
        this();
        name = aName;
        employer = anEmployer;
        location = aLocation;
        positionType = aPositionType;
        coreCompetency = aCoreCompetency;
    }

    //Methods
    private boolean isNotEmpty(String stringIn) {
        return stringIn != null && !stringIn.isEmpty();
    }

    private boolean isAnyNotEmpty(String ... stringInput) {
        for(String s : stringInput) {
            if(isNotEmpty(s))
                return true;
        }
        return false;
    }

    private String defaultString(String stringIn, String defaultString) {
        return isNotEmpty(stringIn) ? stringIn : defaultString;
    }

    // Custom toString method.
    @Override
    public String toString() {

        String dataNot = "Data not available";
        if(id != 0 && isAnyNotEmpty(name,
                employer == null ? null : employer.getValue(),
                location == null ? null : location.getValue(),
                positionType == null ? null : positionType.getValue(),
                positionType == null ? null : coreCompetency.getValue())) {
            return String.format("\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: %s\nCore Competency: %s\n",
                    id,
                    defaultString(name, dataNot),
                    employer == null ? dataNot : defaultString(employer.getValue(), dataNot),
                    location == null ? dataNot : defaultString(location.getValue(), dataNot),
                    positionType == null ? dataNot : defaultString(positionType.getValue(), dataNot),
                    coreCompetency == null ? dataNot : defaultString(coreCompetency.getValue(), dataNot));
        } else {
            return "OOPS! This job does not seem to exist.";
        }
    }

    // Custom equals and hashCode methods. Two Job objects are "equal" when their id fields match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // Getters and setters.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
