# 🌍 EcoScore AI

EcoScore AI is a Java Swing Desktop Application that helps users calculate their **Digital Carbon Footprint** and improve their digital habits through **AI-based personalized eco suggestions**.

---

## 📌 Features

### 🔐 User Authentication
- User Registration
- User Login
- MySQL Database Authentication

### 🌱 EcoScore Calculator
Calculate carbon footprint based on:

- 📧 Emails Sent
- ☁️ Cloud Storage Usage
- 🎥 Video Streaming Hours
- 💻 Device Usage Hours

---

### 🤖 AI Eco Suggestions

The application analyzes your digital habits and provides personalized suggestions such as:

- Reduce unnecessary emails
- Delete unused cloud files
- Lower video streaming quality
- Reduce daily device usage
- Maintain green digital habits

---

### 📊 EcoScore Report

Displays:

- Email Carbon Impact
- Cloud Carbon Impact
- Streaming Carbon Impact
- Device Carbon Impact
- Total Carbon Footprint
- EcoScore
- Eco Category

---

### 📁 Previous Reports

- Save every calculation
- View report history
- Refresh reports
- Delete selected reports

---

### 👤 User Profile

Displays:

- Username
- Total Reports
- Average EcoScore
- Best EcoScore
- Best Category

---

## 🛠️ Technologies Used

- Java
- Java Swing
- JDBC
- MySQL
- IntelliJ IDEA
- Git
- GitHub

---

## 🗄️ Database

Database Name:

```sql
ecoscoredb
```

Table:

```sql
users
```

---

## 📂 Project Structure

```
src
│
├── UI
│   ├── LoginFrame
│   ├── RegisterFrame
│   ├── EcoScoreFrame
│   ├── CalculatorFrame
│   ├── ReportFrame
│   ├── ProfileFrame
│   ├── AIReportFrame
│   └── DashboardCard
│
├── model
│   ├── CarbonCalculator1
│   ├── EcoScoreEngine1
│   └── EcoAIAdvisor
│
├── database
│   ├── DatabaseManager1
│   └── UserDAO
│
└── EcoScore2.java
```

---

## 🚀 How to Run

1. Clone the repository

```bash
git clone https://github.com/govind-kevat/EcoScore-Desktop-App.git
```

2. Open the project in IntelliJ IDEA

3. Create MySQL Database

```sql
CREATE DATABASE ecoscoredb;
```

4. Update database credentials inside

```
DatabaseManager1.java
```

```java
URL = jdbc:mysql://localhost:3306/ecoscoredb
USER = root
PASSWORD = your_password
```

5. Add MySQL JDBC Driver

6. Run

```
LoginFrame.java
```

---

## 📷 Screenshots

### Login Screen

(Add Screenshot)

### Dashboard

(Add Screenshot)

### Calculator

(Add Screenshot)

### Previous Reports

(Add Screenshot)

### Profile

(Add Screenshot)

---

## 🎯 Future Improvements

- Export Reports as PDF
- Charts & Analytics
- Dark Mode
- Email Reports
- Cloud Sync
- Machine Learning Based Carbon Prediction

---

## 👨‍💻 Developer

**Govind Kevat**

GitHub:
https://github.com/govind-kevat

---

## ⭐ If you like this project

Give this repository a ⭐ on GitHub.
