# MediTrack - Design Decisions

## 1. Overall Architecture

The MediTrack system follows a layered structure:

- entity → Core domain models (Doctor, Patient, Appointment, Bill)
- service → Business logic (CRUD, booking, billing)
- util → Utilities (Validator, CSVUtil, IdGenerator, DataStore)
- interfaces → Abstractions (Searchable, Payable)
- exception → Custom exceptions
- constants → Central configuration

This separation ensures:
- High cohesion
- Low coupling
- Better maintainability
- Clear responsibility distribution

---

## 2. Object-Oriented Principles

### 2.1 Encapsulation

All entity classes use:
- Private fields
- Public getters
- Controlled setters

Validation is centralized via the `Validator` class to prevent invalid object states.

---

### 2.2 Inheritance

`Person` is a base class.

Doctor and Patient extend Person.

This avoids duplication of:
- id
- name
- age

---

### 2.3 Polymorphism

Polymorphism is demonstrated via:

- Method overriding (e.g., billing behavior)
- Interface implementation (Searchable, Payable)
- Dynamic dispatch when working with entities

---

### 2.4 Abstraction

Interfaces used:

- `Searchable<T>` → Enforces search contract
- `Payable` → Enforces billing contract

This allows flexible future extension without modifying core logic.

---

## 3. Design Patterns Used

### 3.1 Singleton Pattern

Implemented in `IdGenerator`.

Purpose:
- Ensure only one ID generator exists.
- Prevent duplicate ID conflicts.
- Centralize ID management.

---

### 3.2 Generic DataStore<T>

A reusable storage abstraction built using generics.

Benefits:
- Type safety
- Reusability
- Avoids duplicate storage logic
- Demonstrates understanding of Java generics

---

### 3.3 Strategy - like Billing Logic

Billing logic is separated inside Bill class.

Allows extension for:
- Different tax strategies
- Insurance support
- Discount logic

---

## 4. Exception Handling Strategy

Custom exceptions used:

- AppointmentNotFoundException
- InvalidDataException

Benefits:
- Clear error meaning
- Better debugging
- Clean service-layer logic

---

## 5. Collections and Streams

Used:
- ArrayList via DataStore
- Streams API for filtering and searching

Examples:
- Filter doctors by specialization
- Count appointments per doctor
- Search patients by name

Streams improve:
- Readability
- Functional style
- Reduced boilerplate loops

---

## 6. Enums Usage

Enums used instead of Strings:

- Specialization
- AppointmentStatus

Benefits:
- Type safety
- Avoids invalid string inputs
- Improves readability

---

## 7. Immutable Design

BillSummary is designed as immutable:
- Final fields
- No setters
- Thread-safe structure

Prevents accidental modification after bill generation.

---

## 8. Static Initialization

Static blocks used for:
- Configuration initialization
- Singleton setup

Demonstrates JVM class loading behavior understanding.

---

## 9. Why Menu-Driven Console?

A console-based UI was chosen because:
- Focus is on core Java concepts
- No external frameworks required
- Easy to test logic
- Suitable for academic evaluation

---

## 10. Clone Implementation

Clone functionality is implemented in:
- Patient
- Appointment

Purpose:
- Demonstrates deep object copying
- Avoids unintended reference sharing
- Supports safe duplication of domain objects

This highlights understanding of object memory behavior in JVM.




---

## Conclusion

The MediTrack project demonstrates:

- Core and advanced OOP
- Design patterns
- Generics
- Exception handling
- Streams
- JVM understanding
- Clean architecture

The design prioritizes scalability, clarity, and adherence to Java best practices.
