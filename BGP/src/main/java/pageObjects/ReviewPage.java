package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.Context;
import utilities.TestContext;

public class ReviewPage extends BasePage {

	@FindBy(how = How.ID, using = "react-eligibility-sg_registered_check")
	private WebElement registeredCheck;
	@FindBy(how = How.ID, using = "react-eligibility-turnover_check")
	private WebElement turnoverCheck;
	@FindBy(how = How.ID, using = "react-eligibility-global_hq_check")
	private WebElement localEquityCheck;
	@FindBy(how = How.ID, using = "react-eligibility-new_target_market_check")
	private WebElement newTargetMarketCheckYes;
	@FindBy(how = How.ID, using = "react-eligibility-started_project_check")
	private WebElement startedProjectCheckYes;
	@FindBy(how = How.ID, using = "react-contact_info-name")
	private WebElement contactPersonName;
	@FindBy(how = How.ID, using = "react-contact_info-designation")
	private WebElement contactPersonJobTitle;
	@FindBy(how = How.ID, using = "react-contact_info-phone")
	private WebElement contactNum;
	@FindBy(how = How.ID, using = "react-contact_info-primary_email")
	private WebElement primaryEmail;
	@FindBy(how = How.ID, using = "react-contact_info-secondary_email")
	private WebElement secondaryEmail;
	@FindBy(how = How.ID, using = "react-contact_info-correspondence_address")
	private WebElement mailingAddress;
	@FindBy(how = How.ID, using = "react-contact_info-offeree_name")
	private WebElement offereeName;
	@FindBy(how = How.ID, using = "react-contact_info-offeree_designation")
	private WebElement offereeJobTitle;
	@FindBy(how = How.ID, using = "react-contact_info-offeree_email")
	private WebElement offereeEmail;

	@FindBy(how = How.ID, using = "react-project-title")
	private WebElement projectTitle;
	@FindBy(how = How.ID, using = "react-project-start_date")
	private WebElement projectStartDate;
	@FindBy(how = How.ID, using = "react-project-end_date")
	private WebElement projectEndDate;
	@FindBy(how = How.ID, using = "react-project-project_duration_months")
	private WebElement projectDuration;
	@FindBy(how = How.ID, using = "react-project-description")
	private WebElement projectDesc;
	@FindBy(how = How.ID, using = "react-project-activity")
	private WebElement activity;
	@FindBy(how = How.ID, using = "react-project-primary_market")
	private WebElement tarketMarket;
	@FindBy(how = How.ID, using = "react-project-is_first_time_expand")
	private WebElement isFirstTimeExpand;
	@FindBy(how = How.ID, using = "react-project_impact-overseas_sales_0")
	private WebElement overseasSales0;

	@FindBy(how = How.ID, using = "react-project_impact-overseas_sales_1")
	private WebElement overseasSales1;
	@FindBy(how = How.ID, using = "react-project_impact-overseas_sales_2")
	private WebElement overseasSales2;
	@FindBy(how = How.ID, using = "react-project_impact-overseas_sales_3")
	private WebElement overseasSales3;
	@FindBy(how = How.ID, using = "react-project_impact-overseas_investments_0")
	private WebElement investments0;
	@FindBy(how = How.ID, using = "react-project_impact-overseas_investments_1")
	private WebElement investments1;
	@FindBy(how = How.ID, using = "react-project_impact-overseas_investments_2")
	private WebElement investments2;
	@FindBy(how = How.ID, using = "react-project_impact-overseas_investments_3")
	private WebElement investments3;
	@FindBy(how = How.ID, using = "react-project_impact-rationale_remarks")
	private WebElement rationaleForProjections;
	@FindBy(how = How.ID, using = "react-project_impact-benefits_remarks")
	private WebElement nonTangibleBenefits;
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-name")
	private WebElement empName;
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-designation")
	private WebElement empDesignation;
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-nric")
	private WebElement nricPassportNum;
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-nationality")
	private WebElement nationalityType;
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-project_role")
	private WebElement empProjectRole;
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-involvement_months")
	private WebElement empProjectInvolvement;
	@FindBy(how = How.ID, using = "react-project_cost-salaries-0-salary_in_billing_currency")
	private WebElement empSalaryBillingCurrency;
	@FindBy(how = How.ID, using = "react-declaration-criminal_liability_check")
	private WebElement liabilityCheck;
	@FindBy(how = How.ID, using = "react-declaration-civil_proceeding_check")
	private WebElement civilProceedingCheck;
	@FindBy(how = How.ID, using = "react-declaration-insolvency_proceeding_check")
	private WebElement insolvencyProceedingCheck;
	@FindBy(how = How.ID, using = "react-declaration-project_incentives_check")
	private WebElement projectIncentivesCheck;
	@FindBy(how = How.ID, using = "react-declaration-other_incentives_check")
	private WebElement otherIncentivesCheck;
	@FindBy(how = How.ID, using = "react-declaration-project_commence_check")
	private WebElement projectCommenceCheck;
	@FindBy(how = How.ID, using = "react-declaration-related_party_check")
	private WebElement partyCheck;
	@FindBy(how = How.ID, using = "react-declaration-covid_safe_check")
	private WebElement covidSafe;
	@FindBy(how = How.ID, using = "react-declaration-covid_safe_ques_check")
	private WebElement complyAllSDMs;
	@FindBy(how = How.ID, using = "react-declaration-consent_acknowledgement_check")
	private WebElement acknowledgementCheck;

	public ReviewPage(TestContext context) {
		super(context);
	}

