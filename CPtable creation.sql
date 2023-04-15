use carpool;


CREATE TABLE user (
userID int UNSIGNED AUTO_INCREMENT NOT NULL,
username varchar(40) NOT NULL,
password varchar(40) NOT NULL,
firstName varchar(40) NOT NULL,
lastName varchar(40) NOT NULL,
isDonor boolean DEFAULT false, 
hasActiveDonation boolean DEFAULT false,
PRIMARY KEY (userID)

);

CREATE TABLE vehicle (
plateNumber varchar(10) NOT NULL,
stateRegistered varchar(20) NOT NULL,
year int NOT NULL,
make varchar(40) NOT NULL,
model varchar(40) NOT NULL,
userID int UNSIGNED NOT NULL,

PRIMARY KEY(plateNumber,stateRegistered),
FOREIGN KEY(userId) REFERENCES user(userID)
);



/*
The donation table will be populated once a user clicks
"submit" on the donation page, with start time being the time that that 
button was pressed. The endTime will be updated once the user clicks disconnect

The date field will be modified in the future to automatically
enter the current date and time when the row is created
*/
CREATE TABLE donation(
donorID int UNSIGNED NOT NULL,
date date,
startTime time,
endTime time,
estimatedStay int,
actualStay int,
plateNumber varchar(10) NOT NULL,
stateRegistered varchar(20) NOT NULL,
isActive boolean DEFAULT true,

PRIMARY KEY (donorID, date, startTime),
FOREIGN KEY (plateNumber,stateRegistered) REFERENCES vehicle(plateNumber,stateRegistered),
FOREIGN KEY (donorID) REFERENCES user (userID)
);



CREATE TABLE job(
jobID int UNSIGNED AUTO_INCREMENT NOT NULL,
userID int UNSIGNED NOT NULL,
jobType varchar(50) NOT NULL,
jobDeadline datetime ,
startTime datetime ,
endTime datetime ,
duration int ,
redundancy int ,

PRIMARY KEY (jobID),
FOREIGN KEY (userID) REFERENCES user (userID)
);