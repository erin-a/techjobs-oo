package org.launchcode.controllers;

import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view
        // Your first two tasks involve displaying data associated with a single job. When you're done, visiting the
        // URL /job?id=X will display the details of the job with an id equal to X.
        // Within the index handler method of JobController, you should retrieve the job with the given ID, and then
        // pass it into the view.

        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.




        return "";

    }
}

//that you will work in to enable full creation of a Job object,
// including all necessary fields.


/* notes from assignment on #6
Validate the form in the add handler of JobController, and if it's valid, create a new Job object and add it to
the data layer by calling jobData.add(newJob).

To create the new job, you'll need to find the pre-existing objects for all fields other than name (employer, location,
etc). Do this using the methods discussed above. Refer to the constructor in Job to make sure you list the objects in
the correct order when calling it.

Once you've created the new job, redirect to the single job display page that you created above. If the jobForm model
object fails validation, display the form again.

Once you've knocked that out, you'll be able to create new jobs in the system via the application interface! Note that
these job objects won't survive an application restart, because they live only within our in-progress application's
temporary data storage system. (This is one difference between how your app will behave compared with our demo app.
If you add a new job to our demo app, it will persist.)






 */