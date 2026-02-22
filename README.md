🔐 Advanced Full Stack Authentication System
React ⚛️ + Spring Boot ☕ + MySQL 🗄️

A production-style authentication system built using React (Frontend) and Spring Boot (Backend) with secure password encoding and multiple authentication mechanisms.

This project demonstrates real-world backend architecture and secure user authentication workflows.

🚀 System Overview

The application supports:

Username & Password Login

Mobile OTP Login

User Registration (Signup)

Secure Password Encoding

Password Reset

REST API Integration

Frontend and backend are separated for maintainability and scalability.

🏗️ Architecture Design

React Frontend
⬇
Fetch API
⬇
Spring Boot REST Controller
⬇
Service Layer
⬇
Repository Layer
⬇
MySQL Database

The backend follows a layered architecture ensuring clean separation of concerns.

🔐 Authentication Features
1️⃣ User Signup (Registration)

Method: POST
Endpoint: /signup

Purpose:
Registers a new user in the system.

Processing Overview:

Validates input data

Encodes password using PasswordEncoder

Saves user details into database

Returns success response

Security Implementation:
Passwords are stored in encoded (hashed) format using Spring Security’s PasswordEncoder.

2️⃣ Login by Username & Password

Method: POST
Endpoint: /login

Purpose:
Authenticates user using username and password.

Processing Overview:

Fetches user from database

Compares raw password with encoded password

Returns authentication result

Password verification is handled securely using PasswordEncoder match function.

3️⃣ Login by Mobile OTP

Step 1 – Send OTP

Method: POST
Endpoint: /send-otp

Purpose:
Generates and sends OTP to registered mobile number.

Processing Overview:

Validates mobile number

Generates random OTP

Stores OTP temporarily (database or memory)

Sends OTP (simulated or integrated SMS gateway)

Step 2 – Verify OTP

Method: POST
Endpoint: /verify-otp

Purpose:
Authenticates user using OTP.

Processing Overview:

Validates entered OTP

Matches with stored OTP

Authenticates user upon success

4️⃣ Reset Password

Method: PUT
Endpoint: /reset-password

Purpose:
Allows user to update password.

Processing Overview:

Validates username

Confirms new password match

Encodes new password

Updates database securely

🔒 Security Implementation

This project uses:

Spring Security PasswordEncoder

Hashed password storage

No plain-text password storage

Secure password comparison

Proper RESTful HTTP methods

Security ensures that even if the database is compromised, raw passwords are not exposed.

⚛️ Frontend Features

Login by Username & Password UI

Login by Mobile OTP UI

Signup Form

Reset Password Form

Password Confirmation Validation

Navigation links (Forgot Username / Forgot Password)

Fetch API for backend communication

🛠️ Technology Stack

Frontend:

React

Vite

JavaScript

CSS

Backend:

Spring Boot

Spring Security (PasswordEncoder)

Maven

MySQL

Lombok

Version Control:

Git

GitHub

🧠 Engineering Concepts Demonstrated

Multi-Authentication System

Password Hashing

OTP-Based Authentication Flow

DTO Pattern

Layered Backend Architecture

RESTful API Design

Form Validation

Secure Password Management

JWT Token-Based Authentication

Git Best Practices

🚀 Future Enhancements

Refresh Tokens

Role-Based Access Control

Email Verification

SMS Gateway Integration

Cloud Deployment

📈 Project Strength

This project demonstrates the ability to:

✔ Design secure authentication systems
✔ Implement password hashing
✔ Build OTP-based login flow
✔ Apply layered backend architecture
✔ Integrate frontend with secure backend APIs

It reflects strong understanding of full stack authentication design used in real-world applications.

👨‍💻 Author

Mayur Hasnabadkar
Full Stack Developer (React + Spring Boot)

GitHub Repository:
https://github.com/Mayur29082000/Login-project