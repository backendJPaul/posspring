import {UserService} from './modules/UserService.js'
import {RoleService} from './modules/RoleService.js'

const userService = new UserService("api/users");
const roleService = new RoleService("api/roles");



const urlParams = window.location.search;
const params = new URLSearchParams(urlParams);


let users = await userService.fetchAll(params.get("param"));

for(let user of users) {

    let userRow = document.createElement("div");
    userRow.classList.add("row");

    let userId = document.createElement("div");
    userId.classList.add("col");
    userId.innerHTML = user.id;
    userRow.appendChild(userId);


    let userName = document.createElement("div");
    userName.classList.add("col");
    userName.innerHTML = user.name;
    userRow.appendChild(userName);


    let userRole = document.createElement("div");
    userRole.classList.add("col");
    userRole.innerHTML = user.role;
    userRow.appendChild(userRole);

    let userActions = document.createElement("div");
    userActions.classList.add("col");

    let updateButton = document.createElement("button");
    updateButton.setAttribute("id","updateButton" + user.id);
    updateButton.addEventListener("click",updateUser);
    function updateUser(){
        window.location.href = "update.html?id=" + user.id;
    }
    updateButton.innerHTML = "update";

    let deleteButton = document.createElement("button");
    deleteButton.setAttribute("id","deleteButton" + user.id);
    deleteButton.addEventListener("click",deleteUser);
    function deleteUser(){
        window.location.href = "delete.html?id=" + user.id;
    }
    deleteButton.innerHTML = "delete";
    userActions.appendChild(updateButton);
    userActions.appendChild(deleteButton);
    userRow.appendChild(userActions);

    document.getElementById("tableSection").appendChild(userRow);
}

let searchButton = document.getElementById("searchUserButton");
searchButton.addEventListener("click", searchUserButtonFunction);

function searchUserButtonFunction() {
    window.location.href = "index.html?param=" + document.getElementById("patternText").value;
}
