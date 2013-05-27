# Sulfur

Sulfur, it's above Selenium. Literally!

[![Build Status](https://travis-ci.org/loesak/sulfur.png?branch=master)](https://travis-ci.org/loesak/sulfur)

## What is it?

Sulfur was created to test highly dynamic web applications while at the same time bring better organization and clarity to your web testing. 

## Features

It has built in support for all major WebDriver drivers (Android, Chrome, FireFox, HtmlUnit, Internet Explorer, iPhone, Opera, PhantomJS, Safari, and more). You just tell Sulfur the what and where of the browsers you want and it will do the rest.

Use Sulfur's page objects and custom web elements to define the structure and behavior of your web application with ease.

Want your tests to seamlessly interact with the popular widget frameworks like [Twitter Bootstrap][1] or [jQueryUI][2]? We can do that.

Want your tests to be written in the language of your application? We have support for supplying your own element definitions.

Looking to run your tests locally but have them execute remotely and distributed? No problem. Sulfur has full support for the Selenium Grid.

## Build Instructions

Check out source code and run `mvn install` on sulfur/pom.xml.

The build expects you to have FireFox installed. If you do not, then you can switch your browser by supplying the system property of `webdriver.browser.name` to any value `android`, `chrome`, `firefox`, `htmlunit`, `internetexplorer`, `iphone`, `opera`, `phantom`, `remote`, or `safari`. Depending on the browser you pick, additional system properties may need to be set.

## Updates

> 5/27/13 - Delivered the initial code for bootstrap testing (basic buttons only implemented). Looking to keep working on this for the rest of the week.

> 5/24/13 - Correction, the basic testing framework is ready, no work is done for the grid.

> 5/24/13 - The basic framework is finished and is ready for element class creation.

> 5/5/13 - This project is in its conception phase and is not ready for use at this time.

[1]: http://twitter.github.io/bootstrap/ "Twitter Bootstrap"
[2]: http://jqueryui.com/ "jQueryUI"