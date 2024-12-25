Dependency Injection:
Three types:
Field Injection
Contructor Injection
Setter Injection

Initialize with @Componenet

We can create dependency injection using context

We can also use @Autowired

We have multiple class implimenting same interface then we can use @primary or remove @component on either

but if we have multiple @Primary then we can use @Qualifier("<class_name>")

//To use spring only

Create a quick-start maven project
In main class create application context for IoC(Inversion of Control) container by adding spring context dependency
configure context with sprig.xml file inside resource folder in main folder by adding beans from beans configuration from internet
Inside beans add you classess(with complete package path) to create them in IoC container
To assign values to object via spring add property tag with name and value in xml file

