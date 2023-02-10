import {UserService} from './modules/UserService.js'
import {RoleService} from './modules/RoleService.js'

const userService = new UserService("api/users");
const roleService = new RoleService("api/roles");

    let roles = await roleService.fetchAll();

    for(let role of roles) {
        let roleOption = document.createElement("option");
        roleOption.innerHTML = role.name;
        document.getElementById("roleSelect").appendChild(roleOption);
    }

    document.getElementById("createUserButton").addEventListener("click",actionButton);
    function actionButton() {
        let userData = {
            name: document.getElementById("nameText").value,
            password : document.getElementById("passwordPassword").value,
            idRole : document.getElementById("roleSelect").selectedIndex
        };
        window.location.href = "index.html";
    }