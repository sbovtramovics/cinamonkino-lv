$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyTestSteps.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "",
  "id": "",
  "keyword": "Feature"
});
formatter.background({
  "line": 2,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 3,
  "name": "I go to the main page: \"https://cinamonkino.lv/\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "https://cinamonkino.lv/",
      "offset": 24
    }
  ],
  "location": "MyStepDefinitions.iGoToTheMainPage(String)"
});
formatter.result({
  "duration": 6216209332,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 5,
      "value": "#Preparing:"
    },
    {
      "line": 6,
      "value": "#Web: cinamonkino.lv"
    },
    {
      "line": 7,
      "value": "#Register account in cinamonkino.lv using www.mailinator.com (free emails). Name and Surname, must be: Neo and Tech"
    },
    {
      "line": 8,
      "value": "#User/Pass - should be incl. in test"
    }
  ],
  "line": 12,
  "name": "",
  "description": "",
  "id": ";",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@MyMainTest"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I sign in",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I enter the email: \"sbovtramovics@mailinator.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I enter the password: \"zxcvasdf\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I press submit button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I check that the Name is \"Neo\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I check the the Surname is \"Tech\"",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I select the film from the list",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I choose the time from the list",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I press booking button",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I add 2 tickets",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I store the sum",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I type random text in coupon field",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I scroll down the page",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I press validate button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I check that validation works",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I press Next",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I scroll down the page",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I check first random seat at the last row if available",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I check second random seat at the penult row if available",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I store the seat numbers",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I press Next again",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "I check stored sum",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I check stored seats",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I scroll down the page",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "I change the order by clicking change the order button",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I add 1 tickets",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "I store the sum",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "I scroll down the page",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "I press Next",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "I scroll down the page",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I press Next again",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "I check stored sum",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "I check availability of 5 payment methods",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "I logout",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepDefinitions.iSignIn()"
});
formatter.result({
  "duration": 1208739118,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sbovtramovics@mailinator.com",
      "offset": 20
    }
  ],
  "location": "MyStepDefinitions.iEnterTheEmail(String)"
});
formatter.result({
  "duration": 155721736,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zxcvasdf",
      "offset": 23
    }
  ],
  "location": "MyStepDefinitions.iEnterThePassword(String)"
});
formatter.result({
  "duration": 87855830,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iPressSubmitButton()"
});
formatter.result({
  "duration": 1248833260,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Neo",
      "offset": 26
    }
  ],
  "location": "MyStepDefinitions.iCheckThatTheNameIs(String)"
});
formatter.result({
  "duration": 3753285625,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Tech",
      "offset": 28
    }
  ],
  "location": "MyStepDefinitions.iCheckTheTheSurnameIs(String)"
});
formatter.result({
  "duration": 51690630,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iClickToTheFilmList()"
});
formatter.result({
  "duration": 2768039448,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iChooseTheTimeFromTheList()"
});
formatter.result({
  "duration": 190508401,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iPressBookingButton()"
});
formatter.result({
  "duration": 2436057903,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 6
    }
  ],
  "location": "MyStepDefinitions.iAddTickets(int)"
});
formatter.result({
  "duration": 166258782,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iStoreTheSum()"
});
formatter.result({
  "duration": 48467517,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iTypeRandomTextInCouponField()"
});
formatter.result({
  "duration": 108892134,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iScrollDownThePage()"
});
formatter.result({
  "duration": 1025711193,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iPressValidateButton()"
});
formatter.result({
  "duration": 1115997071,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iCheckThatValidationWorks()"
});
formatter.result({
  "duration": 41344853,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iPressNext()"
});
formatter.result({
  "duration": 1847714571,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iScrollDownThePage()"
});
formatter.result({
  "duration": 1001161142,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iCheckFirstRandomSeatAtTheLastRowIfAvailable()"
});
formatter.result({
  "duration": 129377024,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iCheckSecondRandomSeatAtThePenultRowIfAvailable()"
});
formatter.result({
  "duration": 82696237,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iStoreTheSeatNumbers()"
});
formatter.result({
  "duration": 82024930,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iPressNextAgain()"
});
formatter.result({
  "duration": 1342574105,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iCheckStoredSum()"
});
formatter.result({
  "duration": 36536075,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iCheckStoredSeats()"
});
formatter.result({
  "duration": 76709523,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iScrollDownThePage()"
});
formatter.result({
  "duration": 1000267310,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iChangeTheOrderByClikingChangeTheOrderButton()"
});
formatter.result({
  "duration": 1425525989,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 6
    }
  ],
  "location": "MyStepDefinitions.iAddTickets(int)"
});
formatter.result({
  "duration": 118926282,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iStoreTheSum()"
});
formatter.result({
  "duration": 43451609,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iScrollDownThePage()"
});
formatter.result({
  "duration": 1000670840,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iPressNext()"
});
formatter.result({
  "duration": 1824226761,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iScrollDownThePage()"
});
formatter.result({
  "duration": 1001038916,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iPressNextAgain()"
});
formatter.result({
  "duration": 1497564821,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iCheckStoredSum()"
});
formatter.result({
  "duration": 42419691,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 24
    }
  ],
  "location": "MyStepDefinitions.iCheckAvailabilityOfPaymentMethods(int)"
});
formatter.result({
  "duration": 21973055,
  "status": "passed"
});
formatter.match({
  "location": "MyStepDefinitions.iLogout()"
});
formatter.result({
  "duration": 1373192043,
  "status": "passed"
});
});