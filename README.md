[![Maven Central](https://img.shields.io/maven-central/v/org.jbrew/concurrent.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22software.nealk%22%20AND%20a:%22concurrent%22)
![Build Status](https://codebuild.us-east-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiWldraHhlak9XQzVuOVJwS2dlUTI2TGxXRDhOb0RtSEloOEowaU4yS3YzL0t1RWhWRnoyQmIrU2JoUWRGVWcyb1BWZXN0aDZXU2liREhST2VuYjVGMWxRPSIsIml2UGFyYW1ldGVyU3BlYyI6Ijh6aE16OVJmSVhRSDkranYiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)
[![Build Status](https://travis-ci.com/nealkumar/Concurrency-Library.svg?branch=master)](https://travis-ci.com/nealkumar/Concurrency-Library)
[![CodeFactor Grade](https://img.shields.io/codefactor/grade/github/nealkumar/Concurrency-Library/master?label=codefactor)](https://www.codefactor.io/repository/github/nealkumar/concurrency-library)
[![codecov](https://codecov.io/gh/nealkumar/Concurrency-Library/branch/master/graph/badge.svg)](https://codecov.io/gh/nealkumar/Concurrency-Library)
[![DepShield Badge](https://depshield.sonatype.org/badges/nealkumar/Concurrency-Library/depshield.svg)](https://depshield.github.io)
[![Gitter](https://img.shields.io/gitter/room/DAVFoundation/DAV-Contributors.svg?style=flat-square)](https://gitter.im/Concurrent-Tasks/community)
[![License: LGPL v3](https://img.shields.io/badge/License-LGPL%20v3-blue.svg)](https://www.gnu.org/licenses/lgpl-3.0)
# Maven Central Dependency
To import this library into Maven, simply insert the following dependency in your pom.xml:
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew</groupId>
      <artifactId>concurrent</artifactId>
      <version>0.0.1</version>
    </dependency>
  </dependencies>
```
# Concurrent Tasks Java Library
The Concurrent Tasks Library is an easy-to-consume Java concurrency library allowing for "Tasks" to execute business logic in a thread safe manner. This library helps users achieve multi-threading in their applications without worrying about synchronization and blocking for race conditions. Presently, there are 2 types of Tasks: Retrievable and Non-Retrievable.

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
### Non-Retrievable Tasks
Once <code>NonRetrievableTask</code> has been extended, this allows for simple concurrent execution where the business logic executed <i>does <b>not</b></i> need to return back an object. As a result, calling the getVal() method for a NonRetrievableTask throws an <code>java.lang.UnsupportedOperationException</code>. 
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
