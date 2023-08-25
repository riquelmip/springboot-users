$(document).ready(function() {

});

async function register(){

      let datos = {};
      datos.name = document.getElementById("name").value;
      datos.lastname = document.getElementById("lastname").value;
      datos.email = document.getElementById("email").value;
      datos.password = document.getElementById("pass").value;

      let repeatpass = document.getElementById("repeatpass").value;

      if(repeatpass != datos.password){
         alert('La contraseña que escribiste es diferente.');
           return;
      }

      const request = await fetch('api/users', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });
      alert("La cuenta fue creada con exito!");
        window.location.href = 'login.html'
      //const users = await request.json();

}

