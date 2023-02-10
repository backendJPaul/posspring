export class RoleService{
    constructor(url){
        this.url = url;
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

        for (let role of response) {
            let obj = {
                id: role.id,
                name: role.role
            }
            arrayObj.push(obj);
        }
        return arrayObj;
    }
}