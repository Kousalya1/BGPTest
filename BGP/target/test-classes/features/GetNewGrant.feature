@Regression 
Feature: Business Grants Portal - Get new grant 

Background: 
	Given Launch Business Grants Portal 

	
Scenario Outline: Get new grant - Verify Eligibility section questions, Yes/No radio buttons, warning message 
	When Login with NRIC "<NRIC>", username "<Username>", UEN "<UEN>", Role "<Role>" 
	And Proceed to get new grant 
	Then Verify Eligibility section has eligibility questions 
	And Verify each question can be answered Yes or No through radio buttons 
	And Ensure visit smart advisor warning message is displayed on selecting No for any of the questions 
	Then Clicking the link in the warning message will launch a website in another window tab 
	
	Examples: 
		|NRIC 		|  Username  | UEN  	 |  Role 	|
		|S1234567A 	| Tan ah Kow | BGPQEDEMO | Acceptor |
		
		
Scenario Outline: Get new grant - Complete filling the Eligibility details 
	When Login with NRIC "<NRIC>", username "<Username>", UEN "<UEN>", Role "<Role>" 
	And Proceed to get new grant 
	And Complete filling the eligibility details by selecting yes for all questions 
	And Click on save button 
	Then Refreshing the page should reload the saved values in eligibility section 
	
	Examples: 
		|NRIC 		|  Username  | UEN  	 |  Role 	|
		|S1234567A 	| Tan ah Kow | BGPQEDEMO | Acceptor | 
		
		
Scenario: Get new grant - Verify auto-populate Mailing Address and Letter of Offer Addressee details 
	When Login with NRIC "S1234567A", username "Tan ah Kow", UEN "BGPQEDEMO", Role "Acceptor" 
	And Proceed to get new grant 
	And Complete filling the eligibility details by selecting yes for all questions 
	And Click on save button 
	And Click on next button 
	And Enter contact person details name "Kousalya", job title "Test Engineer", contact number "12345678", email "kousalya@gmail.com", alternate email "kousal@gmail.com" 
	And Select same as registered address in Company Profile checkbox 
	Then Verify auto-populate Mailing Address details 
	And Select same as main contact person details 
	Then Verify auto-populate Letter of Offer Addressee details 
	
	
Scenario: Get new grant - Search mailing address with the postal code and verify auto-populated details 
	When Login with NRIC "S1234567A", username "Tan ah Kow", UEN "BGPQEDEMO", Role "Acceptor" 
	And Proceed to get new grant 
	And Complete filling the eligibility details by selecting yes for all questions 
	And Click on save button 
	And Click on next button 
	And Enter contact person details name "Kousalya", job title "Test Engineer", contact number "12345678", email "kousalya@gmail.com", alternate email "kousal@gmail.com" 
	And Search mailing address with the postal code "530439" 
	Then Verify auto-populate Mailing Address details 
	And Verify Letter of Offer Addressee subsection
	And Select same as main contact person details 
	Then Verify auto-populate Letter of Offer Addressee details 
	And Click on save button 
	And Refreshing the page should reload the saved values in Contact Details section 
	

Scenario: Get new grant - Verify redirect to the section with the missing details and error numbers are shown in the sidebar 
	When Login with NRIC "S1234567A", username "Tan ah Kow", UEN "BGPQEDEMO", Role "Acceptor" 
	And Proceed to get new grant 
	And Click on Declare and Review section 
	And Click on review button 
	Then Verify redirect to the section with the missing details 
	And Verify error numbers are shown in the sidebar 
	
	
Scenario: Get new grant - Submit Application 
	When Login with NRIC "S1234567A", username "Tan ah Kow", UEN "BGPQEDEMO", Role "Acceptor" 
	And Proceed to get new grant 
	And Complete filling the eligibility details by selecting yes for all questions 
	And Click on save button 
	And Click on next button 
	And Enter contact person details name "Kousalya", job title "Test Engineer", contact number "12345678", email "kousalya@gmail.com", alternate email "kousal@gmail.com" 
	And Search mailing address with the postal code "530439" 
	Then Verify auto-populate Mailing Address details 
	And Select same as main contact person details 
	Then Verify auto-populate Letter of Offer Addressee details 
	And Click on save button 
	And Click on next button 
	And Enter Proposal section details project title "Test Title", start date "01 Jul 2020", end date "30 Nov 2020", project description "Test Project Desc" 
	And Select Activity "FTA Consultancy" and Target market "India" 
	And Select yes for first time expanding outside Singapore 
	And Click on save button 
	And Click on next button 
	And Select FY end date "31 Dec 2020" 
	And Enter Overseas sales details sales one "10", sales two "20", sales three "30", sales four "40" 
	And Enter Overseas investments details investments one "11", investments two "22", investments three "43", investments four "44" 
	And Enter Rationale for projections "Test rationale for projections" and non tangible benefits "Test benefits" 
	And Click on save button 
	And Click on next button 
	And Enter name "Kousalya", designation "Test Engineer", nricPassport number "P1234567", nationlity "Foreigner" in the cost section
	And Enter role in project "Tester", project involvement "3", monthlySalary "200" in the cost section
	And Click on save button 
	And Click on next button 
	And Select No for Declare and Acknowledgement terms 
	And Select Yes for comply all Government rules 
	And Click on Consent and Acknowledgement checkbox 
	And Click on review button 
	Then Verify Yes selected for Eligibility section questions in review page
	And Verify the Contact details in review page
	And Verify the Proposal details in review page
	And Verify the Business impact details in review page
	And Verify the Cost details in review page
	And Verify No selected for Declare and Acknowledgement terms in review page
	And Verify Yes selected for comply all Government rules, Consent and Acknowledgement in review page
	Then Submit application and ensure 
	And Ensure My Grants dashboard shows the application under processing tab
	
	 
	 
	 
	 
	 
	 