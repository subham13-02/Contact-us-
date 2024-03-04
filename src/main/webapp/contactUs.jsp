<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact us</title>
<link rel="stylesheet" href="contactUs.css">
</head>
<body>
    <main>
        <div class="container">
            <h1>Contact Us</h1>
            <p>Please fill this form in a decent manner</p>
            <form action="contactus" method="post">
                <label for="fullname">Full Name</label>
                <input type="text" id="fullname" name="name" placeholder="Full Name" required>

                <label for="email">E-mail</label>
                <input type="email" id="email" name="email" placeholder="example@mountblue.com" required>
                
                <label for="message">Message</label>
                <textarea id="message" name="message" rows="5" placeholder="Message" required></textarea>

                <button type="submit">SUBMIT</button>
            </form>
        </div>
    </main>
</body>
</html>