package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location,
               PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {

        String employerValue = employer.getValue();
        String locationValue = location.getValue();
        String positionTypeValue = positionType.getValue();
        String coreCompetencyValue = coreCompetency.getValue();

        String dataDoesNotExist = "Data does not exist";

        if (
                name.equals("") &&
                        employerValue.equals("") &&
                        locationValue.equals("") &&
                        positionTypeValue.equals("") &&
                        coreCompetencyValue.equals("")) {

            return dataDoesNotExist;
        }
        else {
            return "\nID: " + id +
                    toStringFieldLabelAndValue("Name", name) +
                    toStringFieldLabelAndValue("Employer", employerValue) +
                    toStringFieldLabelAndValue("Location",  locationValue) +
                    toStringFieldLabelAndValue("Position Type", positionTypeValue) +
                    toStringFieldLabelAndValue("Core Competency",  coreCompetencyValue) +
                    "\n";
        }
    }

    public String toStringFieldLabelAndValue(String fieldLabel, String fieldValue) {

        String dataNotAvailable = "Data not available";

        String tempToString = "\n" + fieldLabel + ": ";

        if (fieldValue.equals("")) {
            return tempToString + dataNotAvailable;
        } else {
            return tempToString + fieldValue;
        }
    }
}