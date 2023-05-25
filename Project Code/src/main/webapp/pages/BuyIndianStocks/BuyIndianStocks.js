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
}

Page.Nifty100StocksList1Render = function(widget, $data) {
    if (Page.Widgets.label12.caption > 0) {
        Page.Widgets.label12.color = "green";
        Page.Widgets.label11.color = "green";
    } else {
        Page.Widgets.label12.color = "red";
        Page.Widgets.label11.color = "red";
    }
};
setTimeout(function() {
    Page.Variables.Nifty100StocksInvoke
}, 60000);

Page.qvCheckExitsingStockonSuccess = function(variable, data) {
    debugger
    if (data.length > 0) {
        Page.Variables.IndianStockPortfolioExistingStock.invoke();
    } else {
        Page.Variables.IndianStockPortfolioNewStock.invoke();
    }
};