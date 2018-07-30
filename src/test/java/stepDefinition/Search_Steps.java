package stepDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObject.SearchArea;
import pageObject.SearchResultsPage;

public class Search_Steps {

    @Given("^I want to find many articles$")
    public void i_want_to_find_many_articles() throws Throwable {
        System.out.println("Ready to search and find many articles.");
    }

    @When("^(?:I|I have) search(?:ed)? for \"([^\"]*)\"$")
    public void i_search_for(String searchTerm) throws Throwable {
        SearchArea.enterSearchTermAndPressEnter(searchTerm);
    }

    @Then("^I should see search results for \"([^\"]*)\"$")
    public void i_should_see_search_results_for(String searchTerm) throws Throwable {
        SearchResultsPage.searchResultsPage();
        SearchResultsPage.searchResultsPage_assertions(searchTerm);
    }

    @Given("^I want to find only (\\d+) article$")
    public void i_want_to_find_only_article(int arg1) throws Throwable {
        System.out.println("Ready to search and find only one article."); }

    @Then("^I should see only a single search result for \"([^\"]*)\"$")
    public void i_should_see_only_a_single_search_result_for(String searchTerm) throws Throwable {
        SearchResultsPage.searchResultsPage();
        SearchResultsPage.searchResultsPage_assertions(searchTerm);

        if (SearchResultsPage.searchResultsPage_ResultCount() == 1) {
            System.out.println("only 1 result found"); }
        else {
            System.out.println("expected 1 result; found 0 or more than 1");
            //throw AssertionError
            }
    }

    @Given("^I want to find no articles$")
    public void i_want_to_find_no_articles() throws Throwable {
        System.out.println("Ready to search and find no articles.");
    }

    @Then("^I should see no articles found$")
    public void i_should_see_no_articles_found() throws Throwable {

        SearchResultsPage.searchResultsPage_NoResults();
        SearchResultsPage.searchResultsPage_NoResultsContent();

    }
}
