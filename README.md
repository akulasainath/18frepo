[http://openfda.ventera.com/web/#/](http://openfda.ventera.com/web/#/)

##Summary:
This web-based application enables users to search and filter adverse reactions related to the intake of specific drugs based off publicly-available FDA Drug Incident Reports. The goal is to both help people understand what adverse reactions may occur and arm them with information to ask the right questions to their medical providers. The application consumes a public API of drug interactions and provides a robust means of searching one or more drugs, while displaying potential reactions in an easy-to-understand collection of graphics, tables and references to NIH definitions of drugs and reactions.

![marketing] (https://github.com/akulasainath/18frepo/blob/master/18F%20Evidence/Marketing%20One-Pager.jpg)

*For a closer look at this Marketing 1-pager, click[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FMarketing%2520One-Pager.jpg&sa=D&sntz=1&usg=AFQjCNGUndBwUq4hUEt5hNxA6X3qnMEaLw)[here](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FMarketing%2520One-Pager.jpg&sa=D&sntz=1&usg=AFQjCNGUndBwUq4hUEt5hNxA6X3qnMEaLw).*

##About Ventera
Ventera Corporation is a small business, delivering high-value technology outcomes to both the private sector and the federal government for nearly two decades. Two of our largest federal clients—the USDA Food and Nutrition Service and the Department of Homeland Security—have embraced our Agile Scrum methodology as a proven means of ensuring valuable, user-centric solutions.

##Project Approach
When the RFQ was released, the selected Product Manager, Swati Khandewale, had the authority to make both budget and implementation decisions regarding the prototype.

The Product Owner (PO) team used a lean approach when initially presented with the RFQ prompt. The first step in that approach involved defining both a problem hypothesis and a customer hypothesis. Assumptions surrounding those hypotheses were then validated or invalidated through analysis of data provided in OpenFDA APIs and conversations with potential users. Our team then determined a goal for the prototype and concluded a high-level user story:

As a concerned patient, family member, or friend, I want access to information in past FDA Drug Incident Reports so that I am aware of patient drug reactions.

Personas were identified to ensure that user stories developed for the prototype addressed specific user needs.  Detailed user stories and tasks were created in a[ ](https://github.com/akulasainath/18frepo/issues)[Product Backlog](https://github.com/akulasainath/18frepo/issues).  Each user story was prioritized to ensure that the most impactful items were completed first.

The team decided Kanban was a more appropriate Agile methodology for a project with the time constraint (Ventera usually employs a Scrum approach).  Kanban allowed Ventera to deliver value quickly while minimizing waste. Frequent user story prioritization ensured that every feature added to the prototype provided value.

A co-located cross-disciplinary[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FOrg%2520Chart.png&sa=D&sntz=1&usg=AFQjCNGdLu3sryZMuohz04lp6niawAZW4Q)[Technical Team was assembled](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FOrg%2520Chart.png&sa=D&sntz=1&usg=AFQjCNGdLu3sryZMuohz04lp6niawAZW4Q) for implementation purposes. The discovery phase allowed the Technical Team to determine the application’s architecture and technical stack and also provided the PO team with the opportunity to ensure that the Technical Team was aligned with project goals and objectives.  The PO team elaborated the highest priority user stories for the initial iteration. A designer worked with both teams to create wireframes for the initial implementation approach. A live Design[ ](http://www.google.com/url?q=http%3A%2F%2Fopenfdatest.ventera.com%2F18Fstyles%2Fstyle-guide%2F&sa=D&sntz=1&usg=AFQjCNHCzm4yIRGNBQOzqCE6H7Ko2dQ36A)[Style Guide](http://www.google.com/url?q=http%3A%2F%2Fopenfdatest.ventera.com%2F18Fstyles%2Fstyle-guide%2F&sa=D&sntz=1&usg=AFQjCNHCzm4yIRGNBQOzqCE6H7Ko2dQ36A) was created in order to remain in sync with the code.

The Ventera team applied many Agile best practices from a technical perspective.

* Agile Tenet \#1: Value individuals and interactions over processes and tools:  During implementation, Ventera employed an[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FIterative%2520Approach.docx&sa=D&sntz=1&usg=AFQjCNHVrKZ5hJju5Toj0oY-kAHBS1qrnA)[iterative approach](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FIterative%2520Approach.docx&sa=D&sntz=1&usg=AFQjCNHVrKZ5hJju5Toj0oY-kAHBS1qrnA) using daily standup meetings and application demos to collect feedback from the PO team for each iteration. The team’s key area of focus was to achieve a “quick win” from the first iteration.

* Agile Tenet \#2: Value working software over comprehensive documentation. The team set and successfully achieved a key goal by delivering a minimally viable product (MVP)[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fcommit%2Fc132cdc2f5b38abb7b32e2eb916384921c4ebff6&sa=D&sntz=1&usg=AFQjCNFG3fob787lQUknWHxSi1gRGK3Pww)[within 12 hours of discovery](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fcommit%2Fc132cdc2f5b38abb7b32e2eb916384921c4ebff6&sa=D&sntz=1&usg=AFQjCNFG3fob787lQUknWHxSi1gRGK3Pww).

* Agile Tenet \#3: Value customer collaboration over contract negotiation: A user survey was created to solicit and incorporate feedback from potential users outside of the team in order to full understand what people need.

* Agile Tenet \#4: Value responding to change over following a plan:[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Ftree%2Fe6bcf90de20e66e22aa2e9024696c71ca873c757%2F18F%2520Evidence%2FUser%2520Centered%2520Design%2520Evidence&sa=D&sntz=1&usg=AFQjCNGL9pJn_PzDT7Qo9FFhhTJgswB7YA)[Human-centered design techniques](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Ftree%2Fe6bcf90de20e66e22aa2e9024696c71ca873c757%2F18F%2520Evidence%2FUser%2520Centered%2520Design%2520Evidence&sa=D&sntz=1&usg=AFQjCNGL9pJn_PzDT7Qo9FFhhTJgswB7YA) were employed during the design and development of the prototype. The team conducted a usability survey and ensured that feedback from the survey, along with demo feedback and feedback from a Heuristics Evaluation was added to the[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fissues%3Futf8%3D%25E2%259C%2593%26q%3Dis%253Aissue%2B&sa=D&sntz=1&usg=AFQjCNHrWBqTaLYixbaLcPUi6EXqrQYu-g)[GitHub Product Backlog](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fissues%3Futf8%3D%25E2%259C%2593%26q%3Dis%253Aissue%2B&sa=D&sntz=1&usg=AFQjCNHrWBqTaLYixbaLcPUi6EXqrQYu-g) as new user stories and prioritized by the PO team for subsequent iterations.  This continuous feedback loop allowed the team to ensure that user needs drove scope.

* Test-driven approach: Major focus was placed on quality assurance, automated testing, and continuous monitoring.

  * Jenkins was used for[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fissues%2F26&sa=D&sntz=1&usg=AFQjCNFShZBKrqq6AI54Uz9ivlhDm72rgg)[continuous integration](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fissues%2F26&sa=D&sntz=1&usg=AFQjCNFShZBKrqq6AI54Uz9ivlhDm72rgg) for our test and production builds, allowing multiple builds a day, ensuring that delivery wasn’t slowed by infrequent integration. Jenkin’s clones the source code directly from GitHub and then performs the necessary build tasks and deployment procedures

  * Our source code and Karma test classes are analyzed with SonarQube Javascript metrics, as part of every Jenkins build/deployment to the Test environment

  * The team also employed[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fissues%2F24&sa=D&sntz=1&usg=AFQjCNHiWvXuRhZoESz_YEEe9NeMA76oiA)[unit](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fissues%2F24&sa=D&sntz=1&usg=AFQjCNHiWvXuRhZoESz_YEEe9NeMA76oiA) and integration testing techniques to ensure that implemented functionality met acceptance criteria.  A Karma-Jasmine testing framework was used to unit test implemented functionality.

  * The automated test framework includes Selenium WebDriver, Maven, and TestNG.

  * CloudAware, CloudWatch, and Modit were used in a 3-pronged approach to[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FContinuous%2520Monitoring%2520Evidence%2FContinuous%2520Monitoring%2520Evidence.docx&sa=D&sntz=1&usg=AFQjCNE4NWH2DYfxyMqNJBc9jiG7qV1P8Q)[continuous monitoring](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FContinuous%2520Monitoring%2520Evidence%2FContinuous%2520Monitoring%2520Evidence.docx&sa=D&sntz=1&usg=AFQjCNE4NWH2DYfxyMqNJBc9jiG7qV1P8Q).

  * The prototype was evaluated for[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FResponsive%2520Design%2520Video.pptx&sa=D&sntz=1&usg=AFQjCNEXxjR1j4HpceA71M4P6AUSqSezXQ)[responsive design](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FResponsive%2520Design%2520Video.pptx&sa=D&sntz=1&usg=AFQjCNEXxjR1j4HpceA71M4P6AUSqSezXQ) on multiple platforms using an emulator tool.

  * GitHub was used for Configuration Management.

##Open Source Applications:
This prototype utilizes multiple open source frontend and backend technologies, including 10+ modern technologies that had the first stable release in the past 5 years.  All technology used to create the prototype is openly licensed and free of charge:

* [ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2F&sa=D&sntz=1&usg=AFQjCNHReqsuKT6C86HcgL4TbSevF24rxQ)[GitHub](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2F&sa=D&sntz=1&usg=AFQjCNHReqsuKT6C86HcgL4TbSevF24rxQ)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fwww.eclipse.org%2Fluna%2F&sa=D&sntz=1&usg=AFQjCNEtBd0-vrSJ11Ggi5mnX0LVRplOfA)[Eclipse Luna](https://www.google.com/url?q=https%3A%2F%2Fwww.eclipse.org%2Fluna%2F&sa=D&sntz=1&usg=AFQjCNEtBd0-vrSJ11Ggi5mnX0LVRplOfA)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FHTML5&sa=D&sntz=1&usg=AFQjCNFSjGM1LI5s3kJ-wMx8KXhr5zGImg)[HTML5](https://www.google.com/url?q=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FHTML5&sa=D&sntz=1&usg=AFQjCNFSjGM1LI5s3kJ-wMx8KXhr5zGImg)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fjquery.com%2F&sa=D&sntz=1&usg=AFQjCNHwHug0a3dAQeHj3gBsPltK-jTsaQ)[jQuery](https://www.google.com/url?q=https%3A%2F%2Fjquery.com%2F&sa=D&sntz=1&usg=AFQjCNHwHug0a3dAQeHj3gBsPltK-jTsaQ)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fangularjs.org%2F&sa=D&sntz=1&usg=AFQjCNGRyGh9RrGsnTyFsZ7ht8qCmaF8Pw)[angularJS](https://www.google.com/url?q=https%3A%2F%2Fangularjs.org%2F&sa=D&sntz=1&usg=AFQjCNGRyGh9RrGsnTyFsZ7ht8qCmaF8Pw)

* [ ](http://www.google.com/url?q=http%3A%2F%2Fgetbootstrap.com%2F&sa=D&sntz=1&usg=AFQjCNFcuWE7kcMSjG0AtLf81JzsTheXPQ)[Bootstrap](http://www.google.com/url?q=http%3A%2F%2Fgetbootstrap.com%2F&sa=D&sntz=1&usg=AFQjCNFcuWE7kcMSjG0AtLf81JzsTheXPQ)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fnodejs.org%2F&sa=D&sntz=1&usg=AFQjCNHswJNMhgW-o3Z2bHy6y33tlwEIug)[NodeJS](https://www.google.com/url?q=https%3A%2F%2Fnodejs.org%2F&sa=D&sntz=1&usg=AFQjCNHswJNMhgW-o3Z2bHy6y33tlwEIug)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fwww.npmjs.com%2Fpackage%2Fkarma&sa=D&sntz=1&usg=AFQjCNHDzUD-f3SmEVW_0kDSRozxI62I-Q)[Karma-Jasmine](https://www.google.com/url?q=https%3A%2F%2Fwww.npmjs.com%2Fpackage%2Fkarma&sa=D&sntz=1&usg=AFQjCNHDzUD-f3SmEVW_0kDSRozxI62I-Q)

* [ ](http://www.google.com/url?q=http%3A%2F%2Ftestng.org%2Fdoc%2Findex.html&sa=D&sntz=1&usg=AFQjCNFRpFZscuyy5mXLQW86vISIeXzaHA)[TestNG](http://www.google.com/url?q=http%3A%2F%2Ftestng.org%2Fdoc%2Findex.html&sa=D&sntz=1&usg=AFQjCNFRpFZscuyy5mXLQW86vISIeXzaHA)

* [ ](https://maven.apache.org/)[Maven](https://maven.apache.org/)

* [ ](http://www.google.com/url?q=http%3A%2F%2Fjmeter.apache.org%2F&sa=D&sntz=1&usg=AFQjCNEjy20Gkbw6RjmYvO20Xoem04zoig)[jMeter](http://www.google.com/url?q=http%3A%2F%2Fjmeter.apache.org%2F&sa=D&sntz=1&usg=AFQjCNEjy20Gkbw6RjmYvO20Xoem04zoig)

* [ ](http://www.google.com/url?q=http%3A%2F%2Fwww.seleniumhq.org%2Fprojects%2Fwebdriver%2F&sa=D&sntz=1&usg=AFQjCNF16LQEfN-C_wX44I09KOV_bsJ4qw)[Selenium WebDriver](http://www.google.com/url?q=http%3A%2F%2Fwww.seleniumhq.org%2Fprojects%2Fwebdriver%2F&sa=D&sntz=1&usg=AFQjCNF16LQEfN-C_wX44I09KOV_bsJ4qw)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fjenkins-ci.org%2F&sa=D&sntz=1&usg=AFQjCNGqYWv2Ut5FuwrOOHimM0aOOLtM-A)[Jenkins](https://www.google.com/url?q=https%3A%2F%2Fjenkins-ci.org%2F&sa=D&sntz=1&usg=AFQjCNGqYWv2Ut5FuwrOOHimM0aOOLtM-A)

* [ ](http://www.google.com/url?q=http%3A%2F%2Fhttpd.apache.org%2F&sa=D&sntz=1&usg=AFQjCNEnE18Zqwca67qcEKHyyk34gCmIlQ)[Apache HTTP server](http://www.google.com/url?q=http%3A%2F%2Fhttpd.apache.org%2F&sa=D&sntz=1&usg=AFQjCNEnE18Zqwca67qcEKHyyk34gCmIlQ)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fmmonit.com%2F&sa=D&sntz=1&usg=AFQjCNHGhR06Eob7cA6Nn0xayYUph3hePQ)[Monit](https://www.google.com/url?q=https%3A%2F%2Fmmonit.com%2F&sa=D&sntz=1&usg=AFQjCNHGhR06Eob7cA6Nn0xayYUph3hePQ)

* [ ](https://www.google.com/url?q=https%3A%2F%2Fwww.docker.com%2F&sa=D&sntz=1&usg=AFQjCNE5nyFU509RkAzKxHJaHHo4XAXEsQ)[Docker](https://www.google.com/url?q=https%3A%2F%2Fwww.docker.com%2F&sa=D&sntz=1&usg=AFQjCNE5nyFU509RkAzKxHJaHHo4XAXEsQ)

* [ ](http://www.google.com/url?q=http%3A%2F%2Fphantomjs.org%2F&sa=D&sntz=1&usg=AFQjCNGlZm-5n0EwflGB_FXNHwWFAd0CTg)[PhantomJS](http://www.google.com/url?q=http%3A%2F%2Fphantomjs.org%2F&sa=D&sntz=1&usg=AFQjCNGlZm-5n0EwflGB_FXNHwWFAd0CTg)

For additional description of each tool, see the[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FTechnical%2520Stack%2520Description.docx&sa=D&sntz=1&usg=AFQjCNFL2eKsBWArAhdOgSOoeA19Y-TSew)[Technical Stack Description.](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FTechnical%2520Stack%2520Description.docx&sa=D&sntz=1&usg=AFQjCNFL2eKsBWArAhdOgSOoeA19Y-TSew)



##Infrastructure as a Service:
This prototype is deployed using Amazon Web Services (AWS) Infrastructure as a Service for compute capacity in the cloud. The following are all AWS technologies that were used:

* [ ](http://www.google.com/url?q=http%3A%2F%2Faws.amazon.com%2Fec2%2F&sa=D&sntz=1&usg=AFQjCNGdVfqGba8hJnfnihNs2-MtB2HynA)[AWS EC2 Server](http://www.google.com/url?q=http%3A%2F%2Faws.amazon.com%2Fec2%2F&sa=D&sntz=1&usg=AFQjCNGdVfqGba8hJnfnihNs2-MtB2HynA) Instances running[ ](http://www.google.com/url?q=http%3A%2F%2Fwww.ubuntu.com%2Fserver&sa=D&sntz=1&usg=AFQjCNH_gAG3c5ND0EF3m09_PD42-IzNmw)[Ubuntu](http://www.google.com/url?q=http%3A%2F%2Fwww.ubuntu.com%2Fserver&sa=D&sntz=1&usg=AFQjCNH_gAG3c5ND0EF3m09_PD42-IzNmw)

* [ ](http://www.google.com/url?q=http%3A%2F%2Faws.amazon.com%2Felasticloadbalancing%2F&sa=D&sntz=1&usg=AFQjCNENWPF_qj6ACSzqNMzAltm_1M2cgg)[AWS EC2 Elastic Load Balancers](http://www.google.com/url?q=http%3A%2F%2Faws.amazon.com%2Felasticloadbalancing%2F&sa=D&sntz=1&usg=AFQjCNENWPF_qj6ACSzqNMzAltm_1M2cgg) and [] (http://aws.amazon.com/autoscaling/) [Auto Scaling Groups](http://aws.amazon.com/autoscaling/)

* [ ](http://www.google.com/url?q=http%3A%2F%2Faws.amazon.com%2Fcloudwatch%2F&sa=D&sntz=1&usg=AFQjCNEzxHOwyQLOs4SyLrAhvdY2C57i6g)[Amazon CloudWatch Monitoring](http://www.google.com/url?q=http%3A%2F%2Faws.amazon.com%2Fcloudwatch%2F&sa=D&sntz=1&usg=AFQjCNEzxHOwyQLOs4SyLrAhvdY2C57i6g)

* [ ](http://www.google.com/url?q=http%3A%2F%2Faws.amazon.com%2Froute53%2F&sa=D&sntz=1&usg=AFQjCNFOq11_4vvmuny6_ZalngX20thp-A)[AWS Route 53](http://www.google.com/url?q=http%3A%2F%2Faws.amazon.com%2Froute53%2F&sa=D&sntz=1&usg=AFQjCNFOq11_4vvmuny6_ZalngX20thp-A)

##Deployment Process
1. In order to run our application, an HTTP web server must be installed on your system. Download and installation instructions, per your specific environment, can be found at[ ](http://www.google.com/url?q=http%3A%2F%2Fhttpd.apache.org%2Fdownload.cgi%23apache24&sa=D&sntz=1&usg=AFQjCNFJsyw7U-goTLitWegXm5dXDQ5nYQ)[http://httpd.apache.org/download.cgi\#apache24](http://www.google.com/url?q=http%3A%2F%2Fhttpd.apache.org%2Fdownload.cgi%23apache24&sa=D&sntz=1&usg=AFQjCNFJsyw7U-goTLitWegXm5dXDQ5nYQ).

  a) For our local deployment we used Apache HTTP 2.4 ([http://httpd.apache.org/docs/2.4/](http://www.google.com/url?q=http%3A%2F%2Fhttpd.apache.org%2Fdocs%2F2.4%2F&sa=D&sntz=1&usg=AFQjCNH1qT11A09mmobi6yBvS7RXNbBR7Q)).

  b) For Windows, Apache 2.4 binaries VC10 at[ ](http://www.google.com/url?q=http%3A%2F%2Fwww.apachelounge.com%2Fdownload%2F&sa=D&sntz=1&usg=AFQjCNHUkqnWB_vveeZf5ECu8vvb91ouEQ)[http://www.apachelounge.com/download/](http://www.google.com/url?q=http%3A%2F%2Fwww.apachelounge.com%2Fdownload%2F&sa=D&sntz=1&usg=AFQjCNHUkqnWB_vveeZf5ECu8vvb91ouEQ) is recommended for use.

  c) Download your version of Apache to the C:\\ directory and unzip to the same location. If you do not download and unzip to C:\\, please be sure to update the ServerRoot within your httpd.conf located in \\Apache24\\conf.

  d) Of course, other web server installations can be used, allowing for versatility across many environments. For example, NPM package manager provides a simple zero-configuration command-line http server.

   * npm install http-server -g

2. Clone the repository at[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo.git&sa=D&sntz=1&usg=AFQjCNFTLEnd3RSyfHrGMZGptOqKuWbeCw)[https://github.com/akulasainath/18frepo.git](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo.git&sa=D&sntz=1&usg=AFQjCNFTLEnd3RSyfHrGMZGptOqKuWbeCw), using the desired branch (Release branch).

   * git clone[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo.git&sa=D&sntz=1&usg=AFQjCNFTLEnd3RSyfHrGMZGptOqKuWbeCw)[https://github.com/akulasainath/18frepo.git](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo.git&sa=D&sntz=1&usg=AFQjCNFTLEnd3RSyfHrGMZGptOqKuWbeCw)

  a) The repository can also be download directly from any internet browser:

3. Move the entire /18FDemo/web directory of the cloned repository to the /htdocs directory (Apache), or the default configured directory, of your HTTP web server installation directory.

4. Start the HTTP web server. Apache instructions can be found at[ ](http://www.google.com/url?q=http%3A%2F%2Fhttpd.apache.org%2Fdocs%2F2.4%2Finvoking.html&sa=D&sntz=1&usg=AFQjCNEXLibRrhU4S_Ml5rhLIGej_rH1hw)[http://httpd.apache.org/docs/2.4/invoking.html](http://www.google.com/url?q=http%3A%2F%2Fhttpd.apache.org%2Fdocs%2F2.4%2Finvoking.html&sa=D&sntz=1&usg=AFQjCNEXLibRrhU4S_Ml5rhLIGej_rH1hw).

5. If deployed correctly using the default Apache configuration settings, the application should be available at:[ ](http://www.google.com/url?q=http%3A%2F%2Flocalhost%2Fweb%2F&sa=D&sntz=1&usg=AFQjCNGODMRsv_wGhWUgdZRYd5L0NMZioQ)[http://localhost:80/web/](http://www.google.com/url?q=http%3A%2F%2Flocalhost%2Fweb%2F&sa=D&sntz=1&usg=AFQjCNGODMRsv_wGhWUgdZRYd5L0NMZioQ)

##Docker Instructions
For detailed instructions for deploying from a Docker Container, click[ ](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FDeploying%2520from%2520a%2520Docker%2520Container.docx&sa=D&sntz=1&usg=AFQjCNGhyYmw2gRI39BCpQ6sBB3Q70UyCQ)[here.](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fakulasainath%2F18frepo%2Fblob%2Fmaster%2F18F%2520Evidence%2FDeploying%2520from%2520a%2520Docker%2520Container.docx&sa=D&sntz=1&usg=AFQjCNGhyYmw2gRI39BCpQ6sBB3Q70UyCQ)

##Contact Information

Chris Ford

EVP, Partner

Ventera Corporation

703-442-5220

cford@ventera.com

