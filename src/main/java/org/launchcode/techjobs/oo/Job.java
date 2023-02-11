package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

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

    @Override
    public String toString() {
        //Try looping through instead of testing each class individually
        StringBuilder aName = new StringBuilder();
        StringBuilder aEmployer = new StringBuilder();
        StringBuilder aLocation = new StringBuilder();
        StringBuilder aPositionType = new StringBuilder();
        StringBuilder aCoreCompetency = new StringBuilder();

        //Bonus Step 4:  If a Job contains data only for the id field return OOPS! This job does not seem to exist.
        if (this.name.length() == 0  && this.getEmployer().getValue().length() == 0  && this.getLocation().getValue().length() == 0  && this.getPositionType().getValue().length() == 0 && this.getCoreCompetency().getValue().length() == 0 ) {
            return "OOPS! This job does not seem to exist.";
        }

        //Conditionals for toString Task 3.
        if(this.name .length() == 0) {
            aName.append("Data not available");
        } else {
            aName.append(this.name);
        }
        if(this.getEmployer().getValue().length() == 0) {
            aEmployer.append("Data not available");
        } else {
            aEmployer.append(this.getEmployer());
        }

        if(this.getLocation().getValue().length() == 0) {
            aLocation.append("Data not available");
        } else {
            aLocation.append(this.getLocation());
        }

        if(this.getPositionType().getValue() .length() == 0) {
            aPositionType.append("Data not available");
        } else {
            aPositionType.append(this.getPositionType());
        }

        if(this.getCoreCompetency().getValue() .length() == 0) {
            aCoreCompetency.append("Data not available");
        } else {
            aCoreCompetency.append(this.getCoreCompetency());
        }

        return "\nID: " + this.id +
                "\nName: " + aName +
                "\nEmployer: " + aEmployer +
                "\nLocation: " + aLocation +
                "\nPosition Type: " + aPositionType +
                "\nCore Competency: " + aCoreCompetency +
                "\n";
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


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

    public int getId() {
        return id;
    }
}
