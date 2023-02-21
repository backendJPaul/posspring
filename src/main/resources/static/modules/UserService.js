export class UserService{
    constructor(url){
        this.url = url;
    }

    async delete(id){
        const request = await fetch(this.url + "/" + id,{
            method : "DELETE",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        let user;
        const response = await request.json();
        user = {
            'id': response.id,
            'name': response.name,
            'password': response.password,
            'idRole': response.idRole
        };
        return user;
    }

    async update(userData){
        const request = await fetch(this.url, {
            method: "PUT",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });
        let user;
        const response = await request.json();
    }

    async gotoId(id){
        const request = await fetch(this.url + "/"+id,{
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        let user;
        const response = await request.json();
        user = {
          'id': response.id,
          'name': response.name,
          'password': response.password,
          'idRole': response.idRole
        };
        return user;
    }

    async save(userData) {
        const request = await fetch(this.url, {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });
        const response =  await request.json();
        return response;
    }

    async fetchAll(pattern) {
        if(pattern){
            this.url  = this.url + "/search/" + pattern;
        }

        const request = await fetch(this.url, {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        });

        let arrayObj = [];
        const response = await request.json();

        for (let user of response) {
            let obj = {
                id: user.id,
                name: user.name,
                role: user.role
            }
            arrayObj.push(obj);
        }
        return arrayObj;
    }
}