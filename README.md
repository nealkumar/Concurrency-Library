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
[![GitHub commit activity](https://img.shields.io/github/commit-activity/y/nealkumar/JBrew)](https://github.com/nealkumar/JBrew/pulse)
[![OSS Lifecycle (branch)](https://img.shields.io/osslifecycle/nealkumar/JBrew?color=yellow)](https://github.com/Netflix/osstracker)
[![JDK 1.8+](https://img.shields.io/badge/jdk-1.8%2B-purple)](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)
# JBrew Home ![](https://storage.googleapis.com/documentation.jbrew.org/Favicon%20Logo.png)
* Please note, the master branch is always live! The latest release is reflected on <code>master</code>.
* The branch <code>staged-for-release</code> reflects the newest updates to the library which will be officially released in the next release iteration. New contributors should make pull requests into <code>staged-for-release</code>.
* To dive into the concurrency library's source code, please navigate [here](https://github.com/nealkumar/JBrew/tree/docpatch-010/concurrent). The README.md contains information on how to get started, and full documentation is available at [jbrew.org](https://jbrew.org/).
* Feedback is always welcome, and can be submitted to [support@jbrew.org](mailto:support@jbrew.org). Thank you!

# JBrew Maven Dependencies
<p>The following libraries are available as Maven depdendencies, which can be inserted into your project's <code>pom.xml</code>.</p>

## Concurrency Library
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew</groupId>
      <artifactId>concurrent</artifactId>
      <version>0.1.0-beta.5</version>
    </dependency>
  </dependencies>
```
## CBrew JNI Library
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-core</artifactId>
      <version>0.1.0-beta.5</version>
    </dependency>
  </dependencies>
```
## CBrew Libary Validators
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-validators</artifactId>
      <version>0.1.0-beta.5</version>
    </dependency>
  </dependencies>
```
## Native Libary Validators
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-validators</artifactId>
      <version>0.1.0-beta.5</version>
    </dependency>
  </dependencies>
```
## Native Library Core
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-core</artifactId>
      <version>0.1.0-beta.5</version>
    </dependency>
  </dependencies>
```
## JBrew Core Annotations
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.core</groupId>
      <artifactId>annotations</artifactId>
      <version>0.1.0-beta.5</version>
    </dependency>
  </dependencies>
```
## JBrew Core
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.core</groupId>
      <artifactId>jbrew-core</artifactId>
      <version>0.1.0-beta.5</version>
    </dependency>
  </dependencies>
```
# Installation
To install the JBrew library locally, simple clone this libary from <code>master</code> or any other branch needed for development. Next, run "mvn package" at the project's
root directory. If you receive errors, please proceed to follow the installation steps below for your specific operating system.
## Linux 
Linux is supported as the primary development for JBrew. As such, no additional configuration is needed for most Linux distros. JBrew is actively tested on the 
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
## Solaris OS
At the moment, SolarisOS is <i>not</i> supported by JBrew. If you would like Solaris support, please open an issue detailing your request.