# Resource Event Handler Project

This project is a Java application that simulates a Resource Event Generator and various Resource Event Handlers. It demonstrates handling resource events with functionalities such as encoding events to JSON, filtering events based on criteria, logging events, buffering and re-ordering events based on timestamp, and handling high loads of events.


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
Refer to the Commands to run txt file for details to compile and run 
