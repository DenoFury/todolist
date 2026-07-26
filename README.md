# ToDoList

A desktop to-do list application built with Java and JavaFX, with local data persistence.

## Features
- Add and delete tasks
- Tasks save locally and reload automatically on restart
- Simple, clean desktop UI

## Tech Stack
- Java
- JavaFX
- Maven (`pom.xml`)

## Installation
```bash
git clone https://github.com/DenoFury/todolist.git
```
Open the project in your IDE of choice (IntelliJ recommended) as a Maven project, then run the main class.

## Future Improvements
- Task categories/priorities
- Due dates and reminders
- Dark mode

## Lessons Learned
First GUI application built with JavaFX, including handling local file persistence (`tasks.json`) and debugging UI state issues (e.g. a delete button that initially failed to display correctly).