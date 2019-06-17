package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public enum JobFieldType {

    EMPLOYER ("Employer"),
    LOCATION ("Location"),
    CORE_COMPETENCY ("Skill"),
    POSITION_TYPE ("Position Type"),
    ALL ("All");

    private final String name;

    JobFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}


/**The JobFieldType class is an enum that enables the view and controller layers to easily ask for data related to a
 * specific job field, or to all fields.

 The enum has the values EMPLOYER, LOCATION, POSITION_TYPE, CORE_COMPETENCY, and ALL. These take the place of
 the "magic strings" that we were using all across our code in the first two iterations of TechJobs.

 To find all employers we can do this: ArrayList<JobField> employers = jobData.findByColumnAndValue(JobFieldType.EMPLOYER,
 "LaunchCode");

 By using enum values instead of strings, we eliminate the possibility of runtime errors. In other words,
 the compiler will force us to use a valid JobFieldType, whereas if we had misspelled "employer" in the first example,
 we wouldn't have found out until running our code.

 Many of the methods in JobData now work by taking in a JobFieldType parameter rather than a string.

 We also use the JobFieldType values to render search and list options in the view, and to collect these options
 in the controller layer.
 */