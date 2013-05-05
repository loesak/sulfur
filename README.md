> This project is in its conception phase and is not ready for use at this time.

# Sulfur

Sulfur, it's above Selenium

## What is it?

Sulfur was created to test highly dynamic web applications while at the same time bring better structure and clarity to your testing. 

It has built in support for all major WebDriver drivers (Android, Chrome, FireFox, HtmlUnit, Internet Explorer, iPhone, Opera, PhantomJS, Safari, and more). You just tell Sulfur the what and where of the browsers you want and it will do the rest.

Use Sulfur's page objects and custom web elements to define the structure and behavior of your web application with ease.

Want your tests to seamlessly interact with the popular widget frameworks like [Twitter Bootstrap][1] or [jQueryUI][2]? We can do that.

Looking to run your tests locally but have them execute remotely and distributed? No problem. Sulfur has full support for the Selenium Grid.

Have some old Selenium unit tests, or worse, Selenese HTML tests? No problem. Sulfur can execute those as well. It can even execute them using WebDriver for true browser testing.

### Lets Dig In

#### Page Object

	public class GoogleSearchPage extends SulfurPageObject {
	
		@ImageElement(by = By.ById.class, using = "hplogo")
		public Image banner;
		
		@InputElement(by = By.ById.class, using = "gbqfq", type = "text")
		public Input query;
		
		@ButtonElement(by = By.ById.class, using = "gbqfsa")
		public Button searchButton;
		
		@ButtonElement(by = By.ById.class, using = "gbqfbb")
		public Button imFeelingLuckyButton;
	
		public GoogleSearchPage query(String text) {
			this.query.clear();
			this.query.sendKeys(text);
			
			return this;
		}
	
		public GoogleResultsPage clickSearchButton() {
			this.searchButton.click();
			return GoogleResultsPage.get();
		}
		
		public GoogleResultsPage search(String text) {
			return this.query(text).clickSearchButton();
		}
	}

#### Test

	public class GoogleWT extends SulfurTest {
		@Rule
		public ErrorCollector collector = new ErrorCollector();
		
		@Test
		public void searchForSulfur() throws Exception {
			GoogleSearchPage gsp = GoogleSearchPage.get();
			
			collector.checkThat(gsp.banner, is(visible()));
			collector.checkThat(gsp.searchButton.text(), is("Google Search"));
			collector.checkThat(gsp.imFeelingLuckyButton.text(), is("I'm Feeling Lucky"));
			
			GoogleResultsPage grp = gsp.search("Sulfur");
			
			// do more stuff
		}
	}

#### Maven

	<dependencies>
		...
		<dependency>
			<groupId>com.loesoft.sulfur</groupId>
			<artifactId>core</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
		...
	</dependencies>

####

[1]: http://twitter.github.io/bootstrap/ "Twitter Bootstrap"
[2]: http://jqueryui.com/ "jQueryUI"