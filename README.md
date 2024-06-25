# Resource Event Handler Project

This project is a Java application that simulates a Resource Event Generator and various Resource Event Handlers. It demonstrates handling resource events with functionalities such as encoding events to JSON, filtering events based on criteria, logging events, buffering and re-ordering events based on timestamp, and handling high loads of events.

## Project Structure

The project structure is as follows:

ResourceEventHandler/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── com/
│ │ └── example/
│ │ └── eventhandler/
│ │ ├── ResourceEventGenerator.java
│ │ ├── ResourceEventHandler.java
│ │ ├── JSONEncodingHandler.java
│ │ ├── FilteringHandler.java
│ │ ├── LoggingHandler.java
│ │ ├── BufferingAndReorderingHandler.java
│ │ ├── HighLoadEventHandler.java
│ │ └── Main.java
│ └── test/
│ └── java/
│ └── com/
│ └── example/
│ └── eventhandler/
│ ├── ResourceEventGeneratorTest.java
│ ├── JSONEncodingHandlerTest.java
│ ├── FilteringHandlerTest.java
│ ├── LoggingHandlerTest.java
│ ├── BufferingAndReorderingHandlerTest.java
│ └── HighLoadEventHandlerTest.java
├── lib/
│ ├── gson-2.8.6.jar
│ ├── junit-4.13.2.jar
│ └── hamcrest-core-1.3.jar
├── javadocs/ # Generated JavaDocs for main source files
├── test-javadocs/ # Generated JavaDocs for test files
├── README.md # This file
└── pom.xml # Maven project configuration (if applicable)


## Features

- **Resource Event Generator**: Generates resource events with random values once a second.
- **Resource Event Handlers**:
  - **JSONEncodingHandler**: Encodes resource events to JSON format.
  - **FilteringHandler**: Filters resource events by name, datatype, or value.
  - **LoggingHandler**: Logs resource events to console or file.
  - **BufferingAndReorderingHandler**: Buffers and re-orders events based on timestamp.
  - **HighLoadEventHandler**: Handles very high loads of events efficiently.
- **Main Application**: Entry point to run and demonstrate the functionality.

## Requirements

- Java 8 or higher
- Dependencies: Gson library (`gson-2.8.6.jar`), JUnit and Hamcrest libraries (`junit-4.13.2.jar`, `hamcrest-core-1.3.jar` for testing)

## Setup and Run

### Manual Setup

1. Clone the repository:

   ```sh
   git clone https://github.com/your-username/ResourceEventHandler.git
   cd ResourceEventHandler
