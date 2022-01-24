Feature: Borrowing Estimate

 @test1
 Scenario: calculateBorrowingEstimateWithStartOver
 		Given A user navigates to HomePage
 		When page title is "Home loan borrowing power calculator | ANZ"
 		And wait for "5" seconds
 		Then click on "Single"
 		Then select "0" dependants
 		Then click on "Home to live in"
 		Then enter "80000" in "annual income (before tax)"
 		Then enter "10000" in "annual other income (optional)"
 		Then enter "500" in "Monthly living expenses"
 		Then enter "0" in "Current home loan"
 		Then enter "100" in "Other loan"
 		Then enter "0" in "Other monthly commitments"
 		Then enter "10000" in "Total credit card limits"
 		Then click on "Work out how much I could borrow"
 		And wait for "5" seconds
 		And wait for the estimate value "479,000"
 		And wait for "5" seconds
 		Then click on "start over"
 		And wait for "5" seconds
 		Then check "Single" is selected
 		Then check "Number of dependants" is "0"
 		Then check "Home to live in" is selected
 		Then check "annual income" is "0"
 		Then check "annual other income" is "0"
 		Then check "Monthly living expenses" is "0"
 		Then check "Current home loan" is "0"
 		Then check "Other loan" is "0"
 		Then check "Other monthly commitments" is "0"
 		Then check "Total credit card limits" is "0"
 		

  @test2
 Scenario: ValidationMessageCheck
 		Given A user navigates to HomePage
 		When page title is "Home loan borrowing power calculator | ANZ"
 		And wait for "5" seconds
 		Then click on "Single"
 		Then select "0" dependants
 		Then click on "Home to live in"
 		Then enter "0" in "annual income (before tax)"
 		Then enter "0" in "annual other income (optional)"
 		Then enter "1" in "Monthly living expenses"
 		Then enter "0" in "Current home loan"
 		Then enter "0" in "Other loan"
 		Then enter "0" in "Other monthly commitments"
 		Then enter "0" in "Total credit card limits"
 		Then click on "Work out how much I could borrow"
 		And wait for "5" seconds
 		And wait for the warning message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."
 		And wait for "5" seconds
 		