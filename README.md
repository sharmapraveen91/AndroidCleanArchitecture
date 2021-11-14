# Android Clean Architecture That Screams (MVVM + JetPack Compose UI + Flow + State)

Clean architecture that screams using MVVM

A good architectures produce systems that are:

- <B>Independent of Frameworks</B>. The architecture does not depend on the existence of some library of feature laden software. This allows you to use such frameworks as tools, rather than having to cram your system into their limited constraints.
- <B>Testable</B>. The business rules can be tested without the UI, Database, Web Server, or any other external element.
- <B>Independent of UI</B>. The UI can change easily, without changing the rest of the system. A Web UI could be replaced with a console UI, for example, without changing the business rules.
- <B>Independent of Database</B>. You can swap out Oracle or SQL Server, for Mongo, BigTable, CouchDB, or something else. Your business rules are not bound to the database.
- <B>Independent of any external agency</B>. In fact your business rules simply don’t know anything at all about the outside world.
