### `Clone this project`
Open cmd/terminal and run "git clone https://github.com/aljaaaymp/notes.git"

### `Used Stacks`
- Java: OpenJDK version 17.0.9
- Maven

### `Steps to Build the Project`
You can just use your Maven home path as default or "Bundled (Maven 3)" and it will automatically download the dependencies.
or
1. Navigate to Project Directory:
- Open a terminal or command prompt.
- Change the directory to the root directory of your project.
2. Run Maven Wrapper:
- Use the Maven Wrapper script (mvnw or mvnw.cmd) provided in your project's root directory.
"./mvnw clean install" in linux/macOS
"mvnw.cmd clean install" on windows

### `Using the API`
After you setup and run the project. You can use the following API calls:
#### POST: localhost:8080/notes
Request body:
{
    "title": "SAMPLE TITLE",
    "body": "Sample body here"
}

##### GET all: localhost:8080/notes
Expected response:
{
    "1": {
        "id": 1,
        "title": "sad",
        "body": "body"
    }
}

#### GET specific: localhost:8080/notes/{noteID} / localhost:8080/notes/1
Expected response:
{
    "title": "SAMPLE TITLE",
    "body": "Sample body here"
    "id": 1
}

#### PUT: localhost:8080/notes/{noteID} / localhost:8080/notes/1
Request body:
{
    "title": "asdasd",
    "body": "body"
}

#### DELETE: localhost:8080/notes/{noteID} / localhost:8080/notes/1




