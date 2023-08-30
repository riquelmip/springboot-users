$(document).ready(function() {

});

async function login(){

      let datos = {};
      datos.email = document.getElementById("email").value;
      datos.password = document.getElementById("pass").value;

      if(datos.email == "" || datos.password == ""){
        alert("Ingrese los campos");
        return;
      }

      const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });
      //const users = await request.json();

     const respuesta = await request.text();

       if (respuesta != 'FAIL') {
         localStorage.token = respuesta;
         localStorage.email = datos.email;
         window.location.href = 'users.html';
       } else {
         alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
       }

}

