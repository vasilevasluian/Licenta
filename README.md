##GUI
1. Web pages are defined through the Page Object design pattern;
2. Web elements within Page Objects are defined using the **PageElement** class;
3. Page Objects use Lombok **@Getter** and **@Accessors(fluent = true)** annotations to reduce default code;
4. Page Objects will always use getters instead of direct variable referencing;
5. Page capabilities include compositions of methods defined within a Page Object, and define a business action;
6. **Please define only what is necessary, avoid useless code.**

##LOG
1. Logging is done with Lombok **@Log4j2** annotation, e.g.;
```
log.info("[API] Add user [{}] to team [{}]", user.getUsername(), crmTeam.getName());
```
2. Changes to the log configuration is done through the **src.text.resources.log4j2.xml** file;
3. Log messages are written in present tense and only before the logged event happens.

##Gauge
1. Specifications are defined with the basic markdown syntax, e.g.:
```
# Login specification
Tags: login

## Successful login scenario
* Login as user "john" and create project "Gauge java";
```
2. Specification name is equal to the story/bug name defined in Jira;
3. Scenario names and steps are written in present tense, additionally, scenario names should contain the identifier of the related test/bug in Jira, if it exists;
4. Scenarios that cover bugs are marked with the **bug** tag.
* [Gauge specification writing documentation](https://docs.gauge.org/writing-specifications.html?os=windows&language=javascript&ide=vscode)
