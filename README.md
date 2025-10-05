# Algorithm Performance Analysis – Assignment 2

## Overview
This project is part of the **Algorithm Analysis and Design** course.  
It contains two sorting algorithm implementations — **Shell Sort** (my algorithm) and **Heap Sort** (partner’s algorithm) — with performance measurement tools, benchmark scripts, and unit tests.

---

## Project Structure
DAA/ <br>
├── src/main/java/<br>
│ ├── algorithms/ <br>
│ ├── metrics/ <br>
│ └── cli/ <br>
├── src/test/java/ <br>
│ └── algorithms/ <br>
├── docs/<br>
│ ├── analysis-report.pdf <br>
│ └── performance-plots/ <br>
├── README.md <br>
└── pom.xml <br>


---

## Algorithms Included
- **Shell Sort (Nazym)** — adaptive, gap-based comparison sort.
- **Heap Sort (Aluana)** — tree-based comparison sort using a binary heap.

---

## How to Run

### 1. Compile the project

 mvn clean compile
### 2. Run benchmarks
java -cp target/classes cli.BenchmarkRunner

### 3. Run unit tests
mvn test

👩‍💻 Author

Nazym — Shell Sort implementation & report writing

Partner: Aluana — Heap Sort implementation