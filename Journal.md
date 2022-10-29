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