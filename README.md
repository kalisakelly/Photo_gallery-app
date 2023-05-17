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
<img width="1196" alt="Screenshot 2023-05-16 at 19 26 30" src="https://github.com/kalisakelly/Photo_gallery-app/assets/101429002/53441867-e4d0-4688-8444-ff4c90625ecf">


Login Page

users
<img width="1680" alt="Screenshot 2023-05-16 at 19 26 22" src="https://github.com/kalisakelly/Photo_gallery-app/assets/101429002/54f37c6c-8d90-4a9c-a6f4-7e2da62fe7de">


Gallery Page
<img width="1628" alt="Screenshot 2023-05-16 at 19 26 50" src="https://github.com/kalisakelly/Photo_gallery-app/assets/101429002/0332f1b9-639c-457b-bd3d-c834348328af">

Gallery Page

search
<img width="862" alt="Screenshot 2023-05-16 at 19 27 03" src="https://github.com/kalisakelly/Photo_gallery-app/assets/101429002/7bfeb686-56a5-4f76-afaf-80e2cb946586">


link to access it : <a href="https://photogallery-app-production.up.railway.app">PhotoGallery.App</a>
<br/>
link to access the documentation: <a href="https://docs.google.com/document/d/1dT-q8wckjBQvPfpeS0VhG9sIUbHSnhhf/edit?usp=sharing&ouid=106655911330539580739&rtpof=true&sd=true">https://docs.google.com/document/d/1dT-q8wckjBQvPfpeS0VhG9sIUbHSnhhf/edit?usp=sharing&ouid=106655911330539580739&rtpof=true&sd=true</a>

We hope you enjoy using Galleryphoto! If you have any questions or need further assistance, please don't hesitate to contact us. Happy uploading and downloading!





Regenerate response
Send a message.

