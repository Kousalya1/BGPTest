package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.EnvPropertyManager;
import utilities.Context;
import utilities.ScenarioContext;
import utilities.TestContext;
import pageObjects.LoginPage;
import pageObjects.MyGrantsPage;
import pageObjects.ReviewPage;

public class GetNewGrantSteps {

	TestContext testContext;
	private LoginPage loginPage;
	private MyGrantsPage myGrantsPage;
	private ReviewPage reviewPage;
	ScenarioContext scenarioContext;
	String applnRefId;
	
	public GetNewGrantSteps(TestContext testContext) {
		this.testContext = testContext;
		loginPage = new LoginPage(testContext);
		myGrantsPage = new MyGrantsPage(testContext);
		reviewPage = new ReviewPage(testContext);
		scenarioContext = new ScenarioContext();
	}

	@Given("Launch Business Grants Portal")
	public void Launch_Business_Grants_Portal() {
		loginPage.launchUrl(EnvPropertyManager.getUsername(), EnvPropertyManager.getPassword(),
				EnvPropertyManager.getUrl());
	}

	@When("Login with NRIC {string}, username {string}, UEN {string}, Role {string}")
	public void login_with_NRIC_username_UEN_Role(String nric, String name, String uen, String role) {
		loginPage.login(nric, name, uen, role);
	}

	@When("Proceed to get new grant")
	public void proceed_to_get_new_grant() {
		myGrantsPage.proceedToGetNewGrant();
	}

	@When("Complete filling the eligibility details by selecting yes for all questions")
	public void Enter_Eligibility_details() {
		myGrantsPage.selectYesEligibilityQues();
	}

	@When("Ensure visit smart advisor warning message is displayed on selecting No for any of the questions")
	public void ensure_warning_message_is_displayed_on_selecting_No_for_any_of_the_questions() {
		myGrantsPage.ensureWarnMsgVisitSmartAdvisor();
	}

	@When("Clicking the link in the warning message will launch a website in another window tab")
	public void clicking_the_link_in_the_warning_message_will_launch_a_website_in_another_window_tab() {
		myGrantsPage.clickWarnMsgLinkAndSwitchTo2ndTab();
	}
	
	@When("Click on save button")
	public void clicking_save_button() throws InterruptedException {
		myGrantsPage.clickSave();
	}

	@When("Refreshing the page should reload the saved values in eligibility section")
	public void refreshing_the_page_should_reload_the_saved_values() {
		myGrantsPage.reloadPage();
		myGrantsPage.ensureYesSelectedForEligibilityQues();
	}
	
	@When("Click on next button")
	public void click_on_next_button() {
		myGrantsPage.clickNext();
	}
	
	@When("Enter contact person details name {string}, job title {string}, contact number {string}, email {string}, alternate email {string}")
	public void enter_contact_person_details_name_job_title_contact_number_email_alternate_email(String name,
			String jobTitle, String contactNo, String email, String altEmail) {
		myGrantsPage.enterContactPersonDetails(name, jobTitle, contactNo, email, altEmail);
		scenarioContext.setContext(Context.ContactPersonName, name);
		scenarioContext.setContext(Context.ContactPersonJobTitle, jobTitle);
		scenarioContext.setContext(Context.ContactNum, contactNo);
		scenarioContext.setContext(Context.PrimaryEmail, email);
		scenarioContext.setContext(Context.AlternateEmail, altEmail);
	}

	@When("Select same as registered address in Company Profile checkbox")
	public void select_same_as_registered_address_in_Company_Profile_checkbox() {
		myGrantsPage.selectSameAsRegAddress();
	}

	@Then("Verify auto-populate Mailing Address details")
	public void verify_auto_populate_Mailing_Address_details() {
		myGrantsPage.verifyAutoPopMailAddressDetails();
	}

	@Then("Select same as main contact person details")
	public void select_same_as_main_contact_person_details() {
		myGrantsPage.selectSameAsMainContact();
	}

	@Then("Verify auto-populate Letter of Offer Addressee details")
	public void verify_auto_populate_Letter_of_Offer_Addressee_details() {
		myGrantsPage.verifyAutoPopLetterOfferAddresseeDetails();
	}
	
