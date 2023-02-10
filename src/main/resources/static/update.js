import {UserService} from './modules/UserService.js'
import {RoleService} from './modules/RoleService.js'

const userService = new UserService("api/users");
const roleService = new RoleService("api/roles");

const urlParams = window.location.search;
const params = new URLSearchParams(urlParams);
alert(params.get("id"));

