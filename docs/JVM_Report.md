# MediTrack - JVM Report

## 1. Introduction

Java follows the principle of **"Write Once, Run Anywhere" (WORA)"**.  
This is made possible by the Java Virtual Machine (JVM), which allows Java programs to run on any system that has a compatible JVM installed.

The JVM is a part of the Java Runtime Environment (JRE) and is responsible for executing Java bytecode.

---

## 2. Java Architecture Overview

Java execution flow:

Source Code (.java)  
↓  
Compiled by javac  
↓  
Bytecode (.class)  
↓  
Executed by JVM

The JVM acts as an abstraction layer between compiled Java code and the underlying operating system.

---

## 3. Class Loader Subsystem

The Class Loader is responsible for loading `.class` files into memory.

It works in three main stages:

### 3.1 Loading
The Class Loader reads the bytecode from `.class` files and loads them into memory.

### 3.2 Linking
Linking consists of:
- **Verification** → Ensures bytecode is safe and secure
- **Preparation** → Allocates memory for static variables
- **Resolution** → Replaces symbolic references with actual references

### 3.3 Initialization
Executes static initializers and static blocks.

In MediTrack:
- Static initialization is demonstrated in `IdGenerator` and constants configuration.

---

## 4. Runtime Data Areas

The JVM divides memory into different runtime areas.

### 4.1 Method Area
Stores:
- Class metadata
- Static variables
- Runtime constant pool

### 4.2 Heap
Stores:
- All objects
- Instance variables

In MediTrack:
- Doctor, Patient, Appointment objects are stored in Heap.

### 4.3 Stack
Each thread has its own stack.

Stores:
- Local variables
- Method calls
- Partial results

When a method completes, its stack frame is removed.

### 4.4 Program Counter
Stores:
- Address of the currently executing instruction.

Each thread has its own PC register.

### 4.5 Native Method Stack
Used for executing native (non-Java) methods.

---

## 5. Execution Engine

The Execution Engine executes the bytecode.

It has:

### 5.1 Interpreter
Reads bytecode line-by-line and executes it.

### 5.2 JIT (Just-In-Time) Compiler
Improves performance by converting frequently executed bytecode into native machine code.

JIT makes Java programs faster during runtime.

---

## 6. JIT Compiler vs Interpreter

| Feature      | Interpreter  | JIT Compiler                  |
|--------------|--------------|-------------------------------|
| Speed        | Slower       | Faster                        |
| Compilation  | Line-by-line | Compiles frequently used code |
| Memory Usage | Lower        | Higher                        |

The JVM uses both for optimized performance.

---

## 7. Write Once, Run Anywhere (WORA)

Java achieves platform independence because:

- Java source code compiles into bytecode.
- Bytecode runs on JVM.
- JVM is platform-specific.
- Bytecode is platform-independent.

Thus, the same `.class` file runs on Windows, Linux, or Mac.

---

## 8. JVM in MediTrack Project

In the MediTrack system:

- Objects are dynamically allocated in the Heap.
- Method calls are managed via Stack frames.
- Static blocks initialize configuration.
- The IdGenerator singleton demonstrates controlled object creation.
- Streams and lambdas are executed via JVM bytecode optimization.

---

## 9. Conclusion

The JVM provides:

- Memory management
- Security verification
- Platform independence
- Runtime optimization via JIT
- Thread management

Understanding JVM internals ensures better Java application design and performance optimization.

The MediTrack project demonstrates practical usage of JVM concepts through object creation, static initialization, collections, and runtime execution.