	public void verifyYesSelectedEligibilityQues() {
		assertEquals(elementFactory.elementGetText(registeredCheck), "Yes");
		assertEquals(elementFactory.elementGetText(turnoverCheck), "Yes");
		assertEquals(elementFactory.elementGetText(localEquityCheck), "Yes");
		assertEquals(elementFactory.elementGetText(newTargetMarketCheckYes), "Yes");
		assertEquals(elementFactory.elementGetText(startedProjectCheckYes), "Yes");
	}

	public void verifyContactDeatails() {
		assertEquals(elementFactory.elementGetText(contactPersonName),
				scenarioContext.getContext(Context.ContactPersonName));
		assertEquals(elementFactory.elementGetText(contactPersonJobTitle),
				scenarioContext.getContext(Context.ContactPersonJobTitle));
		assertEquals(elementFactory.elementGetText(contactNum), scenarioContext.getContext(Context.ContactNum));
		assertEquals(elementFactory.elementGetText(primaryEmail), scenarioContext.getContext(Context.PrimaryEmail));
		assertEquals(elementFactory.elementGetText(secondaryEmail), scenarioContext.getContext(Context.AlternateEmail));
		assertTrue(elementFactory.elementGetText(mailingAddress)
				.contains(scenarioContext.getContext(Context.PostalCode).toString()));
		assertEquals(elementFactory.elementGetText(offereeName), scenarioContext.getContext(Context.ContactPersonName));
		assertEquals(elementFactory.elementGetText(offereeJobTitle),
				scenarioContext.getContext(Context.ContactPersonJobTitle));
		assertEquals(elementFactory.elementGetText(offereeEmail), scenarioContext.getContext(Context.PrimaryEmail));
	}

	public void verifyProposalDeatails() {
		assertEquals(elementFactory.elementGetText(projectTitle), scenarioContext.getContext(Context.ProjectTitle));
		assertEquals(elementFactory.elementGetText(projectStartDate), scenarioContext.getContext(Context.StartDate));
		assertEquals(elementFactory.elementGetText(projectEndDate), scenarioContext.getContext(Context.EndDate));
		assertEquals(elementFactory.elementGetText(projectDesc), scenarioContext.getContext(Context.ProjectDesc));
		assertEquals(elementFactory.elementGetText(activity), scenarioContext.getContext(Context.Activity));
		assertEquals(elementFactory.elementGetText(tarketMarket), scenarioContext.getContext(Context.TargetMarket));
		assertEquals(elementFactory.elementGetText(isFirstTimeExpand), "Yes");
	}

	public void verifyBusinessImpactDetails() {
		assertEquals(elementFactory.elementGetText(overseasSales0), scenarioContext.getContext(Context.OverseasSales1));
		assertEquals(elementFactory.elementGetText(overseasSales1), scenarioContext.getContext(Context.OverseasSales2));
		assertEquals(elementFactory.elementGetText(overseasSales2), scenarioContext.getContext(Context.OverseasSales3));
		assertEquals(elementFactory.elementGetText(overseasSales3), scenarioContext.getContext(Context.OverseasSales4));
		assertEquals(elementFactory.elementGetText(investments0), scenarioContext.getContext(Context.Investments1));
		assertEquals(elementFactory.elementGetText(investments1), scenarioContext.getContext(Context.Investments2));
		assertEquals(elementFactory.elementGetText(investments2), scenarioContext.getContext(Context.Investments3));
		assertEquals(elementFactory.elementGetText(investments3), scenarioContext.getContext(Context.Investments4));
		assertEquals(elementFactory.elementGetText(rationaleForProjections),
				scenarioContext.getContext(Context.RationaleProjetions));
		assertEquals(elementFactory.elementGetText(nonTangibleBenefits),
				scenarioContext.getContext(Context.NonTangibleBenefits));
	}

	public void verifyCostSectionDetails() {
		assertEquals(elementFactory.elementGetText(empName), scenarioContext.getContext(Context.EmpName));
		assertEquals(elementFactory.elementGetText(empDesignation), scenarioContext.getContext(Context.EmpDesignation));
		assertEquals(elementFactory.elementGetText(nricPassportNum),
				scenarioContext.getContext(Context.EmpPassportNum));
		assertEquals(elementFactory.elementGetText(nationalityType),
				scenarioContext.getContext(Context.EmpNationality));
		assertEquals(elementFactory.elementGetText(empProjectRole), scenarioContext.getContext(Context.RoleInProject));
		assertEquals(elementFactory.elementGetText(empProjectInvolvement),
				scenarioContext.getContext(Context.ProjectInvolvement));
		assertEquals(elementFactory.elementGetText(empSalaryBillingCurrency),
				scenarioContext.getContext(Context.MonthlySalary));
	}

	public void verifyNoForDeclareAckTerms() {
		assertEquals(elementFactory.elementGetText(liabilityCheck), "No");
		assertEquals(elementFactory.elementGetText(civilProceedingCheck), "No");
		assertEquals(elementFactory.elementGetText(insolvencyProceedingCheck), "No");
		assertEquals(elementFactory.elementGetText(projectIncentivesCheck), "No");
		assertEquals(elementFactory.elementGetText(otherIncentivesCheck), "No");
		assertEquals(elementFactory.elementGetText(projectCommenceCheck), "No");
		assertEquals(elementFactory.elementGetText(partyCheck), "No");
	}

	public void verifyYesCovidSafeComplySDMsConsentAck() {
		assertEquals(elementFactory.elementGetText(covidSafe), "Yes");
		assertEquals(elementFactory.elementGetText(complyAllSDMs), "Yes");
		assertEquals(elementFactory.elementGetText(acknowledgementCheck), "Yes");
	}
}
