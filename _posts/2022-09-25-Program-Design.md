---
toc: true
layout: post
description: Outlining the ideas for Scioly Website
categories: [markdown,pbl]
comments: true
title: Program Design Science Olympiad Website
---

# Idea: Science Olympiad Website

As many of our members are in Science Olympiad (4/8 of them), and we have friends in different classes, we decided to combine two teams to make one large group. Our idea was to make a Science Olympiad website, being able to create a database of current and past science olympiad members and assigning them to competitions. 

## Features (Wire Frame, Concept)

Overall, the design should include a navigation bar, with dropdown menus for things like events, rosters, and instructors. The events page should have a brief overview of each event, and perhaps a link can be put in each one for another page with further information. 

For the rosters, it should just be displaying the database, maybe with javascript styling and data management as seen in [this weeks javascript learning](https://supermengman.github.io/blog/jupyter/javascript/pbl/2022/09/25/Javascript.html).

As for events, there should be multiple areas for things like a calendar API, so others can request information on when a certain event or where it is.

A core feature would be the need for accounts. These accounts would have information logged directly into the rosters, and should update if they choose to update their information inside a profile tab. There should also be an option to choose desired events and add those categories into the roster. 

Another feature would be the creation of groups for events, where information of the group will be shared to all members of the group to allow them to find contact information quickly and easily. It would make organization easier than trying to interpret a google sheets. 

## Modeling/UML

![image](https://www.researchgate.net/profile/Dirk-Draheim/publication/262014927/figure/fig17/AS:392516034678787@1470594523085/Data-flow-diagram-of-a-system-login-and-registration-feature.png)

This is a diagram for how the data will be transferred between users and the website for logging in. Inside CurrentUser will be attributes like school, grade, and events, which would get updated regularly into the database. 

In addition, instructors should have more features in an admin area that is only accessible to them. There should be a database to check if the user is an instructor, and allow access to admin. This admin area will  have areas to set groups and delete users or change data as well in the database.