	@When("Search mailing address with the postal code {string}")
	public void search_mailing_address_with_the_postal_code(String postalCode) {
		myGrantsPage.searchPostalCode(postalCode);
		scenarioContext.setContext(Context.PostalCode, postalCode);
	}


	@Then("Refreshing the page should reload the saved values in Contact Details section")
	public void refreshing_the_page_should_reload_the_saved_values_in_Contact_Details_section() {
		myGrantsPage.reloadPage();
		myGrantsPage.verifyAutoPopMailAddressDetails();
		myGrantsPage.verifyAutoPopLetterOfferAddresseeDetails();
	}
	
	@When("Click on Declare and Review section")
	public void click_on_Declare_and_Review_section() {
		myGrantsPage.clickDeclareReviewSection();
	}

	@When("Click on review button")
	public void click_on_review_button() {
		myGrantsPage.clickReview();
	}

	@Then("Verify redirect to the section with the missing details")
	public void verify_redirect_to_the_section_with_the_missing_details() {
		myGrantsPage.verifyRedirectSectionMissingDetails();
	}

	@Then("Verify error numbers are shown in the sidebar")
	public void verify_error_numbers_are_shown_in_the_sidebar() {
		myGrantsPage.verifyErrorNumShown();
	}

	@Then("Enter Proposal section details project title {string}, start date {string}, end date {string}, project description {string}")
	public void enter_Proposal_section_details_project_title_start_date_end_date_project_description(String prjTitle,
			String startDate, String endDate, String prjDesc) {
		myGrantsPage.enterProposalDetails(prjTitle, startDate, endDate, prjDesc);
		scenarioContext.setContext(Context.ProjectTitle, prjTitle);
		scenarioContext.setContext(Context.StartDate, startDate);
		scenarioContext.setContext(Context.EndDate, endDate);
		scenarioContext.setContext(Context.ProjectDesc, prjDesc);
	}
	
	@Then("Select Activity {string} and Target market {string}")
	public void select_Activity_and_Target_market(String activity, String targetMarket) {
		myGrantsPage.selectActivityTargetMarket(activity, targetMarket);
		scenarioContext.setContext(Context.Activity, activity);
		scenarioContext.setContext(Context.TargetMarket, targetMarket);
	}

	@Then("Select yes for first time expanding outside Singapore")
	public void select_yes_for_first_time_expanding_outside_Singapore() {
		myGrantsPage.selectYesFirstTimeExpanOutsideSg();
	}

	@Then("Select FY end date {string}")
	public void select_FY_end_date(String fyEndDate) {
		myGrantsPage.selectFyEndDate(fyEndDate);
		scenarioContext.setContext(Context.FYEndDate, fyEndDate);
	}

	@Then("Enter Overseas sales details sales one {string}, sales two {string}, sales three {string}, sales four {string}")
	public void enter_Overseas_sales_details_sales_sales_sales_sales(String sales1, String sales2, String sales3, String sales4) {
		myGrantsPage.enterOverseasSales(sales1, sales2, sales3, sales4);
		scenarioContext.setContext(Context.OverseasSales1, sales1);
		scenarioContext.setContext(Context.OverseasSales2, sales2);
		scenarioContext.setContext(Context.OverseasSales3, sales3);
		scenarioContext.setContext(Context.OverseasSales4, sales4);
	}

	@Then("Enter Overseas investments details investments one {string}, investments two {string}, investments three {string}, investments four {string}")
	public void enter_Overseas_investments_details_investments_investments_investments_investments(String investments1,
			String investments2, String investments3, String investments4) {
		myGrantsPage.enterOverseasInvestments(investments1, investments2, investments3, investments4);
		scenarioContext.setContext(Context.Investments1, investments1);
		scenarioContext.setContext(Context.Investments2, investments2);
		scenarioContext.setContext(Context.Investments3, investments3);
		scenarioContext.setContext(Context.Investments4, investments4);
	}

	@Then("Enter Rationale for projections {string} and non tangible benefits {string}")
	public void enter_Rationale_for_projections_and_non_tangible_benefits(String rationaleProj, String nonTangBenefits) {
		myGrantsPage.enterRationaleProjNonTangBenefits(rationaleProj, nonTangBenefits);
		scenarioContext.setContext(Context.RationaleProjetions, rationaleProj);
		scenarioContext.setContext(Context.NonTangibleBenefits, nonTangBenefits);
	}
	
