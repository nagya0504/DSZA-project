// Define the function to add a user to the server
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
      // Handle the response data here
      console.log('User added:', data);
      // You can perform further actions like updating the UI or redirecting the user.
    })
    .catch(error => {
      // Handle errors here, such as network issues or server errors
      console.error('Error during user addition:', error);
      // Display an error message to the user or perform error-specific actions.
    });
}

// Attach an event listener to the form submit event
document.getElementById('regform').addEventListener('submit', function (event) {
  event.preventDefault(); // Prevent the default form submission

  // Get user data from input fields
  const username = form.elements['username'].value;
  const familyname = form.elements['familyname'].value;
  const givenname = form.elements['givenname'].value;
  const email = form.elements['email'].value;
  const password = form.elements['pwd'].value;
  const phone = form.elements['phone'].value;
  const town = form.elements['town'].value;

  // Create a user data object
  const userData = {
    username: username,
    familyname: familyname,
    givenname: givenname,
    email: email,
    password: password,
    phone: phone,
    town: town,
  };

  // Call the addUserToServer function with the user data
  addUserToServer(userData);
});
