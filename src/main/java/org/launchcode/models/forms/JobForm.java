package org.launchcode.models.forms;

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
        TODO #3 - Included other fields needed to create a job,
        with correct validation attributes and display names.
        Don't forget to add getters and setters

        TODO #3 and 4 notes from assignment
        First, you'll need to work within JobForm to set up the properties to allow for both form display and form
        submission. Cheryl has put in place the code to display and process the name and the data associated with
        an employer.

        Notice that rather having a field for employer, we have a field for employerId:
        @NotNull
        private int employerId;

        In the user interface (that is, on the web page) we'll only need to display the name of each employer, and
        when processing the form, we'll use the ID to retrieve the employer from the data layer. Using the ID of an
        employer is the only way to uniquely identify which employer has been selected in the form, outside the cozy
        confines of our Java application.

        In the JobForm constructor, we initialize the list of Employer objects. Initializing the other lists is up
        to you.

        For tasks #3-5, you'll need to mimic the code that's in place for employerId and the employers list for
        the other job field types.


     */

    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> coreCompetencies;
    private ArrayList<PositionType> positionTypes;

    public JobForm() {

        JobData jobData = JobData.getInstance();

        /*
            TODO #4 - populate the other ArrayList collections needed in the view

            see notes above but also note For tasks #3-5, you'll need to mimic the code that's in place for employerId
            and the employers list for the other job field types.
        */

        employers = jobData.getEmployers().findAll();

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
