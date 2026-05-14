# Semester 2: Final Project

## Library Management System

### Author: Mossimo Bianco
### Student ID: 2585451

This project is a Java-based library management system.
It allows the creation and management of library users, books, magazines, DVDs, and borrowing operations.

The system supports:

* Adding and managing library items
* Registering different types of users
* Borrowing and returning items
* Searching and sorting library data
* Loading and saving information using CSV files
* Generating reports through admin functionality

The goal of this project is to model a realistic library environment while applying object-oriented programming principles such as abstraction, inheritance, encapsulation, association, and interface implementation.

---

## **Classes and Responsibilities**

### **Library**

Represents the main library management system.

**Responsibilities:**

* Stores all library items and users
* Handles borrowing and returning operations
* Manages queues, stacks, and maps
* Searches for items using recursive and stream-based searching
* Sorts users and items
* Loads and saves data using CSV files

---

### **User**

An abstract class representing a generic library user.

**Responsibilities:**

* Stores user ID and name
* Stores borrowed items
* Defines common user behavior
* Provides borrowing limit functionality

---

### **Student**

Represents a student library user.

**Responsibilities:**

* Inherits from User
* Defines borrowing limits for students

---

### **Teacher**

Represents a teacher library user.

**Responsibilities:**

* Inherits from User
* Defines borrowing limits for teachers

---

### **Admin**

Represents a library administrator.

**Responsibilities:**

* Inherits from User
* Implements reporting functionality
* Generates library reports
* Connects administrative features to the library system

---

### **Item**

An abstract class representing a generic library item.

**Responsibilities:**

* Stores item ID, title, and status
* Defines common item behavior
* Provides status management functionality

---

### **Book**

Represents a book in the library.

**Responsibilities:**

* Stores ISBN, author, and genre
* Inherits from Item
* Provides access to book-specific information

---

### **Magazine**

Represents a magazine in the library.

**Responsibilities:**

* Stores issue number and publisher
* Inherits from Item
* Provides access to magazine-specific information

---

### **DVD**

Represents a DVD in the library.

**Responsibilities:**

* Stores director and duration
* Inherits from Item
* Provides access to DVD-specific information

---

### **Validation**

A utility class used for validating data.

**Responsibilities:**

* Validates ISBN values
* Ensures item information is correctly formatted

---

### **Reportable**

An interface for report generation.

**Responsibilities:**

* Defines report generation behavior
* Ensures Admin supports reporting features

---

## **Key Features**

* Object-oriented design with clear class responsibilities
* Inheritance and abstraction for reusable code
* Searching using recursion and Java Streams
* CSV file loading and saving
* Queue, Stack, List, and Map usage
* Data validation for ISBN values
* Sorting functionality for users and items
* Clean separation of concerns between classes

---

## **Relationships**

### **Inheritance**

* Student extends User
* Teacher extends User
* Admin extends User
* Book extends Item
* Magazine extends Item
* DVD extends Item

---

### **Interface Implementation**

* Admin implements Reportable

---

### **Associations**

* Library contains Users
* Library contains Items
* User stores borrowed Items

---

## **Data Structures Used**

### **List**

Used for storing:

* Users
* Items
* Borrowed items

---

### **Stack**

Used for:

* Tracking returned items

---

### **Queue**

Used for:

* Managing borrowing requests

---

### **Map**

Used for:

* Fast item lookup by ID

---

## **Exception Handling**

The project uses Java exception handling techniques.

**Features:**

* try/catch blocks
* Built-in Exception handling
* Input validation

---

## **Technologies Used**

* Java
* Java Collections Framework
* Java Stream API
* File I/O
* CSV Processing
* UML Class Diagrams
* Visual Paradigm

---

## **Conclusion**

This project demonstrates the practical application of object-oriented programming concepts in Java by modeling a real-world library management system.
It emphasizes clean design, modularity, reusable code, and proper data management while providing meaningful functionality for managing users and library items.
