package org.launchcode.controllers;

import org.launchcode.models.Job;
import org.launchcode.models.data.JobFieldData;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 * annotated my moi
 * I'm using my comments to rubber duck this OO.
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET) //${job.id} next to value = is where you set the route - so I think this is where you put the placeholder thing for the id - which think is the ${}
    public String index(Model model, int id) {

        // TODO (done) #1 - get the Job with the given ID and pass it into the view
        // Your first two tasks involve displaying data associated with a single job. When you're done, visiting the
        // URL /job?id=X will display the details of the job with an id equal to X.
        // Within the index handler method of JobController, you should retrieve the job with the given ID, and then
        // pass it into the view.

        // you need to pull the job data by the id

        // Job j = new Job(id); // creates object j of the job class and as a new object // this is wrong because we shouldn't be creating an object, we are looking for an object
        // can't use find by id because that is not static, so not accessible here // tells it to select the exact job data based on the find by id method in the job data model
        // can i just make find by id static???
        // this.id = id; //first is red error says cannot find symbol, symbol is variable id
        // model.addAttribute("id", id);

        //maybe i need to create an Job j, so later i can call Job.j ?

        // JobData j = new JobData().findById(); // tried Job().getbyid, but it didn't work so switched to jobdata. // then tried findbyid, same errors. Source 1 in notes
        // not working because JobData is private. W.T.F. - class job data is public, but there is also a method called job data in there, i don't know how to differentiate
        // tried Job j and JobData j and it's not helping either
        // tried this: Job j = new JobFieldData<>().findById(id); because JobFieldData and findById are both public, but it didn't work, probably since JFD is derived from JobData I

        //JobData j = new JobData(getById()); //create a class Instance
        // model.addAttribute("id", JobData().getById()); //call the non-static method

        //Job j = new Job(JobData().findById());
        //Job j = new Job(JobData.findById());
        //Job j = new Job(JobData().findById(id));
        //Job j = new Job(JobData.findById(id));


        // fresh day
        // in mvc we pulled an array list to find the data, so let's try that tactic but with single item instead of the array list
        Job job = jobData.findById(id); //static/non-static can I just change the static and/or access levels?  tried this, it led down a rabbit hole of contingencies, or is that the answer?
        // Job j = JobFieldData.findById(id); // I think this would require is casting and that's not good.
        model.addAttribute("job", job);
        // I needed jobData (lower case j) not JobData, because JobData is a different class, and jobData is calling the instance declared at the top of this method handler
        // changing j to job to cooperate with html
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm()); // I think this is already the skeleton object to hold the fields
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) { // added @ModelAttribute
        // annotation because I think binding is necessary to make the validation work

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.

        if(errors.hasErrors()) {
            return "new-job";
        }

        return "";

    }
}

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