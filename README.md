# Pattern-Recognition-Exercise
# 1. Technology Used
Springboot, jdk 1.8, maven

# 2. Problem Solving Rough Overview

Rules on Line creation
Lines must have atleast 2 points
to have more than two points this program  calculate the slope in between 3 points and add the new point as a new 
line segment or in other words create a new point on the datastorage space.

Memory
prepare two the same type of datastore, using Singleton creation design pattern
1, Real Implmentation uses this ArrayList<Set<String>>
2, for better performance the program proposed Concurenthashmap<String, List<String>> to efficiently manage concurent threads execution, other mechanism can be proposed

## POST point
new point creation or Line segment expannsion by adding new point starts in time of the first Post method execution
creatrion of new ine segment with incremental Index, or updating existing line segment with new entry point manipulated in the datastore

## GET Point
get all inserted points, starting line by line from the datastore

## Delete Space
delete all the points from the space, datastore

## Get 
this reduces the complexity of searching, its needed to search a lines


# 3: Complexity
space:  uses for n number of point inputs at least n/2 record/space usage, since atleast every 2 points must create a line 
Insertion and searching a given point require the same complexity O(K) which is < O(n/2) best case worst case = O(n/2)=O(n) is K constants, n number of points

all operation performed JVM memeory 


#  4: Exception

the program manage errored input or improper Json binding also incorrect input
MethodArgumentNotValidException
HttpMessageNotReadableException

additionall other jdk exceptions too

for detail documentation the program documented well on respective Java api, on block of codes too
                                                                                        
# 5: Dockerizing
 to execute as a docker image you can execute the following series command, i created Dockerfile inside the project
     
     - java -jar ./target/Pattern-Recognition-Exercise-0.0.1.jar  

     - docker build -t Pattern-Recognition-Test .
     
     - docker run -it -p 8080:8080 pattern-recognition-test
