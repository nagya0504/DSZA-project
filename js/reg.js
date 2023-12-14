function addUserToServer(userData) {
  fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/addUser', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(userData),
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      console.log('User added:', data);
    })
    .catch(error => {
      console.error('Error during user addition:', error);
    });
}

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
    town: town,
  };

  addUserToServer(userData);
});

