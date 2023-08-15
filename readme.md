## Angular UI
I have created an Angular UI project in the sc-ui subfolder.

To build the project you have to have nodejs and npm installed.
* npm i - to install the dependencies
* ng build - to build the project
* ng serve - for local development (request are proxied to the BFF)

A prebuilt binary is deployed into the src/main/resources/static folder 
and can be accessed at localhost:9000/index.html

If you want to rebuild and deploy a new version then you have to  
copy the content of sc-ui/dist/sc-ui to src/main/resources/static.

Travel API Client
=================

Fork or otherwise clone this repo into your own personal **private** GitHub repository, and please make sure to add read access for the following GitHub users (depending on who sent you the assessment):
- manishjha88 (Manish Jha)
- Pim-Huisman (Pim Huisman)
- bv1p (Goran N.)
- ccakkan (Ceren Akkan)
- goran (Goran V.)

Please reply to the assessment invitation that you got from us with the link to your
repository when you are done with the assignment below. The mock backend to communicate with can be
found [here on GitHub](https://github.com/Pim-Huisman/simple-travel-api-mock).

Create your own [GitHub actions](https://github.com/features/actions) to build and test your assignment software.

Start it (on windows systems use the gradlew.bat file):

`./gradlew bootRun`

to list all tasks:

`./gradlew tasks`

To view the actual assignment (after starting the application) go to:

[http://localhost:9000/index.html](http://localhost:9000/index.html)
