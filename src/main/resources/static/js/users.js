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
      let btnDelete = '<button onclick="deleteUser('+user.id+');" class="btn btn-danger btn-circle btn-sm pl-2"><i class="fas fa-trash"></i></button>';
      let phone = user.phone == null ? '' : user.phone;
      usersHTML += '<tr>'+
          '<td>'+user.id+'</td>'+
          '<td>'+user.name+'</td>'+
          '<td>'+user.email+'</td>'+
          '<td>'+phone+'</td>'+
          '<td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-edit"></i></a>'+btnDelete+'</td>'+
      '</tr>';
      }
      document.querySelector("#tableUsers tbody").outerHTML = usersHTML;

}

async function deleteUser(id){

if(!confirm('Desea eliminar este usuario?')){
return;
}
 const request = await fetch('api/users/' + id, {
           method: 'DELETE',
           headers: {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
           }
         });

location.reload();
}