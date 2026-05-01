# Spring Boot Contact Book API

A full-featured Spring Boot backend showcasing **JPA**, **MyBatis**, **concurrency patterns**, and **RESTful API design** — built around a contact book (person CRUD) backed by PostgreSQL.

---

## What This Project Covers

### Data Access — Two Approaches, One Database
- **Spring Data JPA** (`/jpa/*`) — repository-based CRUD with `@Entity`, `@Query`, and derived query methods
- **MyBatis** (`/mybatis/*`) — XML mapper-driven SQL with `resultMap`, parameterized queries, and manual column mapping

Both layers operate on the same `contact_book.person` table, demonstrating the tradeoffs between each approach.

### Concurrency & Threading (`/lock/*`)
- **Deadlock demonstration** — two threads acquiring locks in opposite order via `synchronized`
- **ReentrantLock** — `tryLock` with timeout, thread pool execution via `ThreadPoolExecutor`
- **@Synchronized** (Lombok) — simplified synchronized methods on a shared counter

### Transactional Management
- `@Transactional` success path — saves two `Person` records atomically
- `@Transactional` rollback — forces a `RuntimeException` to prove rollback behavior

### Algorithms
- **Selection sort** (swap sort) — sorts a list via `POST /sort`
- **Matrix multiplication** — validates dimensions and computes the product

### Networking
- **Network segment calculator** — computes the network address from an IP + subnet mask using bitwise AND

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Framework | Spring Boot 3.3.2, Java 21 |
| ORM | Spring Data JPA + Hibernate |
| SQL Mapper | MyBatis 3.0.3 |
| Database | PostgreSQL (via JDBC) |
| Boilerplate | Lombok (`@Data`, `@Builder`, `@Jacksonized`) |
| Build | Maven |

---

## Project Structure

```
src/main/java/org/example/
├── MyApp.java                          # Entry point
├── controller/
│   ├── Controller.java                 # JPA-based CRUD endpoints (/jpa/*)
│   ├── ControllerMB.java              # MyBatis-based CRUD endpoints (/mybatis/*)
│   ├── ControllerLock.java            # Deadlock, ReentrantLock, Transactional (/lock/*)
│   ├── ControllerNetworkSegment.java  # IP/mask network segment (/networksegment/*)
│   ├── SortServiceController.java     # Sort + matrix endpoints
│   ├── MatrixRequest.java             # Request DTO for matrix multiplication
│   └── DoublePersonRequest.java       # Request DTO for transactional tests
├── entity/
│   └── Person.java                    # JPA entity (jakarta.persistence)
├── model/
│   └── Person.java                    # MyBatis POJO (plain Lombok)
├── mapper/
│   └── PersonMapper.java             # MyBatis mapper interface
├── repository/
│   └── PersonRepository.java         # Spring Data JPA repository
└── service/
    ├── ContactBookService.java        # JPA-backed business logic
    ├── ContactBookServiceMB.java      # MyBatis-backed business logic
    ├── LockSampleAbstract.java        # Abstract threading base class
    ├── LockSample.java                # Deadlock + ReentrantLock impl
    ├── NetworkSegmentInterface.java   # Interface with static methods
    ├── NetworkSegment.java            # IP mask calculation + synchronized counter
    ├── MatrixMultiplicationCalc.java   # Matrix multiplication algorithm
    ├── SortService.java               # Orchestrates swap sort
    ├── Swapsort.java                  # Selection sort implementation
    └── TestingWithDataStructure.java  # ArrayList manipulation demo

src/main/resources/
├── application.yml                    # DB connection, JPA, MyBatis config
└── mapper/
    └── PersonMapper.xml               # MyBatis SQL definitions
```

---

## API Endpoints

### JPA Controller (`/jpa`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/jpa/create` | Create a person |
| GET | `/jpa/read` | List all persons |
| GET | `/jpa/readByName?name=` | Find by name |
| GET | `/jpa/readByPhone?phone=` | Find by phone |
| GET | `/jpa/readByNameReturnPhone?name=` | Get phone by name (JPQL) |
| PUT | `/jpa/updatePhoneNumber?name=` | Update phone number |
| DELETE | `/jpa/deleteByName?name=` | Delete by name |
| DELETE | `/jpa/deleteByPhone?phone=` | Delete by phone |

### MyBatis Controller (`/mybatis`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/mybatis/readAll` | List all persons |
| GET | `/mybatis/readByName/{name}` | Find by name |
| POST | `/mybatis/create` | Create a person |
| PUT | `/mybatis/updateAll` | Update all fields |
| PUT | `/mybatis/updatePhone/{name}` | Update phone |
| DELETE | `/mybatis/delete/{name}` | Delete by name |

### Lock Controller (`/lock`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/lock/hello` | Health check |
| GET | `/lock/deadlock` | Trigger deadlock demo |
| GET | `/lock/reentrantlock` | Trigger ReentrantLock demo |
| POST | `/lock/transactionaltestsucess` | Transactional success |
| POST | `/lock/transactionaltestrollback` | Transactional rollback |

### Other
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/hello?name=` | Hello greeting |
| POST | `/sort` | Sort a list of integers |
| POST | `/networksegment/ipmask?ip=&mask=` | Compute network segment |
| POST | `/networksegment/synchronizedcounter` | Increment shared counter |

---

## Setup

1. **PostgreSQL** — ensure a database is running with a `contact_book` schema and `person` table
2. **Configure** — update `src/main/resources/application.yml` with your DB host, port, username, password
3. **Run**:
```bash
mvn spring-boot:run
```
Server starts on **port 8082**.

---

## Sample Request

```bash
# Create a person
curl -X POST http://localhost:8082/jpa/create \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice","phone":"12345","country":"SG","gender":"F"}'

# Sort a list
curl -X POST http://localhost:8082/sort \
  -H "Content-Type: application/json" \
  -d '[5,3,8,1,4]'
```
