import {UserService} from './modules/UserService.js'
import {RoleService} from './modules/RoleService.js'

const userService = new UserService("api/users");
const roleService = new RoleService("api/roles");

const urlParams = window.location.search;
const params = new URLSearchParams(urlParams);

let roles = await roleService.fetchAll();

for(let role of roles) {
    let roleOption = document.createElement("option");
    roleOption.innerHTML = role.name;
    document.getElementById("roleSelect").appendChild(roleOption);
}

let user = await userService.gotoId(params.get("id"));

document.getElementById("idText").value = user.id;
document.getElementById("nameText").value = user.name;
document.getElementById("passwordPassword").value = user.password;
document.getElementById("roleSelect").selectedIndex = user.idRole;

document.getElementById("updateUserButton").addEventListener("click",actionButton);
async function actionButton() {
    let userData = {
        id: document.getElementById ("idText").value,
        name: document.getElementById("nameText").value,
        password : document.getElementById("passwordPassword").value,
        idRole : document.getElementById("roleSelect").selectedIndex
    };
    let user = await userService.update(userData);
    window.location.href = "index.html";
}
