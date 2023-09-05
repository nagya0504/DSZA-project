// Example GET request
fetch('http://127.0.0.1:8080/bookmark-1.0-SNAPSHOT/webresources/user/login', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
    // Add any necessary headers like authentication tokens
  },
})
.then(response =>{
    // Check if the response status is OK (200)
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    // Parse the response body as JSON and return it
    return response.json();
  })
.then(data => {
    console.log('Response data:', data);
})
.catch(error => {
    console.error('Error:', error);
});
