# ROADMAP
* build out HTML DSL for core elements
* build out HTML DSL for bootstrap elements
* build in ability for application DSL for core elements
* build in ability for application DSL for bootstrap elements
* build in Selenium Grid support
* execute tests in Grid
* build out HTML DSL for jqueryui elements
* build in ability for application DSL for jqueryui elements
* build in javadoc creation
* deploy to repository (github -> maven)

# NOTES
* build in "hook" for annotations to automatically look for "data-sulfur-hook" attribute
* remove all xpath for complete IE support
* look into LoadableComponent .. may not work with custom annotations

# FEATURES IN QUESTION
* build in support for old Selenium
* build in support for old Selenese
* build custom runner to allow for custom test setup

    	@Test
    	@Setup("setupXYZ")
    	public void verifyXYZ_ScenarioA() {
    		...
    	}
