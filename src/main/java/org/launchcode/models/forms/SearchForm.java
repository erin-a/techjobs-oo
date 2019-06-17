package org.launchcode.models.forms;

import org.launchcode.models.JobFieldType;

/**
 * Created by LaunchCode
 */
public class SearchForm {

    // The search options - is necessary to display and process the form b/c of model binding
    private JobFieldType[] fields = JobFieldType.values();

    // The selected search options - is necessary to display and process the form b/c of model binding
    private JobFieldType searchField = JobFieldType.ALL;

    // The search string - is necessary to display and process the form b/c of model binding
    private String keyword;

    public JobFieldType getSearchField() {
        return searchField;
    }

    public void setSearchField(JobFieldType searchField) {
        this.searchField = searchField;
    }

    public JobFieldType[] getFields() {
        return fields;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
