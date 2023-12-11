const apiUrl = 'http://127.0.0.1:8080/com.bookmark_bookmark_war_1.0-SNAPSHOTPU'; // replace with your actual API base URL

const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

fetch(`${apiUrl}/selectUserByEmail`, {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json',
    // token
  },
  body: JSON.stringify({
    email: email,
    pwd: password
  }),
})
  .then(response => {
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }
    return response.json();
  })
  .then(data => {
    // Handle the response data
    console.log(data);
  })
  .catch(error => {
    // Handle errors
    console.error('Error:', error);
  });
