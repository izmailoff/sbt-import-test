# sbt-import-test
Example of how to import and use an external library in SBT.

# Usage
Run SBT from your OS shell:

    > sbt

Run the app to check if environment variables are set:

    sbt:Hello> run
    [info] running (fork) Main 
    [info] Found the following environment variable:
    [info] null

Getting `null`. Load env:

    sbt:Hello> loadDevEnv
    [info] Defining envVars
    [info] The new value will be used by Compile / bspBuildTargetRun, Compile / bspScalaMainClassesItem and 6 others.
    [info] 	Run `last` for details.
    [info] Reapplying settings...
    [info] set current project to Hello (in build file:/home/tvc/repos/sbt_test/)

Run the app to check again:

    sbt:Hello> run
    [info] running (fork) Main 
    [info] Found the following environment variable:
    [info] 123

Found value `123`.

# Explanation
https://stackoverflow.com/questions/70942473/sbt-task-to-load-system-environment-variables
