# Pattern-Recognition-Exercise
# 1. Technology Used
Springboot, jdk 1.8, maven

# 2. Problem Solving Rough Overview

Lines must have atleast 2 points
to have more than two points this program  calculate the slope in between 3 points and add the new point as a new 
line segment or in other words create a new point.

Memory
prepare two the same type of datastore, using Singleton creation design pattern
1, Real Implmentation uses this ArrayList<List<String>>
2, for better performance the program proposed Concurenthashmap<String, List<String>> to efficiently manage concurent threads calling

## POST point
new point creation or Line segment expannsion by adding new point starts in time of the first method execution
creatrion of new ine segment with incremental Index, or updating existing line segment with new entry point manipulated in the datastore

## GET Point
get all inserted points, starting line by line from the datastore

## Delete Space
delete all the points from the space, datastore

## Get 
this reduces the complexity of searching, its needed to search a lines


# 3: Complexity
space: can uses for n number of at least n/2 record/space usage , since atleast every 2 points must create a line 
Insertion and searching a given point require the same complexity O(K) k is constants

all operation performed in JVM in memeory 


#  4: Exception

the program manage errored input or faulty Json binding, incorrect input
MethodArgumentNotValidException
HttpMessageNotReadableException

and other jdk exceptions

for detaile documentation the program has welly documentation on the internal Java api and if necessary on the lines
