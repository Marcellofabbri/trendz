Granting the user access to the database
```
GRANT CONNECT ON DATABASE my_db TO my_user;
```
Granting the user _usage_ privilege on the schema
```
GRANT USAGE ON SCHEMA public TO my_user;
```
Granting all pemissions for all tables
```
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO my_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO my_user;
```