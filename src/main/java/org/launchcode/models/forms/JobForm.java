package org.launchcode.models.forms;

import javafx.geometry.Pos;
import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Employer;
import org.launchcode.models.Location;
import org.launchcode.models.PositionType;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int employerId;


    /*
        TODO (done) #3 - Included other fields needed to create a job, with correct validation attributes and display names.
        Don't forget to add getters and setters

        Fields we'll need:
        Name - user will input, needs validation? - already set above
        Employer - use IDs to populate drop down menu - already set above
        Location - use IDs to populate drop down menu
        Position Type - use IDs to populate drop down menu
        Skill/core competency - use IDs to populate drop down menu

     */

    // doing the not null and private because the name and employer have it, using the Classes already created
    // for each field we need
    @NotNull
    private Location locationId;

    @NotNull
    private CoreCompetency coreCompetencyId;

    @NotNull
    private PositionType positionTypeId;

        // Location location = employerId.getLocation().getValue()

/*
        TO DO #3 and 4 notes from assignment
        First, you'll need to work within JobForm to set up the properties to allow for both form display and form
        submission. Cheryl has put in place the code to display and process the name and the data associated with
        an employer.

        Notice that rather having a field for employer, we have a field for employerId:
        @NotNull
        private int employerId;

        *** In the user interface (that is, on the web page) we'll only need to display the name of each employer,****
        and when processing the form, we'll use the ID to retrieve the employer from the data layer. Using the ID of an
        employer is the only way to uniquely identify which employer has been selected in the form, outside the cozy
        confines of our Java application.

        In the JobForm constructor, we initialize the list of Employer objects. Initializing the other lists is up
        to you.

        For tasks #3-5, you'll need to mimic the code that's in place for employerId and the employers list for
        the other job field types.


         So, for example, if you had a Job instance, you could get the name of the employer this way:
        // job is an instance of Job
        String employerName = job.getEmployer().getValue();

        Additionally, the toString() method of the JobField class (which these other classes inherit) is set up to
        return the value field. Thus, using one of these objects in a template, or in another string context like
        System.out.println, will print the value.

        // prints the name of the employer
        System.out.println(job.getEmployer);

        example from elsewhere in instructions:

        // Find the job with id 42
        Job someJob = jobData.findById(42);

        //Find all jobs at LaunchCode
        ArrayList<Job> jobsAtLaunchcode = jobData.findByColumnAndValue(JobFieldType.EMPLOYER, "LaunchCode");

        // Find all jobs involving Ruby
        ArrayList<Job> jobsInvolvingRuby = jobData.findByValue("ruby");

        To work with the list of Job objects itself, you can do the following:

        // Get the full list of jobs
        ArrayList<Job> allOfTheJobs = jobData.findAll();

        // add a new Job object to the list
        jobData.add(newJob);

        Additionally, collections of classes that make up the individual properties of a Job object -- Employer,
        Location, CoreCompetency, PositionType -- are available as properties of JobData. For example, all employers
        are contained in a property called Employers.

        There are two methods that you might want to use here. Here they are:

        // Find the employer with id=7
        Employer anEmployer = jobData.getEmployers().findById(7);

        // Get all employers
        ArrayList<Employer> allEmployers = jobData.getEmployers().findAll();
        Examples for locations, position types, and core competencies are similar.

        warning - you have to use drop downs of existing employers, location, etc because of how the database is
        currently set up and what it's capabilities are.


     */

    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> coreCompetencies;
    private ArrayList<PositionType> positionTypes;

    public JobForm() {

        JobData jobData = JobData.getInstance();

        /*
            TODO (done) #4 - populate the other ArrayList collections needed in the view
            see notes above but also note For tasks #3-5, you'll need to mimic the code that's in place for employerId
            and the employers list for the other job field types.
        */

        employers = jobData.getEmployers().findAll();
        locations = jobData.getLocations().findAll();
        coreCompetencies = jobData.getCoreCompetencies().findAll();
        positionTypes = jobData.getPositionTypes().findAll();



    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public CoreCompetency getCoreCompetencyId() {
        return coreCompetencyId;
    }

    public void setCoreCompetencyId(CoreCompetency coreCompetencyId) {
        this.coreCompetencyId = coreCompetencyId;
    }

    public PositionType getPositionTypeId() {
        return positionTypeId;
    }

    public void setPositionTypeId(PositionType positionTypeId) {
        this.positionTypeId = positionTypeId;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;
    }

    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }
}
