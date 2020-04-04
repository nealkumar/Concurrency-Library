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
# Welcome to CBrew
This library contains native facade implementations of the JBrew utility libraries with the Java Native Interface
(JNI). This set of libraries features specific optimizations for Unix-based systems in terms of performance 
and memory. This is achieved through careful tuning using the C programming language to not only control for 
garbage collection, but also to ensure maximum performance for elected library features.
