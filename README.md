<img src='https://res.cloudinary.com/dnw4kirdp/image/upload/c_limit,h_126,r_30,w_600/v1680760059/globant-vector-logo_kjrxj3.png'></img>

<h2 class="code-line" data-line-start=1 data-line-end=2 ><a id="Web_ESPN_and_Mobile_Disneyland_hybrid_test_automation_1"></a>Web (ESPN) and Mobile (Disneyland) hybrid test automation</h2>
<h2 class="code-line" data-line-start=5 data-line-end=6 ><a id="To_run_it_5"></a>To run it:</h2>
<ul>
<li class="has-line-data" data-line-start="6" data-line-end="7">Open the project in the IDE, and then run the &lt;MobileTestRunner&gt; and &lt;WebTestRunner&gt; classes.</li>
<li class="has-line-data" data-line-start="7" data-line-end="9">You will need to have Java 8 installed and the Android Studio and Appium server configured and running. Also configure the capabilities in the &lt;mobile_capabilities.json&gt;.</li>
<li class="has-line-data" data-line-start="7" data-line-end="9"> Sometimes the webpage tries to send a code to the email account and it some tests can break because of it... So if you need to switch the non generated account it can have any email <in the email attribute>, but you will have to change the <username> and the <password> in the file <BaseForWebTests> otherwise some assertions will fail.</li>
</ul>
<h2 class="code-line" data-line-start=9 data-line-end=10 ><a id="Have_in_mind_9"></a>Have in mind:</h2>
<ul>
<li class="has-line-data" data-line-start="10" data-line-end="11">The Appium and Selenium versions used in this project are the highest compatible that don’t require to stop using MobileElement, this is so the mobile project doesn’t need major refactors to work.</li>
<li class="has-line-data" data-line-start="10" data-line-end="11">The ESPN web test has a probability of ~10% to fail due to external reasons that affect the selection of the close-modal-button-locator on the watchpage. But the Disneyland mobile test almost never fails if the Appium server and Android Studio have a proper configuration.</li>
</ul>
