# Selenium Web QA Automation Demo
<p>In this demo, I will be testing a web application using Selenium WebDriver. This test case will focus on basic 
functionality of the application, such as adding items to the cart, removing items from the cart, and confirming 
the total price of the items in the cart.</p>

## The task:
<ol>
<li>Login to the SauceLabs demo platform</li>
<li>Add items to the cart (Bike Light, Bolt T-Shirt, and Fleece Jacket)</li>
<li>Confirm that the items are added to the cart</li>
<li>Confirm that the total price of the items in the cart is correct</li>
<li>Remove an item from the cart (Bike Light)</li>
<li>Confirm that the item is removed from the cart</li>
<li>Confirm that the total price of the items in the cart is correct</li>
<li>Add another item to the cart (Onesie)</li>
<li>Confirm that the item is added to the cart</li>
<li>Confirm that the total price of the items in the cart is correct</li>
</ol>

# Comments
<ul>
<li>I separated the steps in different test cases for better test granularity. In BDD, we should focus on testing
one behaviour per test and avoid unrelated assertions in the same test.</li>
<li>I used Serenity BDD framework as it was listed in the job description.</li>
</ul>

# Instructions
<ul>
<li>Clone repo</li>
<li>Install Java 21 and set $JAVA_HOME</li>
<li>Install maven (e.g. v3.8.5)</li>
<li>Build project</li>
<li>Install firefox (or change driver in serenity.conf)</li>
<li>Add your secrets file <code>.env.dev</code> under <code>src/test/resources/secrets</code>(check the example file provided for guidance).</li>
<li>Open a terminal, go to the project base directory and execute: <code>mvn verify -Denvironment=dev -Pdev</code></li>
</ul>
