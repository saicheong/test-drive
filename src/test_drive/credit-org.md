# Credit Origination 

In order to test the credit origination service - we first need to understand
the data that is required by the service.

The service body consist of:
- application header
- application

application consist of
- card application details
- financial package

For card application, financial package will be empty (or not applicable?)
For non-card application, card application details will be empty (or not applicable?)

card application details consist of
- one or more card application

financial package consist of
- facilities
- collaterals

facilities consists of
- one or more lines
- zero or more collaterals


To test the service, one approach can be creating separate properties
based on the kinds of application:

Credit Card Application
Mortgage Application
Car Finance Application
Other Application

Credit Card Application - try:
- financial package is not specified
- financial package is empty
- financial contain empty facilties and empty collaterals

Non Credit Card Application - try:
- card application details is not specified
- card application details ia empty
- card application details contain single card application (with default values) 
