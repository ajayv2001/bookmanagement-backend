# Book Management System

### A full-stack Book Management System built using:

→ Frontend: React + Bootstrap (Vite)<br/>
→ Backend: Spring Boot + MongoDB<br/>
→ Deployment: Frontend on Vercel, Backend on Render  

### Live Links

live link : https://bookmanagement-frontend-git-main-ajayv2001s-projects.vercel.app/<br/>
frontend repo : https://github.com/ajayv2001/bookmanagement-frontend

## Features Implemented
### Core CRUD

→ Add new books with validation<br/>
→ View all books in a responsive, styled table<br/>
→ View individual book details with Google Books API integration<br/>
→ Delete books

### Extra Features

→ Pagination (10 books per page)<br/>
→ Sorting dropdown<br/>
→ Toast notifications using react-toastify<br/>
→ Tabs for book details (basic + Google data)<br/>
→ Bootstrap styling for UI consistency<br/>
→ Responsive and mobile-friendly design

## Tech Stack
### Frontend

→ React (Vite)<br/>
→ React Router<br/>
→ Bootstrap 5<br/>
→ React Toastify<br/>
→ Axios

### Backend

→ Java 21<br/>
→ Spring Boot 3<br/>
→ MongoDB Atlas<br/>
→ Google Books API integration<br/>
→ Docker (for Render deployment)

## How to Run Locally
### Backend Setup (Spring Boot)

 1. Clone the repo:<br/>
```
git clone https://github.com/ajayv2001/bookmanagement-backend.git
cd bookmanagement-backend
```
 2. Create .env or use application.properties:<br/>
```
spring.data.mongodb.uri=your_mongodb_uri  // create a new cluster in mongodb and get the uri
server.port=8080
```
 3. Run the app:<br/>
 ```
./mvnw spring-boot:run
```
> Ensure you have Java 21 installed locally.

### Frontend Setup (React)

 1. Clone the repo:<br/>
```
git clone https://github.com/ajayv2001/bookmanagement-frontend.git
cd bookmanagement-frontend
```
 2. Install dependencies:<br/>
```
npm install 
```
 3. Update api.js with correct backend URL:<br/>
 ```
baseURL: 'http://localhost:8080/api'
```
 4. Run the app:<br/>
  ```
npm run dev
```

## Project Structure
### Backend 

 ```
 com.valoriz.bookmanagement
├── controller
├── model
├── repository
├── service
└── config
```

### Frontend

 ```
src/
├── components/
│   ├── AddBooks.jsx
│   ├── Home.jsx
│   ├── Navbar.jsx
│   └── BookPage.jsx
└── services/
    └── api.js
```





