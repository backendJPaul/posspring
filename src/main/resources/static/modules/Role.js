export class Role{
    constructor(id, role) {
        this._id = id;
        this._role = role;
    }


    getId() {
        return this._id;
    }

    setId(value) {
        this._id = value;
    }

    getRole() {
        return this._role;
    }

    setRole(value) {
        this._role = value;
    }
}
