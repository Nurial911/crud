# Notes Manager CRUD API
Simple CRUD app for interacting with notes.
Allows to create, update, view, and delete notes using REST API.

## Functionality
-Create a Note.
-Retrieve a note by ID.
-Retrieve all notes.
-Update a note.
-Delete a note.

## Technologies
-Java 21
-Spring Boot
-Spring Data JPA
-Hibernate
-PostgreSQL
-Maven
-Lombok
-MapStruct

## Project Structure
src/main/java/com/example/crud/
-controller
-dto
-entities
-mappers
-repositories
-service

## API Endpoints
POST | /api/notes | Create a note
GET | /api/notes/allnotes | Retrieve all notes
GET | /api/notes/{id} | Retrieve a note by ID
PUT | /api/notes/{id} | Update a note by ID
DELETE | /api/notes/{id} | Delete a note by ID

# Future improvements
-Add validation
-Add logging
-Add error handling
