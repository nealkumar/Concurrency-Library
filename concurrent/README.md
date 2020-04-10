[![Maven Central](https://img.shields.io/maven-central/v/org.jbrew/concurrent.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.jbrew%22%20AND%20a:%22jbrew-parent%22)
[![Documentation](https://img.shields.io/badge/documentation-jbrew.org-000)](https://jbrew.org)
[![Build Status](https://codebuild.us-east-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiREpyWjkrdUNEODlGOWQvUExFVy9DNWdmWkRIZCs2ZGpJN0NDb3I5SW83SmRPbE9xSVlRcitqSi95NHUxc2JDeUowT3gyc2Y3K21ZSGpPbTNGREhScHRjPSIsIml2UGFyYW1ldGVyU3BlYyI6ImhIcG8rd1hGL0FJK2JBalAiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)](https://aws.amazon.com/codebuild/)
[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=org.jbrew:jbrew-parent&metric=alert_status)](https://sonarcloud.io/dashboard?id=org.jbrew:jbrew-parent)
[![codecov](https://codecov.io/gh/nealkumar/JBrew/branch/master/graph/badge.svg)](https://codecov.io/gh/nealkumar/JBrew)
[![CodeFactor](https://www.codefactor.io/repository/github/nealkumar/jbrew/badge)](https://www.codefactor.io/repository/github/nealkumar/jbrew)
[![Build Status](https://travis-ci.com/nealkumar/JBrew.svg?branch=master)](https://travis-ci.com/nealkumar/JBrew)
[![DepShield Badge](https://depshield.sonatype.org/badges/nealkumar/JBrew/depshield.svg)](https://depshield.github.io)
[![Gitter](https://img.shields.io/gitter/room/DAVFoundation/DAV-Contributors.svg?style=flat-square)](https://gitter.im/Concurrent-Tasks/community)
[![License: LGPL v3](https://img.shields.io/badge/License-LGPL%20v3-blue.svg)](https://www.gnu.org/licenses/lgpl-3.0)
[![GitHub commit activity](https://img.shields.io/github/commit-activity/y/nealkumar/JBrew)](https://github.com/nealkumar/JBrew/pulse)
[![OSS Lifecycle (branch)](https://img.shields.io/osslifecycle/nealkumar/JBrew?color=yellow)](https://github.com/Netflix/osstracker)
[![JDK 1.7+](https://img.shields.io/badge/jdk-1.7%2B-purple)](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)
# Maven Central Dependency
To import this library into Maven, simply insert the following dependency in your pom.xml:
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew</groupId>
      <artifactId>concurrent</artifactId>
      <version>0.1.0-beta.3</version>
    </dependency>
  </dependencies>
```
# JBrew Java Concurrency Library
The Concurrent Tasks Library is an easy-to-consume Java concurrency library allowing for "Tasks" to execute business logic in a thread safe manner. This library helps users achieve multi-threading in their applications without worrying about synchronization and blocking for race conditions. Presently, there are 2 types of Tasks: Retrievable and Non-Retrievable.
<br/>
<i>Please note, the below content is relavent only for v0.0.1 - v0.0.4 of the JBrew concurrency library. For v0.0.5 and above, please refer to the official documentation at [jbrew.org](https://jbrew.org/). README documentation will be updated with the Release Candidate release of v0.1.0-rc.</i>
### Retrievable Tasks
Once <code>RetrievableTask</code> is extended, this allows for <code>@ThreadSafe</code> concurrent execution where business logic executed <i>does</i> need to return back an object. As a result, calling the getVal() method for a Retrievable task returns the object of type T (via use of Java generics) - which is blocked until all logic in the execute() method has terminated. 
<br/><br/>
Example usages: Api calls, I/O, or any other situation warranting concurrent parallel processing.
<br/><br/>
Note that classes extending RetrievableTask.java should explicity specify object type in the class declaration to enable compile-type type checking. See example:
```java
  public class ExampleTask extends RetrievableTask<String>{}
```

Finally to return the value, one simple has to set the value for <code>obj</code> or <code>this.obj</code>, as such:

```java
  public class ExampleTask extends RetrievableTask<String>{
      @Overide
      protected void execute(){
        //do work, execute business logic
        
        //then set the return value for ExampleTasks's object
        this.obj = "Example task successfully completed";
      }
  }
```
### Non-Retrievable or Basic Tasks
Once <code>NonRetrievableTask</code> or <code>BasicTask</code> has been extended, this allows for simple concurrent execution where the business logic executed <i>does <b>not</b></i> need to return back an object. As a result, calling the getVal() method for a NonRetrievableTask throws an <code>java.lang.UnsupportedOperationException</code>. 
</br></br>
Example usages: initializers, message dispatchers, or any standalone time-consuming task which you would like to execute concurrently.
# Client Usage Examples
Regardless on the type of <code>Task</code> needed, each respective <code>Task</code> should be wrapped within with a <code>Thread</code> and will begin execution upon calling of the <code>start()</code> or <code>run()</code> methods. The <code>start()</code> method executes the <code>Task</code> in a new thread, while the <code>run()</code> method executes the <code>Task</code> in the same thread.
<br/><br/>Below is an example of a <code>RetrievableTask</code> and <code>NonRetrievable</code> executing business logic in new threads, and then printing out status messages - based on the designated <code>Task</code> type.
```java
  public class Main{
  
    private Task retrievable, nonRetrievable;
    
    public static void main(String[] args){
      retrieveable = new RTask();
      nonRetrievable = new NRTask();
      
      //start the Retrievable Task
      Thread t = new Thread(retrievable);
      t.start();
      //start the Non-Retrievable Task using an anonymous Thread                   
      new Thread(nonRetrievable).start();
      
      //Print the results of each respective Task
      System.out.println(retrievable.getVal()); // Since this is a RetrievableTask, retrievable.getVal()
                                                // is blocked until its execute() method has completed.
    }
    
    private static class RTask extends RetrievableTask<String>{
      @Override
      protected void execute(){
        //do work, execute business logic
        //...    
        this.obj = "Finished with Retrievable task!";
      }
    }
    
    private static class NRTask extends NonRetrievableTask{
      @Override
      protected void execute(){
        //do work, execute business logic
        //...
        System.out.println("Finished with Non-Retrievable task!");
      }
    } 
    
  }
```
Console:</br>
```
  Thread #2 started...
  Thread #1 started...
  Finished with Retrievable task!
  Finished with Non-Retrievable task!
```
