$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/income.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# new feature"
    },
    {
      "line": 2,
      "value": "# Tags: optional"
    }
  ],
  "line": 4,
  "name": "income",
  "description": "    As a user\r\n    I can add income to ledger\r\n    so that I can view balance",
  "id": "income",
  "keyword": "Feature"
});
formatter.before({
  "duration": 65444,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Normal income",
  "description": "",
  "id": "income;normal-income",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "a user have balance 200 exists",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I earned 100 from work",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "balance is 300",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 20
    }
  ],
  "location": "StepDefLedger.a_user_have_balance_exists(int)"
});
formatter.result({
  "duration": 60569917,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 9
    },
    {
      "val": "work",
      "offset": 18
    }
  ],
  "location": "StepDefLedger.i_earned_from(int,String)"
});
formatter.result({
  "duration": 602786,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "300",
      "offset": 11
    }
  ],
  "location": "StepDefLedger.balance_is_minus(int)"
});
formatter.result({
  "duration": 29458252,
  "status": "passed"
});
});