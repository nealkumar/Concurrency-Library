[![Maven Central](https://img.shields.io/maven-central/v/org.jbrew/concurrent.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.jbrew%22%20AND%20a:%22jbrew-parent%22)
[![Documentation](https://img.shields.io/badge/documentation-jbrew.org-000)](https://jbrew.org)
[![Build Status](https://codebuild.us-east-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiREpyWjkrdUNEODlGOWQvUExFVy9DNWdmWkRIZCs2ZGpJN0NDb3I5SW83SmRPbE9xSVlRcitqSi95NHUxc2JDeUowT3gyc2Y3K21ZSGpPbTNGREhScHRjPSIsIml2UGFyYW1ldGVyU3BlYyI6ImhIcG8rd1hGL0FJK2JBalAiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)](https://aws.amazon.com/codebuild/)
[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=org.jbrew:jbrew-parent&metric=alert_status)](https://sonarcloud.io/dashboard?id=org.jbrew:jbrew-parent)
[![codecov](https://codecov.io/gh/nealkumar/JBrew/branch/master/graph/badge.svg)](https://codecov.io/gh/nealkumar/JBrew)
[![CodeFactor](https://www.codefactor.io/repository/github/nealkumar/jbrew/badge)](https://www.codefactor.io/repository/github/nealkumar/jbrew)
[![Build Status](https://travis-ci.com/nealkumar/JBrew.svg?branch=master)](https://travis-ci.com/nealkumar/JBrew)
[![DepShield Badge](https://depshield.sonatype.org/badges/nealkumar/JBrew/depshield.svg)](https://depshield.github.io)
[![Gitter](https://img.shields.io/gitter/room/DAVFoundation/DAV-Contributors.svg?style=flat-square)](https://gitter.im/Concurrent-Tasks/community)
[![License](https://img.shields.io/badge/License-BSD%203--Clause%20Clear-blue)](https://spdx.org/licenses/BSD-3-Clause-Clear.html)
[![GitHub commit activity](https://img.shields.io/github/commit-activity/y/nealkumar/JBrew?label=Release%20Activity)](https://github.com/nealkumar/JBrew/pulse)
[![OSS Lifecycle (branch)](https://img.shields.io/osslifecycle/nealkumar/JBrew?color=yellow)](https://github.com/Netflix/osstracker)
[![JDK 1.8+](https://img.shields.io/badge/jdk-1.8%2B-purple)](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)
# JBrew Home ![](https://storage.googleapis.com/documentation.jbrew.org/Favicon%20Logo.png)
* Please note, the master branch is always live! The latest stable release is reflected on <code>master</code>.
* The branch <code>staged-for-release</code> contains the most recent nightly builds and includes the newest features which will be added to the library to be officially released to Maven Central (after the current development iteration). New contributors should make pull requests into <code>staged-for-release</code>.
* To dive into the concurrency library's source code, please navigate [here](https://github.com/nealkumar/JBrew/tree/docpatch-010/concurrent). The README.md contains information on how to get started, and full documentation is available at [jbrew.org](https://jbrew.org/).
* Feedback is always welcome, and can be submitted to [support@jbrew.org](mailto:support@jbrew.org). Thank you!

# User Installation
Note that contributors or other users who wish to use the latest nightly build should follow the [Upstream Installation](#upstream-installation) guide.
## GNU/Linux (Red Hat Enterprise, Fedora, CentOS, Ubuntu, Debian, Arch, Clear), FreeBSD (11.2+)
1. Simply download the file "install.sh" above. FreeBSD users should use the file "install-freebsd.sh" instead.
2. At your desired java.library.path, run "install.sh" in the terminal, like so:
    * <code>./install.sh</code> will install to the current directory, OR
    * <code>./install.sh /path/to/java.library.path</code> will install to the directory specified.
3. You may be prompted to enter sudo password. Note that no text or cursor movement will appear on screen.
    * <code>[sudo] password for user:      </code>&nbsp;Enter your credentials, then hit <code>[Enter]</code>.
4. Your installation is complete! ***Important:*** Make sure you set your java.library.path to the location specied in part 2, appended with /bin (Ex: <code>java.library.path=/path/in-part2/bin)</code> before compiling your code, as these libraries have links to native libraries.
    * Essentially, whenever you run the <code>java</code> command, you will need to add <code>-Djava.library.path=path/to/where-you-ran/install.sh/in-step-2/bin</code> (Don't forget to append "/bin" to the end of the location!). More detailed istructions can be found [here](https://examples.javacodegeeks.com/java-basics/java-library-path-what-is-it-and-how-to-use/). Just remember to append "/bin"!
    * For Maven JUnit tests, it is reccomended you add the Apache Surefire plugin and provide the java.library.path as a compiler argument. [Use these instructions](https://stackoverflow.com/questions/10226082/surefire-junit-testing-using-native-libraries) if you are unsure how to do this.
# JBrew Maven Dependencies
<p>The following libraries are synchronixed with Maven Central, and can be inserted into your project's <code>pom.xml</code> as a dependency.</p>

## Concurrency Library
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew</groupId>
      <artifactId>concurrent</artifactId>
      <version>0.1.0-beta.6</version>
    </dependency>
  </dependencies>
```
## CBrew JNI Library (See [User Installation Guide](#user-installation) before using)
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.cbrew</groupId>
      <artifactId>cbrew</artifactId>
      <version>0.1.0-beta.6</version>
    </dependency>
  </dependencies>
```
## CBrew Libary Validators (See [User Installation Guide](#user-installation) before using)
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.cbrew</groupId>
      <artifactId>cbrew-validators</artifactId>
      <version>0.1.0-beta.6</version>
    </dependency>
  </dependencies>
```
## Native Libary Validators (See [User Installation Guide](#user-installation) before using)
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-validators</artifactId>
      <version>0.1.0-beta.6</version>
    </dependency>
  </dependencies>
```
## Native Library Core (See [User Installation Guide](#user-installation) before using)
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native</artifactId>
      <version>0.1.0-beta.6</version>
    </dependency>
  </dependencies>
```
## JBrew Core Annotations
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.core</groupId>
      <artifactId>annotations</artifactId>
      <version>0.1.0-beta.6</version>
    </dependency>
  </dependencies>
```
## JBrew Core
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.core</groupId>
      <artifactId>jbrew-core</artifactId>
      <version>0.1.0-beta.6</version>
    </dependency>
  </dependencies>
```
# Upstream Installation
To install the JBrew library locally, simple clone this libary from the branch <code>staged-for-release</code> to get the latest nightly build. Next, run "mvn package" at the project's
root directory. If you receive errors, please proceed to follow the installation steps below for your specific operating system.
## GNU/Linux 
The GNU/Linux is supported as the primary development for JBrew. As such, no additional configuration is needed for most Linux distros. JBrew is actively tested on the 
following Linux distrubtions:
* RHEL 8.1/8.2, CentOS, Fedora
* RHEL 7.0+
* CentOS
* Fedora
* Ubuntu
## FreeBSD 12.1+
As of release v0.1.0-beta.4, FreeBSD is now supported as part of the CBrew and Native libraries! TO configure JBrew for BSD, simply update the <code>java.library.path</code>
from <code>$(user.home}/bin/</code> to <code>${user.home}/binbsd/</code>. The reason for this configuration is that by default, C executables are packaged for 
Linux systems. There are slight variances for FreeBSD systems which must be accounted for, and as such a seperate binaries folder was created to house all FreeBSD
C libraries for CBrew and Native.
## Windows 10+
As of release v0.1.0-beta.3, Windows 10+ is now supported as part of the CBrew and Native libraries! No additional configuration is needed, as windows dynamically
linked libraries are packaged as part of the standard release process.
## Solaris
At the moment, SolarisOS is <i>not</i> supported by JBrew. If you would like Solaris support, please open an issue detailing your request.
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
# CBrew
This library contains native facade implementations of the JBrew utility libraries with the Java Native Interface
(JNI). This set of libraries features specific optimizations for Unix-based systems in terms of performance 
and memory. This is achieved through careful tuning using the C programming language to not only control for 
garbage collection, but also to ensure maximum performance for elected library features.
