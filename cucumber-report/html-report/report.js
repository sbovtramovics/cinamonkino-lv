$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("addNewAlbum.feature");
formatter.feature({
  "line": 2,
  "name": "Scenarios containing user story: Add New Album",
  "description": "",
  "id": "scenarios-containing-user-story:-add-new-album",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@addNewAlbum"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "New published Album test",
  "description": "",
  "id": "scenarios-containing-user-story:-add-new-album;new-published-album-test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@NewPubishedAlbumTests"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Log in as admin",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Click on Photo Gallery button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Click on Albums button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "click on Add New button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User input Album name: \"Album1\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User input Slug name: \"Fun album\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User input short description: \"Short description\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "User choses published option: \"Yes\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User clicks on preview image",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User adds chosen picture",
  "keyword": "And "
});
formatter.match({
  "location": "logInAsAdminStepDef.logInAsAdmin()"
});
formatter.result({
  "duration": 10698331031,
  "status": "passed"
});
formatter.match({
  "location": "JevgenijsJeremejevsSteps.clickOnPhotoGalleryButton()"
});
formatter.result({
  "duration": 6926305756,
  "status": "passed"
});
formatter.match({
  "location": "JevgenijsJeremejevsSteps.clickOnAlbumsButton()"
});
formatter.result({
  "duration": 1616649959,
  "status": "passed"
});
formatter.match({
  "location": "JevgenijsJeremejevsSteps.clickOnAddNewButton()"
});
formatter.result({
  "duration": 1690225635,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Album1",
      "offset": 24
    }
  ],
  "location": "JevgenijsJeremejevsSteps.userInputAlbumName(String)"
});
formatter.result({
  "duration": 5203546895,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fun album",
      "offset": 23
    }
  ],
  "location": "JevgenijsJeremejevsSteps.userInputSlugName(String)"
});
formatter.result({
  "duration": 194909480,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Short description",
      "offset": 31
    }
  ],
  "location": "JevgenijsJeremejevsSteps.userInputShortDescription(String)"
});
formatter.result({
  "duration": 313473475,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Yes",
      "offset": 31
    }
  ],
  "location": "JevgenijsJeremejevsSteps.userChosesPublishedOption(String)"
});
formatter.result({
  "duration": 54366405,
  "status": "passed"
});
formatter.match({
  "location": "JevgenijsJeremejevsSteps.userClicksOnPreviewImage()"
});
formatter.result({
  "duration": 1844166193,
  "status": "passed"
});
formatter.match({
  "location": "JevgenijsJeremejevsSteps.userAddsChosenPicture()"
});
formatter.result({
  "duration": 320782768,
  "status": "passed"
});
});