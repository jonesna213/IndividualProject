# Journal

This Document Is a weekly journal of the progress made on the independent project.


### Week 2

9/6/2022 - 2 hours

Tasks Completed:
 * Created the Directory structure/GitHub repo
 * Chose the project im going to be doing
 * Started writing project plan

### Week 3

9/16/2022 - 3 hours

Tasks Completed:
 * Finished problem statement
 * Finished User Stories
 * Finished Project plan
 * Started on Screen Designs

### Week 4

9/19/2022 - 2.5 hours

Tasks Completed:
 * Finished Screen Designs
 * Submitted for first checkpoint

### Week 5

9/27/2022 -  2.5 hours

Tasks Completed:
 * Remade Screens designs and redid readme, project plan and user stories for change in project direction
 * Completed homepage with head, header, and footer in separate pages for includes

9/28/2022 - 30 minutes

Tasks Completed:
 * Started getting a layout of what the ERD will probably look like. Wasn't sure of all fields since im not sure 1,
what data im going to get from JSoup and 2, I'm not sure what exactly Amazon Cognito is yet.

### Week 7

10/11/2022 - 4.5 hours

Tasks Completed:
 * Implemented aws cognito
 * Got sign in, sign up, and sign out all working great
 * Completed unit tests for User dao (without the parts many-to-many table)

10/12/2022 - 30 minutes 

Tasks Completed:
 * Updated create script to have all the tables needed (from what I think right now)
 * Started trying to figure out how to get hibernate working with database with all the relationships (mostly 
researching, not much code was written sadly)

10/13/2022 - 5 hours

Tasks Completed:
 * Completed getting hibernate working with database for all the relationships
 * Completed all dao tests (There was a problem with the equals method, so I had to redo a lot of the tests because for
some reason I was getting either nullPointerException or stackOverflowException with them in the part and merchant classes)

### Week 8

10/18/2022 - 1 hour

Tasks Completed:
 * Got view/edit profile working (Just going to update database for now)
 * implemented JQuery Form validation

10/19/2022 - 1.5 hours

Tasks Completed:
 * Got hibernate working correctly and updated tests to account for it. Thought it was correct before but when a user 
was deleted it deleted the part that was with the user in the saved parts table. Did the same thing with merchants and 
parts. But its working correctly now.

10/21/2022 - 2.5 hours

Tasks Completed:
 * Made progress on view parts page as well as the servlet for it
 * Made more progress on jsoup for rock auto

### Week 9

10/25/2022 - 1 hour

Tasks Completed:
 * Created saved parts page
 * Created view prices page

10/26/2022 - 2.5 hours

Tasks Completed:
 * Made progress on rock auto jsoup scraping. Think im about ready to start populating database with part info.

10/28/2022 - 5.5 hours

Tasks Completed:
 * Got parts inserted into database, FINALLY!!!
 * Deployed to aws
 * Configured aws to allow cognito logins
 * Configured aws database to have current database
 * Submitted checkpoint 3
 * Got view parts jsp looking good on mobile
 * Got saved parts jsp working
 * Realized I made a big mistake.... The parts image file location is saved as rock auto's website... not where it's
located in the project. Merchant logo image is saved correctly but doesn't show up...
 * Fixed images problem after some debugging I just decided to put them in the webapp dir

### Week 10

This week was not as productive as the last few weeks. I've been working on the team project as well as other classes,
so I wasn't able to do much for this project this week. I did do the recommendations from checkpoint 3, and I did 
start doing some research on how to implement google's recaptcha. I'm thinking since I cant directly change the UI of 
cognito im going to have it go to a recaptcha page before it goes to auth then if they pass the recaptcha it will then 
go to auth and continue signing in. I am going to look into this a little more to see if there's an easier/nicer way to 
do this because I feel like this might cause some problems with cognito.

### Week 11

This was another not so productive week...

11/11/2022 - 4 hours

Tasks Completed:
 * Made a bit of progress on the OReilly web scraping
 * Did research on recaptcha with cognito and didn't find anything that would help... Might have to find a different api.


### Week 12

11/18/2022 - 2 hours

Tasks Completed:
 * Got OReilly working for the brake pads which gives a duplicate part which demonstrates everything works.
 * Fixed ImageDownloader

### Week 13

11/25/2022 - 1 hour

Tasks Completed:
 * Touched up a few things
 * Changed up web scraping directory

11/26/2022 - 3 hours

Tasks Completed:
 * Got searching for parts working
 * I believe all the site functionality is done now. (Besides some api that I have yet to find/implement)
 * Uploaded current code to aws and updated aws database with new parts

### Week 14

11/28/2022 - 1 hour

Tasks Completed:
 * Went through current code and made sure I had all java doc and comments were necessary
 * Refactored some code


### Week 15

12/7/2022 - 3.5 hours

Tasks Completed:
 * Chose to use a weather api to display the weather in the header. I couldn't find an api that would make sense with
the rest of the project/add to the rest of the project, so I just decided that I should at least have some type of api.
 * Got weather dao set up as well as the api's java classes. Couldn't create unit tests because the results will be 
different each time its used... it's a weather api.
 * Changed the database and related to have a zip column for the api.
 * Fully implemented weather api and deployed new version of project to aws
 * As of now I believe all the actual website stuff is complete besides adding more parts from jsoup scraping