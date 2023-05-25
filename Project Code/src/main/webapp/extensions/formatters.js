/**
 * This file is used to extend the app runtime
 *
 * Custom Formatters:
 * Used for data formatting across widgets. Apart from predefined formatter like toDate, toCurrency, prefix, etc, you can define custom formatters here.
 * Once defined here, custom formatters appear in the "Use Expression" tab of data binding dialog.
 * E.g. Here is sample custom formatter (for data formatting)
 *   myFormatter : {
 *     formatter : function(data, param1){
 *       // your logic goes here
 *       return data;
 *     },
 *     config: {
 *       param1: {
 *         name: '',
 *         widget: '',
 *         value: ''
 *       }...
 *     }
 *   }
 *
 * Terminology
 * myFormatter	:   Name of the custom formatter
 * formatter 	:   Function where you can write the logic to format the data. The returned value from this function will be applied on the property this formatter is bound to
 * config       :   parameter information required during the design time. List down all the parameters required for your formatter function
 *                  Each param has following info
 *                  - name      : name of the parameter to display during design time
 *                  - widget    : widget to take parameter input from the user. E.g. text, select
 *                  - value     : default value if user doesn't provide any value
 */

var WM_CUSTOM_FORMATTERS = (function() {

})();