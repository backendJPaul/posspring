export class UserService{
    constructor(url){
        this.url = url;
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


    async fetchAll() {
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