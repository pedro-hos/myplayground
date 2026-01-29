# Byteman Scripts

Byteman Scripts used in our [JUG Vale presentation](https://docs.google.com/presentation/d/1Rof25ql3cBW3fpC7rhkqv0phcG4ic_Sjz27erdE3Tng/edit?usp=sharing)

## How to use our examples?

Fist you'll need to make sure that you have Java 11+ installed and optional have [Jbang](https://www.jbang.dev/) installed.

1. Download [Byteman](https://byteman.jboss.org/downloads.html)
2. Add Byteman on your classpath
3. Compile the Java class that you want to use, for example:

```
javac AppMain.java
```

4. You'll find the command to execute the script inside of each `btm` file. For example, see `appmain.btm`, the first line:

```
java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:appmain.btm AppMain foo bar baz
```

Note: each script file have the respective byteman command.
