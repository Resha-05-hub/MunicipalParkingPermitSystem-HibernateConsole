#  Municipal Parking Permit System
### Hibernate Console-Based Java Application

---

##  Project Overview

The **Municipal Parking Permit System** is a console-based Java backend application developed using **Hibernate ORM** and **Oracle XE Database**.

This system allows:

- Registration of Permit Holders
- Issuing Parking Permits
- Managing Vehicle Information
- Tracking Violations
- Managing Outstanding Fine Amount
- Storing & Retrieving Data using Hibernate ORM

The project demonstrates real-world database interaction using ORM mapping and transaction management.

---

##  Technologies Used

- Java (JDK 8+)
- Hibernate ORM 5.6.15.Final
- Oracle XE 11g
- JDBC
- Maven
- Console-Based Application
- Eclipse IDE

---

##  Database Design

###  PERMIT_HOLDER_TBL

| Column Name | Description |
|-------------|-------------|
| PERMIT_HOLDER_ID | Primary Key |
| FULL_NAME | Name of Permit Holder |
| HOLDER_TYPE | RESIDENT / VISITOR |
| ADDRESS_LINE1 | Address Line 1 |
| ADDRESS_LINE2 | Address Line 2 |
| WARD_CODE | Ward Code |
| MOBILE | Mobile Number |
| EMAIL | Email Address |
| STATUS | Active / Inactive |

---

###  PARKING_PERMIT_TBL

| Column Name | Description |
|-------------|-------------|
| PERMIT_ID | Primary Key |
| VEHICLE_REG_NO | Vehicle Registration Number |
| VEHICLE_TYPE | CAR / BIKE |
| ZONE_CODE | Parking Zone |
| PERMIT_START_DATE | Start Date |
| PERMIT_END_DATE | End Date |
| PERMIT_STATUS | Active / Expired |
| VIOLATION_COUNT | Number of Violations |
| OUTSTANDING_FINE_AMOUNT | Fine Amount |
| PERMIT_HOLDER_ID | Foreign Key (References PERMIT_HOLDER_TBL) |

---

##  Entity Relationship

- One Permit Holder ➝ Multiple Parking Permits  
- Relationship Type: **One-To-Many**
- Mapping handled using Hibernate Annotations

---

##  How to Run the Project

### 1️) Start Oracle XE Database

Start the database service.

### 2️) Start Listener

```bash
lsnrctl start
```

### 3️) Configure `hibernate.cfg.xml`

```xml
<property name="hibernate.connection.url">
    jdbc:oracle:thin:@localhost:1522:XE
</property>

<property name="hibernate.connection.username">
    parking
</property>

<property name="hibernate.connection.password">
    your_password
</property>
```

### 4️) Run Main Class

Run:

```
ParkingMain.java
```

---

##  Sample Console Output

```
=== Municipal Parking Permit System (Hibernate) ===

Enter Permit Holder ID: PH2002
Enter Full Name: Arjun Kumar
Enter Holder Type (RESIDENT/VISITOR): VISITOR
Enter Address Line 1: 12 Lake View Street
Enter Address Line 2: Opp Bus Stand
Enter Ward Code: WARD05
Enter Mobile Number: 9123456789
Enter Email: arjun.kumar@gmail.com

Enter Permit ID: PMT2002
Enter Vehicle Registration No: TN22AB4567
Enter Vehicle Type (CAR/BIKE): BIKE
Enter Zone Code: ZONE-B

SUCCESSFULLY EXECUTED
```

##  Project Output Screenshot

<img width="1916" height="723" alt="Screenshot 2026-02-21 104014" src="https://github.com/user-attachments/assets/2915f1dc-ffc0-4171-a121-490c823c2d17" />

```

```
<img width="1919" height="689" alt="Screenshot 2026-02-21 104034" src="https://github.com/user-attachments/assets/7fc645ad-d3eb-4f07-98b9-8d745af34482" />

```

```
<img width="1919" height="621" alt="Screenshot 2026-02-21 104055" src="https://github.com/user-attachments/assets/766f0193-7a23-4e80-af4f-53159921507a" />

```

---

##  Project Structure

MunicipalParkingPermitSystem-HibernateConsole/
│
├── pom.xml
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/kce/
│   │   │       ├── app/
│   │   │       │     └── ParkingMain.java
│   │   │       │
│   │   │       ├── bean/
│   │   │       │     ├── PermitHolder.java
│   │   │       │     └── ParkingPermit.java
│   │   │       │
│   │   │       ├── dao/
│   │   │       │     ├── PermitHolderDAO.java
│   │   │       │     └── ParkingPermitDAO.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │     └── ParkingService.java
│   │   │       │
│   │   │       └── util/
│   │   │             ├── HibernateUtil.java
│   │   │             ├── ValidationException.java
│   │   │             ├── FineProcessingException.java
│   │   │             └── ActivePermitOrFineExistsException.java
│   │   │
│   │   └── resources/
│   │         └── hibernate.cfg.xml
│   │
│   ├── test/
│   │   ├── java/
│   │   └── resources/
│
├── target/
```

---

##  Key Concepts Implemented

- Hibernate Configuration
- ORM Mapping using Annotations
- One-To-Many Relationship
- CRUD Operations
- Transaction Management
- Oracle Database Integration
- Exception Handling
- Console-Based User Interaction

---

##  Learning Outcomes

Through this project, I gained hands-on experience in:

- Hibernate ORM framework
- Database connectivity with Oracle XE
- Entity Relationship Mapping
- Managing Transactions in Hibernate
- Building structured backend console applications

---

##  Author

**RASMI RESHA A**  
B.E Computer Science Engineering  

---

##  GitHub Repository

```
https://github.com/Resha-05-hub/MunicipalParkingPermitSystem-HibernateConsole.git
```
