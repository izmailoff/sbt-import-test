# sbt-import-test
Example of how to import and use an external library in SBT.

# Usage
Run SBT from your OS shell:

    > sbt

Run the SBT task:

    sbt:Hello> loadDevEnv
    --- 
    system: 
      port: 123
      service: name

    Right({
      "system" : {
        "port" : 123,
        "service" : "name"
      }
    })

# Explanation
https://stackoverflow.com/questions/70942473/sbt-task-to-load-system-environment-variables
