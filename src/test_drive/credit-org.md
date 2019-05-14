# Credit Origination 

In order to test the credit origination service - we first need to understand
the data required by the service and how it is to be structured.

The data consist of:
- header
- body

header specifies identifying information:
- <todo>

body includes (among others)
- credit 
- credit details

credit details consist of
- one or more facility
- zero or more security

credit specifies:
- type: unsecured(card), secured(card), unsecured. Optional (may be required for cards)
- limit. 
- ccy: base currency used
- reference no. 


For card application, there are no further credit details required
For cashplus application, credit details consist of the cashplus facility details  
For debt consol application, credit details consist of the term loan facility details
For other secured application, credit details consist of both line and security details 

