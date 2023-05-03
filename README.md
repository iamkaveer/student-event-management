# student-event-management
## Requirements
To run this project, you need to have the following installed on your system:
- Java
- Spring Boot
- Hibernate
- MySQL
- Swagger

## Endpoints
The following endpoints are provided by the application:
### Students
- **POST /students:** Add a new student. The request body should contain a JSON object representing the student.
- **PUT /students/{studentId}?department={department}:** Update the department of a student with the given ID.
- **DELETE /students/{studentId}:** Delete the student with the given ID.
- **GET /students:** Get a list of all students.
- **GET /students/{studentId}:** Get the student with the given ID.

### Events
- **POST /events:** Add a new event. The request body should contain a JSON object representing the event.
- **PUT /events/{eventId}:** Update the event with the given ID.
- **DELETE /events/{eventId}:** Delete the event with the given ID.
- **GET /events?date={date}:** Get a list of all events on the given date.

## Validation
The following validation rules are applied to the student and event objects:
- **Student:** Age must be between 18 and 25, first name must start with a capital letter, department must be one of the following: ME, ECE, Civil, CSE.
- **Event:** Start time must be before end time.
