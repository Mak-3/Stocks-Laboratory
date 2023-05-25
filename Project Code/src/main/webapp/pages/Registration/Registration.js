/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */
};

Page.createUsersForm2Submit = function($event, widget, $formData) {
    // On Button Click event
    // On Save Button Click event


};

Page.createUsersForm1Beforesubmit = function($event, widget, $data) {
    if (Page.Variables.FileServiceUploadFile2.dataSet.length > 0) {

        $data.Users.profilePicture = Page.Variables.FileServiceUploadFile2.dataSet[0].path;
    }

};