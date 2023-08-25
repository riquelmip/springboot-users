$(document).ready(function() {
    getUsers();
  $('#tableUsers').DataTable();
});

async function getUsers(){

      const request = await fetch('api/users', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const users = await request.json();

      console.log(users);

      let usersHTML = '';
      for (let user of users){
      usersHTML += '<tr>'+
          '<td>'+user.id+'</td>'+
          '<td>'+user.name+'</td>'+
          '<td>'+user.email+'</td>'+
          '<td>'+user.phone+'</td>'+
          '<td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-edit"></i></a><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td>'+
      '</tr>';
      }
      document.querySelector("#tableUsers tbody").outerHTML = usersHTML;

}