	@Then("Enter name {string}, designation {string}, nricPassport number {string}, nationlity {string} in the cost section")
	public void enter_name_designation_nricPassport_number_nationlity_in_the_cost_section(String name,
			String designation, String nricPassportNum, String nationlity) {
		myGrantsPage.enterDetailsInSalarySubSec(name, designation, nricPassportNum, nationlity);
		scenarioContext.setContext(Context.EmpName, name);
		scenarioContext.setContext(Context.EmpDesignation, designation);
		scenarioContext.setContext(Context.EmpPassportNum, nricPassportNum);
		scenarioContext.setContext(Context.EmpNationality, nationlity);
	}

	@Then("Enter role in project {string}, project involvement {string}, monthlySalary {string} in the cost section")
	public void enter_role_in_project_project_involvement_monthlySalary_in_the_cost_section(String roleInProject,
			String projectInvolvement, String monthlySalary) {
		myGrantsPage.enterDetailsInSalarySubSec(roleInProject, projectInvolvement, monthlySalary);
		scenarioContext.setContext(Context.RoleInProject, roleInProject);
		scenarioContext.setContext(Context.ProjectInvolvement, projectInvolvement);
		scenarioContext.setContext(Context.MonthlySalary, monthlySalary);
	}

	@Then("Select No for Declare and Acknowledgement terms")
	public void select_No_for_declare_and_acknowledgement_terms() {
		myGrantsPage.selectNoDeclareAckTerms();
	}
	
	@Then("Select Yes for comply all Government rules")
	public void select_Yes_for_comply_all_Government_rules() {
		myGrantsPage.selectYesComplyAllGovtRules();
	}
	
	@When("Click on Consent and Acknowledgement checkbox")
	public void click_on_Consent_and_Acknowledgement_checkbox() {
		myGrantsPage.ClickConsentAckCheckbox();
	}

	@Then("Submit application and ensure")
	public void ensure_application_is_submitted() {
		applnRefId = myGrantsPage.clickSumbitAndEnsure();
	}

	@Then("Ensure My Grants dashboard shows the application under processing tab")
	public void ensure_My_Grants_dashboard_shows_the_application_under_processing_tab() {
		myGrantsPage.verifyApplnUnderProcessingTab(applnRefId);
	}

	@Then("Verify Eligibility section has eligibility questions")
	public void verify_Eligibility_section_has_eligibility_questions() {
		myGrantsPage.verifyEligibilitySecHasQues();
	}

	@Then("Verify each question can be answered Yes or No through radio buttons")
	public void verify_each_question_can_be_answered_Yes_or_No_through_radio_buttons() {
		myGrantsPage.verifyYesNoRadioDisplayedEligibilityQues();
	}

	@Then("Verify Letter of Offer Addressee subsection")
	public void verify_Letter_of_Offer_Addressee_subsection() {
		myGrantsPage.verifyLetterOfAddresseeSubSec();
	}
	
	@Then("Verify Yes selected for Eligibility section questions in review page")
	public void verify_Yes_selected_for_Eligibility_section_questions_in_review_page() {
		reviewPage.verifyYesSelectedEligibilityQues();
	}

	@Then("Verify the Contact details in review page")
	public void verify_the_Contact_details_in_review_page() {
		reviewPage.verifyContactDeatails();
	}

	@Then("Verify the Proposal details in review page")
	public void verify_the_Proposal_details_in_review_page() {
		reviewPage.verifyProposalDeatails();
	}

	@Then("Verify the Business impact details in review page")
	public void verify_the_Business_impact_details_in_review_page() {
		reviewPage.verifyBusinessImpactDetails();
	}

	@Then("Verify the Cost details in review page")
	public void verify_the_Cost_details_in_review_page() {
		reviewPage.verifyCostSectionDetails();
	}

	@Then("Verify No selected for Declare and Acknowledgement terms in review page")
	public void verify_No_selected_for_Declare_and_Acknowledgement_terms_in_review_page() {
		reviewPage.verifyNoForDeclareAckTerms();
	}

	@Then("Verify Yes selected for comply all Government rules, Consent and Acknowledgement in review page")
	public void verify_Yes_selected_for_comply_all_Government_rules_Consent_and_Acknowledgement_in_review_page() {
		reviewPage.verifyYesCovidSafeComplySDMsConsentAck();
	}

}
