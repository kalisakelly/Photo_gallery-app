Galleryphoto Web Application
Galleryphoto Logo

Welcome to Galleryphoto, a web application that allows you to upload and download pictures in a secure and organized manner. To get started, follow the instructions below.

Table of Contents
Features
Prerequisites
Installation
Configuration
Usage
Screenshots
Contributing
License
Features
User registration and authentication
Upload and store pictures securely
Download pictures
Organize pictures into albums
User-friendly interface
Prerequisites
Before installing and using Galleryphoto, make sure you have the following prerequisites:

Java Development Kit (JDK) 11 or above
Apache Maven
PostgreSQL (installed and running)
Installation
Clone the repository to your local machine using the following command:

bash
Copy code
git clone https://github.com/your-username/galleryphoto.git
Change into the project directory:

bash
Copy code
cd galleryphoto
Build the application using Maven:

go
Copy code
mvn clean package
Run the application using the following command:

bash
Copy code
java -jar target/galleryphoto-1.0.0.jar
Configuration
Create a PostgreSQL database for Galleryphoto.

Open the application.properties file located in the src/main/resources directory.

Configure the following properties in the application.properties file:

bash
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/galleryphoto
spring.datasource.username=your_username
spring.datasource.password=your_password
Usage
Open your web browser and navigate to http://localhost:8080.

Register a new user account by clicking on the "Register" button and providing the required information.

Log in using your registered credentials.

Upload pictures by clicking on the "Upload" button and selecting the desired images from your device.

Download pictures by clicking on the "Download" button next to each image in the gallery.

Organize pictures into albums by creating new albums and moving images into them.

Screenshots
Registration Page
<img width="1456" alt="Screenshot 2023-05-16 at 16 44 17" src="https://github.com/kalisakelly/Photo_gallery-app/assets/101429002/1a93c450-52bd-4545-863f-6c5f41e05129">

Registration Page

Login Page

Login Page

Upload Page
Upload Page

Gallery Page
Gallery Page



We hope you enjoy using Galleryphoto! If you have any questions or need further assistance, please don't hesitate to contact us. Happy uploading and downloading!





Regenerate response
Send a message.

