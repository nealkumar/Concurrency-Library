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
[![JDK 1.8+](https://img.shields.io/badge/jdk-1.8%2B-purple)](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)
# JBrew Home
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
      <version>0.1.0-beta.2</version>
    </dependency>
  </dependencies>
```
## CBrew JNI Library
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-core</artifactId>
      <version>0.1.0-beta.2</version>
    </dependency>
  </dependencies>
```
## CBrew Libary Validators
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-validators</artifactId>
      <version>0.1.0-beta.2</version>
    </dependency>
  </dependencies>
```
## Native Libary Validators
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-validators</artifactId>
      <version>0.1.0-beta.2</version>
    </dependency>
  </dependencies>
```
## Native Library Core
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.native</groupId>
      <artifactId>native-core</artifactId>
      <version>0.1.0-beta.2</version>
    </dependency>
  </dependencies>
```
## JBrew Core Annotations
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.core</groupId>
      <artifactId>annotations</artifactId>
      <version>0.1.0-beta.2</version>
    </dependency>
  </dependencies>
```
## JBrew Core
```xml
  <dependencies>
    <dependency>
      <groupId>org.jbrew.core</groupId>
      <artifactId>jbrew-core</artifactId>
      <version>0.1.0-beta.2</version>
    </dependency>
  </dependencies>
```