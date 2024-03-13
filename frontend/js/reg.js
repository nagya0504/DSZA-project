emailjs.init("GJBGMxsKtobVWVUzQ");

function sendEmail(email, familyname, givenname) {
  var emailData = {
     to: email,
     to_name: familyname + givenname,
     from_name: 'Bookmark',
     message: 'This is a test email'
  };

  emailjs.send('service_ui8qb1c', 'template_hbaq118', emailData)
     .then(function(response) {
        alert('Köszönjük, hogy regisztráltál. Kérlek nézd meg az emailedet.', response);
     }, function(error) {
        console.error('Error sending email:', error);
     });
}

function addUserToServer(userData) {
  fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/addUser', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(userData),
  })
    .then(response => {
      console.log(response);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      console.log('Request Payload:', JSON.stringify(userData));
      return response.text();
    })
    .then(data => {
      console.log('User added:', data);
      if (data == "Sikertelen regisztráció") {
        errorMessageContainer.innerText = 'Rossz adatokat adtál meg, kérlek próbáld újra.';
      } else {
        errorMessageContainer.innerText = 'Sikeres regisztráció.';
        sendEmail(email, familyname, givenname);
      }
    })
    .catch(error => {
      console.error('Error during user addition:', error);
    });
}

var errorMessageContainer = document.getElementById('error-message');

document.getElementById('regform').addEventListener('submit', function (event) {
  event.preventDefault();

  const username = document.getElementById('username').value;
  const familyname = document.getElementById('familyname').value;
  const givenname = document.getElementById('givenname').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('pwd').value;
  const phone = document.getElementById('phone').value;
  const town = document.getElementById('town').value;

  const userData = {
    username: username,
    familyName: familyname,
    givenName: givenname,
    email: email,
    pwd: password,
    phone: phone,
    town: town
  };

  addUserToServer(userData);
});

