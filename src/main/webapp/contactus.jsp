<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact us</title>
<link rel="stylesheet" href="contactus.css">
</head>
<body>
    <main>
        <div class="container">
            <h1>Contact Us</h1>
            <p>Please fill this form in a decent manner</p>

            <form action="addData" method="post">
                <label for="fullname">Full Name</label>
                <input type="text" id="fullname" name="name" required>

                <label for="email">E-mail</label>
                <input type="email" id="email" name="email" placeholder="example@example.com" required>

                <label for="message">Message</label>
                <textarea id="message" name="message" rows="5" required></textarea>

                <button type="submit">SUBMIT</button>
            </form>
        </div>
    </main>
</body>
</html>